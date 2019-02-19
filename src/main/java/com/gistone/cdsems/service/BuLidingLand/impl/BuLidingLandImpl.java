package com.gistone.cdsems.service.BuLidingLand.impl;

import com.gistone.cdsems.database.entity.TBULIDINGLAND;
import com.gistone.cdsems.database.entity.TINVESTIGATIONLAND;
import com.gistone.cdsems.database.mapper.TBULIDINGLANDMapper;
import com.gistone.cdsems.database.mapper.TINVESTIGATIONLANDMapper;
import com.gistone.cdsems.service.BuLidingLand.BuLidingLandService;
import com.gistone.cdsems.util.EdatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BuLidingLandImpl implements BuLidingLandService {
    @Autowired
    private TBULIDINGLANDMapper tbulidinglandMapper;
    @Autowired
    private TINVESTIGATIONLANDMapper tinvestigationlandMapper;

    @Override
    public EdatResult save(Object record) throws Exception {
        try{
            tbulidinglandMapper.insert(record);
            return EdatResult.ok("建设用地基础信息添加成功！ID（"+((TBULIDINGLAND)record).getLid()+"）");
        } catch (Exception e ) {
            return EdatResult.build(1001, "建设用地基础信息添加数据异常！");
        }
    }

    @Override
    public EdatResult updateByPrimaryKeySelective(Object record) {
        try{
            tbulidinglandMapper.updateByPrimaryKeySelective(record);
            return EdatResult.ok("建设用地基础信息修改成功！ID（"+((TBULIDINGLAND) record).getLid()+"）");
        } catch (Exception e ) {
            return EdatResult.build(1003, "建设用地基础信息更新数据异常！");
        }
    }

    @Override
    public EdatResult deleteByPrimaryKey(Long cid) {
        try{
            tbulidinglandMapper.deleteByPrimaryKey(cid);
            tinvestigationlandMapper.deleteByPrimaryKey(cid);
            return EdatResult.ok("建设用地基础信息删除成功！ID（"+cid+"）");
        } catch (Exception e ) {
            return EdatResult.build(1002, "建设用地基础信息删除数据异常");
        }
    }

    @Override
    public EdatResult deleteByPrimaryKeyBatch(String[] str) {
        try{
            for( int i = 0 ; i < str.length;i ++ ) {
                tbulidinglandMapper.deleteByPrimaryKey(Long.parseLong(str[i]));
                tinvestigationlandMapper.deleteByPrimaryKey(Long.parseLong(str[i]));
            }
            return EdatResult.ok("建设用地基础信息批量删除成功！");
        } catch (Exception e ) {
            return EdatResult.build(1002, "建设用地基础信息删除数据异常");
        }
    }

    @Override
    public EdatResult saveBath(List<Map> list) {
        try{
            tbulidinglandMapper.insertBath(list);
            return EdatResult.ok("建设用地批量导入成功！");
        } catch (Exception e ) {
            return EdatResult.build(1001, "建设用地导入异常");
        }
    }

    @Override
    public EdatResult selectListByLids(TBULIDINGLAND tbulidingland) {
        try{
            List<TBULIDINGLAND> data = tbulidinglandMapper.selectListByLids(tbulidingland);
            return EdatResult.ok(data,"建设用地导出成功");
        } catch (Exception e ) {
            return EdatResult.build(1004, "建设用地导出异常");
        }
    }

    @Override
    public EdatResult list(TBULIDINGLAND tbulidingland) {
        try{
            int size = tbulidingland.getPageSize();
            int number = tbulidingland.getPageNumber();
            int page = (number/size)+1;
            List<TBULIDINGLAND> list = tbulidinglandMapper.selectByEntityPage(tbulidingland);
            Integer total = tbulidinglandMapper.selectByCount(tbulidingland);
            return EdatResult.build(list, page, total);
        } catch (Exception e ) {
            return EdatResult.build(1004, "selectBuLidingTable 查询数据异常");
        }
    }

    @Override
    public EdatResult selectAll(TBULIDINGLAND tbulidingland) {
        try{
            List<Map> list = tbulidinglandMapper.selectAll(tbulidingland);
            return EdatResult.ok(list);
        } catch (Exception e ) {
            return EdatResult.build(1001, "selectBuLidingAll 查询异常");
        }
    }
}
