package com.gistone.cdsems.service.contaminated.impl;

import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import com.gistone.cdsems.database.entity.TREPAIRCONTAMINATED;
import com.gistone.cdsems.database.mapper.TREPAIRCONTAMINATEDMapper;
import com.gistone.cdsems.service.contaminated.RepairService;
import com.gistone.cdsems.util.EdatResult;
import com.gistone.cdsems.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairImpl implements RepairService {
    @Autowired
    private TREPAIRCONTAMINATEDMapper trepaircontaminatedMapper;

    @Override
    public EdatResult save(Object record) throws Exception {
        try{
            trepaircontaminatedMapper.insert(record);
            return  EdatResult.ok("污染地块治理修复添加成功！ID（"+((TREPAIRCONTAMINATED)record).getTid()+"）");
        } catch (Exception e) {
            return EdatResult.build(1001, "污染地块治理修复添加数据异常");
        }
    }

    @Override
    public EdatResult updateByPrimaryKeySelective(Object record) {
        try{
            trepaircontaminatedMapper.updateByPrimaryKeySelective(record);
            return EdatResult.ok("污染地块治理修复修改成功！ID（"+((TREPAIRCONTAMINATED ) record).getTid()+"）");
        } catch (Exception e) {
            return EdatResult.build(1003, "污染地块治理修复更新数据异常");
        }
    }

    @Override
    public EdatResult deleteByPrimaryKey(Long cid) {
        try{
            trepaircontaminatedMapper.deleteByPrimaryKeys(cid);
            return EdatResult.ok("污染地块治理修复删除成功！ID（"+cid+"）");
        } catch (Exception e) {
            return EdatResult.build(1002, "污染地块治理修复删除数据异常");
        }
    }

    @Override
    public EdatResult deleteByPrimaryKeyBatch(String[] str) {
        try{
            for ( int i = 0 ; i < str.length; i++ ) {
                trepaircontaminatedMapper.deleteByPrimaryKeys(Long.parseLong(str[i]));
            }

            return EdatResult.ok("污染地块治理修复批量删除成功！");
        } catch (Exception e) {
            return EdatResult.build(1002, "污染地块治理修复批量删除数据异常");
        }
    }

    @Override
    public EdatResult list(TBASICSCONTAMINATED tbasicscontaminated) {
        try{
            int size = tbasicscontaminated.getPageSize();
            int number = tbasicscontaminated.getPageNumber();
            int page = (number/size)+1;
            List<TBASICSCONTAMINATED> list = trepaircontaminatedMapper.selectByEntityPage(tbasicscontaminated);
            Integer total = trepaircontaminatedMapper.selectByCount(tbasicscontaminated);
            return EdatResult.build(list, page, total);
        } catch (Exception e) {
            return EdatResult.build(1003, "selectRepairTable 治理修复查询数据异常");
        }
    }
}
