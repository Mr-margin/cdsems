package com.gistone.cdsems.database.mapper;

import com.gistone.cdsems.database.entity.TBULIDINGLAND;
import com.gistone.cdsems.database.entity.TINVESTIGATIONLAND;
import com.gistone.cdsems.database.entity.TINVESTIGATIONLANDExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TINVESTIGATIONLANDMapper {
    long countByExample(TINVESTIGATIONLANDExample example);

    int deleteByExample(TINVESTIGATIONLANDExample example);

    int deleteByPrimaryKey(Long lid);

    int deleteByPrimaryKeys(Long iid);

    int insert(Object record);

    int insertSelective(TINVESTIGATIONLAND record);

    List<TINVESTIGATIONLAND> selectByExample(TINVESTIGATIONLANDExample example);

    TINVESTIGATIONLAND selectByPrimaryKey(Long iid);

    int updateByExampleSelective(@Param("record") TINVESTIGATIONLAND record, @Param("example") TINVESTIGATIONLANDExample example);

    int updateByExample(@Param("record") TINVESTIGATIONLAND record, @Param("example") TINVESTIGATIONLANDExample example);

    int updateByPrimaryKeySelective(Object record);

    int updateByPrimaryKey(TINVESTIGATIONLAND record);

    //表格分页数据
    List<TBULIDINGLAND> selectByEntityPage(TBULIDINGLAND tbulidingland);
    //表格数据总数
    int selectByCount(TBULIDINGLAND tbulidingland);
}