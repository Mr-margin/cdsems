package com.gistone.cdsems.database.mapper;

import com.gistone.cdsems.database.entity.TAGRICUTURALSOIL;
import com.gistone.cdsems.database.entity.TAGRICUTURALSOILExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TAGRICUTURALSOILMapper {
    long countByExample(TAGRICUTURALSOILExample example);

    int deleteByExample(TAGRICUTURALSOILExample example);

    int deleteByPrimaryKey(Long aid);

    //添加农用地数据
    int insert(Object record);

    int insertSelective(TAGRICUTURALSOIL record);

    List<TAGRICUTURALSOIL> selectByExample(TAGRICUTURALSOILExample example);

    TAGRICUTURALSOIL selectByPrimaryKey(Long aid);

    int updateByExampleSelective(@Param("record") TAGRICUTURALSOIL record, @Param("example") TAGRICUTURALSOILExample example);

    int updateByExample(@Param("record") TAGRICUTURALSOIL record, @Param("example") TAGRICUTURALSOILExample example);

    int updateByPrimaryKeySelective(Object record);

    int updateByPrimaryKey(TAGRICUTURALSOIL record);
    //农用地数据列表
    List<TAGRICUTURALSOIL> selectByEntityPage(TAGRICUTURALSOIL tagricuturalsoil);
    //农用地数据总数
    int selectByCount(TAGRICUTURALSOIL tagricuturalsoil);

    //批量导入农用地信息
    void insertBath(@Param("list")List<Map> list);
    //批量导出
    List<TAGRICUTURALSOIL> selectListByAids(TAGRICUTURALSOIL tagricuturalsoil);
    //查询所有农用地
    List<TAGRICUTURALSOIL> selectAll(TAGRICUTURALSOIL tagricuturalsoil);
  //根据县查询详细信息

    List<Map> selectByCounty(TAGRICUTURALSOIL tAgricuturalSoil);
    //根据市统计各个县的数据
    List<Map> selectByCity(TAGRICUTURALSOIL tAgricuturalSoil);
    // 查询整个市的数据
    List<Map> selectAllCity(TAGRICUTURALSOIL tAgricuturalSoil);
    // 已上图
	int alreadyShown(TAGRICUTURALSOIL tAgricuturalSoil);
}