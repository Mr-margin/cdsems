package com.gistone.cdsems.database.mapper;

import com.gistone.cdsems.database.entity.SysRoleYzt;

import java.math.BigDecimal;
import java.util.List;

public interface SysRoleYztMapper {
    int deleteByPrimaryKey(BigDecimal sryId);

    int insert(SysRoleYzt record);

    int insertSelective(SysRoleYzt record);

    SysRoleYzt selectByPrimaryKey(BigDecimal sryId);
    
    int updateByPrimaryKeySelective(SysRoleYzt record);

    int updateByPrimaryKey(SysRoleYzt record);
    
    //根据角色ID 删除
  	void deleteBySrySrId(BigDecimal srId);
  	
  	//根据角色ID，获取角色一张图信息
  	List<SysRoleYzt> selectByrySrId(BigDecimal sryId);
}