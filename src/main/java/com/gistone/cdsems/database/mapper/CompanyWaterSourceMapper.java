package com.gistone.cdsems.database.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gistone.cdsems.database.entity.CompanyWaterSource;

public interface CompanyWaterSourceMapper {
	
	/*自定义*/
	List<Map<String,Object>> SelectWaterSourceList(Map<String,Object> parmap);
	List<Map<String,Object>> SelectWaterSourceListCount(Map<String,Object> parmap);
	
	List<Map<String,Object>> SelectWaterMonitorList(Map<String,Object> parmap);
	
	int delWaterSourceInfor(@Param(value="id") String id);
	int delWaterMonitorInforBySourceId(@Param(value="id") String id);
	int delWaterMonitorInfor(@Param(value="id") String id);
	List<Map<String, Object>> SelectWaterSourceInfor(CompanyWaterSource waterSource);
	
	int updateWaterMonitorInfor(CompanyWaterSource waterSource);
	int insertWaterSourceInfor(CompanyWaterSource waterSource);
	int insertWaterMonitorInfor(List<Map<String, Object>> lm);
	int saveBatch(List<Map<String, Object>> list);
	
	
	/*自定义*/
	
    int deleteByPrimaryKey(Long id);

    int insert(CompanyWaterSource record);

    int insertSelective(CompanyWaterSource record);

    CompanyWaterSource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CompanyWaterSource record);

    int updateByPrimaryKey(CompanyWaterSource record);
}