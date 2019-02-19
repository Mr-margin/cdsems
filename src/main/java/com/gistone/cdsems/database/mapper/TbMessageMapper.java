package com.gistone.cdsems.database.mapper;

import com.gistone.cdsems.database.entity.TbMessage;

import java.math.BigDecimal;
import java.util.List;

public interface TbMessageMapper {
    int deleteByPrimaryKey(BigDecimal tmId);

    int insert(TbMessage record);

    int insertSelective(TbMessage record);

    TbMessage selectByPrimaryKey(BigDecimal tmId);

    int updateByPrimaryKeySelective(TbMessage record);

    int updateByPrimaryKey(TbMessage record);

	List<TbMessage> list(TbMessage tbMessage);

	int total(TbMessage tbMessage);

	////根据数据条数和用户id，查询数据列表
	List<TbMessage> getMessageListByUserId(TbMessage tbMessage);
	////根据数据条数和用户id，查询数据列表
	int totalByUserId(TbMessage tbMessage);
}