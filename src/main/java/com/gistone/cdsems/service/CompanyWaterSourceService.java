package com.gistone.cdsems.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.gistone.cdsems.database.entity.CompanyWaterSource;
import com.gistone.cdsems.util.EdatResult;

public interface CompanyWaterSourceService {
	//查询分页数据
	EdatResult listPage(Map<String,Object> parmap);
	EdatResult SelectlistPage(Map<String,Object> parmap);

	EdatResult delete(BigDecimal bigDecimal,String id);
	EdatResult deleteWaterMonitor(BigDecimal bigDecimal,String id);
	EdatResult save(BigDecimal userId, CompanyWaterSource parkManag, List<Map<String, Object>> lm);
	EdatResult updateWaterMonitor(BigDecimal userId, CompanyWaterSource waterSource, List<Map<String, Object>> lm);
	EdatResult saveBatch(BigDecimal userId, List<Map<String, Object>> list);
}
