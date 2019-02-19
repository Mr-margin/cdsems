package com.gistone.cdsems.service.index.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gistone.cdsems.database.mapper.IndexMapper;
import com.gistone.cdsems.service.index.IndexService;
import com.gistone.cdsems.util.EdatResult;

@Service
public class IndexServiceImpl implements IndexService {
	
	@Autowired
	private IndexMapper indexMapper;

	//首页获取数据概况统计数据
	@Override
	public EdatResult getIndexCount(Map map) throws Exception {
		List<Map> list =  indexMapper.getIndexCount(map);
		return EdatResult.ok(list);
	}
	
}
