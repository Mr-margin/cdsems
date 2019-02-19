package com.gistone.cdsems.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.gistone.cdsems.util.EdatResult;

public interface CompanyService {

	//新增
	EdatResult save(Map map);
	
	//批量新增
	EdatResult saveBatch(List<Map> list);
	
	//根据id修改
	EdatResult update(Map map);
	
	//根据id删除
	EdatResult delete(Long id);
	
	//批量删除
	EdatResult deleteBatch(String idsStr);
	
	//根据企业名称查询数据
	Map getByName(String companyName);
	
	//查询分页数据
	EdatResult listPage(Map map);
	
	//导出查询所有数据
	List<Map> listAllExport(Map map);
	
	//根据条件查询所有数据
	List<Map> listAll(Map map);
	
	//查询全部工业园区
	List<Map> listAllPark();
	
	//查询全部行业
	List<Map> listAllIndustry();
	
	// 查询县详情数据
	List<Map> selectByCounty(Map map);
	
	// 查询县计数数据
	List<Map> selectByCity(Map map);
	
	// 查询县计数数据
	List<Map> selectAllCity(Map map);
	
	// 已上图
	int alreadyShown(Map map);
	// 查询行业类别
	List<Map> selectIndustryType();
}
