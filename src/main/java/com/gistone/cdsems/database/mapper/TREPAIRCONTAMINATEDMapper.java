package com.gistone.cdsems.database.mapper;

import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import com.gistone.cdsems.database.entity.TREPAIRCONTAMINATED;
import com.gistone.cdsems.database.entity.TREPAIRCONTAMINATEDExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TREPAIRCONTAMINATEDMapper {
    long countByExample(TREPAIRCONTAMINATEDExample example);

    int deleteByExample(TREPAIRCONTAMINATEDExample example);

    int deleteByPrimaryKey(Long cid);

    int deleteByPrimaryKeys(Long tid);

    int insert(Object record);

    int insertSelective(TREPAIRCONTAMINATED record);

    List<TREPAIRCONTAMINATED> selectByExample(TREPAIRCONTAMINATEDExample example);

    TREPAIRCONTAMINATED selectByPrimaryKey(Long tid);

    int updateByExampleSelective(@Param("record") TREPAIRCONTAMINATED record, @Param("example") TREPAIRCONTAMINATEDExample example);

    int updateByExample(@Param("record") TREPAIRCONTAMINATED record, @Param("example") TREPAIRCONTAMINATEDExample example);

    int updateByPrimaryKeySelective(Object record);

    int updateByPrimaryKey(TREPAIRCONTAMINATED record);
    //治理修复列表
    List<TBASICSCONTAMINATED> selectByEntityPage(TBASICSCONTAMINATED tbasicscontaminated);
    //治理修复总数
    int selectByCount(TBASICSCONTAMINATED tbasicscontaminated);


}