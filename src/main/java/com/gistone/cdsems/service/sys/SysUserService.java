package com.gistone.cdsems.service.sys;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.util.EdatResult;

@Service
public interface SysUserService {

	//登录
	EdatResult loginUser(HttpServletRequest request, SysUser sysUser) throws Exception;

	@MyPermission(module="149")
	EdatResult list(SysUser selectUser)throws Exception;

	@MyPermission(module="150")
	EdatResult saveUser(SysUser addUser)throws Exception;

	//根据id查询用户
	SysUser getUserByID(SysUser user)throws Exception;

	@MyPermission(module="151")
	EdatResult updateUser(SysUser addUser)throws Exception;

	@MyPermission(module="152")
	EdatResult deleteUser(SysUser user)throws Exception;

	EdatResult logout(SysUser seUser) throws Exception;

	EdatResult listAll() throws Exception;

	//修改密码
	EdatResult updateSuPassword(SysUser updateUser, String newPassword);


}
