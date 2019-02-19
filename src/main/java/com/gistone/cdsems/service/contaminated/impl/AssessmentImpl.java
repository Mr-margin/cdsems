package com.gistone.cdsems.service.contaminated.impl;

import com.gistone.cdsems.database.entity.TASSESSMENTCONTAMINATED;
import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import com.gistone.cdsems.database.mapper.TASSESSMENTCONTAMINATEDMapper;
import com.gistone.cdsems.service.contaminated.AssessmentService;
import com.gistone.cdsems.util.EdatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentImpl implements AssessmentService {
    @Autowired
    private TASSESSMENTCONTAMINATEDMapper tassessmentcontaminatedMapper;

    @Override
    public EdatResult save(Object record) throws Exception {
        try {
            tassessmentcontaminatedMapper.insert(record);
            return EdatResult.ok("污染地块风险评估添加成功！ID（"+((TASSESSMENTCONTAMINATED)record).getRid()+"）");
        } catch (Exception e){
            return EdatResult.build(1001, "污染地块风险评估添加数据异常");
        }
    }

    @Override
    public EdatResult updateByPrimaryKeySelective(Object record) {
        try {
            tassessmentcontaminatedMapper.updateByPrimaryKeySelective(record);
            return EdatResult.ok("污染地块风险评估修改成功！ID（"+((TASSESSMENTCONTAMINATED) record).getRid()+"）");
        } catch (Exception e){
            return EdatResult.build(1001, "污染地块风险评估更新数据异常！");
        }
    }

    @Override
    public EdatResult deleteByPrimaryKey(Long cid) {
        try {
            tassessmentcontaminatedMapper.deleteByPrimaryKeys(cid);
            return EdatResult.ok("污染地块风险评估删除成功！ID（"+cid+"）");
        } catch (Exception e){
            return EdatResult.build(1002, "污染地块风险评估删除数据异常！");
        }
    }

    @Override
    public EdatResult deleteByPrimaryKeyBatch(String[] str) {
        try {
            for( int i = 0 ; i < str.length ; i ++ ) {
                tassessmentcontaminatedMapper.deleteByPrimaryKeys(Long.parseLong(str[i]));
            }
            return EdatResult.ok("污染地块风险评估批量删除数据成功！");
        } catch (Exception e){
            return EdatResult.build(1002, "污染地块风险评估批量删除数据异常！");
        }
    }

    @Override
    public EdatResult list(TBASICSCONTAMINATED tbasicscontaminated) {
        try {
            int size = tbasicscontaminated.getPageSize();
            int number = tbasicscontaminated.getPageNumber();
            int page = (number/size)+1;
            List<TBASICSCONTAMINATED> list = tassessmentcontaminatedMapper.selectByEntityPage(tbasicscontaminated);
            Integer total = tassessmentcontaminatedMapper.selectByCount(tbasicscontaminated);
            return EdatResult.build(list, page, total);
        } catch (Exception e){
            return EdatResult.build(1004, "selectAssessmentTable 风险评估查询数据异常");
        }
    }
}
