package com.gistone.cdsems.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gistone.cdsems.database.entity.CompanyParkManagement;
import com.gistone.cdsems.util.EdatResult;
import com.gistone.cdsems.util.Result;

public interface CompanyParkManagementService {
	//新增
	 EdatResult save(BigDecimal userId,CompanyParkManagement parkManag,List<Map<String,Object>> lm);
	//批量新增
	 EdatResult saveBatch(BigDecimal userId,List<Map<String,Object>> list);
	 EdatResult updatePollutants(BigDecimal userId,List<Map<String,Object>> list);
	//根据id修改
	EdatResult update(BigDecimal userId,CompanyParkManagement parkManag,List<Map<String, Object>> lm);
	//根据id删除
	EdatResult delete(BigDecimal userId,String id);
	//查询分页数据
	EdatResult listPage(Map<String,Object> parmap);
	//查询所有检测信息
	EdatResult SelectlistPage(Map<String,Object> parmap);
	//根据条件查询所有数据
	Result exportInfor(Map<String, Object> resultMap, HttpServletRequest request, HttpServletResponse response);
	
	List<Map> selectByCounty(Map map);
	List<Map> selectByCity(Map map);
	List<Map> selectAllCity(Map map);

}
