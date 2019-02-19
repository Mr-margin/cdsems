package com.gistone.cdsems.service.sys;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.SysLog;
import com.gistone.cdsems.util.EdatResult;


public interface SysLogService {

	//添加日志
	int insertSelective(SysLog record);

	@MyPermission(module="157")
	EdatResult list(SysLog sysLog) throws Exception;

}
