package com.gistone.cdsems.database.mapper;

import com.gistone.cdsems.database.entity.SysRole;

import java.math.BigDecimal;
import java.util.List;

public interface SysRoleMapper {
    int deleteByPrimaryKey(BigDecimal srId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(BigDecimal srId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    //所有角色
	List<SysRole> listAll();

	List<SysRole> list(SysRole selectRole);

	int total(SysRole selectRole);

	//根据角色名称查询角色
	List<SysRole> findRoleBySrName(SysRole addRole);
}