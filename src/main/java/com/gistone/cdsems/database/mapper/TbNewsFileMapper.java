package com.gistone.cdsems.database.mapper;

import com.gistone.cdsems.database.entity.TbNewsFile;

import java.math.BigDecimal;
import java.util.List;

public interface TbNewsFileMapper {
    int deleteByPrimaryKey(BigDecimal tnfId);

    int insert(TbNewsFile record);

    int insertSelective(TbNewsFile record);

    TbNewsFile selectByPrimaryKey(BigDecimal tnfId);

    int updateByPrimaryKeySelective(TbNewsFile record);

    int updateByPrimaryKey(TbNewsFile record);

    //根据新闻id，查询
	List<TbNewsFile> selectByTnfTnId(BigDecimal tnId);

	//根据新闻id，删除
	void deleteByTnfTnId(BigDecimal tnId);
}