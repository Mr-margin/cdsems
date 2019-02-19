package com.gistone.cdsems.database.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 企业特征污染物监测数据管理Mapper类
 * @Title CompanyPollutantMonitorMapper
 * @author NingYudong
 * @date 2018年11月21日
 */
@Mapper
//@Component(value="companyMapper")
public interface CompanyPollutantMonitorMapper {
	
	//新增
	int save(@Param("pd") Map map);
	
	//批量新增
	void saveBatch(@Param("list") List<Map> list);
	
	//根据id修改
	void update(@Param("pd") Map map);
	
	//根据id删除
	void delete(@Param("id") Long id);
	
	//批量删除
	void deleteBatch(@Param("ids") String[] ids);
	
	//查询分页数据
	List<Map> listPage(@Param("pd") Map map);
	
	//查询分页查询总条数
	int listPageTotal(@Param("pd") Map map);
	
	//查询全部数据
	List<Map> listAll(@Param("pd") Map map);
	
	//根据污染物名称查询污染物信息
	Map getPollutantByName(@Param("pollutant_name") String name);
	
	//查询全部特征污染物信息
	List<Map> listAllPollutant();
}
