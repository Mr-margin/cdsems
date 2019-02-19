package com.gistone.cdsems.service.contaminated.impl;

import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import com.gistone.cdsems.database.entity.TCONTROLCONTAMINATED;
import com.gistone.cdsems.database.mapper.TCONTROLCONTAMINATEDMapper;
import com.gistone.cdsems.service.contaminated.ControlService;
import com.gistone.cdsems.util.EdatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControlImpl implements ControlService {
    @Autowired
    private TCONTROLCONTAMINATEDMapper tcontrolcontaminatedMapper;
    @Override
    public EdatResult save(Object record) throws Exception {
        try{
            tcontrolcontaminatedMapper.insert(record);
            return EdatResult.ok("污染地块风险管控添加成功！ID（"+((TCONTROLCONTAMINATED)record).getMid()+"）");
        } catch (Exception e ) {
            return EdatResult.build(1001, "insertTControlContaminated 污染地块风险管控添加数据异常！");
        }
    }

    @Override
    public EdatResult updateByPrimaryKeySelective(Object record) {
        try{
            tcontrolcontaminatedMapper.updateByPrimaryKeySelective(record);
            return EdatResult.ok("污染地块风险管控修改成功！ID（"+((TCONTROLCONTAMINATED) record).getMid()+"）");
        } catch (Exception e ) {
            return EdatResult.build(1003, "污染地块风险管控更新数据异常！");
        }
    }

    @Override
    public EdatResult deleteByPrimaryKey(Long cid) {
        try{
            tcontrolcontaminatedMapper.deleteByPrimaryKeys(cid);
            return EdatResult.ok("污染地块风险管控删除成功！ID（"+cid+"）");
        } catch (Exception e ) {
            return EdatResult.build(1002, "污染地块风险管控删除数据异常！");
        }
    }

    @Override
    public EdatResult deleteByPrimaryKeyBatch(String[] str) {
        try{
            for ( int i = 0 ; i < str.length; i++ ) {
                tcontrolcontaminatedMapper.deleteByPrimaryKeys(Long.parseLong(str[i]));
            }
            return EdatResult.ok("污染地块风险管控批量删除成功！");
        } catch (Exception e ) {
            return EdatResult.build(1002, "污染地块风险管控批量删除数据异常！");
        }
    }

    @Override
    public EdatResult list(TBASICSCONTAMINATED tbasicscontaminated) {
        try{
            int size = tbasicscontaminated.getPageSize();
            int number = tbasicscontaminated.getPageNumber();
            int page = (number/size)+1;
            List<TBASICSCONTAMINATED> list = tcontrolcontaminatedMapper.selectByEntityPage(tbasicscontaminated);
            Integer total = tcontrolcontaminatedMapper.selectByCount(tbasicscontaminated);
            return EdatResult.build(list, page, total);
        } catch (Exception e ) {
            return EdatResult.build(1003, "selectControlTable 风险管控查询数据异常");
        }
    }
}
