package com.gistone.cdsems.database.mapper;

import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import com.gistone.cdsems.database.entity.TCONTROLCONTAMINATED;
import com.gistone.cdsems.database.entity.TCONTROLCONTAMINATEDExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCONTROLCONTAMINATEDMapper {
    long countByExample(TCONTROLCONTAMINATEDExample example);

    int deleteByExample(TCONTROLCONTAMINATEDExample example);

    int deleteByPrimaryKey(Long cid);

    int deleteByPrimaryKeys(Long mid);

    int insert(Object record);

    int insertSelective(TCONTROLCONTAMINATED record);

    List<TCONTROLCONTAMINATED> selectByExample(TCONTROLCONTAMINATEDExample example);

    TCONTROLCONTAMINATED selectByPrimaryKey(Long mid);

    int updateByExampleSelective(@Param("record") TCONTROLCONTAMINATED record, @Param("example") TCONTROLCONTAMINATEDExample example);

    int updateByExample(@Param("record") TCONTROLCONTAMINATED record, @Param("example") TCONTROLCONTAMINATEDExample example);

    int updateByPrimaryKeySelective(Object record);

    int updateByPrimaryKey(TCONTROLCONTAMINATED record);
    //风险管控列表
    List<TBASICSCONTAMINATED> selectByEntityPage(TBASICSCONTAMINATED tbasicscontaminated);
    //风险管控总数
    int selectByCount(TBASICSCONTAMINATED tbasicscontaminated);
}