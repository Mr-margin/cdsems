package com.gistone.cdsems.controller.sys;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.regexp.RegexpUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.GitProperties;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.service.sys.SysUserService;
import com.gistone.cdsems.util.EdatResult;
import com.gistone.cdsems.util.RegUtil;

@RestController
@SuppressWarnings("all")
@RequestMapping("sys/user")
public class SysUserController {
	
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("/loginUser")
	public EdatResult loginUser(@RequestBody Map<String, Object> requestData, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//返回值
			EdatResult edatResult = null;
			
			//获取参数
			SysUser sysUser = new SysUser();
			Map<String, Object> data = (Map) requestData.get("data");
			//用户名
			if(!RegUtil.CheckParameter(data.get("suUsername"), "String", null, false)){
				return EdatResult.build(1003, "用户名不能为空！");
			}else{
				sysUser.setSuUsername(data.get("suUsername").toString());
			}
			//密码
			if(!RegUtil.CheckParameter(data.get("suPassword"), "String", null, false)){
				return EdatResult.build(1003, "密码不能为空！");
			}else{
				sysUser.setSuPassword(data.get("suPassword").toString());
			}
			//验证码
			String checkCode = "";
			if(!RegUtil.CheckParameter(data.get("checkCode"), "String", null, false)){
				return EdatResult.build(1003, "验证码不能为空！");
			}else{
				checkCode = data.get("checkCode").toString();
			}
			
			//Session 中的验证码
			String seCheckCode = request.getSession().getAttribute("checkCode").toString();
			if(!checkCode.equalsIgnoreCase(seCheckCode)){
				return EdatResult.build(1005, "验证码错误！");
			}else{
				//登录验证
				edatResult = sysUserService.loginUser(request, sysUser);
			}
			 
			return edatResult;
			
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	/**
	 * 分页查询用户信息
	 */
	@RequestMapping("/list")
	public EdatResult list(@RequestBody Map<String, Object> requestData,HttpServletRequest request,HttpServletResponse response) throws Exception{
		try {
			//1.获取session
			HttpSession session = request.getSession();
			//判断session中是否有用户信息
			if (!RegUtil.CheckParameter(session.getAttribute("sysUser"), null, null, false)) {
				return EdatResult.build(1002, "登陆超时");
			}
			//获取用户信息
			SysUser seUser = (SysUser) session.getAttribute("sysUser");
			
			//2.获取前端传递的参数
			SysUser selectUser = new SysUser();
			Map<String, Object> data = (Map) requestData.get("data");
			//每页条数
			if (!RegUtil.CheckParameter(data.get("pageSize"), "Integer", null, false)) {
				return EdatResult.build(1003, "pageSize(每页条数)不能为空");
			}else{
				selectUser.setPageSize(Integer.parseInt(data.get("pageSize").toString()));
			}
			//开始索引
			if (!RegUtil.CheckParameter(data.get("pageNumber"), "Integer", null, false)) {
				return EdatResult.build(1003, "pageNumber(开始索引)不能为空");
			}else{
				selectUser.setPageNumber(Integer.parseInt(data.get("pageNumber").toString()));
			}
			
			//模糊查询条件，用户名
			if (RegUtil.CheckParameter(data.get("suUserName"), null, null, false)) {
				selectUser.setSuUsername(data.get("suUserName").toString());
			}
			//模糊查询条件，手机号
			if (RegUtil.CheckParameter(data.get("suPhone"), null, null, false)) {
				selectUser.setSuPhone(data.get("suPhone").toString());
			}
			
			//3.调用service
			EdatResult result = sysUserService.list(selectUser);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	@RequestMapping("/saveUser")
	public EdatResult saveUser(@RequestBody Map<String, Object> requestData,HttpServletRequest request,HttpServletResponse response){
		try {
			
			//1.获取session
			HttpSession session = request.getSession();
			//判断session中是否有用户信息
			if (!RegUtil.CheckParameter(session.getAttribute("sysUser"), null, null, false)) {
				return EdatResult.build(1002, "登陆超时");
			}
			//获取用户信息
			SysUser seUser = (SysUser) session.getAttribute("sysUser");
			
			//2.获取前端传递的参数
			SysUser addUser = new SysUser();
			Map<String, Object> data = (Map) requestData.get("data");
			//用户名
			if (!RegUtil.CheckParameter(data.get("suUsername"), null, null, false)) {
				return EdatResult.build(1003, "suUsername(用户名)不能为空");
			}else{
				addUser.setSuUsername(data.get("suUsername").toString());
			}
			//密码
			if (!RegUtil.CheckParameter(data.get("suPassword"), null, null, false)) {
				return EdatResult.build(1003, "suPassword(密码)不能为空");
			}else{
				addUser.setSuPassword(data.get("suPassword").toString());
			}
			//真实姓名
			if (RegUtil.CheckParameter(data.get("suRealname"), null, null, false)) {
				addUser.setSuRealname(data.get("suRealname").toString());
			}
			//用户级别
			if (!RegUtil.CheckParameter(data.get("suLevel"), "Integer", null, false)) {
				return EdatResult.build(1003, "suLevel(用户级别)不能为空");
			}else{
				addUser.setSuLevel(data.get("suLevel").toString());
			}
			//行政区划
			int suLevel = Integer.parseInt(data.get("suLevel").toString());
			if("2".equals(suLevel+"")){
				//市级用户
				if (!RegUtil.CheckParameter(data.get("suCityRegion"), null, null, false)) {
					return EdatResult.build(1003, "suCityRegion(市级行政区划)不能为空");
				}else{
					addUser.setSuRegioncode(data.get("suCityRegion").toString());
				}
			}else if("3".equals(suLevel+"")){
				//省级用户
				if (!RegUtil.CheckParameter(data.get("suCountyRegion"), null, null, false)) {
					return EdatResult.build(1003, "suCountyRegion(县级行政区划)不能为空");
				}else{
					addUser.setSuRegioncode(data.get("suCountyRegion").toString());
				}
			}else if("4".equals(suLevel+"")){
				//企业用户
				if (!RegUtil.CheckParameter(data.get("suCompanyname"), null, null, false)) {
					return EdatResult.build(1003, "suCompanyname(企业名称)不能为空");
				}else{
					addUser.setSuCompanyname(data.get("suCompanyname").toString());
				}
			}
			//角色
			if(!RegUtil.CheckParameter(data.get("suSrId"), "Integer", null, false)) {
				return EdatResult.build(1003, "suSrId(角色)不能为空");
			}else{
				addUser.setSuSrId(new BigDecimal(data.get("suSrId").toString()));
			}
			//性别
			if (RegUtil.CheckParameter(data.get("suSex"), "Integer", null, false)) {
				addUser.setSuSex(data.get("suSex").toString());
			}
			//手机
			if (RegUtil.CheckParameter(data.get("suPhone"), null, null, false)) {
				addUser.setSuPhone(data.get("suPhone").toString());
			}
			//邮箱
			if (RegUtil.CheckParameter(data.get("suEmail"), null, null, false)) {
				addUser.setSuEmail(data.get("suEmail").toString());
			}
			
			//创建用户
			addUser.setAddSuId(seUser.getSuId());
			//创建时间
			addUser.setAddTime(new Date());
			//用户删除状态
			addUser.setIsDel("0");
			
			EdatResult result = sysUserService.saveUser(addUser);
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	@RequestMapping("/getUserByID")
	public EdatResult getUserByID(@RequestBody Map<String, Object> requestData, HttpServletRequest request,HttpServletResponse response){
		try {
			
			//1.获取session
			HttpSession session = request.getSession();
			//判断session中是否有用户信息
			if (!RegUtil.CheckParameter(session.getAttribute("sysUser"), null, null, false)) {
				return EdatResult.build(1002, "登陆超时");
			}
			//获取用户信息
			SysUser seUser = (SysUser) session.getAttribute("sysUser");
			
			//2.获取前端传递的参数
			SysUser user = new SysUser();
			Map<String, Object> data = (Map) requestData.get("data");
			//Id
			if (!RegUtil.CheckParameter(data.get("suId"), "Integer", null, false)) {
				return EdatResult.build(1003, "suId(用户ID)不能为空");
			}else{
				user.setSuId(new BigDecimal(data.get("suId").toString()));
			}
			
			SysUser resultUser = sysUserService.getUserByID(user);
			resultUser.setSuPassword("");
			
			return EdatResult.ok(resultUser);
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	@RequestMapping("/updateUser")
	public EdatResult updateUser(@RequestBody Map<String, Object> requestData,HttpServletRequest request,HttpServletResponse response) throws Exception{
		try{
			//1.获取session
			HttpSession session = request.getSession();
			//判断session中是否有用户信息
			if (!RegUtil.CheckParameter(session.getAttribute("sysUser"), null, null, false)) {
				return EdatResult.build(1002, "登陆超时");
			}
			//获取用户信息
			SysUser seUser = (SysUser) session.getAttribute("sysUser");
			
			//2.获取前端传递的参数
			SysUser updateUser = new SysUser();
			Map<String, Object> data = (Map) requestData.get("data");
			//ID
			if (!RegUtil.CheckParameter(data.get("suId"), null, null, false)) {
				return EdatResult.build(1003, "suId(主键)不能为空");
			}else{
				updateUser.setSuId(new BigDecimal(data.get("suId").toString()));
			}
			//用户名
			if (!RegUtil.CheckParameter(data.get("suUsername"), null, null, false)) {
				return EdatResult.build(1003, "suUsername(用户名)不能为空");
			}else{
				updateUser.setSuUsername(data.get("suUsername").toString());
			}
			//密码
			if (RegUtil.CheckParameter(data.get("suPassword"), null, null, false)) {
				updateUser.setSuPassword(data.get("suPassword").toString());
			}
			//真实姓名
			if (RegUtil.CheckParameter(data.get("suRealname"), null, null, false)) {
				updateUser.setSuRealname(data.get("suRealname").toString());
			}else{
				updateUser.setSuRealname("");
			}
			//用户级别
			if (!RegUtil.CheckParameter(data.get("suLevel"), "Integer", null, false)) {
				return EdatResult.build(1003, "suLevel(用户级别)不能为空");
			}else{
				updateUser.setSuLevel(data.get("suLevel").toString());
			}
			//行政区划
			int suLevel = Integer.parseInt(data.get("suLevel").toString());
			if("2".equals(suLevel+"")){
				//市级用户
				if (!RegUtil.CheckParameter(data.get("suCityRegion"), null, null, false)) {
					return EdatResult.build(1003, "suCityRegion(市级行政区划)不能为空");
				}else{
					updateUser.setSuRegioncode(data.get("suCityRegion").toString());
				}
			}else if("3".equals(suLevel+"")){
				//省级用户
				if (!RegUtil.CheckParameter(data.get("suCountyRegion"), null, null, false)) {
					return EdatResult.build(1003, "suCountyRegion(县级行政区划)不能为空");
				}else{
					updateUser.setSuRegioncode(data.get("suCountyRegion").toString());
				}
			}else if("4".equals(suLevel+"")){
				//企业用户
				if (!RegUtil.CheckParameter(data.get("suCompanyname"), null, null, false)) {
					return EdatResult.build(1003, "suCompanyname(企业名称)不能为空");
				}else{
					updateUser.setSuCompanyname(data.get("suCompanyname").toString());
				}
			}
			//角色
			if(!RegUtil.CheckParameter(data.get("suSrId"), "Integer", null, false)) {
				return EdatResult.build(1003, "suSrId(角色)不能为空");
			}else{
				updateUser.setSuSrId(new BigDecimal(data.get("suSrId").toString()));
			}
			//性别
			if (RegUtil.CheckParameter(data.get("suSex"), "Integer", null, false)) {
				updateUser.setSuSex(data.get("suSex").toString());
			}else{
				updateUser.setSuSex("");
			}
			//手机
			if (RegUtil.CheckParameter(data.get("suPhone"), null, null, false)) {
				updateUser.setSuPhone(data.get("suPhone").toString());
			}else{
				updateUser.setSuPhone("");
			}
			//邮箱
			if (RegUtil.CheckParameter(data.get("suEmail"), null, null, false)) {
				updateUser.setSuEmail(data.get("suEmail").toString());
			}else{
				updateUser.setSuEmail("");
			}
			
			//创建用户
			updateUser.setUpdSuId(seUser.getSuId());
			//创建时间
			updateUser.setUpdTime(new Date());
			//用户删除状态
			updateUser.setIsDel("0");
			
			EdatResult result = sysUserService.updateUser(updateUser);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	@RequestMapping("/deleteUser")
	public EdatResult deleteUser(@RequestBody Map<String, Object> requestData,HttpServletRequest request,HttpServletResponse response){
		try {
			
			//1.获取session
			HttpSession session = request.getSession();
			//判断session中是否有用户信息
			if (!RegUtil.CheckParameter(session.getAttribute("sysUser"), null, null, false)) {
				return EdatResult.build(1002, "登陆超时");
			}
			//获取用户信息
			SysUser seUser = (SysUser) session.getAttribute("sysUser");
			
			//2.获取前端传递的参数
			SysUser user = new SysUser();
			Map<String, Object> data = (Map) requestData.get("data");
			//Id
			if (!RegUtil.CheckParameter(data.get("suId"), "Integer", null, false)) {
				return EdatResult.build(1003, "suId(用户ID)不能为空");
			}else{
				user.setSuId(new BigDecimal(data.get("suId").toString()));
			}
			
			EdatResult result = sysUserService.deleteUser(user);
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	//登录退出
	@RequestMapping("/loginOut")
	public EdatResult loginOut(HttpServletRequest request,HttpServletResponse response){
		try{
			
			//1.获取session
			HttpSession session = request.getSession();
			//判断session中是否有用户信息
			if (!RegUtil.CheckParameter(session.getAttribute("sysUser"), null, null, false)) {
				return EdatResult.build(1002, "登陆超时");
			}
			//获取用户信息
			SysUser seUser = (SysUser) session.getAttribute("sysUser");
			
			EdatResult result = sysUserService.logout(seUser);
			
			//销毁session
			session.invalidate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	//所有用户
	@RequestMapping("/listAll")
	public EdatResult listAll(@RequestBody Map<String, Object> requestData, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			
			EdatResult result = sysUserService.listAll();
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
		
	}
	
	@RequestMapping("/updateSuPassword")
	public EdatResult updateSuPassword(@RequestBody Map<String, Object> requestData,HttpServletRequest request,HttpServletResponse response) throws Exception{
		try{
			//1.获取session
			HttpSession session = request.getSession();
			//判断session中是否有用户信息
			if (!RegUtil.CheckParameter(session.getAttribute("sysUser"), null, null, false)) {
				return EdatResult.build(1002, "登陆超时");
			}
			//获取用户信息
			SysUser seUser = (SysUser) session.getAttribute("sysUser");
			
			//2.获取前端传递的参数
			SysUser updateUser = new SysUser();
			Map<String, Object> data = (Map) requestData.get("data");
			//ID
			if (!RegUtil.CheckParameter(data.get("suId"), null, null, false)) {
				return EdatResult.build(1003, "suId(主键)不能为空");
			}else{
				updateUser.setSuId(new BigDecimal(data.get("suId").toString()));
			}
			//旧密码
			if (!RegUtil.CheckParameter(data.get("suPassword"), null, null, false)) {
				return EdatResult.build(1003, "suPassword(旧密码)不能为空");
			}else{
				updateUser.setSuPassword(data.get("suPassword").toString());
			}
			//新密码
			String newSuPassword = "";
			if (!RegUtil.CheckParameter(data.get("newSuPassword"), null, null, false)) {
				return EdatResult.build(1003, "newSuPassword(新密码)不能为空");
			}else{
				newSuPassword = data.get("newSuPassword").toString();
			}
			
			EdatResult result = sysUserService.updateSuPassword(updateUser, newSuPassword);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
}