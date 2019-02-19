package com.gistone.cdsems.database.mapper;

import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import com.gistone.cdsems.database.entity.TPRELIMINARYCONTAMINATED;
import com.gistone.cdsems.database.entity.TPRELIMINARYCONTAMINATEDExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPRELIMINARYCONTAMINATEDMapper {
    long countByExample(TPRELIMINARYCONTAMINATEDExample example);

    int deleteByExample(TPRELIMINARYCONTAMINATEDExample example);

    int deleteByPrimaryKey(Long cid);

    int deleteByPrimaryKeys(Long pid);

    int insert(Object record);

    int insertSelective(TPRELIMINARYCONTAMINATED record);

    List<TPRELIMINARYCONTAMINATED> selectByExample(TPRELIMINARYCONTAMINATEDExample example);

    TPRELIMINARYCONTAMINATED selectByPrimaryKey(Long pid);

    int updateByExampleSelective(@Param("record") TPRELIMINARYCONTAMINATED record, @Param("example") TPRELIMINARYCONTAMINATEDExample example);

    int updateByExample(@Param("record") TPRELIMINARYCONTAMINATED record, @Param("example") TPRELIMINARYCONTAMINATEDExample example);

    int updateByPrimaryKeySelective(Object record);

    int updateByPrimaryKey(Object record);

    //初步调查查询列表
    List<TBASICSCONTAMINATED> selectByEntityPage(TBASICSCONTAMINATED tbasicscontaminated);
    //初步调查总数
    int selectByCount(TBASICSCONTAMINATED tbasicscontaminated);

}