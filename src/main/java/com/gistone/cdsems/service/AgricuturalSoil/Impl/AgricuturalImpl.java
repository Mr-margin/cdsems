package com.gistone.cdsems.service.AgricuturalSoil.Impl;

import com.gistone.cdsems.database.entity.TAGRICUTURALSOIL;
import com.gistone.cdsems.database.mapper.TAGRICUTURALSOILMapper;
import com.gistone.cdsems.database.mapper.TMONITORSOILMapper;
import com.gistone.cdsems.service.AgricuturalSoil.AgricuturalService;
import com.gistone.cdsems.util.EdatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AgricuturalImpl implements AgricuturalService {
    @Autowired
    TAGRICUTURALSOILMapper tagricuturalsoilMapper;
    @Autowired
    TMONITORSOILMapper tmonitorsoilMapper;
    @Override
    public EdatResult save(Object record) throws Exception {
        try {
            tagricuturalsoilMapper.insert(record);
            return EdatResult.ok("农用地基础信息添加成功！ID（"+((TAGRICUTURALSOIL)record).getAid()+"）");
        } catch (Exception e ) {
            return EdatResult.build(1001, "saveAgricuturalSoil 农用地数据添加数据异常");
        }
    }

    @Override
    public EdatResult updateByPrimaryKeySelective(Object record) {
        try {
            tagricuturalsoilMapper.updateByPrimaryKeySelective(record);
            return EdatResult.ok("农用地基础信息修改成功！（ID："+((TAGRICUTURALSOIL) record).getAid()+"）");
        } catch (Exception e ) {
            return EdatResult.build(1003, "saveAgricuturalSoil 农用地数据添加数据异常");
        }
    }

    @Override
    public EdatResult deleteByPrimaryKey(Long cid) {
        try {
            tagricuturalsoilMapper.deleteByPrimaryKey(cid);
            tmonitorsoilMapper.deleteByPrimaryKey(cid);
            return EdatResult.ok("农用地基础信息删除成功！ID（"+cid+"）");
        } catch (Exception e ) {
            return EdatResult.build(1002, "deleteAgricuturalSoil 删除农用地数据异常");
        }
    }

    @Override
    public EdatResult deleteByPrimaryKeyBatch(String[] str) {
        try {
            for( int i = 0 ; i < str.length;i ++ ) {
                tagricuturalsoilMapper.deleteByPrimaryKey(Long.parseLong(str[i]));
                tmonitorsoilMapper.deleteByPrimaryKey(Long.parseLong(str[i]));
            }
            return EdatResult.ok("农用地基础信息批量删除成功！");
        } catch (Exception e ) {
            return EdatResult.build(1002, "deleteAgricuturalSoilBatch 删除农用地数据异常");
        }
    }

    @Override
    public EdatResult saveBath(List<Map> list) {
        try {
            tagricuturalsoilMapper.insertBath(list);
            return EdatResult.ok("农用地批量导入成功！");
        } catch (Exception e ) {
            return EdatResult.build(1003, "importAgricuturalBatch 农用地批量导入异常");
        }
    }

    @Override
    public EdatResult selectListByAids(TAGRICUTURALSOIL tagricuturalsoil) {
        try {
            List<TAGRICUTURALSOIL> data =  tagricuturalsoilMapper.selectListByAids(tagricuturalsoil);
            return EdatResult.ok(data,"导出成功");
        } catch (Exception e ) {
            return EdatResult.build(1005,"导出失败");
        }
    }

    @Override
    public EdatResult list(TAGRICUTURALSOIL tagricuturalsoil) {
        try {
            int size = tagricuturalsoil.getPageSize();
            int number = tagricuturalsoil.getPageNumber();
            int page = (number/size)+1;
            List<TAGRICUTURALSOIL> list = tagricuturalsoilMapper.selectByEntityPage(tagricuturalsoil);
            Integer total = tagricuturalsoilMapper.selectByCount(tagricuturalsoil);
            return EdatResult.build(list, page, total);
        } catch (Exception e ) {
            return EdatResult.build(1001, "AgricuturalSoilTable 农用地数据查询列表异常");
        }
    }

    @Override
    public EdatResult selectAll(TAGRICUTURALSOIL tagricuturalsoil) {
        try {
            List<TAGRICUTURALSOIL> list = tagricuturalsoilMapper.selectAll(tagricuturalsoil);
            return EdatResult.ok(list);
        } catch (Exception e ) {
            return EdatResult.build(1001, "selectAll 查询异常");
        }
    }
}
