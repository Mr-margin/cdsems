package com.gistone.cdsems.service.sys;


import org.springframework.stereotype.Service;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.SysRole;
import com.gistone.cdsems.util.EdatResult;


@Service
public interface SysRoleService {

	EdatResult listAll()throws Exception;

	@MyPermission(module="153")
	EdatResult list(SysRole selectRole) throws Exception;

	@MyPermission(module="154")
	EdatResult saveRole(SysRole addRole) throws Exception;

	SysRole getRole(SysRole role) throws Exception;

	@MyPermission(module="155")
	EdatResult updateRole(SysRole addRole) throws Exception;

	@MyPermission(module="156")
	EdatResult deleteRole(SysRole role)throws Exception;

	

}
