package com.gistone.cdsems.database.mapper;

import com.gistone.cdsems.database.entity.TBULIDINGLAND;
import com.gistone.cdsems.database.entity.TBULIDINGLANDExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TBULIDINGLANDMapper {
    long countByExample(TBULIDINGLANDExample example);

    int deleteByExample(TBULIDINGLANDExample example);

    int deleteByPrimaryKey(Long lid);

    int insert(Object record);

    int insertSelective(TBULIDINGLAND record);

    List<TBULIDINGLAND> selectByExample(TBULIDINGLANDExample example);

    TBULIDINGLAND selectByPrimaryKey(Long lid);

    int updateByExampleSelective(@Param("record") TBULIDINGLAND record, @Param("example") TBULIDINGLANDExample example);

    int updateByExample(@Param("record") TBULIDINGLAND record, @Param("example") TBULIDINGLANDExample example);

    int updateByPrimaryKeySelective(Object record);

    int updateByPrimaryKey(TBULIDINGLAND record);

    //分页表格数据
    List<TBULIDINGLAND> selectByEntityPage(TBULIDINGLAND tbulidingland);
    //分页总数
    int selectByCount(TBULIDINGLAND tbulidingland);
    //批量导入
    void insertBath(@Param("list") List<Map> list);
    //批量导出
    List<TBULIDINGLAND> selectListByLids(TBULIDINGLAND tbulidingland);
    //查询所有的建设用地
    List<Map> selectAll(TBULIDINGLAND  tbulidingland);
    //根据县查询详细信息
    List<Map> selectByCounty(TBULIDINGLAND tbulidingland);
    //根据市统计各个县的数据
    List<Map> selectByCity(TBULIDINGLAND tbulidingland);
    // 查询整个市的数据
    List<Map> selectAllCity(TBULIDINGLAND tbulidingland);

	int alreadyShown(TBULIDINGLAND tbulidingland);
    
}