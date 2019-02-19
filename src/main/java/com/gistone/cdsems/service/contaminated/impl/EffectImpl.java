package com.gistone.cdsems.service.contaminated.impl;

import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import com.gistone.cdsems.database.entity.TEFFECTCONTAMINATED;
import com.gistone.cdsems.database.mapper.TEFFECTCONTAMINATEDMapper;
import com.gistone.cdsems.service.contaminated.EffectService;
import com.gistone.cdsems.util.EdatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EffectImpl implements EffectService {
    @Autowired
    private TEFFECTCONTAMINATEDMapper teffectcontaminatedMapper;
    @Override
    public EdatResult save(Object record) throws Exception {
        try{
            teffectcontaminatedMapper.insert(record);
            return EdatResult.ok("污染地块效果评估添加成功！ID（"+((TEFFECTCONTAMINATED)record).getEid()+"）");
        } catch(Exception e) {
            return EdatResult.build(1001, "insertTEffectContaminated 污染地块效果评估添加数据异常");
        }
    }

    @Override
    public EdatResult updateByPrimaryKeySelective(Object record) {
        try{
            teffectcontaminatedMapper.updateByPrimaryKeySelective(record);
            return EdatResult.ok("污染地块效果评估修改成功！ID（"+((TEFFECTCONTAMINATED) record).getEid()+"）");
        } catch(Exception e) {
            return EdatResult.build(1003, "insertTEffectContaminated 污染地块效果评估更新数据异常");
        }
    }

    @Override
    public EdatResult deleteByPrimaryKey(Long cid) {
        try{
            teffectcontaminatedMapper.deleteByPrimaryKeys(cid);
            return EdatResult.ok("污染地块效果评估删除成功！ID（"+cid+"）");
        } catch(Exception e) {
            return EdatResult.build(1002, "污染地块效果评估删除异常");
        }
    }

    @Override
    public EdatResult deleteByPrimaryKeyBatch(String[] str) {
        try{
            for ( int i = 0 ; i < str.length; i ++ ) {
                teffectcontaminatedMapper.deleteByPrimaryKeys(Long.parseLong(str[i]));
            }
            return EdatResult.ok("污染地块效果评估批量删除成功！");
        } catch(Exception e) {
            return EdatResult.build(1002, "污染地块效果评估批量删除异常");
        }
    }

    @Override
    public EdatResult list(TBASICSCONTAMINATED tbasicscontaminated) {
        try{
            int size = tbasicscontaminated.getPageSize();
            int number = tbasicscontaminated.getPageNumber();
            int page = (number/size)+1;
            List<TBASICSCONTAMINATED> list = teffectcontaminatedMapper.selectByEntityPage(tbasicscontaminated);
            Integer total = teffectcontaminatedMapper.selectByCount(tbasicscontaminated);
            return EdatResult.build(list, page, total);
        } catch(Exception e) {
            return EdatResult.build(1003, "selectEffectTable 效果评估查询数据异常");
        }
    }
}
