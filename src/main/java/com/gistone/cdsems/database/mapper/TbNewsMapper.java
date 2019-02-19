package com.gistone.cdsems.database.mapper;

import com.gistone.cdsems.database.entity.TbNews;

import java.math.BigDecimal;
import java.util.List;

public interface TbNewsMapper {
    int deleteByPrimaryKey(BigDecimal tnId);

    int insert(TbNews record);

    int insertSelective(TbNews record);

    TbNews selectByPrimaryKey(BigDecimal tnId);

    int updateByPrimaryKeySelective(TbNews record);

    int updateByPrimaryKeyWithBLOBs(TbNews record);

    int updateByPrimaryKey(TbNews record);

	List<TbNews> list(TbNews tbNews);

	int total(TbNews tbNews);

	//根据标题查询
	List<TbNews> findNewsByTnTitle(TbNews addNews);

	//批量更新
	int updateNewsWithoutTnContentByTnIds(TbNews tbNews);

	//首页，根据新闻类型和数据条数获取数据
	List<TbNews> getNewsListByType(TbNews tbNews);
	//首页，根据新闻类型和数据条数获取数据
	int totalByType(TbNews tbNews);
}