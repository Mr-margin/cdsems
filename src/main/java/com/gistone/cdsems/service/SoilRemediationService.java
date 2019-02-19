package com.gistone.cdsems.service;

import java.util.List;
import java.util.Map;

import com.gistone.cdsems.util.EdatResult;

public interface SoilRemediationService {

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
	
	//查询分页数据
	EdatResult listPage(Map map);
	
	//根据条件查询所有数据
	List<Map> listAll(Map map);
}
