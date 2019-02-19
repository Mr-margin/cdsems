package com.gistone.cdsems.database.mapper;

import com.gistone.cdsems.database.entity.SysModule;
import com.gistone.cdsems.database.entity.SysRole;

import java.math.BigDecimal;
import java.util.List;

public interface SysModuleMapper {
    int deleteByPrimaryKey(BigDecimal smId);

    int insert(SysModule record);

    int insertSelective(SysModule record);

    SysModule selectByPrimaryKey(BigDecimal smId);

    int updateByPrimaryKeySelective(SysModule record);

    int updateByPrimaryKey(SysModule record);

    //所有模块
	List<SysModule> listAll();
}