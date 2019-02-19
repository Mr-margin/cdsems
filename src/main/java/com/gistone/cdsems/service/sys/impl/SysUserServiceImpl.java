package com.gistone.cdsems.service.sys.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.SysRole;
import com.gistone.cdsems.database.entity.SysRoleModule;
import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.database.mapper.SysRoleMapper;
import com.gistone.cdsems.database.mapper.SysUserMapper;
import com.gistone.cdsems.service.sys.SysUserService;
import com.gistone.cdsems.util.EdatResult;
import com.gistone.cdsems.util.MD5Util;

@SuppressWarnings("all")
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	//登录
	@Override
	public EdatResult loginUser(HttpServletRequest request, SysUser sysUser) throws Exception{
		//密码加密
		sysUser.setSuPassword(MD5Util.MD5(sysUser.getSuPassword()));
		List<SysUser> result = sysUserMapper.logingUser(sysUser);
		if(result.size()>0){
			SysUser resultUser = result.get(0);
			//获取角色
			BigDecimal suSrId = resultUser.getSuSrId();
			if(suSrId!=null){
				SysRole sysRole = sysRoleMapper.selectByPrimaryKey(suSrId);
				//处理角色
				handledRole(sysRole);
				
				resultUser.setSuSysRole(sysRole);
				
				resultUser.setSuPassword("");
			}
			//存储用户到session
			request.getSession().setAttribute("sysUser", resultUser);
			//存储用户级别和用户行政区划、企业名称到session
			if(resultUser.getSuLevel()!=null){
				request.getSession().setAttribute("suLevel", resultUser.getSuLevel());
				if("2".equals(resultUser.getSuLevel().toString())||"3".equals(resultUser.getSuLevel().toString())){
					request.getSession().setAttribute("suRegioncode", resultUser.getSuRegioncode());
				}
				if("4".equals(resultUser.getSuLevel().toString())){
					request.getSession().setAttribute("suCompanyname", resultUser.getSuCompanyname());
				}
			}
			//返回值
			return EdatResult.ok(resultUser, "用户登录成功（ID："+resultUser.getSuId()+"）");
		
			
		}else{
			return EdatResult.error(1, "用户名或密码错误！", "用户登录失败");
		}
	}
	
	private void handledRole(SysRole sysRole){
		//处理模块权限
		String srSmIds = "";
	  	List<String> srSmEles = new ArrayList<String>();
	  	
	  	if(sysRole!=null && sysRole.getSrSysRoleModule()!=null){
	  		 List<SysRoleModule> srSysRoleModule = sysRole.getSrSysRoleModule();
	  		for (SysRoleModule sysRoleModule : srSysRoleModule) {
	  			//功能id
	  			srSmIds += sysRoleModule.getSrmSmId() + ",";
				if(sysRoleModule.getSrmSysModule()!=null && sysRoleModule.getSrmSysModule().getSmEle()!=null){
					//功能element
					srSmEles.add(sysRoleModule.getSrmSysModule().getSmEle());
				}
			}
	  	}
	  	sysRole.setSrSmIds(srSmIds==""?"":srSmIds.substring(0, srSmIds.length()-1));
	  	sysRole.setSrSmEles(srSmEles);
	  	
	  	
	}

	@Override
	@MyPermission(module="149")
	public EdatResult list(SysUser selectUser) throws Exception {
		//分页查询条件
		int size = selectUser.getPageSize();//每页条数
		int number = selectUser.getPageNumber();//开始索引
		int page = (number / size) + 1;//当前页码
		
		//分页查询
		List<SysUser> list = sysUserMapper.list(selectUser);
		for (SysUser sysUser : list) {
			sysUser.setSuPassword("");
		}
		//查询数据总条数
		int total = sysUserMapper.total(selectUser);
		
		EdatResult result = EdatResult.build(list, page, total);
		return result;
	}

	//添加用户
	@Override
	@MyPermission(module="150")
	public EdatResult saveUser(SysUser addUser) throws Exception {
		//1.判断用户是否存在
		List<SysUser> userList = sysUserMapper.findUserByUserName(addUser);
		if (userList.size() > 0) {
			return EdatResult.build(10, "用户名重复");
		}else{
			//密码加密
			addUser.setSuPassword(MD5Util.MD5(addUser.getSuPassword()));
			int number = sysUserMapper.insertSelective(addUser);
			if(number>0){
				//创建日志对象
				return EdatResult.build(0, "添加成功", null, "添加用户成功（ID："+addUser.getSuId()+"）");
			}else{
				return EdatResult.build(1, "添加失败");
			}
		}
	}

	@Override
	public SysUser getUserByID(SysUser user) throws Exception{
		SysUser resutlUser = sysUserMapper.selectByPrimaryKey(user.getSuId());
		resutlUser.setSuPassword("");
		return resutlUser;
	}
	
	@Override
	@MyPermission(module="151")
	public EdatResult updateUser(SysUser updateUser) throws Exception {
		//1.判断用户是否存在
		List<SysUser> userList = sysUserMapper.findUserByUserName(updateUser);
		if (userList.size() > 0) {
			return EdatResult.build(10, "用户名重复");
		}else{
			//1.数据处理
			if(updateUser.getSuPassword()!=null&&!"".equals(updateUser.getSuPassword())){
				//MD5加密
				//密码加密
				updateUser.setSuPassword(MD5Util.MD5(updateUser.getSuPassword()));
			}else{
				updateUser.setSuPassword(null);
			}
			
			//2.调用Dao
			int number = sysUserMapper.updateByPrimaryKeySelective(updateUser);
			if(number>0){
				return EdatResult.build(0, "修改成功", null, "修改用户成功（ID："+updateUser.getSuId()+"）");
			}else{
				return EdatResult.build(1, "修改失败");
			}
		}
	}

	//删除用户
	@Override
	@MyPermission(module="152")
	public EdatResult deleteUser(SysUser user) throws Exception {
		//设置删除状态
		user.setIsDel("1");
		int updateUser = sysUserMapper.updateByPrimaryKeySelective(user);
		if(updateUser > 0){
			//创建日志对象
			return EdatResult.build(0, "删除成功", null, "删除用户成功（ID："+user.getSuId()+"）");
		}else{
			return EdatResult.build(1, "删除失败");
		}
	}

	@Override
	public EdatResult logout(SysUser seUser) throws Exception {
		return EdatResult.build(0, "退出成功", null, "用户退出（ID："+seUser.getSuId()+"）");
	}

	@Override
	public EdatResult listAll() throws Exception {
		//所有角色
		List<SysUser> data = sysUserMapper.listAll();
		return EdatResult.ok(data);
	}

	//修改密码
	@Override
	public EdatResult updateSuPassword(SysUser updateUser, String newPassword) {
		//判断新旧密码是否一致
		if(newPassword.equals(updateUser.getSuPassword())){
			return EdatResult.build(11, "新密码与旧密码不能相同");
		}
		
		SysUser selectUser = sysUserMapper.selectByPrimaryKey(updateUser.getSuId());
		if(selectUser!=null){
			String oldPassword = MD5Util.MD5(updateUser.getSuPassword());
			//判断旧密码是否正确
			if(oldPassword.equals(selectUser.getSuPassword())){
				updateUser.setSuPassword(MD5Util.MD5(newPassword));
				int number = sysUserMapper.updateByPrimaryKeySelective(updateUser);
				if(number>0){
					return EdatResult.build(0, "修改成功", null, "修改用户成功（ID："+updateUser.getSuId()+"）");
				}else{
					return EdatResult.build(1, "修改失败");
				}
			}else{
				return EdatResult.error("您所输入的旧密码不对!");
			}
		}else{
			return EdatResult.error("不存在当前用户");
		}
	}
	
	

}
