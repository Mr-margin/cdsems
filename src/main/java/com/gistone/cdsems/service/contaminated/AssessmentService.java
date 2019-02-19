package com.gistone.cdsems.service.contaminated;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import com.gistone.cdsems.util.EdatResult;
import org.springframework.stereotype.Service;

/**
 * @author chendong
 * @date 2018-11-27 14:39
 * @param
 * @return
 * @Description 风险评估Service
 */
@Service
public interface AssessmentService {
    //风险评估添加
    @MyPermission(module="22")
    EdatResult save(Object record)throws Exception;

    //风险评估修改
    @MyPermission(module="23")
    EdatResult updateByPrimaryKeySelective( Object record);

    //风险评估删除
    @MyPermission(module="24")
    EdatResult deleteByPrimaryKey( Long cid);

    //批量删除风险评估
    @MyPermission(module="25")
    EdatResult deleteByPrimaryKeyBatch(String[] str);

    //风险评估列表
    @MyPermission(module="21")
    EdatResult list( TBASICSCONTAMINATED tbasicscontaminated);
}
