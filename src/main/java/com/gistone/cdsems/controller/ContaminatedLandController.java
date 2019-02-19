package com.gistone.cdsems.controller;

import com.gistone.cdsems.database.entity.*;
import com.gistone.cdsems.database.mapper.*;
import com.gistone.cdsems.service.contaminated.*;
import com.gistone.cdsems.util.*;
import com.google.gson.Gson;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author chendong
 * @date 2018-11-22 11:22
 * @param
 * @return
 * @Description 污染地块
 */
@RestController
@RequestMapping("ContaminatedLandController")
public class ContaminatedLandController {

    @Autowired
    private TbCityMapper tbCityMapper;
    @Autowired
    private ContaminatedLandService contaminatedLandService;
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
    @Autowired
    private UrlsUtil urlsUtil;

    /**
     * @author chendong
     * @date 2018-11-20 9:44
     * @param
     * @return
     * @Description 添加污染地块基本信息
     */
    @RequestMapping("insertTBasicsContanminated")
    public EdatResult insertTBasicsContanminated(@RequestBody Map<String,Object> requestDate, HttpServletRequest request, HttpServletResponse response ) {
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            BeanInfo beanInfo = Introspector.getBeanInfo(TBASICSCONTAMINATED.class);
            Object obj = TBASICSCONTAMINATED.class.newInstance();
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor descriptor : propertyDescriptors ){
                String propertyName = descriptor.getName();
                if(data.containsKey(propertyName)){
                    Object value = data.get(propertyName);
                    if ( "cid".equals(propertyName)){
                        value = Long.parseLong(value.toString());
                    }
                    descriptor.getWriteMethod().invoke(obj,value);
                }
            }
            EdatResult result =null;
            if ( data.containsKey("cid")) result=contaminatedLandService.updateByPrimaryKeySelective(obj);
            else {
                result = contaminatedLandService.save(obj);
            }
            return result;
        } catch( Exception e ) {
            LogUtil.getLogger().error("insertTBasicsContanminated 污染地块基本信息添加数据异常",e);
            return EdatResult.build(1001, "insertTBasicsContanminated 污染地块基本信息添加数据异常");
        }
    }

    /**
     * @author chendong
     * @date 2018-11-20 9:48
     * @param
     * @return
     * @Description 添加污染地块初步调查
     */
    @RequestMapping("insertTPreliminaryContaminated")
    public EdatResult insertTPreliminaryContaminated(@RequestParam( value="files0",required=false)MultipartFile  file,@RequestParam( value="files1",required=false)MultipartFile  file1,HttpServletRequest request ) {
        try{
            String xdUrl = "";
            String xdUrl1 = "";
            if ( file != null || file1 != null ) {
                DateFormat df = new SimpleDateFormat("yyyyMMdd");
                //唯一文件名称
                String newFilename = UuidUtil.get32UUID()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                String newFilename1 = UuidUtil.get32UUID()+file1.getOriginalFilename().substring(file1.getOriginalFilename().lastIndexOf("."));
                //相对路径
                xdUrl = "/File/contanminated/"+df.format(new Date())+"/"+newFilename;
                xdUrl1 = "/File/contanminated/"+df.format(new Date())+"/"+newFilename1;
                //创建文件夹
                String directoryUrl = urlsUtil.geturl()+"/File/contanminated/"+df.format(new Date())+"/";
                File dirFile = new File(directoryUrl);
                if (!dirFile.exists()) {
                    dirFile.mkdirs();
                }
                if ( file != null ) {
                    File uploadedFile = new File(directoryUrl, newFilename);
                    byte[] bytes = file.getBytes();
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                    stream.write(bytes);
                    stream.close();
                }
                if ( file1 != null ) {
                    File uploadedFile1 = new File(directoryUrl,newFilename1);
                    byte[] bytes1 = file1.getBytes();
                    BufferedOutputStream stream1 = new BufferedOutputStream(new FileOutputStream(uploadedFile1));
                    stream1.write(bytes1);
                    stream1.close();
                }
            }
            String  str = request.getParameter("data").toString();
            Gson gson = new Gson();
            Map<String ,Object > data = new HashMap<String,Object>();

            data = gson.fromJson(str,data.getClass());
            if ( file != null ) {
                data.put("investigationReportPath",xdUrl);
            } else {
                data.remove("investigationReportPath");
            }
            if(file1 != null )  {
                data.put("testReportPath",xdUrl1);
            } else {
                data.remove("testReportPath");
            }
            if("".equals(data.get("preliminaryCompilingTime"))) data.remove("preliminaryCompilingTime");
            BeanInfo beanInfo = Introspector.getBeanInfo(TPRELIMINARYCONTAMINATED.class);
            Object obj = TPRELIMINARYCONTAMINATED.class.newInstance();
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor descriptor : propertyDescriptors ){
                String propertyName = descriptor.getName();
                if(data.containsKey(propertyName)){
                    Object value = data.get(propertyName);
                    if ( "cid".equals(propertyName)){
                        value = Long.parseLong(value.toString());
                    }
                    if ( "pid".equals(propertyName)){
                        value = Long.parseLong(value.toString());
                    }
                    if ( "preliminaryCompilingTime".equals(propertyName)){
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        value = sdf.parse(value.toString());
                    }
                    descriptor.getWriteMethod().invoke(obj,value);
                }
            }
            EdatResult result = null;
            if ( data.containsKey("pid") ) result=tPreliminaryService.updateByPrimaryKeySelective(obj);
            else result=tPreliminaryService.save(obj);
            return result;
        } catch(Exception e ) {
            LogUtil.getLogger().error("insertTPreliminaryContaminated 污染地块初步调查添加数据异常",e);
            return EdatResult.build(1001, "insertTPreliminaryContaminated 污染地块初步调查添加数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-20 9:54
     * @param
     * @return
     * @Description 添加污染地块 详细调查
     */
    @RequestMapping("insertTDtailedContaminated")
    public EdatResult insertTDtailedContaminated(@RequestParam( value="files0",required=false)MultipartFile  file,@RequestParam( value="files1",required=false)MultipartFile  file1,HttpServletRequest request ){
        try{
            String xdUrl = "";
            String xdUrl1 = "";
            if ( file != null || file1 != null ) {
                DateFormat df = new SimpleDateFormat("yyyyMMdd");
                //唯一文件名称
                String newFilename = UuidUtil.get32UUID()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                String newFilename1 = UuidUtil.get32UUID()+file1.getOriginalFilename().substring(file1.getOriginalFilename().lastIndexOf("."));
                //相对路径
                xdUrl = "/File/contanminated/"+df.format(new Date())+"/"+newFilename;
                xdUrl1 = "/File/contanminated/"+df.format(new Date())+"/"+newFilename1;
                //创建文件夹
                String directoryUrl = urlsUtil.geturl()+"/File/contanminated/"+df.format(new Date())+"/";
                File dirFile = new File(directoryUrl);
                if (!dirFile.exists()) {
                    dirFile.mkdirs();
                }
                if ( file != null ) {
                    File uploadedFile = new File(directoryUrl,newFilename);
                    byte[] bytes = file.getBytes();
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                    stream.write(bytes);
                    stream.close();
                }
                if ( file1 != null ) {
                    File uploadedFile1 = new File(directoryUrl,newFilename);
                    byte[] bytes1 = file1.getBytes();
                    BufferedOutputStream stream1 = new BufferedOutputStream(new FileOutputStream(uploadedFile1));
                    stream1.write(bytes1);
                    stream1.close();
                }
            }
            String  str = request.getParameter("data").toString();
            Gson gson = new Gson();
            Map<String ,Object > data = new HashMap<String,Object>();

            data = gson.fromJson(str,data.getClass());
            if ( file != null ) {
                data.put("investigationReportPath",xdUrl);
            } else {
                data.remove("investigationReportPath");
            }
            if(file1 != null )  {
                data.put("testReportPath",xdUrl);
            } else {
                data.remove("testReportPath");
            }
            if ("".equals(data.get("detailedCompilingTime")))  data.remove("detailedCompilingTime");
            BeanInfo beanInfo = Introspector.getBeanInfo(TDETAILEDCONTAMINATED.class);
            Object obj = TDETAILEDCONTAMINATED.class.newInstance();
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor descriptor : propertyDescriptors ){
                String propertyName = descriptor.getName();
                if(data.containsKey(propertyName)){
                    Object value = data.get(propertyName);
                    if ( "cid".equals(propertyName)){
                        value = Long.parseLong(value.toString());
                    }
                    if ( "did".equals(propertyName)){
                        value = Long.parseLong(value.toString());
                    }
                    if ( "detailedCompilingTime".equals(propertyName)){
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        value = sdf.parse(value.toString());
                    }
                    descriptor.getWriteMethod().invoke(obj,value);
                }
            }
            EdatResult result = null;
            if ( data.containsKey("did") ) result=detailedService.updateByPrimaryKeySelective(obj);
            else result=detailedService.save(obj);
            return result;
        } catch (Exception e ) {
            LogUtil.getLogger().error("insertTDtailedContaminated 污染地块详细调查添加数据异常",e);
            return EdatResult.build(1001, "insertTDtailedContaminated 污染地块详细调查添加数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-20 9:57
     * @param
     * @return
     * @Description 添加污染地块 风险评估
     */
    @RequestMapping("insertTAssessmentContaminated")
    public EdatResult insertTAssessmentContaminated(@RequestParam( value="files",required=false)MultipartFile  file,HttpServletRequest request ){
        try{
            String xdUrl = "";
            if ( file != null ) {
                DateFormat df = new SimpleDateFormat("yyyyMMdd");
                //唯一文件名称
                String newFilename = UuidUtil.get32UUID()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                //相对路径
                xdUrl = "/File/contanminated/"+df.format(new Date())+"/"+newFilename;
                //创建文件夹
                String directoryUrl = urlsUtil.geturl()+"/File/contanminated/"+df.format(new Date())+"/";
                File dirFile = new File(directoryUrl);
                if (!dirFile.exists()) {
                    dirFile.mkdirs();
                }
                if ( file != null ) {
                    File uploadedFile = new File(directoryUrl, newFilename);
                    byte[] bytes = file.getBytes();
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                    stream.write(bytes);
                    stream.close();
                }
            }
            String  str = request.getParameter("data").toString();
            Gson gson = new Gson();
            Map<String ,Object > data = new HashMap<String,Object>();

            data = gson.fromJson(str,data.getClass());
            if ( file != null ) {
                data.put("riskAssessmentPath",xdUrl);
            } else {
                data.remove("riskAssessmentPath");
            }
            if ("".equals(data.get("riskAssessmentTime")))  data.remove("riskAssessmentTime");
            BeanInfo beanInfo = Introspector.getBeanInfo(TASSESSMENTCONTAMINATED.class);
            Object obj = TASSESSMENTCONTAMINATED.class.newInstance();
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor descriptor : propertyDescriptors ){
                String propertyName = descriptor.getName();
                if(data.containsKey(propertyName)){
                    Object value = data.get(propertyName);
                    if ( "cid".equals(propertyName)){
                        value = Long.parseLong(value.toString());
                    }
                    if ( "rid".equals(propertyName)){
                        value = Long.parseLong(value.toString());
                    }
                    if ( "riskAssessmentTime".equals(propertyName)){
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        value = sdf.parse(value.toString());
                    }
                    descriptor.getWriteMethod().invoke(obj,value);
                }
            }
            EdatResult result = null;
            if ( data.containsKey("rid")) result = assessmentService.updateByPrimaryKeySelective(obj);
            else result = assessmentService.save(obj);
            return result;
        } catch (Exception e ) {
            LogUtil.getLogger().error("insertTAssessmentContaminated 污染地块风险评估添加数据异常",e);
            return EdatResult.build(1001, "insertTAssessmentContaminated 污染地块风险评估添加数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-20 10:01
     * @param
     * @return
     * @Description 添加污染地块 风险管控
     */
    @RequestMapping("insertTControlContaminated")
    public EdatResult insertTControlContaminated(@RequestParam( value="files",required=false)MultipartFile  file,HttpServletRequest request ){
        try{
            String xdUrl = "";
            if ( file != null ) {
                DateFormat df = new SimpleDateFormat("yyyyMMdd");
                //唯一文件名称
                String newFilename = UuidUtil.get32UUID()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                //相对路径
                xdUrl = "/File/contanminated/"+df.format(new Date())+"/"+newFilename;
                //创建文件夹
                String directoryUrl = urlsUtil.geturl()+"/File/contanminated/"+df.format(new Date())+"/";
                File dirFile = new File(directoryUrl);
                if (!dirFile.exists()) {
                    dirFile.mkdirs();
                }
                if ( file != null ) {
                    File uploadedFile = new File(directoryUrl, newFilename);
                    byte[] bytes = file.getBytes();
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                    stream.write(bytes);
                    stream.close();
                }
            }
            String  str = request.getParameter("data").toString();
            Gson gson = new Gson();
            Map<String ,Object > data = new HashMap<String,Object>();

            data = gson.fromJson(str,data.getClass());
            if ( file != null ) {
                data.put("riskControlPath",xdUrl);
            } else {
                data.remove("riskControlPath");
            }
            if ("".equals(data.get("riskControlTime")))  data.remove("riskControlTime");
            BeanInfo beanInfo = Introspector.getBeanInfo(TCONTROLCONTAMINATED.class);
            Object obj = TCONTROLCONTAMINATED.class.newInstance();
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor descriptor : propertyDescriptors ){
                String propertyName = descriptor.getName();
                if(data.containsKey(propertyName)){
                    Object value = data.get(propertyName);
                    if ( "cid".equals(propertyName)){
                        value = Long.parseLong(value.toString());
                    }
                    if ( "mid".equals(propertyName)){
                        value = Long.parseLong(value.toString());
                    }
                    if ( "riskControlTime".equals(propertyName)){
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        value = sdf.parse(value.toString());
                    }
                    descriptor.getWriteMethod().invoke(obj,value);
                }
            }
            EdatResult result = null;
            if ( data.containsKey("mid") ) result = controlService.updateByPrimaryKeySelective(obj);
            else result = controlService.save(obj);
            return result;
        } catch (Exception e ) {
            LogUtil.getLogger().error("insertTControlContaminated 污染地块风险管控添加数据异常",e);
            return EdatResult.build(1001, "insertTControlContaminated 污染地块风险管控添加数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-20 10:04
     * @param
     * @return
     * @Description 添加污染地块修复治理
     */
    @RequestMapping("insertTRepairContaminated")
    public EdatResult insertTRepairContaminated(@RequestParam( value="files",required=false)MultipartFile  file,HttpServletRequest request ){
        try{
            String xdUrl = "";
            if ( file != null ) {
                DateFormat df = new SimpleDateFormat("yyyyMMdd");
                //唯一文件名称
                String newFilename = UuidUtil.get32UUID()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                //相对路径
                xdUrl = "/File/contanminated/"+df.format(new Date())+"/"+newFilename;
                //创建文件夹
                String directoryUrl = urlsUtil.geturl()+"/File/contanminated/"+df.format(new Date())+"/";
                File dirFile = new File(directoryUrl);
                if (!dirFile.exists()) {
                    dirFile.mkdirs();
                }
                if ( file != null ) {
                    File uploadedFile = new File(directoryUrl, newFilename);
                    byte[] bytes = file.getBytes();
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                    stream.write(bytes);
                    stream.close();
                }
            }
            String  str = request.getParameter("data").toString();
            Gson gson = new Gson();
            Map<String ,Object > data = new HashMap<String,Object>();

            data = gson.fromJson(str,data.getClass());
            if ( file != null ) {
                data.put("treamentRepairPath",xdUrl);
            } else {
                data.remove("treamentRepairPath");
            }
            if ("".equals(data.get("treamentRepairTime")))  data.remove("treamentRepairTime");
            BeanInfo beanInfo = Introspector.getBeanInfo(TREPAIRCONTAMINATED.class);
            Object obj = TREPAIRCONTAMINATED.class.newInstance();
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor descriptor : propertyDescriptors ){
                String propertyName = descriptor.getName();
                if(data.containsKey(propertyName)){
                    Object value = data.get(propertyName);
                    if ( "cid".equals(propertyName)){
                        value = Long.parseLong(value.toString());
                    }
                    if ( "tid".equals(propertyName)){
                        value = Long.parseLong(value.toString());
                    }
                    if ( "treamentRepairTime".equals(propertyName)){
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        value = sdf.parse(value.toString());
                    }
                    descriptor.getWriteMethod().invoke(obj,value);
                }
            }
            EdatResult result = null;
            if ( data.containsKey("tid") ) result=repairService.updateByPrimaryKeySelective(obj);
            else result=repairService.save(obj);
            return result;
        } catch (Exception e ) {
            LogUtil.getLogger().error("insertTRepairContaminated 污染地块治理修复添加数据异常",e);
            return EdatResult.build(1001, "insertTRepairContaminated 污染地块治理修复添加数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-20 10:07
     * @param
     * @return
     * @Description 添加污染地块 效果评估
     */
    @RequestMapping("insertTEffectContaminated")
    public EdatResult insertTEffectContaminated(@RequestParam( value="files",required=false)MultipartFile  file,HttpServletRequest request ){
        try{
            String xdUrl = "";
            if ( file != null ) {
                DateFormat df = new SimpleDateFormat("yyyyMMdd");
                //唯一文件名称
                String newFilename = UuidUtil.get32UUID()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                //相对路径
                xdUrl = "/File/contanminated/"+df.format(new Date())+"/"+newFilename;
                //创建文件夹
                String directoryUrl = urlsUtil.geturl()+"/File/contanminated/"+df.format(new Date())+"/";
                File dirFile = new File(directoryUrl);
                if (!dirFile.exists()) {
                    dirFile.mkdirs();
                }
                if ( file != null ) {
                    File uploadedFile = new File(directoryUrl, newFilename);
                    byte[] bytes = file.getBytes();
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                    stream.write(bytes);
                    stream.close();
                }
            }
            String  str = request.getParameter("data").toString();
            Gson gson = new Gson();
            Map<String ,Object > data = new HashMap<String,Object>();

            data = gson.fromJson(str,data.getClass());
            if ( file != null ) {
                data.put("effectEvaluationPath",xdUrl);
            } else {
                data.remove("effectEvaluationPath");
            }
            if ("".equals(data.get("effectEvaluationTime")))  data.remove("effectEvaluationTime");
            BeanInfo beanInfo = Introspector.getBeanInfo(TEFFECTCONTAMINATED.class);
            Object obj = TEFFECTCONTAMINATED.class.newInstance();
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor descriptor : propertyDescriptors ){
                String propertyName = descriptor.getName();
                if(data.containsKey(propertyName)){
                    Object value = data.get(propertyName);
                    if ( "cid".equals(propertyName)){
                        value = Long.parseLong(value.toString());
                    }
                    if ( "eid".equals(propertyName)){
                        value = Long.parseLong(value.toString());
                    }
                    if ( "effectEvaluationTime".equals(propertyName)){
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        value = sdf.parse(value.toString());
                    }
                    descriptor.getWriteMethod().invoke(obj,value);
                }
            }
            EdatResult result = null;
            if ( data.containsKey("eid") ) result = effectService.updateByPrimaryKeySelective(obj);
            else result = effectService.save(obj);
            return result;
        } catch (Exception e ) {
            LogUtil.getLogger().error("insertTEffectContaminated 污染地块效果评估添加数据异常",e);
            return EdatResult.build(1001, "insertTEffectContaminated 污染地块效果评估添加数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-19 10:57
     * @param
     * @return
     * @Description 污染地块基本信息查询列表
     */
    @RequestMapping("selectContaminatedLand")
    public EdatResult selectContaminatedLand(@RequestBody Map<String,Object> requestDate,HttpServletResponse response , HttpServletRequest request ) {
        try {
            Map<String,Object> data = (Map)requestDate.get("data");
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
           EdatResult edatResult = contaminatedLandService.list(tbasicscontaminated);
            return edatResult;
        } catch (Exception e) {
            LogUtil.getLogger().error("selectContaminatedLand 查询数据异常",e);
            return EdatResult.build(1003, "selectContaminatedLand 查询数据异常");
        }
    }

    /**
     * @author chendong
     * @date 2018-11-19 11:55
     * @param
     * @return
     * @Description 删除污染地块信息
     */
    @RequestMapping("deleteContaminatedLand")
    public EdatResult deleteContaminatedLand(@RequestBody Map<String,Object> requestDate,HttpServletRequest request,HttpServletResponse response ) {
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            long cid = Integer.parseInt(data.get("cid").toString());
            EdatResult result = contaminatedLandService.deleteByPrimaryKey(cid);
            return  result;
        } catch ( Exception e ) {
            LogUtil.getLogger().error("deleteContaminatedLand 删除数据异常",e);
            return EdatResult.build(1002, "deleteContaminatedLand 删除数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-22 15:06
     * @param
     * @return
     * @Description 批量删除
     */
    @RequestMapping("deleteContaminatedLandBatch")
    public EdatResult deleteContaminatedLandBatch(@RequestBody Map<String,Object> requestDate,HttpServletRequest request ,HttpServletResponse response ) {
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            String  cd = (String) data.get("data");
            String[] str = cd.split(",");
            contaminatedLandService.deleteByPrimaryKeyBatch(str);
            return  EdatResult.ok();
        } catch (Exception e ) {
            LogUtil.getLogger().error("deleteContaminatedLandBatch 删除数据异常",e);
            return EdatResult.build(1002, "deleteContaminatedLandBatch 删除数据异常");
        }
    }

    /**
     * @author chendong  
     * @date 2018-11-19 17:14  
     * @param   
     * @return  
     * @Description 更新污染地块状态
     */
//    @RequestMapping("updateContanminatedLandState")
//    public Result updateContanminatedLandState(@RequestBody Map<String,Object> requeatDate,HttpServletRequest request,HttpServletResponse response ) {
//        try{
//            Map<String,Object> data = (Map<String, Object>) requeatDate.get("data");
//            long cid = Integer.parseInt(data.get("cid").toString());
//            TBASICSCONTAMINATED tbasicscontaminated = new TBASICSCONTAMINATED();
//            tbasicscontaminated.setCid(cid);
//            tbasicscontaminated.setMassifStage(data.get("massifStage").toString());
//            int num = tbasicscontaminatedMapper.updateByPrimaryKeySelective(tbasicscontaminated);
//            return Result.ok();
//        } catch (Exception e ) {
//            return Result.build(1003,"updateContanminatedLandState 更新状态异常");
//        }
//    }

    /**
     * @author chendong
     * @date 2018-11-21 11:20
     * @param
     * @return
     * @Description 批量导入
     */
    @RequestMapping("importContanminatedBatch")
    public EdatResult importContanminatedBatch(@RequestParam( value="files",required=false)MultipartFile  file,HttpServletRequest request,HttpServletResponse response){
        InputStream is = null;
        try{
            String upName = file.getOriginalFilename();//获取上传的文件名
            String suffix = upName.substring(upName.lastIndexOf(".") + 1);//获取后缀名
            if (!suffix.equals("xls") && !suffix.equals("xlsx")) {
                return EdatResult.build(2,"批量上传格式错误");
            }
            is = file.getInputStream();
            Workbook wb = WorkbookFactory.create(is);
            Sheet sheet = wb.getSheetAt(0);
            int row = sheet.getLastRowNum()+1;
            List<Map> list = new ArrayList<>();
            HttpSession session = request.getSession();
            SysUser user = (SysUser) session.getAttribute("sysUser");
            String quanxian = "";
            if("3".equals(user.getSuLevel())){
                quanxian = user.getSuRegioncode();
            }
            for ( int i = 1 ; i < row; i++ ) {
                Map map = new HashMap();
                Row rows = sheet.getRow(i);
                if( rows != null ) {
                    if (rows.getCell(0).toString() == null || "".equals(rows.getCell(0).toString())){
                        return EdatResult.error(1002, "[第"+i+"行企业名称为空]");
                    }
                    if (rows.getCell(1).toString() == null || "".equals(rows.getCell(1).toString())){
                        return EdatResult.error(1002, "[第"+i+"地块编码为空]");
                    }
                    map.put("MASSIF_NAME",rows.getCell(0).toString());//地块名称
                    if(rows.getCell(1)!=null){
                        if((rows.getCell(1).toString()).indexOf("E")>0 ||(rows.getCell(1).toString()).indexOf("e")>0){
                            BigDecimal bd = new BigDecimal(rows.getCell(10).toString());
                            map.put("MASSIF_CODE",bd.toPlainString());
                        }  else   map.put("MASSIF_CODE",rows.getCell(1) == null ? "" : rows.getCell(1).toString());//地块编码
                    } else {
                        map.put("MASSIF_CODE",rows.getCell(1) == null ? "" : rows.getCell(1).toString());//地块编码
                    }

//                    map.put("MASSIF_CODE",rows.getCell(1).toString());//地块编码
                    map.put("MASSIF_ADDRESS",rows.getCell(2) == null ? "" : rows.getCell(2).toString());//污染地块地址
                    String reg = "^[0-9]+(.[0-9]+)?$";

                    if (rows.getCell(3) != null){
                        if(!rows.getCell(3).toString().matches(reg))  return EdatResult.error(2, "导入失败，错误原因面积有别的字符]");
                    }
                    map.put("MASSIF_COVERED",rows.getCell(3) == null ? "" : rows.getCell(3).toString());//占地面积
                    if (rows.getCell(4) != null && "".equals(rows.getCell(4))){
                        if ( !"".equals(quanxian)){
                            if (!quanxian.equals(rows.getCell(4))){
                                return EdatResult.error(1002, "[第"+i+"区县编码错误]");
                            }
                        }
                    }
                    map.put("COUNTY_CODE",rows.getCell(4) == null ? "" : rows.getCell(4).toString().replace(".0",""));//县编码
                    map.put("MASSIF_POLLUTE",rows.getCell(5) == null ? "" : rows.getCell(5).toString());//是否污染
                    map.put("MASSIF_STAGE",rows.getCell(6) == null ? "" : rows.getCell(6).toString());//所处阶段
                    map.put("RISK_LEVEL",rows.getCell(7) == null ? "" : rows.getCell(7).toString());//风险级别
                    map.put("ENTERPRISE_NAME",rows.getCell(8) == null ? "" : rows.getCell(8).toString());//企业名称
                    map.put("LEGAL_REPRESENTATIVE",rows.getCell(9) == null ? "" : rows.getCell(9).toString());//法人代表
                    if(rows.getCell(10)!=null){
                        if((rows.getCell(10).toString()).indexOf("E")>0 ||(rows.getCell(10).toString()).indexOf("e")>0){
                            BigDecimal bd = new BigDecimal(rows.getCell(10).toString());
                            map.put("BUSINESS_LICENSE",bd.toPlainString());
                        }  else   map.put("BUSINESS_LICENSE",rows.getCell(10) == null ? "" : rows.getCell(10).toString());//工商营业执照
                    } else {
                        map.put("BUSINESS_LICENSE",rows.getCell(10) == null ? "" : rows.getCell(10).toString());//工商营业执照
                    }

                    map.put("POSTAL_CODE",rows.getCell(11) == null ? "" : rows.getCell(11).toString());//邮政编码
                    map.put("MASSIF_AROUND_AREA",rows.getCell(12) == null ? "" : rows.getCell(12).toString());//地块四周范围
                    map.put("MASSIF_LONGITUDE",rows.getCell(13) == null ? "" : rows.getCell(13).toString());//污染地块中心经度
                    map.put("MASSIF_LATITUDE",rows.getCell(14) == null ? "" : rows.getCell(14).toString());//污染地块中心纬度
                    map.put("COORDINATE_DESCRIPTION",rows.getCell(15) == null ? "" : rows.getCell(15).toString());//坐标说明
                    map.put("ACCESS_UNIT_CONTACTS",rows.getCell(16) == null ? "" : rows.getCell(16).toString());//使用权单位联系人
                    if(rows.getCell(17)!=null){
                        if((rows.getCell(17).toString()).indexOf("E")>0 ||(rows.getCell(17).toString()).indexOf("e")>0){
                            BigDecimal bd = new BigDecimal(rows.getCell(17).toString());
                            map.put("ACCESS_UNIT_PHONE",bd.toPlainString());//使用权单位联系电话
                        }  else  map.put("ACCESS_UNIT_PHONE",rows.getCell(17) == null ? "" : rows.getCell(17).toString());//使用权单位联系电话
                    } else {
                        map.put("ACCESS_UNIT_PHONE",rows.getCell(17) == null ? "" : rows.getCell(17).toString());//使用权单位联系电话
                    }
                    map.put("CONTACT_FACSIMILE",rows.getCell(18) == null ? "" : rows.getCell(18).toString());//联系传真
                    map.put("MAILBOX",rows.getCell(19) == null ? "" : rows.getCell(19).toString());//电子邮箱
                    map.put("FAX",rows.getCell(20) == null ? "" : rows.getCell(20).toString());//传真
                    list.add(map);
                } else break;

            }
            EdatResult result = contaminatedLandService.saveBath(list);
            return result;
        } catch (Exception e ) {
            LogUtil.getLogger().error("importContanminatedBatch 批量导入异常",e);
            return EdatResult.build(1003, "importContanminatedBatch 批量导入异常");
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
                return EdatResult.build(1003, "importContanminatedBatch 批量导入异常");
            }
        }

    }
    /**
     * @author chendong
     * @date 2018-11-21 14:43
     * @param
     * @return
     * @Description 批量导出
     */
    @RequestMapping("exportContanminatedBatch")
    public EdatResult exportContanminatedBatch(HttpServletRequest request , HttpServletResponse response ) {
        try{
            TBASICSCONTAMINATED tbasicscontaminated1 = new TBASICSCONTAMINATED();
            if(!"".equals(request.getParameter("massifName"))){
                tbasicscontaminated1.setMassifName(request.getParameter("massifName"));
            }
            if(!"".equals(request.getParameter("countyCode"))){
                tbasicscontaminated1.setCountyCode(request.getParameter("countyCode"));
            }
            if( !"".equals(request.getParameter("massifAddress"))){
                tbasicscontaminated1.setMassifAddress(request.getParameter("massifAddress"));
            }
            if( !"".equals(request.getParameter("massifCovered"))){
                tbasicscontaminated1.setMassifCovered(request.getParameter("massifCovered"));
            }
            if( !"".equals(request.getParameter("massifCovered1"))){
                tbasicscontaminated1.setReservedField3(request.getParameter("massifCovered1"));
            }
            EdatResult edatResult = contaminatedLandService.selectListByCids(tbasicscontaminated1);


            String[] title = {"地块名称","地块编码","污染地块地址","占地面积（平方米）","县编码","是否污染","所处阶段","风险级别",
                    "企业名称","法人代表","工商营业执照","邮政编码","地块四周范围","污染地块中心经度","污染地块中心纬度","坐标说明","使用权单位联系人",
                    "使用权单位联系电话","联系传真","电子邮箱","传真"};
            List<TBASICSCONTAMINATED> list = (List<TBASICSCONTAMINATED>) edatResult.getData();
            String [][] content = new String[list.size()][];
            if ( list.size() > 0 ) {
                for( int i = 0 ; i < list.size(); i ++ ) {
                    content[i] = new String[title.length];
                    TBASICSCONTAMINATED tbasicscontaminated = list.get(i);
                    content[i][0] = tbasicscontaminated.getMassifName();
                    content[i][1] = tbasicscontaminated.getMassifCode();
                    content[i][2] = tbasicscontaminated.getMassifAddress();
                    content[i][3] = tbasicscontaminated.getMassifCovered();
//                    content[i][4] = tbasicscontaminated.getProvinceCode();
//                    content[i][5] = tbasicscontaminated.getCityCode();
                    content[i][4] = tbasicscontaminated.getCountyCode();
                    content[i][5] = tbasicscontaminated.getMassifPollute();
                    content[i][6] = tbasicscontaminated.getMassifStage();
                    content[i][7] = tbasicscontaminated.getRiskLevel();
                    content[i][8] = tbasicscontaminated.getEnterpriseName();
                    content[i][9] = tbasicscontaminated.getLegalRepresentative();
                    content[i][10] = tbasicscontaminated.getBusinessLicense();
                    content[i][11] = tbasicscontaminated.getPostalCode();
                    content[i][12] = tbasicscontaminated.getMassifAroundArea();
                    content[i][13] = tbasicscontaminated.getMassifLongitude();
                    content[i][14] = tbasicscontaminated.getMassifLatitude();
                    content[i][15] = tbasicscontaminated.getCoordinateDescription();
                    content[i][16] = tbasicscontaminated.getAccessUnitContacts();
                    content[i][17] = tbasicscontaminated.getAccessUnitPhone();
                    content[i][18] = tbasicscontaminated.getContactFacsimile();
                    content[i][19] = tbasicscontaminated.getMailbox();
                    content[i][20] = tbasicscontaminated.getFax();
                }
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/x-download");
            String  fileName = sdf.format(new Date()) + "_" + new Random().nextInt(1000) + ".xls";
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);


            //定义工作簿
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet("污染地块基本信息");
            sheet.setDefaultRowHeight((short) (2 * 256));//设置行高
            XSSFFont font = wb.createFont();
            font.setFontName("宋体");
            font.setFontHeightInPoints((short) 16);
            XSSFCellStyle style = wb.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
            XSSFRow row = sheet.createRow(0);
            XSSFCell cell;
            for ( int i = 0 ; i < title.length; i++ ) {
                cell = row.createCell(i);
                cell.setCellValue(title[i]);
                cell.setCellStyle(style);
            }
            XSSFRow rows;
            XSSFCell cells;
            for ( int i = 0 ; i < content.length ; i ++ ) {
                rows = sheet.createRow(i+1);
                for ( int j = 0 ; j < content[i].length; j ++ ) {
                    cells = rows.createCell(j);
                    cells.setCellValue(content[i][j]);
                }
            }
            OutputStream out  = response.getOutputStream();
            wb.write(out);
            out.close();
            wb.close();
            return EdatResult.ok();
        } catch( Exception  e ) {
            e.printStackTrace();
            return EdatResult.build(1003, "exportContanminatedBatch 批量导出异常");
        }

    }
    /**
     * @author chendong
     * @date 2018-11-22 14:47
     * @param
     * @return
     * @Description 行政区划查询县
     */
    @RequestMapping("selectCity")
    public Result selectCity() {
        try{
            TbCity tbCity = new TbCity();
            tbCity.setTcLevel((long) 2);
            List<Map> list = tbCityMapper.selectCtiy(tbCity);
            return Result.ok(list);
        } catch (Exception e){
            LogUtil.getLogger().error("selectCity 查询县异常",e);
            return Result.build(1004, "selectCity 查询县异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-24 17:13
     * @param
     * @return
     * @Description 所有污染地块
     */
    @RequestMapping("selectContanminatedAll")
    public EdatResult selectContanminatedAll(HttpServletRequest request){
        try{
            TBASICSCONTAMINATED tbasicscontaminated = new TBASICSCONTAMINATED();
            HttpSession session = request.getSession();
            SysUser user = (SysUser) session.getAttribute("sysUser");
            if("3".equals(user.getSuLevel())){
                tbasicscontaminated.setCountyCode(user.getSuRegioncode());
            }
            EdatResult edatResult = contaminatedLandService.selectAll(tbasicscontaminated);
            return edatResult;
        } catch(Exception e ) {
            LogUtil.getLogger().error("selectContanminatedAll 查询异常",e);
            return EdatResult.build(1001, "selectContanminatedAll 查询异常");
        }

    }

}
