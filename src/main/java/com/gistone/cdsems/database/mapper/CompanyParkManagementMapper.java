package com.gistone.cdsems.database.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gistone.cdsems.database.entity.CompanyParkManagement;
import com.gistone.cdsems.database.entity.CompanyParkPollutants;

public interface CompanyParkManagementMapper {
	
	/*自定义*/
	List<Map<String, Object>> listAll(Map<String,Object> map);
	List<Map<String, Object>> SelectParkManagementList(Map<String,Object> resultMap);
	List<Map<String, Object>> SelectParkManagementListCount(Map<String,Object> resultMap);
	List<Map<String, Object>> SelectParkManagementInfor(CompanyParkManagement parkManag);
	List<Map<String, Object>> SelectParkManagementInforByid(CompanyParkManagement parkManag);
	int updateParkManagementInfor(CompanyParkManagement parkManag);
	int insertParkManagementInfor(CompanyParkManagement parkManag);
	int delParkManagementInfor(@Param(value="id") String id);
	int saveBatch(List<Map<String, Object>> list);
	
	List<Map<String, Object>> SelectParkPollutantsList(Map<String,Object> resultMap);
	
	
	
	
	/*自定义*/
	
	
	
	
	
	
	
	
    int deleteByPrimaryKey(Long id);

    int insert(CompanyParkManagement record);

    int insertSelective(CompanyParkManagement record);

    CompanyParkManagement selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CompanyParkManagement record);

    int updateByPrimaryKey(CompanyParkManagement record);
    
	List<Map> selectByCounty(Map map);
	
	List<Map> selectByCity(Map map);
	
	List<Map> selectAllCity(Map map);
}