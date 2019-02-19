package com.gistone.cdsems.database.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 企业信息管理Mapper类
 * @Title CompanyMapper
 * @author NingYudong
 * @date 2018年11月16日
 */
@Mapper
//@Component(value="companyMapper")
public interface CompanyMigrationMapper {
	
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
}
