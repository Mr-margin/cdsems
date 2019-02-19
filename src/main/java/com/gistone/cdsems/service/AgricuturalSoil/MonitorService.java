package com.gistone.cdsems.service.AgricuturalSoil;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.TAGRICUTURALSOIL;
import com.gistone.cdsems.util.EdatResult;
import org.springframework.stereotype.Service;

@Service
public interface MonitorService {
    //添加
    @MyPermission(module="50")
    EdatResult save(Object record)throws Exception;

    //修改
    @MyPermission(module="51")
    EdatResult updateByPrimaryKeySelective( Object record);

    //删除
    @MyPermission(module="52")
    EdatResult deleteByPrimaryKey( Long cid);

    //批量删除删除
    @MyPermission(module="53")
    EdatResult deleteByPrimaryKeyBatch( String[] str);

    //列表
    @MyPermission(module="49")
    EdatResult list( TAGRICUTURALSOIL tagricuturalsoil);
}
