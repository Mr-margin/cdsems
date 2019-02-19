package com.gistone.cdsems.database.mapper;

import com.gistone.cdsems.database.entity.SysLog;

import java.math.BigDecimal;
import java.util.List;

public interface SysLogMapper {
    int deleteByPrimaryKey(BigDecimal slId);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(BigDecimal slId);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);

	List<SysLog> list(SysLog sysLog);

	int total(SysLog sysLog);
}