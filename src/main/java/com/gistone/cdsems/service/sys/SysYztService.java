package com.gistone.cdsems.service.sys;

import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.util.EdatResult;

public interface SysYztService {

	EdatResult listAll() throws Exception;

	EdatResult listByPermission(SysUser seUser) throws Exception;

}
