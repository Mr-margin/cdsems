package com.gistone.cdsems.database.mapper;

import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import com.gistone.cdsems.database.entity.TDETAILEDCONTAMINATED;
import com.gistone.cdsems.database.entity.TDETAILEDCONTAMINATEDExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDETAILEDCONTAMINATEDMapper {
    long countByExample(TDETAILEDCONTAMINATEDExample example);

    int deleteByExample(TDETAILEDCONTAMINATEDExample example);

    int deleteByPrimaryKey(Long did);

    int deleteByPrimaryKeys(Long did);

    int insert(Object record);

    int insertSelective(TDETAILEDCONTAMINATED record);

    List<TDETAILEDCONTAMINATED> selectByExample(TDETAILEDCONTAMINATEDExample example);

    TDETAILEDCONTAMINATED selectByPrimaryKey(Long did);

    int updateByExampleSelective(@Param("record") TDETAILEDCONTAMINATED record, @Param("example") TDETAILEDCONTAMINATEDExample example);

    int updateByExample(@Param("record") TDETAILEDCONTAMINATED record, @Param("example") TDETAILEDCONTAMINATEDExample example);

    int updateByPrimaryKeySelective(Object record);

    int updateByPrimaryKey(Object record);
    //详细调查列表
    List<TBASICSCONTAMINATED> selectByEntityPage(TBASICSCONTAMINATED tbasicscontaminated);
    //查询详细调查总数
    int selectByCount(TBASICSCONTAMINATED tbasicscontaminated);
}