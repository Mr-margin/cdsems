package com.gistone.cdsems.service.contaminated;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import com.gistone.cdsems.util.EdatResult;
import org.springframework.stereotype.Service;
/**
 * @author chendong
 * @date 2018-11-27 14:47
 * @param
 * @return
 * @Description  治理修复Service
 */
@Service
public interface RepairService {

    //添加
    @MyPermission(module="32")
    EdatResult save(Object record)throws Exception;

    //修改
    @MyPermission(module="33")
    EdatResult updateByPrimaryKeySelective( Object record);

    //删除
    @MyPermission(module="34")
    EdatResult deleteByPrimaryKey( Long cid);

    //批量删除删除
    @MyPermission(module="35")
    EdatResult deleteByPrimaryKeyBatch(String[] str);

    //批量删除删除
    @MyPermission(module="31")
    EdatResult list(TBASICSCONTAMINATED tbasicscontaminated);
}
