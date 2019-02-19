package com.gistone.cdsems.service.AgricuturalSoil.Impl;

import com.gistone.cdsems.database.entity.TAGRICUTURALSOIL;
import com.gistone.cdsems.database.entity.TMONITORSOIL;
import com.gistone.cdsems.database.mapper.TMONITORSOILMapper;
import com.gistone.cdsems.service.AgricuturalSoil.MonitorService;
import com.gistone.cdsems.util.EdatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorImpl implements MonitorService {
    @Autowired
    private TMONITORSOILMapper tmonitorsoilMapper;

    @Override
    public EdatResult save(Object record) throws Exception {
        try{
            tmonitorsoilMapper.insert(record);
            return EdatResult.ok("农用地监测数据添加成功！ID（"+((TMONITORSOIL)record).getMid()+"）");
        } catch (Exception e ) {
            return EdatResult.build(1001, "saveMonitorSoil 农用地监测数据添加数据异常");
        }
    }

    @Override
    public EdatResult updateByPrimaryKeySelective(Object record) {
        try{
            tmonitorsoilMapper.updateByPrimaryKeySelective(record);
            return EdatResult.ok("农用地监测数据修改成功！ID（"+((TMONITORSOIL) record).getMid()+"）");
        } catch (Exception e ) {
            return EdatResult.build(1001, "saveMonitorSoil 农用地监测数据更新数据异常");
        }
    }

    @Override
    public EdatResult deleteByPrimaryKey(Long cid) {
        try{
            tmonitorsoilMapper.deleteByPrimaryKeys(cid);
            return EdatResult.ok("农用地监测数据删除成功！ID（"+cid+"）");
        } catch (Exception e ) {
            return EdatResult.build(1002, "deleteMonitor 删除农用地数据异常");
        }
    }

    @Override
    public EdatResult deleteByPrimaryKeyBatch(String[] str) {
        try{
            for( int i = 0 ; i < str.length;i ++ ) {
                tmonitorsoilMapper.deleteByPrimaryKeys(Long.parseLong(str[i]));
            }
            return EdatResult.ok("农用地监测数据批量删除成功！");
        } catch (Exception e ) {
            return EdatResult.build(1002, "deleteMonitorBatch 删除农用地数据异常");
        }
    }

    @Override
    public EdatResult list(TAGRICUTURALSOIL tagricuturalsoil) {
        try{
            int size = tagricuturalsoil.getPageSize();
            int number = tagricuturalsoil.getPageNumber();
            int page = (number/size)+1;
            List<TAGRICUTURALSOIL> list = tmonitorsoilMapper.selectByEntityPage(tagricuturalsoil);
            Integer total = tmonitorsoilMapper.selectByCount(tagricuturalsoil);
            return EdatResult.build(list, page, total);
        } catch (Exception e ) {
            return EdatResult.build(1001, "AgricuturalSoilTable 农用地数据查询列表异常");
        }
    }
}
