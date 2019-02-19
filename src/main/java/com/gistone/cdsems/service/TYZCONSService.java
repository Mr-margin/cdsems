package com.gistone.cdsems.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.gistone.cdsems.database.entity.TYZCONS;
import com.gistone.cdsems.util.EdatResult;

@Service
public interface TYZCONSService {
	EdatResult getJchpfx(Map map);
	EdatResult getJchpfxMessage(TYZCONS tztcons);
}
