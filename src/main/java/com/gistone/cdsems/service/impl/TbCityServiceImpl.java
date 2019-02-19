package com.gistone.cdsems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gistone.cdsems.database.entity.TbCity;
import com.gistone.cdsems.database.mapper.TbCityMapper;
import com.gistone.cdsems.service.TbCityService;

@Service
public class TbCityServiceImpl implements TbCityService {
	
	@Autowired
	private TbCityMapper tbCityMapper;

	@Override
	public List<TbCity> getCountyByCityID(TbCity tbCity) throws Exception {
		List<TbCity> result = tbCityMapper.getCountyByCityID(tbCity);
		return result;
	}

}
