package com.gistone.cdsems.service.index;

import java.util.Map;

import com.gistone.cdsems.util.EdatResult;


public interface IndexService {

	//首页获取数据概况统计数据
	EdatResult getIndexCount(Map map) throws Exception;
	
}
