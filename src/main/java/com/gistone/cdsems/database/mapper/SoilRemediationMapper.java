package com.gistone.cdsems.database.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 土壤治理与修复项目基本信息
 * @Title SoilRemediationMapper
 * @author NingYudong
 * @date 2018年11月23日
 */
@Mapper
//@Component(value="companyMapper")
public interface SoilRemediationMapper {
	
	//新增并返回id
	int save(@Param("pd") Map map);
	
	//批量新增
	int saveBatch(@Param("list") List<Map> list);
	
	//根据id修改
	int update(@Param("pd") Map map);
	
	//根据id删除
	int delete(@Param("id") Long id);
	
	//批量删除
	int deleteBatch(@Param("ids") String[] ids);
	
	//查询分页数据
	List<Map> listPage(@Param("pd") Map map);
	
	//查询分页查询总条数
	int listPageTotal(@Param("pd") Map map);
	
	//查询全部数据
	List<Map> listAll(@Param("pd") Map map);
	
}
