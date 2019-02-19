package com.gistone.cdsems.database.mapper;

import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import com.gistone.cdsems.database.entity.TBASICSCONTAMINATEDExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TBASICSCONTAMINATEDMapper {
    long countByExample(TBASICSCONTAMINATEDExample example);

    int deleteByExample(TBASICSCONTAMINATEDExample example);

    int deleteByPrimaryKey(Long cid);

    int insert(Object record);

    int insertSelective(TBASICSCONTAMINATED record);

    List<TBASICSCONTAMINATED> selectByExample(TBASICSCONTAMINATEDExample example);

    List<TBASICSCONTAMINATED> selectByEntityPage(TBASICSCONTAMINATED tbasicscontaminated);

    TBASICSCONTAMINATED selectByPrimaryKey(Long cid);

    int updateByExampleSelective(@Param("record") TBASICSCONTAMINATED record, @Param("example") TBASICSCONTAMINATEDExample example);

    int updateByExample(@Param("record") TBASICSCONTAMINATED record, @Param("example") TBASICSCONTAMINATEDExample example);

    int updateByPrimaryKeySelective(Object record);

    int updateByPrimaryKey(Object record);

    int selectByCount(TBASICSCONTAMINATED tbasicscontaminated);

    //批量导入污染地块信息
    void insertBath(@Param("list") List<Map> list);
    //批量导出
    List<TBASICSCONTAMINATED> selectListByCids(TBASICSCONTAMINATED tbasicscontaminated);
    //根据县查询详细信息
    List<Map> selectByCounty(TBASICSCONTAMINATED tbasicscontaminated);
    //根据市统计各个县的数据
    List<Map> selectByCity(TBASICSCONTAMINATED tbasicscontaminated);
    //查询所有污染地块
    List<Map> selectAll(TBASICSCONTAMINATED tbasicscontaminated);
    // 查询整个市的数据
    List<Map> selectAllCity(TBASICSCONTAMINATED tbasicscontaminated);
    // 通过污染地块编码查询数据
	List<Map> selectByMassifCode(TBASICSCONTAMINATED tbasicscontaminated);
	// 已上图
	int alreadyShown(TBASICSCONTAMINATED tbasicscontaminated);
	// 最近30天上传
	int confirmedInThelastThirtyDays(TBASICSCONTAMINATED tbasicscontaminated);
	
	List<Map> selectById(@Param("cid")Long cid);
	
}