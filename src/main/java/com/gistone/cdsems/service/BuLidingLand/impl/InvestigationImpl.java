package com.gistone.cdsems.service.BuLidingLand.impl;

import com.gistone.cdsems.database.entity.TBULIDINGLAND;
import com.gistone.cdsems.database.entity.TINVESTIGATIONLAND;
import com.gistone.cdsems.database.mapper.TINVESTIGATIONLANDMapper;
import com.gistone.cdsems.service.BuLidingLand.InvestigationService;
import com.gistone.cdsems.util.EdatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestigationImpl implements InvestigationService {
    @Autowired
    private TINVESTIGATIONLANDMapper tinvestigationlandMapper;

    @Override
    public EdatResult save(Object record) throws Exception {
        try{
            tinvestigationlandMapper.insert(record);
            return EdatResult.ok("建设用地调查添加数据成功！ID（"+((TINVESTIGATIONLAND)record).getIid()+"）");
        } catch (Exception e ) {
            return EdatResult.build(1001, "建设用地调查添加数据异常！");
        }
    }

    @Override
    public EdatResult updateByPrimaryKeySelective(Object record) {
        try{
            tinvestigationlandMapper.updateByPrimaryKeySelective(record);
            return EdatResult.ok("建设用地调查修改成功！ID（"+((TINVESTIGATIONLAND) record).getIid()+"）");
        } catch (Exception e ) {
            return EdatResult.build(1003, "建设用地调查更新数据异常");
        }
    }

    @Override
    public EdatResult deleteByPrimaryKey(Long cid) {
        try{
            tinvestigationlandMapper.deleteByPrimaryKeys(cid);
            return EdatResult.ok("建设用地调查删除成功！ID（"+cid+"）");
        } catch (Exception e ) {
            return EdatResult.build(1002, "建设用地调查删除数据异常！");
        }
    }

    @Override
    public EdatResult deleteByPrimaryKeyBatch(String[] str) {
        try{
            for ( int i = 0 ; i < str.length;i++){
                tinvestigationlandMapper.deleteByPrimaryKeys(Long.parseLong(str[i]));
            }
            return EdatResult.ok("建设用地调查批量删除数据成功！");
        } catch (Exception e ) {
            return EdatResult.build(1002, "建设用地调查批量删除数据异常！");
        }
    }

    @Override
    public EdatResult list(TBULIDINGLAND tbulidingland) {
        try{
            int size = tbulidingland.getPageSize();
            int number = tbulidingland.getPageNumber();
            int page = (number/size)+1;
            List<TBULIDINGLAND> list = tinvestigationlandMapper.selectByEntityPage(tbulidingland);
            Integer total = tinvestigationlandMapper.selectByCount(tbulidingland);
            return EdatResult.build(list, page, total);
        } catch (Exception e ) {
            return EdatResult.build(1004, "selectInvestigationTable 查询数据异常");
        }
    }
}
