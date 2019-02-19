package com.gistone.cdsems.service.contaminated.impl;

import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import com.gistone.cdsems.database.entity.TPRELIMINARYCONTAMINATED;
import com.gistone.cdsems.database.mapper.TPRELIMINARYCONTAMINATEDMapper;
import com.gistone.cdsems.service.contaminated.TPreliminaryService;
import com.gistone.cdsems.util.EdatResult;
import com.gistone.cdsems.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TPreliminaryImpl implements TPreliminaryService {
    @Autowired
    private TPRELIMINARYCONTAMINATEDMapper tpreliminarycontaminatedMapper;

    @Override
    public EdatResult save(Object record) throws Exception {
        try{
            tpreliminarycontaminatedMapper.insert(record);
            return EdatResult.ok("污染地块初步调查添加成功！ID（"+((TPRELIMINARYCONTAMINATED)record).getPid()+"）");
        } catch (Exception e){
            return EdatResult.build(1001, "污染地块初步调查添加数据异常");
        }
    }

    @Override
    public EdatResult updateByPrimaryKeySelective(Object record) {
        try{
            tpreliminarycontaminatedMapper.updateByPrimaryKeySelective(record);
            return EdatResult.ok("污染地块初步调查修改成功！");
        } catch (Exception e){
            return EdatResult.build(1003, "污染地块初步调查更新数据异常");
        }
    }

    @Override
    public EdatResult deleteByPrimaryKey(Long cid) {
        try{
            tpreliminarycontaminatedMapper.deleteByPrimaryKeys(cid);
            return EdatResult.ok("污染地块初步调查删除成功！ID（"+cid+"）");
        } catch (Exception e){
            return EdatResult.build(1002, "污染地块初步调查删除数据异常");
        }
    }

    @Override
    public EdatResult deleteByPrimaryKeyBatch(String[] str) {
        try{
            for ( int i = 0 ; i < str.length ; i ++ ) {
                tpreliminarycontaminatedMapper.deleteByPrimaryKeys(Long.parseLong(str[i]));
            }
            return EdatResult.ok("污染地块初步调查批量删除成功！");
        } catch (Exception e){
            return EdatResult.build(1002, "污染地块初步调查批量删除数据异常");
        }
    }

    @Override
    public EdatResult list(TBASICSCONTAMINATED tbasicscontaminated) {
        try{
            int size = tbasicscontaminated.getPageSize();
            int number = tbasicscontaminated.getPageNumber();
            int page = (number/size)+1;
            List<TBASICSCONTAMINATED> list = tpreliminarycontaminatedMapper.selectByEntityPage(tbasicscontaminated);
            Integer total = tpreliminarycontaminatedMapper.selectByCount(tbasicscontaminated);
            return EdatResult.build(list, page, total);
        } catch (Exception e){
            return EdatResult.build(1003, "selectPreliminaryTable 初步调查查询数据异常");
        }
    }
}
