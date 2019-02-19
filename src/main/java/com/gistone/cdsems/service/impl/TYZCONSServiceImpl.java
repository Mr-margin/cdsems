package com.gistone.cdsems.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gistone.cdsems.database.entity.TYZCONS;
import com.gistone.cdsems.database.mapper.TYZCONSMapper;
import com.gistone.cdsems.service.TYZCONSService;
import com.gistone.cdsems.util.EdatResult;
@Service
public class TYZCONSServiceImpl implements TYZCONSService {

	@Autowired
	TYZCONSMapper tyzconsMapper;
	public EdatResult getJchpfx(Map map) {
		return (EdatResult) tyzconsMapper.getJchpfx(map);
	}
	public EdatResult getJchpfxMessage(TYZCONS tztcons) {
		return (EdatResult) tyzconsMapper.getJchpfxMessage(tztcons);
	}

}
