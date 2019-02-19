package com.gistone.cdsems.database.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gistone.cdsems.database.entity.TYZCONS;
@Mapper
public interface TYZCONSMapper {
	List<TYZCONS> getJchpfx(@Param("pd") Map map);

	List<TYZCONS> getJchpfxMessage(TYZCONS tztcons);
}
