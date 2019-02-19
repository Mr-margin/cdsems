package com.gistone.cdsems.database.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gistone.cdsems.database.entity.CompanyParkPollutants;
import com.gistone.cdsems.database.entity.CompanyParkPollutantskey;

public interface CompanyParkPollutantsMapper {
	
	
	int delParkPollutantsInfor(@Param(value="id") String id);
	int insertParkPollutantsInfor(List<Map<String,Object>> list);
	int delAllParkPollutantsInfor(@Param(value="id") String id);
	int updateParkPollutantsfor( List<Map<String ,Object>> list);
	
	
    int deleteByPrimaryKey(CompanyParkPollutantskey key);

    int insert(CompanyParkPollutants record);

    int insertSelective(CompanyParkPollutants record);

    CompanyParkPollutants selectByPrimaryKey(CompanyParkPollutantskey key);

    int updateByPrimaryKeySelective(CompanyParkPollutants record);

    int updateByPrimaryKey(CompanyParkPollutants record);
}