package com.gistone.cdsems.service.contaminated;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import com.gistone.cdsems.util.EdatResult;
import org.springframework.stereotype.Service;
/**
 * @author chendong
 * @date 2018-11-27 14:44
 * @param
 * @return
 * @Description 风险管控
 */
@Service
public interface ControlService {
    //添加
    @MyPermission(module="27")
    EdatResult save(Object record)throws Exception;

    //修改
    @MyPermission(module="28")
    EdatResult updateByPrimaryKeySelective( Object record);

    //删除
    @MyPermission(module="29")
    EdatResult deleteByPrimaryKey( Long cid);

    //批量删除删除
    @MyPermission(module="30")
    EdatResult deleteByPrimaryKeyBatch(String[] str);

    //风险管控列表
    @MyPermission(module="26")
    EdatResult list( TBASICSCONTAMINATED tbasicscontaminated);
}
