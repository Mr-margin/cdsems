package com.gistone.cdsems.database.mapper;

import com.gistone.cdsems.database.entity.SysRoleModule;
import java.math.BigDecimal;

public interface SysRoleModuleMapper {
    int deleteByPrimaryKey(BigDecimal srmId);

    int insert(SysRoleModule record);

    int insertSelective(SysRoleModule record);

    SysRoleModule selectByPrimaryKey(BigDecimal srmId);

    int updateByPrimaryKeySelective(SysRoleModule record);

    int updateByPrimaryKey(SysRoleModule record);

    //根据角色ID 删除
	void deleteBySrmSrId(BigDecimal srId);
}