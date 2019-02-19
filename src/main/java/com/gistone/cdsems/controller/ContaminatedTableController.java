package com.gistone.cdsems.controller;

import com.gistone.cdsems.database.entity.*;
import com.gistone.cdsems.database.mapper.*;
import com.gistone.cdsems.service.contaminated.*;
import com.gistone.cdsems.util.EdatResult;
import com.gistone.cdsems.util.LogUtil;
import com.gistone.cdsems.util.Result;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @author chendong
 * @date 2018-11-22 14:49
 * @param
 * @return
 * @Description 污染地块表格
 */
@RestController
@RequestMapping("ContaminatedTableController")
public class ContaminatedTableController {
    @Autowired
    private TPreliminaryService tPreliminaryService;
    @Autowired
    private DetailedService detailedService;
    @Autowired
    private AssessmentService assessmentService;
    @Autowired
    private ControlService controlService;
    @Autowired
    private RepairService repairService;
    @Autowired
    private EffectService effectService;

    /**
     * @author chendong
     * @date 2018-11-22 15:16
     * @param
     * @return
     * @Description 污染地块初步调查列表
     */
    @RequestMapping("selectPreliminaryTable")
    public EdatResult selectPreliminaryTable(@RequestBody Map<String,Object> requestDate,HttpServletRequest request){
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            TPRELIMINARYCONTAMINATED tpreliminarycontaminated = new TPRELIMINARYCONTAMINATED();

            TBASICSCONTAMINATED tbasicscontaminated = new TBASICSCONTAMINATED();
            //地块名称
            if(!"".equals(data.get("massifName"))){
                tbasicscontaminated.setMassifName(data.get("massifName").toString());
            }
            //地块面积
            if(!"".equals(data.get("massifCovered"))){
                tbasicscontaminated.setMassifCovered(data.get("massifCovered").toString());
            }
            if(!"".equals(data.get("massifCovered1"))){
                tbasicscontaminated.setReservedField3(data.get("massifCovered1").toString());
            }
            //地块位置
            if(!"".equals(data.get("massifAddress"))){
                tbasicscontaminated.setMassifAddress(data.get("massifAddress").toString());
            }
            //县
            if(!"".equals(data.get("countyCode"))){
                tbasicscontaminated.setCountyCode(data.get("countyCode").toString());
            }
            HttpSession session = request.getSession();
            SysUser user = (SysUser) session.getAttribute("sysUser");
            if("3".equals(user.getSuLevel())){
                tbasicscontaminated.setCountyCode(user.getSuRegioncode());
            }
            Integer pageNumber = Integer.valueOf(data.get("pageNumber").toString());
            Integer pageSize = Integer.valueOf(data.get("pageSize").toString());
            tbasicscontaminated.setPageNumber(pageNumber+1);
            tbasicscontaminated.setPageSize(pageSize+pageNumber);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            EdatResult edatResult = tPreliminaryService.list(tbasicscontaminated);
            return edatResult;
        } catch (Exception e ) {
            LogUtil.getLogger().error("selectPreliminaryTable 初步调查查询数据异常",e);
            return EdatResult.build(1003, "selectPreliminaryTable 初步调查查询数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-22 15:28
     * @param
     * @return
     * @Description 污染地块详细调查列表
     */
    @RequestMapping("selectDetailedTable")
    public EdatResult selectDetailedTable(@RequestBody Map<String,Object> requestDate,HttpServletRequest request){
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            TDETAILEDCONTAMINATED tdetailedcontaminated = new TDETAILEDCONTAMINATED();
            TBASICSCONTAMINATED tbasicscontaminated = new TBASICSCONTAMINATED();
            //地块名称
            if (!"".equals(data.get("massifName"))){
                tbasicscontaminated.setMassifName(data.get("massifName").toString());
            }
            //地块名称
            if(!"".equals(data.get("massifName"))){
                tbasicscontaminated.setMassifName(data.get("massifName").toString());
            }
            //地块面积
            if(!"".equals(data.get("massifCovered"))){
                tbasicscontaminated.setMassifCovered(data.get("massifCovered").toString());
            }
            if(!"".equals(data.get("massifCovered1"))){
                tbasicscontaminated.setReservedField3(data.get("massifCovered1").toString());
            }
            //地块位置
            if(!"".equals(data.get("massifAddress"))){
                tbasicscontaminated.setMassifAddress(data.get("massifAddress").toString());
            }
            //县
            if(!"".equals(data.get("countyCode"))){
                tbasicscontaminated.setCountyCode(data.get("countyCode").toString());
            }
            HttpSession session = request.getSession();
            SysUser user = (SysUser) session.getAttribute("sysUser");
            if("3".equals(user.getSuLevel())){
                tbasicscontaminated.setCountyCode(user.getSuRegioncode());
            }
            Integer pageNumber = Integer.valueOf(data.get("pageNumber").toString());
            Integer pageSize = Integer.valueOf(data.get("pageSize").toString());
            tbasicscontaminated.setPageNumber(pageNumber+1);
            tbasicscontaminated.setPageSize(pageSize+pageNumber);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            EdatResult edatResult = detailedService.list(tbasicscontaminated);
            return edatResult;
        } catch(Exception e ) {
            LogUtil.getLogger().error("selectDetailedTable 详细调查调查查询数据异常",e);
            return EdatResult.build(1004, "selectDetailedTable 详细调查调查查询数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-22 15:38
     * @param
     * @return
     * @Description 风险评估列表
     */
    @RequestMapping("selectAssessmentTable")
    public EdatResult selectAssessmentTable(@RequestBody Map <String,Object> requestDate,HttpServletRequest request){
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            TASSESSMENTCONTAMINATED tassessmentcontaminated = new TASSESSMENTCONTAMINATED();
            TBASICSCONTAMINATED tbasicscontaminated = new TBASICSCONTAMINATED();
            //地块名称
            if (!"".equals(data.get("massifName"))){
                tbasicscontaminated.setMassifName(data.get("massifName").toString());
            }
            //地块面积
            if(!"".equals(data.get("massifCovered"))){
                tbasicscontaminated.setMassifCovered(data.get("massifCovered").toString());
            }
            //地块编码
//            if(!"".equals(data.get("massifCode"))){
//                tbasicscontaminated.setMassifCovered(data.get("massifCovered").toString());
//            }
            //地块位置
            if(!"".equals(data.get("massifAddress"))){
                tbasicscontaminated.setMassifAddress(data.get("massifAddress").toString());
            }
            //县
            if(!"".equals(data.get("countyCode"))){
                tbasicscontaminated.setCountyCode(data.get("countyCode").toString());
            }
            HttpSession session = request.getSession();
            SysUser user = (SysUser) session.getAttribute("sysUser");
            if("3".equals(user.getSuLevel())){
                tbasicscontaminated.setCountyCode(user.getSuRegioncode());
            }
            Integer pageNumber = Integer.valueOf(data.get("pageNumber").toString());
            Integer pageSize = Integer.valueOf(data.get("pageSize").toString());
            tbasicscontaminated.setPageNumber(pageNumber+1);
            tbasicscontaminated.setPageSize(pageSize+pageNumber);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            EdatResult edatResult = assessmentService.list(tbasicscontaminated);
            return edatResult;
        } catch (Exception e ) {
            LogUtil.getLogger().error("selectAssessmentTable 风险评估查询数据异常",e);
            return EdatResult.build(1003, "selectAssessmentTable 风险评估查询数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-22 15:56
     * @param
     * @return
     * @Description 风险管控列表
     */
    @RequestMapping("selectControlTable")
    public EdatResult selectControlTable(@RequestBody Map<String,Object> requestDate,HttpServletRequest request) {
        try {
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            TCONTROLCONTAMINATED tcontrolcontaminated = new TCONTROLCONTAMINATED();

            TBASICSCONTAMINATED tbasicscontaminated = new TBASICSCONTAMINATED();
            //地块名称
            if(!"".equals(data.get("massifName"))){
                tbasicscontaminated.setMassifName(data.get("massifName").toString());
            }
            //地块面积
            if(!"".equals(data.get("massifCovered"))){
                tbasicscontaminated.setMassifCovered(data.get("massifCovered").toString());
            }
            if(!"".equals(data.get("massifCovered1"))){
                tbasicscontaminated.setReservedField3(data.get("massifCovered1").toString());
            }
            //地块位置
            if(!"".equals(data.get("massifAddress"))){
                tbasicscontaminated.setMassifAddress(data.get("massifAddress").toString());
            }
            //县
            if(!"".equals(data.get("countyCode"))){
                tbasicscontaminated.setCountyCode(data.get("countyCode").toString());
            }
            HttpSession session = request.getSession();
            SysUser user = (SysUser) session.getAttribute("sysUser");
            if("3".equals(user.getSuLevel())){
                tbasicscontaminated.setCountyCode(user.getSuRegioncode());
            }
            Integer pageNumber = Integer.valueOf(data.get("pageNumber").toString());
            Integer pageSize = Integer.valueOf(data.get("pageSize").toString());
            tbasicscontaminated.setPageNumber(pageNumber+1);
            tbasicscontaminated.setPageSize(pageSize+pageNumber);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            EdatResult edatResult = controlService.list(tbasicscontaminated);
            return edatResult;
        } catch (Exception e ) {
            LogUtil.getLogger().error("selectControlTable 风险管控查询数据异常",e);
            return EdatResult.build(1003, "selectControlTable 风险管控查询数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-22 16:04
     * @param
     * @return
     * @Description 治理修复列表
     */
    @RequestMapping("selectRepairTable")
    public EdatResult selectRepairTable(@RequestBody Map<String,Object> requestDate, HttpServletRequest request) {
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            TREPAIRCONTAMINATED trepaircontaminated = new TREPAIRCONTAMINATED();
            TBASICSCONTAMINATED tbasicscontaminated = new TBASICSCONTAMINATED();
            //地块名称
            if(!"".equals(data.get("massifName"))){
                tbasicscontaminated.setMassifName(data.get("massifName").toString());
            }
            //地块面积
            if(!"".equals(data.get("massifCovered"))){
                tbasicscontaminated.setMassifCovered(data.get("massifCovered").toString());
            }
            if(!"".equals(data.get("massifCovered1"))){
                tbasicscontaminated.setReservedField3(data.get("massifCovered1").toString());
            }
            //地块位置
            if(!"".equals(data.get("massifAddress"))){
                tbasicscontaminated.setMassifAddress(data.get("massifAddress").toString());
            }
            //县
            if(!"".equals(data.get("countyCode"))){
                tbasicscontaminated.setCountyCode(data.get("countyCode").toString());
            }
            HttpSession session = request.getSession();
            SysUser user = (SysUser) session.getAttribute("sysUser");
            if("3".equals(user.getSuLevel())){
                tbasicscontaminated.setCountyCode(user.getSuRegioncode());
            }
            Integer pageNumber = Integer.valueOf(data.get("pageNumber").toString());
            Integer pageSize = Integer.valueOf(data.get("pageSize").toString());
            tbasicscontaminated.setPageNumber(pageNumber+1);
            tbasicscontaminated.setPageSize(pageSize+pageNumber);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            EdatResult edatResult = repairService.list(tbasicscontaminated);
            return edatResult;
        } catch (Exception e ) {
            LogUtil.getLogger().error("selectRepairTable 治理修复查询数据异常",e);
            return EdatResult.build(1003, "selectRepairTable 治理修复查询数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-22 16:12
     * @param
     * @return
     * @Description 效果评估列表
     */
    @RequestMapping("selectEffectTable")
    public EdatResult selectEffectTable(@RequestBody Map<String,Object> requestDate,HttpServletRequest request){
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            TEFFECTCONTAMINATED teffectcontaminated = new TEFFECTCONTAMINATED();

            TBASICSCONTAMINATED tbasicscontaminated = new TBASICSCONTAMINATED();
            //地块名称
            if(!"".equals(data.get("massifName"))){
                tbasicscontaminated.setMassifName(data.get("massifName").toString());
            }
            //地块面积
            if(!"".equals(data.get("massifCovered"))){
                tbasicscontaminated.setMassifCovered(data.get("massifCovered").toString());
            }
            if(!"".equals(data.get("massifCovered1"))){
                tbasicscontaminated.setReservedField3(data.get("massifCovered1").toString());
            }
            //地块位置
            if(!"".equals(data.get("massifAddress"))){
                tbasicscontaminated.setMassifAddress(data.get("massifAddress").toString());
            }
            //县
            if(!"".equals(data.get("countyCode"))){
                tbasicscontaminated.setCountyCode(data.get("countyCode").toString());
            }
            HttpSession session = request.getSession();
            SysUser user = (SysUser) session.getAttribute("sysUser");
            if("3".equals(user.getSuLevel())){
                tbasicscontaminated.setCountyCode(user.getSuRegioncode());
            }
            Integer pageNumber = Integer.valueOf(data.get("pageNumber").toString());
            Integer pageSize = Integer.valueOf(data.get("pageSize").toString());
            tbasicscontaminated.setPageNumber(pageNumber+1);
            tbasicscontaminated.setPageSize(pageSize+pageNumber);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            EdatResult edatResult = effectService.list(tbasicscontaminated);
            return edatResult;
        } catch (Exception e) {
            LogUtil.getLogger().error("selectEffectTable 效果评估查询数据异常",e);
            return EdatResult.build(1003, "selectEffectTable 效果评估查询数据异常");
        }
    }

    /**
     * @author chendong
     * @date 2018-11-23 17:09
     * @param
     * @return
     * @Description 删除初步调查
     */
    @RequestMapping("deletePreliminary")
    public EdatResult deletePreliminary(@RequestBody Map<String,Object> requestDate, HttpServletRequest request, HttpServletResponse response ) {
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            long cid = Integer.parseInt(data.get("cid").toString());
            EdatResult result = tPreliminaryService.deleteByPrimaryKey(cid);
            return  result;
        } catch ( Exception e ) {
            LogUtil.getLogger().error("deletePreliminary 删除数据异常",e);
            return EdatResult.build(1002, "deletePreliminary 删除数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-23 17:11
     * @param
     * @return
     * @Description 批量删除初步调查
     */
    @RequestMapping("deletePreliminaryBatch")
    public EdatResult deletePreliminaryBatch(@RequestBody Map<String,Object> requestDate,HttpServletRequest request ,HttpServletResponse response ) {
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            String  cd = (String) data.get("data");
            String[] str = cd.split(",");
            tPreliminaryService.deleteByPrimaryKeyBatch(str);
            return  EdatResult.ok();
        } catch (Exception e ) {
            LogUtil.getLogger().error("deleteContaminatedLandBatch deletePreliminaryBatch",e);
            return EdatResult.build(1002, "deletePreliminaryBatch 删除数据异常");
        }
    }

    /**
     * @author chendong
     * @date 2018-11-23 18:11
     * @param
     * @return
     * @Description 删除详细调查
     */
    @RequestMapping("deleteDetailed")
    public EdatResult deleteDetailed(@RequestBody Map<String,Object> requestDate,HttpServletRequest request,HttpServletResponse response ) {
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            long cid = Integer.parseInt(data.get("cid").toString());
            EdatResult result = detailedService.deleteByPrimaryKey(cid);
            return  result;
        } catch ( Exception e ) {
            LogUtil.getLogger().error("deleteDetailed 删除数据异常",e);
            return EdatResult.build(1002, "deleteDetailed 删除数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-23 18:11
     * @param
     * @return
     * @Description 批量删除详细调查
     */
    @RequestMapping("deleteDetailedBatch")
    public EdatResult deleteDetailedBatch(@RequestBody Map<String,Object> requestDate,HttpServletRequest request,HttpServletResponse response ) {
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            String  cd = (String) data.get("data");
            String[] str = cd.split(",");
            detailedService.deleteByPrimaryKeyBatch(str);
            return  EdatResult.ok();
        } catch (Exception e ) {
            LogUtil.getLogger().error("deleteDetailedBatch 删除数据异常",e);
            return EdatResult.build(1002, "deleteDetailedBatch 删除数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-23 19:06
     * @param
     * @return
     * @Description 风险评估删除
     */
    @RequestMapping("deleteAssessment")
    public EdatResult deleteAssessment(@RequestBody Map<String,Object> requestDate,HttpServletRequest request,HttpServletResponse response ) {
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            long cid = Integer.parseInt(data.get("cid").toString());
            EdatResult result = assessmentService.deleteByPrimaryKey(cid);
            return  result;
        } catch ( Exception e ) {
            LogUtil.getLogger().error("deleteDetailed 删除数据异常",e);
            return EdatResult.build(1002, "deleteDetailed 删除数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-23 18:11
     * @param
     * @return
     * @Description 批量删除风险评估
     */
    @RequestMapping("deleteAssessmentBatch")
    public EdatResult deleteAssessmentBatch(@RequestBody Map<String,Object> requestDate,HttpServletRequest request,HttpServletResponse response ) {
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            String  cd = (String) data.get("data");
            String[] str = cd.split(",");
            assessmentService.deleteByPrimaryKeyBatch(str);
            return  EdatResult.ok();
        } catch (Exception e ) {
            LogUtil.getLogger().error("deleteDetailedBatch 删除数据异常",e);
            return EdatResult.build(1002, "deleteDetailedBatch 删除数据异常");
        }
    }

    /**
     * @author chendong
     * @date 2018-11-23 19:39
     * @param
     * @return
     * @Description 删除风险管控
     */
    @RequestMapping("deleteControl")
    public EdatResult deleteControl(@RequestBody Map<String,Object> requestDate) {
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            long cid = Integer.parseInt(data.get("cid").toString());
            EdatResult result = controlService.deleteByPrimaryKey(cid);
            return  result;
        } catch ( Exception e ) {
            LogUtil.getLogger().error("deleteControl 删除数据异常",e);
            return EdatResult.build(1002, "deleteControl 删除数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-23 19:39
     * @param
     * @return
     * @Description 批量删除风险管控
     */
    @RequestMapping("deleteControlBatch")
    public EdatResult deleteControlBatch(@RequestBody Map<String,Object> requestDate) {
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            String  cd = (String) data.get("data");
            String[] str = cd.split(",");
            controlService.deleteByPrimaryKeyBatch(str);
            return  EdatResult.ok();
        } catch (Exception e ) {
            LogUtil.getLogger().error("deleteControlBatch 删除数据异常",e);
            return EdatResult.build(1002, "deleteControlBatch 删除数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-23 19:41
     * @param
     * @return
     * @Description 删除治理修复
     */
    @RequestMapping("deleteRepair")
    public EdatResult deleteRepair(@RequestBody Map<String,Object> requestDate,HttpServletRequest request,HttpServletResponse response ) {
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            long cid = Integer.parseInt(data.get("cid").toString());

            EdatResult result = repairService.deleteByPrimaryKey(cid);
            return  result;
        } catch ( Exception e ) {
            LogUtil.getLogger().error("deleteRepair 删除数据异常",e);
            return EdatResult.build(1002, "deleteRepair 删除数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-23 19:42
     * @param
     * @return
     * @Description 批量删除治理修复
     */
    @RequestMapping("deleteRepairBatch")
    public EdatResult deleteRepairBatch(@RequestBody Map<String,Object> requestDate,HttpServletRequest request,HttpServletResponse response ) {
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            String  cd = (String) data.get("data");
            String[] str = cd.split(",");
            repairService.deleteByPrimaryKeyBatch(str);
            return  EdatResult.ok();
        } catch (Exception e ) {
            LogUtil.getLogger().error("deleteRepairBatch 删除数据异常",e);
            return EdatResult.build(1002, "deleteRepairBatch 删除数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-23 19:44
     * @param
     * @return
     * @Description 删除效果评估
     */
    @RequestMapping("deleteEffect")
    public EdatResult deleteEffect(@RequestBody Map<String,Object> requestDate,HttpServletRequest request,HttpServletResponse response ) {
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            long cid = Integer.parseInt(data.get("cid").toString());
            EdatResult result = effectService.deleteByPrimaryKey(cid);
            return  result;
        } catch ( Exception e ) {
            LogUtil.getLogger().error("deleteEffect 删除数据异常",e);
            return EdatResult.build(1002, "deleteEffect 删除数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-23 19:45
     * @param
     * @return
     * @Description 批量删除效果评估
     */
    @RequestMapping("deleteEffectBatch")
    public EdatResult deleteEffectBatch(@RequestBody Map<String,Object> requestDate,HttpServletRequest request,HttpServletResponse response ) {
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            String  cd = (String) data.get("data");
            String[] str = cd.split(",");
            effectService.deleteByPrimaryKeyBatch(str);
            return  EdatResult.ok();
        } catch ( Exception e ) {
            LogUtil.getLogger().error("deleteEffectBatch 删除数据异常",e);
            return EdatResult.build(1002, "deleteEffectBatch 删除数据异常");
        }
    }
}
