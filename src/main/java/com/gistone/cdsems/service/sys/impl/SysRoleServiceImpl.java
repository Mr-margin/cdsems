package com.gistone.cdsems.service.sys.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.SysRole;
import com.gistone.cdsems.database.entity.SysRoleModule;
import com.gistone.cdsems.database.entity.SysRoleYzt;
import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.database.mapper.SysRoleMapper;
import com.gistone.cdsems.database.mapper.SysRoleModuleMapper;
import com.gistone.cdsems.database.mapper.SysRoleYztMapper;
import com.gistone.cdsems.database.mapper.SysUserMapper;
import com.gistone.cdsems.service.sys.SysRoleService;
import com.gistone.cdsems.service.sys.SysUserService;
import com.gistone.cdsems.util.EdatResult;
import com.gistone.cdsems.util.MD5Util;

@SuppressWarnings("all")
@Service
public class SysRoleServiceImpl implements SysRoleService {
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Autowired
	private SysRoleModuleMapper sysRoleModuleMapper;
	
	@Autowired
	private SysRoleYztMapper sysRoleYztMapper;

	@Override
	public EdatResult listAll() throws Exception {
		List<SysRole> data = sysRoleMapper.listAll();
		return EdatResult.ok(data);
	}

	@Override
	@MyPermission(module="153")
	public EdatResult list(SysRole selectRole) throws Exception {
		//分页查询条件
		int size = selectRole.getPageSize();//每页条数
		int number = selectRole.getPageNumber();//开始索引
		int page = (number / size) + 1;//当前页码
		
		//分页查询
		List<SysRole> list = sysRoleMapper.list(selectRole);
		//查询数据总条数
		int total = sysRoleMapper.total(selectRole);
		
		EdatResult result = EdatResult.build(list, page, total);
		return result;
	}

	@Override
	@MyPermission(module="154")
	public EdatResult saveRole(SysRole addRole) throws Exception {
		//1.判断角色是否存在
		List<SysRole> roleList = sysRoleMapper.findRoleBySrName(addRole);
		if (roleList.size() > 0) {
			return EdatResult.build(10, "角色名称重复");
		}else{
		
			int number = sysRoleMapper.insertSelective(addRole);
			if(number>0){
				//主键
				BigDecimal srId = addRole.getSrId();
				
				//功能权限
				if(addRole.getSrSmIds()!=null && addRole.getSrSmIds()!=""){
					String smIds = addRole.getSrSmIds();
					String[] smIdArr = smIds.split(",");
					for (String smId : smIdArr) {
						if(smId!=null && smId!=""){
							SysRoleModule sysRoleModule = new SysRoleModule();
							sysRoleModule.setSrmSrId(srId);
							sysRoleModule.setSrmSmId(new BigDecimal(smId));
							sysRoleModuleMapper.insertSelective(sysRoleModule);
						}
					}
				}
				
				//一张图权限
				if(addRole.getSrSyIds()!=null && addRole.getSrSyIds()!=""){
					String syIds = addRole.getSrSyIds();
					String[] syIdArr = syIds.split(",");
					for (String syId : syIdArr) {
						if(syId!=null && syId!=""){
							SysRoleYzt sysRoleYzt = new SysRoleYzt();
							sysRoleYzt.setSrySrId(srId);
							sysRoleYzt.setSrySyId(new BigDecimal(syId));
							sysRoleYztMapper.insertSelective(sysRoleYzt);
						}
					}
				}
				
				//创建日志对象
				return EdatResult.build(0, "添加成功", null, "添加角色成功（ID："+addRole.getSrId()+"）");
			}else{
				return EdatResult.build(1, "添加失败");
			}
		}
	}

	@Override
	public SysRole getRole(SysRole role) throws Exception {
		SysRole resultRole = sysRoleMapper.selectByPrimaryKey(role.getSrId());
		
		//一张图权限
		if(resultRole!=null){
			List<SysRoleYzt> sysRoleYzts = sysRoleYztMapper.selectByrySrId(resultRole.getSrId());
			resultRole.setSrSysRoleYzt(sysRoleYzts);
		}
		
		return resultRole;
	}

	@Override
	@MyPermission(module="155")
	public EdatResult updateRole(SysRole addRole) throws Exception {
		//1.判断角色是否存在
		List<SysRole> roleList = sysRoleMapper.findRoleBySrName(addRole);
		if (roleList.size() > 0) {
			return EdatResult.build(10, "角色名称重复");
		}else{
			//删除功能权限
			//删除数据权限
			if(addRole.getSrId()!=null){
				BigDecimal srId = addRole.getSrId();
				sysRoleModuleMapper.deleteBySrmSrId(srId);
				sysRoleYztMapper.deleteBySrySrId(srId);
			}
			
			int number = sysRoleMapper.updateByPrimaryKeySelective(addRole);
			if(number>0){
				//主键
				BigDecimal srId = addRole.getSrId();
				
				//功能权限
				if(addRole.getSrSmIds()!=null && addRole.getSrSmIds()!=""){
					String smIds = addRole.getSrSmIds();
					String[] smIdArr = smIds.split(",");
					for (String smId : smIdArr) {
						if(smId!=null && smId!=""){
							SysRoleModule sysRoleModule = new SysRoleModule();
							sysRoleModule.setSrmSrId(srId);
							sysRoleModule.setSrmSmId(new BigDecimal(smId));
							sysRoleModuleMapper.insertSelective(sysRoleModule);
						}
					}
				}
				
				//一张图权限
				if(addRole.getSrSyIds()!=null && addRole.getSrSyIds()!=""){
					String syIds = addRole.getSrSyIds();
					String[] syIdArr = syIds.split(",");
					for (String syId : syIdArr) {
						if(syId!=null && syId!=""){
							SysRoleYzt sysRoleYzt = new SysRoleYzt();
							sysRoleYzt.setSrySrId(srId);
							sysRoleYzt.setSrySyId(new BigDecimal(syId));
							sysRoleYztMapper.insertSelective(sysRoleYzt);
						}
					}
				}
				
				
				//创建日志对象
				return EdatResult.build(0, "修改成功", null, "修改角色成功（ID："+addRole.getSrId()+"）");
			}else{
				return EdatResult.build(1, "修改失败");
			}
		}
	}

	@Override
	@MyPermission(module="156")
	public EdatResult deleteRole(SysRole role) throws Exception {
		//删除功能权限
		//删除数据权限
		if(role.getSrId()!=null){
			BigDecimal srId = role.getSrId();
			sysRoleModuleMapper.deleteBySrmSrId(srId);
			sysRoleYztMapper.deleteBySrySrId(srId);
		}
		
		//删除角色
		//设置删除状态
		int updateRole = sysRoleMapper.deleteByPrimaryKey(role.getSrId());
		if(updateRole > 0){
			//创建日志对象
			return EdatResult.build(0, "删除成功", null, "删除角色成功（ID："+role.getSrId()+"）");
		}else{
			return EdatResult.build(1, "删除失败");
		}
	}

	
	

}
