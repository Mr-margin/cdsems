package com.gistone.cdsems.service;

import java.util.List;

import com.gistone.cdsems.database.entity.TbCity;

public interface TbCityService {

	List<TbCity> getCountyByCityID(TbCity tbCity)throws Exception;

}
