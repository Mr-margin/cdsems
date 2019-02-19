package com.gistone.cdsems.service.contaminated.impl;

import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import com.gistone.cdsems.database.entity.TDETAILEDCONTAMINATED;
import com.gistone.cdsems.database.mapper.TDETAILEDCONTAMINATEDMapper;
import com.gistone.cdsems.service.contaminated.DetailedService;
import com.gistone.cdsems.util.EdatResult;
import com.gistone.cdsems.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailedImpl implements DetailedService {
    @Autowired
    private TDETAILEDCONTAMINATEDMapper tdetailedcontaminatedMapper;

    @Override
    public EdatResult save(Object record) throws Exception {
        try{
            tdetailedcontaminatedMapper.insert(record);
            return EdatResult.ok("污染地块详细调查添加成功！ID（"+((TDETAILEDCONTAMINATED)record ).getDid()+"）");
        } catch (Exception e){
            return EdatResult.build(1001, "污染地块详细调查添加数据异常！");
        }
    }

    @Override
    public EdatResult updateByPrimaryKeySelective(Object record) {
        try{
            tdetailedcontaminatedMapper.updateByPrimaryKeySelective(record);
            return EdatResult.ok("污染地块详细调查修改成功！ID（"+((TDETAILEDCONTAMINATED) record).getDid()+"）");
        } catch (Exception e){
            return EdatResult.build(1003, "污染地块详细调查更新数据异常！");
        }
    }

    @Override
    public EdatResult deleteByPrimaryKey(Long cid) {
        try{
            tdetailedcontaminatedMapper.deleteByPrimaryKeys(cid);
            return EdatResult.ok("污染地块详细调查删除成功！ID（"+cid+")");
        } catch (Exception e){
            return EdatResult.build(1002, "污染地块详细调查删除异常");
        }
    }

    @Override
    public EdatResult deleteByPrimaryKeyBatch(String[] str) {
        try{
            for ( int i = 0 ; i < str.length; i++ ) {
                tdetailedcontaminatedMapper.deleteByPrimaryKeys(Long.parseLong(str[i]));
            }
            return EdatResult.ok("污染地块详细调查批量删除成功！");
        } catch (Exception e){
            return EdatResult.build(1002, "污染地块详细调查批量删除数据异常");
        }
    }

    @Override
    public EdatResult list(TBASICSCONTAMINATED tbasicscontaminated) {
        try{
            int size = tbasicscontaminated.getPageSize();
            int number = tbasicscontaminated.getPageNumber();
            int page = (number/size)+1;
            List<TBASICSCONTAMINATED> list = tdetailedcontaminatedMapper.selectByEntityPage(tbasicscontaminated);
            Integer total = tdetailedcontaminatedMapper.selectByCount(tbasicscontaminated);
            return EdatResult.build(list, page, total);
        } catch (Exception e){
            return EdatResult.build(1004, "selectDetailedTable 详细调查调查查询数据异常");
        }
    }
}
