package com.gistone.cdsems.service.contaminated;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import com.gistone.cdsems.database.entity.TPRELIMINARYCONTAMINATED;
import com.gistone.cdsems.util.EdatResult;
import org.springframework.stereotype.Service;
/**
 * @author chendong
 * @date 2018-11-26 17:38
 * @param
 * @return
 * @Description 初步调查Service
 */
@Service
public interface TPreliminaryService {

    //初步调查添加
    @MyPermission(module="12")
    EdatResult save(Object record)throws Exception;

    //污染地块修改
    @MyPermission(module="13")
    EdatResult updateByPrimaryKeySelective( Object record);

    //删除
    @MyPermission(module="14")
    EdatResult deleteByPrimaryKey( Long cid);

    //批量删除删除
    @MyPermission(module="15")
    EdatResult deleteByPrimaryKeyBatch( String[] str);
    //列表查询
    @MyPermission(module = "11")
    EdatResult list (TBASICSCONTAMINATED tbasicscontaminated);
}
