package com.gistone.cdsems.database.mapper;

import com.gistone.cdsems.database.entity.CompanyWaterMonitor;
import com.gistone.cdsems.database.entity.CompanyWaterMonitorKey;

public interface CompanyWaterMonitorMapper {
    int deleteByPrimaryKey(CompanyWaterMonitorKey key);

    int insert(CompanyWaterMonitor record);

    int insertSelective(CompanyWaterMonitor record);

    CompanyWaterMonitor selectByPrimaryKey(CompanyWaterMonitorKey key);

    int updateByPrimaryKeySelective(CompanyWaterMonitor record);

    int updateByPrimaryKey(CompanyWaterMonitor record);
}