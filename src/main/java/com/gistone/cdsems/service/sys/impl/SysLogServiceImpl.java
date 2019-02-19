package com.gistone.cdsems.service.sys.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.SysLog;
import com.gistone.cdsems.database.mapper.SysLogMapper;
import com.gistone.cdsems.service.sys.SysLogService;
import com.gistone.cdsems.util.EdatResult;


@Service
@SuppressWarnings("all")
public class SysLogServiceImpl implements SysLogService{
	
	@Autowired
	private SysLogMapper sysLogMapper;

	//添加日志
	@Override
	public int insertSelective(SysLog sysLog) {
		sysLog.setSlTime(new Date());
		int count = sysLogMapper.insertSelective(sysLog);
		return count;
	}

	//条件查询日志分页数据
	@Override
	@MyPermission(module="157")
	public EdatResult list(SysLog sysLog) throws Exception {
		//分页查询条件
		int size = sysLog.getPageSize();//每页条数
		int number = sysLog.getPageNumber();//开始索引
		int page = (number / size) + 1;//当前页码
		
		//分页查询
		List<SysLog> list = sysLogMapper.list(sysLog);
		//查询数据总条数
		int total = sysLogMapper.total(sysLog);
		
		EdatResult result = EdatResult.build(list, page, total);
		return result;
	}

	

}
