package com.gistone.cdsems.controller.sys;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.regexp.RegexpUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gistone.cdsems.database.entity.SysLog;
import com.gistone.cdsems.database.entity.SysRole;
import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.service.sys.SysLogService;
import com.gistone.cdsems.service.sys.SysRoleService;
import com.gistone.cdsems.service.sys.SysUserService;
import com.gistone.cdsems.util.EdatResult;
import com.gistone.cdsems.util.RegUtil;

@RestController
@SuppressWarnings("all")
@RequestMapping("sys/role")
public class SysRoleController {
	
	@Autowired
	private SysRoleService sysRoleService;
	
	@RequestMapping("/listAll")
	public EdatResult listAll(@RequestBody Map<String, Object> requestData, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			 
			EdatResult result = sysRoleService.listAll();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	@RequestMapping("/list")
	public EdatResult list(@RequestBody Map<String, Object> requestData,HttpServletRequest request,HttpServletResponse response){
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
			SysRole selectRole = new SysRole();
			Map<String, Object> data = (Map) requestData.get("data");
			//每页条数
			if (!RegUtil.CheckParameter(data.get("pageSize"), "Integer", null, false)) {
				return EdatResult.build(1003, "pageSize(每页条数)不能为空");
			}else{
				selectRole.setPageSize(Integer.parseInt(data.get("pageSize").toString()));
			}
			//开始索引
			if (!RegUtil.CheckParameter(data.get("pageNumber"), "Integer", null, false)) {
				return EdatResult.build(1003, "pageNumber(开始索引)不能为空");
			}else{
				selectRole.setPageNumber(Integer.parseInt(data.get("pageNumber").toString()));
			}
			
			//模糊查询条件，用户名
			if (RegUtil.CheckParameter(data.get("srName"), null, null, false)) {
				selectRole.setSrName(data.get("srName").toString());
			}
			
			//3.调用service
			EdatResult result = sysRoleService.list(selectRole);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	@RequestMapping("/saveRole")
	public EdatResult saveRole(@RequestBody Map<String, Object> requestData,HttpServletRequest request,HttpServletResponse response){
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
			SysRole addRole = new SysRole();
			Map<String, Object> data = (Map) requestData.get("data");
			//角色名
			if (!RegUtil.CheckParameter(data.get("srName"), null, null, false)) {
				return EdatResult.build(1003, "srName(角色名)不能为空");
			}else{
				addRole.setSrName(data.get("srName").toString());
			}
			//角色描述
			if (RegUtil.CheckParameter(data.get("srDesc"), null, null, false)) {
				addRole.setSrDesc(data.get("srDesc").toString());
			}
			//功能权限
			if (RegUtil.CheckParameter(data.get("srSmIds"), null, null, false)) {
				addRole.setSrSmIds(data.get("srSmIds").toString());
			}
			//数据权限
			if (RegUtil.CheckParameter(data.get("srSyIds"), null, null, false)) {
				addRole.setSrSyIds(data.get("srSyIds").toString());
			}
			
			//创建角色
			addRole.setAddSuId(seUser.getSuId());
			addRole.setAddTime(new Date());
			
			EdatResult result = sysRoleService.saveRole(addRole);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	@RequestMapping("/getRole")
	public EdatResult getRole(@RequestBody Map<String, Object> requestData, HttpServletRequest request,HttpServletResponse response) {
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
			SysRole role = new SysRole();
			Map<String, Object> data = (Map) requestData.get("data");
			//Id
			if (!RegUtil.CheckParameter(data.get("srId"), "Integer", null, false)) {
				return EdatResult.build(1003, "srId(角色ID)不能为空");
			}else{
				role.setSrId(new BigDecimal(data.get("srId").toString()));
			}
			
			SysRole result = sysRoleService.getRole(role);
			
			return EdatResult.ok(result);
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	@RequestMapping("/updateRole")
	public EdatResult updateRole(@RequestBody Map<String, Object> requestData,HttpServletRequest request,HttpServletResponse response){
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
			SysRole addRole = new SysRole();
			Map<String, Object> data = (Map) requestData.get("data");
			//Id
			if (!RegUtil.CheckParameter(data.get("srId"), "Integer", null, false)) {
				return EdatResult.build(1003, "srId(角色ID)不能为空");
			}else{
				addRole.setSrId(new BigDecimal(data.get("srId").toString()));
			}
			//角色名
			if (!RegUtil.CheckParameter(data.get("srName"), null, null, false)) {
				return EdatResult.build(1003, "srName(角色名)不能为空");
			}else{
				addRole.setSrName(data.get("srName").toString());
			}
			//角色描述
			if (RegUtil.CheckParameter(data.get("srDesc"), null, null, false)) {
				addRole.setSrDesc(data.get("srDesc").toString());
			}else{
				addRole.setSrDesc("");
			}
			//功能权限
			if (RegUtil.CheckParameter(data.get("srSmIds"), null, null, false)) {
				addRole.setSrSmIds(data.get("srSmIds").toString());
			}else{
				addRole.setSrSmIds("");
			}
			//数据权限
			if (RegUtil.CheckParameter(data.get("srSyIds"), null, null, false)) {
				addRole.setSrSyIds(data.get("srSyIds").toString());
			}else{
				addRole.setSrSyIds("");
			}
			
			//创建角色
			addRole.setUpdSuId(seUser.getSuId());
			addRole.setUpdTime(new Date());
			
			EdatResult result = sysRoleService.updateRole(addRole);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	@RequestMapping("/deleteRole")
	public EdatResult deleteUser(@RequestBody Map<String, Object> requestData,HttpServletRequest request,HttpServletResponse response){
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
			SysRole role = new SysRole();
			Map<String, Object> data = (Map) requestData.get("data");
			//Id
			if (!RegUtil.CheckParameter(data.get("srId"), "Integer", null, false)) {
				return EdatResult.build(1003, "srId(角色ID)不能为空");
			}else{
				role.setSrId(new BigDecimal(data.get("srId").toString()));
			}
			EdatResult result = sysRoleService.deleteRole(role);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
}