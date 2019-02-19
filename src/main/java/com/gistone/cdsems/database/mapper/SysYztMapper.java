package com.gistone.cdsems.database.mapper;

import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.database.entity.SysYzt;

import java.math.BigDecimal;
import java.util.List;

public interface SysYztMapper {
    int deleteByPrimaryKey(BigDecimal syId);

    int insert(SysYzt record);

    int insertSelective(SysYzt record);

    SysYzt selectByPrimaryKey(BigDecimal syId);

    int updateByPrimaryKeySelective(SysYzt record);

    int updateByPrimaryKey(SysYzt record);
    
    //所有模块
   	List<SysYzt> listAll();

   	////根据权限获取一张图目录
	List<SysYzt> listByPermission(SysUser seUser);
}