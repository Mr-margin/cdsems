package com.gistone.cdsems.database.mapper;

import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import com.gistone.cdsems.database.entity.TEFFECTCONTAMINATED;
import com.gistone.cdsems.database.entity.TEFFECTCONTAMINATEDExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TEFFECTCONTAMINATEDMapper {
    long countByExample(TEFFECTCONTAMINATEDExample example);

    int deleteByExample(TEFFECTCONTAMINATEDExample example);

    int deleteByPrimaryKey(Long cid);

    int deleteByPrimaryKeys(Long eid);

    int insert(Object record);

    int insertSelective(TEFFECTCONTAMINATED record);

    List<TEFFECTCONTAMINATED> selectByExample(TEFFECTCONTAMINATEDExample example);

    TEFFECTCONTAMINATED selectByPrimaryKey(Long eid);

    int updateByExampleSelective(@Param("record") TEFFECTCONTAMINATED record, @Param("example") TEFFECTCONTAMINATEDExample example);

    int updateByExample(@Param("record") TEFFECTCONTAMINATED record, @Param("example") TEFFECTCONTAMINATEDExample example);

    int updateByPrimaryKeySelective(Object record);

    int updateByPrimaryKey(TEFFECTCONTAMINATED record);
    //效果评估列表
    List<TBASICSCONTAMINATED> selectByEntityPage(TBASICSCONTAMINATED tbasicscontaminated);
    //效果评估总数
    int selectByCount(TBASICSCONTAMINATED tbasicscontaminated);
}