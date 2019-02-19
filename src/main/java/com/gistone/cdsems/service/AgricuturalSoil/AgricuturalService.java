package com.gistone.cdsems.service.AgricuturalSoil;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.TAGRICUTURALSOIL;
import com.gistone.cdsems.util.EdatResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface AgricuturalService {
    //添加
    @MyPermission(module="43")
    EdatResult save(Object record)throws Exception;

    //修改
    @MyPermission(module="44")
    EdatResult updateByPrimaryKeySelective( Object record);

    //删除
    @MyPermission(module="45")
    EdatResult deleteByPrimaryKey( Long cid);

    //批量删除删除
    @MyPermission(module="46")
    EdatResult deleteByPrimaryKeyBatch(String[] str);

    //批量导入
    @MyPermission(module="47")
    EdatResult saveBath(List<Map> list);

    //批量导出
    @MyPermission(module="48")
    EdatResult selectListByAids(TAGRICUTURALSOIL tagricuturalsoil);

    //农用地列表
    @MyPermission(module="42")
    EdatResult list(TAGRICUTURALSOIL tagricuturalsoil);

    //农用地列表
    EdatResult selectAll(TAGRICUTURALSOIL tagricuturalsoil);
}
