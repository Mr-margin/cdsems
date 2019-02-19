package com.gistone.cdsems.database.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;

/**
 * 企业信息管理Mapper类
 * @Title CompanyMapper
 * @author NingYudong
 * @date 2018年11月16日
 */
@Mapper
//@Component(value="companyMapper")
public interface CompanyMapper {
	
	//新增并返回id
	int save(@Param("pd") Map map);
	
	//批量新增
	void saveBatch(@Param("list") List<Map> list);
	
	//根据id修改
	void update(@Param("pd") Map map);
	
	//根据id删除
	void delete(@Param("id") Long id);
	
	//批量删除
	void deleteBatch(@Param("ids") String[] ids);
	
	//根据id删除关联表数据
	void deleteCorrelation(@Param("tableName") String tableName,@Param("id") Long id);
	
	//批量删除关联表数据
	void deleteCorrelationBatch(@Param("tableName") String tableName,@Param("ids") String[] ids);
	
	//根据企业名称查询数据
	Map getByName(@Param("companyName") String companyName);
	
	//查询分页数据
	List<Map> listPage(@Param("pd") Map map);
	
	//查询分页查询总条数
	int listPageTotal(@Param("pd") Map map);
	
	//查询全部数据
	List<Map> listAll(@Param("pd") Map map);
	
	//查询全部工业园区
	List<Map> listAllPark();
	
	//查询全部行业
	List<Map> listAllIndustry();
	
	// 查询县详情数据
	List<Map> selectByCounty(@Param("pd") Map map);
	
	// 查询县计数数据
	List<Map> selectByCity(@Param("pd") Map map);
	
	// 查询市所有数据
	List<Map> selectAllCity(@Param("pd") Map map);
	
	// 已上图
	int alreadyShown(@Param("pd") Map map);

	List<Map> selectIndustryType();
}
