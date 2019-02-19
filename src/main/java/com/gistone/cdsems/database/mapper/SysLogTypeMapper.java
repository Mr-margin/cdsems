package com.gistone.cdsems.database.mapper;

import com.gistone.cdsems.database.entity.SysLogType;
import java.math.BigDecimal;

public interface SysLogTypeMapper {
    int deleteByPrimaryKey(BigDecimal sltId);

    int insert(SysLogType record);

    int insertSelective(SysLogType record);

    SysLogType selectByPrimaryKey(BigDecimal sltId);

    int updateByPrimaryKeySelective(SysLogType record);

    int updateByPrimaryKey(SysLogType record);
}