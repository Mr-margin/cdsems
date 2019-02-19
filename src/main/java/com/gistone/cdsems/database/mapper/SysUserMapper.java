package com.gistone.cdsems.database.mapper;

import com.gistone.cdsems.database.entity.SysUser;

import java.math.BigDecimal;
import java.util.List;

public interface SysUserMapper {
	
    int deleteByPrimaryKey(BigDecimal suId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(BigDecimal suId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    //登录，用户名、密码、删除状态查询用户
	List<SysUser> logingUser(SysUser sysUser);

	List<SysUser> list(SysUser selectUser);

	int total(SysUser selectUser);

	//查询用户名是否重复
	List<SysUser> findUserByUserName(SysUser addUser);

	//所有用户
	List<SysUser> listAll();

}