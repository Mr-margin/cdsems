package com.gistone.cdsems.database.mapper;

import java.util.List;
import java.util.Map;

import com.gistone.cdsems.database.entity.TbCity;

public interface TbCityMapper {
    int deleteByPrimaryKey(Long tcId);

    int insert(TbCity record);

    int insertSelective(TbCity record);

    TbCity selectByPrimaryKey(Long tcId);

    int updateByPrimaryKeySelective(TbCity record);

    int updateByPrimaryKey(TbCity record);

    //根据城市ID获取县区数据
	List<TbCity> getCountyByCityID(TbCity tbCity);
    //查询县
	List<Map> selectCtiy(TbCity tbCity);
}