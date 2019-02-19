package com.gistone.cdsems.service.contaminated;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import com.gistone.cdsems.util.EdatResult;
import com.gistone.cdsems.util.Result;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ContaminatedLandService {

    //污染地块添加
    @MyPermission(module="5")
    EdatResult save(Object record)throws Exception;

    //污染地块修改
    @MyPermission(module="6")
    EdatResult updateByPrimaryKeySelective( Object record);

    //删除
    @MyPermission(module="7")
    EdatResult deleteByPrimaryKey( Long cid);

    //批量删除删除
    @MyPermission(module="8")
    EdatResult deleteByPrimaryKeyBatch(String[] str);

    //批量导入
    @MyPermission(module="9")
    EdatResult saveBath(List<Map> list);

    //批量导出
    @MyPermission(module="10")
    EdatResult selectListByCids(TBASICSCONTAMINATED tbasicscontaminated);

    //查询列表
    @MyPermission(module="4")
    EdatResult list(TBASICSCONTAMINATED tbasicscontaminated);

    EdatResult selectAll(TBASICSCONTAMINATED tbasicscontaminated);
}
