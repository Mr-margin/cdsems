package com.gistone.cdsems.service.BuLidingLand;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.TBULIDINGLAND;
import com.gistone.cdsems.util.EdatResult;
import org.springframework.stereotype.Service;

@Service
public interface InvestigationService {
    //添加
    @MyPermission(module="106")
    EdatResult save(Object record)throws Exception;

    //修改
    @MyPermission(module="107")
    EdatResult updateByPrimaryKeySelective( Object record);

    //删除
    @MyPermission(module="108")
    EdatResult deleteByPrimaryKey( Long cid);

    //批量删除删除
    @MyPermission(module="109")
    EdatResult deleteByPrimaryKeyBatch(String[] str);

    //批量删除删除
    @MyPermission(module="105")
    EdatResult list( TBULIDINGLAND tbulidingland);
}
