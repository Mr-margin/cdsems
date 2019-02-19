package com.gistone.cdsems.service.contaminated;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import com.gistone.cdsems.util.EdatResult;
import org.springframework.stereotype.Service;
/**
 * @author chendong
 * @date 2018-11-26 17:59
 * @param
 * @return
 * @Description 详细调查
 */
@Service
public interface DetailedService {
    //初步调查添加
    @MyPermission(module="17")
    EdatResult save(Object record)throws Exception;

    //污染地块修改
    @MyPermission(module="18")
    EdatResult updateByPrimaryKeySelective( Object record);

    //删除
    @MyPermission(module="19")
    EdatResult deleteByPrimaryKey( Long cid);

    //批量删除删除
    @MyPermission(module="20")
    EdatResult deleteByPrimaryKeyBatch(String[] str);

    //批量删除删除
    @MyPermission(module="16")
    EdatResult list(TBASICSCONTAMINATED tbasicscontaminated);
}
