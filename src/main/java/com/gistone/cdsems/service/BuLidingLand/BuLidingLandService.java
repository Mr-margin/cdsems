package com.gistone.cdsems.service.BuLidingLand;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.TBULIDINGLAND;
import com.gistone.cdsems.util.EdatResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BuLidingLandService {
    //添加
    @MyPermission(module="99")
    EdatResult save(Object record)throws Exception;

    //修改
    @MyPermission(module="100")
    EdatResult updateByPrimaryKeySelective( Object record);

    //删除
    @MyPermission(module="101")
    EdatResult deleteByPrimaryKey( Long cid);

    //批量删除删除
    @MyPermission(module="102")
    EdatResult deleteByPrimaryKeyBatch(String[] str);

    //批量导入
    @MyPermission(module="103")
    EdatResult saveBath(List<Map> list);

    //批量导出
    @MyPermission(module="104")
    EdatResult selectListByLids(TBULIDINGLAND tbulidingland);

    //表格
    @MyPermission(module="98")
    EdatResult list(TBULIDINGLAND tbulidingland);

    EdatResult selectAll(TBULIDINGLAND tbulidingland);
}
