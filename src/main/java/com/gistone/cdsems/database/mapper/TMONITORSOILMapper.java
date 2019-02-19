package com.gistone.cdsems.database.mapper;

import com.gistone.cdsems.database.entity.TAGRICUTURALSOIL;
import com.gistone.cdsems.database.entity.TMONITORSOIL;
import com.gistone.cdsems.database.entity.TMONITORSOILExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TMONITORSOILMapper {
    long countByExample(TMONITORSOILExample example);

    int deleteByExample(TMONITORSOILExample example);

    int deleteByPrimaryKey(Long aid);


    int deleteByPrimaryKeys(Long mid);

    //添加农用地监测数据
    int insert(Object record);

    int insertSelective(TMONITORSOIL record);

    List<TMONITORSOIL> selectByExample(TMONITORSOILExample example);

    TMONITORSOIL selectByPrimaryKey(Long mid);

    int updateByExampleSelective(@Param("record") TMONITORSOIL record, @Param("example") TMONITORSOILExample example);

    int updateByExample(@Param("record") TMONITORSOIL record, @Param("example") TMONITORSOILExample example);

    int updateByPrimaryKeySelective(Object record);

    int updateByPrimaryKey(TMONITORSOIL record);

    //分页表格
    List<TAGRICUTURALSOIL> selectByEntityPage(TAGRICUTURALSOIL tagricuturalsoil);
    //表格总数
    int selectByCount (TAGRICUTURALSOIL tagricuturalsoil);

}