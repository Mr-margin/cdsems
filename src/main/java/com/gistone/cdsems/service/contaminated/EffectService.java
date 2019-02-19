package com.gistone.cdsems.service.contaminated;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import com.gistone.cdsems.util.EdatResult;
import org.springframework.stereotype.Service;

@Service
public interface EffectService {
    //添加
    @MyPermission(module="37")
    EdatResult save(Object record)throws Exception;

    //修改
    @MyPermission(module="38")
    EdatResult updateByPrimaryKeySelective( Object record);

    //删除
    @MyPermission(module="39")
    EdatResult deleteByPrimaryKey( Long cid);

    //批量删除删除
    @MyPermission(module="40")
    EdatResult deleteByPrimaryKeyBatch(String[] str);

    //效果评估列表
    @MyPermission(module="36")
    EdatResult list( TBASICSCONTAMINATED tbasicscontaminated);
}
