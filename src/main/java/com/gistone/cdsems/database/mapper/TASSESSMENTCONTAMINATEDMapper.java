package com.gistone.cdsems.database.mapper;

import com.gistone.cdsems.database.entity.TASSESSMENTCONTAMINATED;
import com.gistone.cdsems.database.entity.TASSESSMENTCONTAMINATEDExample;
import java.util.List;
import java.util.Map;

import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import org.apache.ibatis.annotations.Param;

public interface TASSESSMENTCONTAMINATEDMapper {
    long countByExample(TASSESSMENTCONTAMINATEDExample example);

    int deleteByExample(TASSESSMENTCONTAMINATEDExample example);

    int deleteByPrimaryKey(Long cid);

    int deleteByPrimaryKeys(Long rid);

    int insert(Object record);

    int insertSelective(TASSESSMENTCONTAMINATED record);

    List<TASSESSMENTCONTAMINATED> selectByExample(TASSESSMENTCONTAMINATEDExample example);

    TASSESSMENTCONTAMINATED selectByPrimaryKey(Long rid);

    int updateByExampleSelective(@Param("record") TASSESSMENTCONTAMINATED record, @Param("example") TASSESSMENTCONTAMINATEDExample example);

    int updateByExample(@Param("record") TASSESSMENTCONTAMINATED record, @Param("example") TASSESSMENTCONTAMINATEDExample example);

    int updateByPrimaryKeySelective(Object record);

    int updateByPrimaryKey(TASSESSMENTCONTAMINATED record);

    //风险评估列表
    List<TBASICSCONTAMINATED> selectByEntityPage (TBASICSCONTAMINATED tbasicscontaminated);
    //风险评估总数
    int selectByCount(TBASICSCONTAMINATED tbasicscontaminated);


}