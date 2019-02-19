package com.gistone.cdsems.service.contaminated.impl;

import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import com.gistone.cdsems.database.mapper.*;
import com.gistone.cdsems.service.contaminated.ContaminatedLandService;
import com.gistone.cdsems.util.EdatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ContanminatedLandImpl implements ContaminatedLandService {
    @Autowired
    private TBASICSCONTAMINATEDMapper tbasicscontaminatedMapper;
    @Autowired
    private TPRELIMINARYCONTAMINATEDMapper tpreliminarycontaminatedMapper;
    @Autowired
    private TDETAILEDCONTAMINATEDMapper tdetailedcontaminatedMapper;
    @Autowired
    private TASSESSMENTCONTAMINATEDMapper tassessmentcontaminatedMapper;
    @Autowired
    private TCONTROLCONTAMINATEDMapper tcontrolcontaminatedMapper;
    @Autowired
    private TREPAIRCONTAMINATEDMapper trepaircontaminatedMapper;
    @Autowired
    private  TEFFECTCONTAMINATEDMapper teffectcontaminatedMapper;
    @Override
    public EdatResult save(Object record) throws Exception {
        try {
            tbasicscontaminatedMapper.insert(record);
            return EdatResult.ok("污染地块基础信息添加成功！ID（"+((TBASICSCONTAMINATED) record).getCid()+"）");
        } catch (Exception  e ) {
            return EdatResult.build(1001,"污染地块基础信息添加异常！");
        }
    }
    @Override
    public EdatResult updateByPrimaryKeySelective(Object record) {
        try{
            tbasicscontaminatedMapper.updateByPrimaryKeySelective(record);
            Integer cid = Math.toIntExact(((TBASICSCONTAMINATED) record).getCid());
            return EdatResult.ok("污染地块基础信息修改成功！ID（"+cid+"）");
        } catch (Exception e ) {
            return EdatResult.build(1003,"污染地块基础信息修改异常！");
        }

    }

    @Override
    public EdatResult deleteByPrimaryKey(Long cid) {
        try {
            tbasicscontaminatedMapper.deleteByPrimaryKey(cid);
            tpreliminarycontaminatedMapper.deleteByPrimaryKey(cid);
            tdetailedcontaminatedMapper.deleteByPrimaryKey(cid);
            tassessmentcontaminatedMapper.deleteByPrimaryKey(cid);
            tcontrolcontaminatedMapper.deleteByPrimaryKey(cid);
            trepaircontaminatedMapper.deleteByPrimaryKey(cid);
            teffectcontaminatedMapper.deleteByPrimaryKey(cid);
            return EdatResult.ok("污染地块基础信息删除成功！ID（"+cid+"）");
        } catch (Exception e ) {
            return EdatResult.build(1002,"污染地块基础信息删除异常！");
        }

    }

    @Override
    public EdatResult deleteByPrimaryKeyBatch(String[] str) {
        try {
            for ( int i = 0 ; i < str.length; i++ ) {
                Long cid = Long.parseLong(str[i]);
                tbasicscontaminatedMapper.deleteByPrimaryKey(cid);
                tpreliminarycontaminatedMapper.deleteByPrimaryKey(cid);
                tdetailedcontaminatedMapper.deleteByPrimaryKey(cid);
                tassessmentcontaminatedMapper.deleteByPrimaryKey(cid);
                tcontrolcontaminatedMapper.deleteByPrimaryKey(cid);
                trepaircontaminatedMapper.deleteByPrimaryKey(cid);
                teffectcontaminatedMapper.deleteByPrimaryKey(cid);
            }
            return EdatResult.ok("污染地块基础信息批量删除成功！");
        } catch(Exception e ) {
            return EdatResult.build(1002,"污染地块基础信息批量删除异常！");
        }

    }

    @Override
    public EdatResult saveBath(List<Map> list) {
        try{
            tbasicscontaminatedMapper.insertBath(list);
            return EdatResult.ok("污染地块批量导入成功！");
        } catch (Exception e ) {
            return EdatResult.build(1003, "污染地块批量导入异常");
        }


    }

    @Override
    public EdatResult selectListByCids(TBASICSCONTAMINATED tbasicscontaminated) {
        try{
            List<TBASICSCONTAMINATED> data = tbasicscontaminatedMapper.selectListByCids(tbasicscontaminated);
            return EdatResult.ok(data,"污染地块导出成功");
        } catch (Exception e ) {
            return EdatResult.build(1003, "污染地块批量导出异常");
        }
    }

    @Override
    public EdatResult list(TBASICSCONTAMINATED tbasicscontaminated) {
        try{
            int size = tbasicscontaminated.getPageSize();
            int number = tbasicscontaminated.getPageNumber();
            int page = (number/size)+1;
            List<TBASICSCONTAMINATED> list = tbasicscontaminatedMapper.selectByEntityPage(tbasicscontaminated);
            int total = tbasicscontaminatedMapper.selectByCount(tbasicscontaminated);
            EdatResult result = EdatResult.build(list, page, total);
            return result;
        }catch (Exception e) {
            return EdatResult.build(1004, "selectContaminatedLand 查询数据异常");
        }
    }

    @Override
    public EdatResult selectAll(TBASICSCONTAMINATED tbasicscontaminated) {
        try{
            List<Map> list = tbasicscontaminatedMapper.selectAll(tbasicscontaminated);
            return EdatResult.ok(list);
        }catch (Exception e) {
            return EdatResult.build(1001, "selectContanminatedAll 查询异常");
        }
    }


}
