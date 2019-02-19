package com.gistone.cdsems.controller;

import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.database.entity.TAGRICUTURALSOIL;
import com.gistone.cdsems.database.entity.TMONITORSOIL;
import com.gistone.cdsems.database.mapper.TAGRICUTURALSOILMapper;
import com.gistone.cdsems.database.mapper.TMONITORSOILMapper;
import com.gistone.cdsems.service.AgricuturalSoil.AgricuturalService;
import com.gistone.cdsems.service.AgricuturalSoil.MonitorService;
import com.gistone.cdsems.util.EdatResult;
import com.gistone.cdsems.util.LogUtil;
import com.gistone.cdsems.util.RegUtil;
import com.gistone.cdsems.util.Result;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chendong  
 * @date 2018-11-22 11:21
 * @param   
 * @return  
 * @Description 农用地土壤环境管理
 */
@RestController
@RequestMapping("AgricuturalSoilController")
public class AgricuturalSoilController {
    @Autowired
    private AgricuturalService agricuturalService;
    @Autowired
    private MonitorService monitorService;
    /**
     * @author chendong
     * @date 2018-11-22 11:33
     * @param
     * @return
     * @Description 农用地数据添加
     */
    @RequestMapping("saveAgricuturalSoil")
    public EdatResult saveAgricuturalSoil(@RequestBody Map<String,Object> requestDate, HttpServletRequest request, HttpServletResponse response ) {
        try {
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            BeanInfo beanInfo = Introspector.getBeanInfo(TAGRICUTURALSOIL.class);
            Object obj = TAGRICUTURALSOIL.class.newInstance();
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor descriptor : propertyDescriptors ){
                String propertyName = descriptor.getName();
                if(data.containsKey(propertyName)){
                    Object value = data.get(propertyName);
                    if ( "aid".equals(propertyName)){
                        value = Long.parseLong(value.toString());
                    }
                    descriptor.getWriteMethod().invoke(obj,value);
                }
            }
            EdatResult result = null;
            if ( data.containsKey("aid")) result=agricuturalService.updateByPrimaryKeySelective(obj);
            else result=agricuturalService.save(obj);
            return result;
        } catch ( Exception e ) {
            LogUtil.getLogger().error("saveAgricuturalSoil 农用地数据添加数据异常",e);
            return EdatResult.build(1001, "saveAgricuturalSoil 农用地数据添加数据异常");
        }
    }
    /**
     * @author chendong  
     * @date 2018-11-22 11:58
     * @param   
     * @return  
     * @Description 农用地监测数据的添加
     */
    @RequestMapping("saveMonitorSoil")
    public EdatResult saveMonitorSoil(@RequestBody Map<String,Object> requestDate){
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            BeanInfo beanInfo = Introspector.getBeanInfo(TMONITORSOIL.class);
            Object obj = TMONITORSOIL.class.newInstance();
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor descriptor : propertyDescriptors ){
                String propertyName = descriptor.getName();
                if(data.containsKey(propertyName)){
                    Object value = data.get(propertyName);
                    if ( "aid".equals(propertyName)){
                        value = Long.parseLong(value.toString());
                    }
                    if ( "mid".equals(propertyName)){
                        value = Long.parseLong(value.toString());
                    }
                    descriptor.getWriteMethod().invoke(obj,value);
                }
            }
            EdatResult result = null;
            if ( data.containsKey("mid")) result=monitorService.updateByPrimaryKeySelective(obj);
            else result=monitorService.save(obj);
            return result;
        } catch(Exception e){
            LogUtil.getLogger().error("saveMonitorSoil 农用地监测数据添加数据异常",e);
            return EdatResult.build(1001, "saveMonitorSoil 农用地监测数据添加数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-22 14:44
     * @param
     * @return
     * @Description 农用地数据列表
     */
    @RequestMapping("AgricuturalSoilTable")
    public EdatResult AgricuturalSoilTable(@RequestBody Map<String,Object> requestDate,HttpServletRequest request) {
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            TAGRICUTURALSOIL tagricuturalsoil = new TAGRICUTURALSOIL();
            //农用地名称
            if(!"".equals(data.get("agricuturalName"))){
                tagricuturalsoil.setAgricuturalName(data.get("agricuturalName").toString());
            }
            //县
            if(!"".equals(data.get("countyCode"))){
                tagricuturalsoil.setCountyCode(data.get("countyCode").toString());
            }
            //土地利用类型
            if(!"".equals(data.get("agricuturalType"))){
                tagricuturalsoil.setAgricuturalType(data.get("agricuturalType").toString());
            }
            HttpSession session = request.getSession();
            SysUser user = (SysUser) session.getAttribute("sysUser");
            if("3".equals(user.getSuLevel())){
                tagricuturalsoil.setCountyCode(user.getSuRegioncode());
            }
            Integer pageNumber = Integer.valueOf(data.get("pageNumber").toString());
            Integer pageSize = Integer.valueOf(data.get("pageSize").toString());
            tagricuturalsoil.setPageNumber(pageNumber+1);
            tagricuturalsoil.setPageSize(pageSize+pageNumber);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            EdatResult edatResult = agricuturalService.list(tagricuturalsoil);
            return edatResult;
        } catch(Exception e ) {
            LogUtil.getLogger().error("AgricuturalSoilTable 农用地数据查询列表异常",e);
            return EdatResult.build(1001, "AgricuturalSoilTable 农用地数据查询列表异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-24 13:57
     * @param
     * @return
     * @Description 农用地监测数据表格
     */
    @RequestMapping("MonitorSoilTable")
    public EdatResult MonitorSoilTable(@RequestBody Map<String,Object> requestDate,HttpServletRequest request){
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            TMONITORSOIL tmonitorsoil = new TMONITORSOIL();

            TAGRICUTURALSOIL tagricuturalsoil = new TAGRICUTURALSOIL();
            //农用地名称
            if(!"".equals(data.get("agricuturalName"))){
                tagricuturalsoil.setAgricuturalName(data.get("agricuturalName").toString());
            }
            //县
            if(!"".equals(data.get("countyCode"))){
                tagricuturalsoil.setCountyCode(data.get("countyCode").toString());
            }
            //土地利用类型
            if(!"".equals(data.get("agricuturalType"))){
                tagricuturalsoil.setAgricuturalType(data.get("agricuturalType").toString());
            }
            HttpSession session = request.getSession();
            SysUser user = (SysUser) session.getAttribute("sysUser");
            if("3".equals(user.getSuLevel())){
                tagricuturalsoil.setCountyCode(user.getSuRegioncode());
            }
            Integer pageNumber = Integer.valueOf(data.get("pageNumber").toString());
            Integer pageSize = Integer.valueOf(data.get("pageSize").toString());
            tagricuturalsoil.setPageNumber(pageNumber+1);
            tagricuturalsoil.setPageSize(pageSize+pageNumber);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            EdatResult edatResult = monitorService.list(tagricuturalsoil);
            return edatResult;
        } catch(Exception e ) {
            LogUtil.getLogger().error("AgricuturalSoilTable 农用地数据查询列表异常",e);
            return EdatResult.build(1001, "AgricuturalSoilTable 农用地数据查询列表异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-22 18:17
     * @param
     * @return
     * @Description 单个删除农用地数据
     */
    @RequestMapping("deleteAgricuturalSoil")
    public EdatResult deleteAgricuturalSoil(@RequestBody Map<String,Object> requestDate){
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            long aid = Integer.parseInt(data.get("aid").toString());
            agricuturalService.deleteByPrimaryKey(aid);
            agricuturalService.deleteByPrimaryKey(aid);
            return  EdatResult.ok();
        } catch(Exception e ) {
            LogUtil.getLogger().error("deleteAgricuturalSoil 删除农用地数据异常",e);
            return EdatResult.build(1002, "deleteAgricuturalSoil 删除农用地数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-22 18:20
     * @param
     * @return
     * @Description 批量删除农用地
     */
    @RequestMapping("deleteAgricuturalSoilBatch")
    public EdatResult deleteAgricuturalSoilBatch(@RequestBody Map<String,Object> requestDate){
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            String  cd = (String) data.get("data");
            String[] str = cd.split(",");
            agricuturalService.deleteByPrimaryKeyBatch(str);
            return EdatResult.ok();
        } catch(Exception e ) {
            LogUtil.getLogger().error("deleteAgricuturalSoilBatch 删除农用地数据异常",e);
            return EdatResult.build(1002, "deleteAgricuturalSoilBatch 删除农用地数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-24 16:12
     * @param
     * @return
     * @Description 删除农用地监测数据
     */
    @RequestMapping("deleteMonitor")
    public EdatResult deleteMonitor(@RequestBody Map<String,Object> requestDate){
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            long aid = Integer.parseInt(data.get("aid").toString());
            EdatResult result = monitorService.deleteByPrimaryKey(aid);
            return  result;
        } catch(Exception e ) {
            LogUtil.getLogger().error("deleteMonitor 删除农用地数据异常",e);
            return EdatResult.build(1002, "deleteMonitor 删除农用地数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-24 16:12
     * @param
     * @return
     * @Description 批量删除农用地监测数据
     */
    @RequestMapping("deleteMonitorBatch")
    public EdatResult deleteMonitorBatch(@RequestBody Map<String,Object> requestDate){
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            String  cd = (String) data.get("data");
            String[] str = cd.split(",");
            monitorService.deleteByPrimaryKeyBatch(str);

            return EdatResult.ok("农用地数据批量删除成功！");
        } catch(Exception e ) {
            LogUtil.getLogger().error("deleteMonitorBatch 删除农用地数据异常",e);
            return EdatResult.build(1002, "deleteMonitorBatch 删除农用地数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-23 9:45
     * @param
     * @return
     * @Description 批量上传
     */
    @RequestMapping("importAgricuturalBatch")
    public EdatResult importAgricuturalBatch (@RequestParam( value="files",required=false)MultipartFile  file,HttpServletRequest request,HttpServletResponse response){
        InputStream is = null;
        try {
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
                        return EdatResult.error(1002, "[第"+i+"农用地名称为空]");
                    }
                    if (rows.getCell(1).toString() == null || "".equals(rows.getCell(1).toString())){
                        return EdatResult.error(1002, "[第"+i+"农用地编码为空]");
                    }
                    map.put("AGRICUTURAL_NAME",rows.getCell(0).toString());//农用地名称
                    map.put("AGRICUTURAL_CODE",rows.getCell(1).toString());//农用地编码
                    map.put("AGRICUTURAL_TYPE",rows.getCell(2) == null ? "" : rows.getCell(2).toString());//土地利用类型
                    if (rows.getCell(3) != null && "".equals(rows.getCell(3))){
                        if ( !"".equals(quanxian)){
                            if (!quanxian.equals(rows.getCell(3))){
                                return EdatResult.error(1002, "[第"+i+"区县编码错误]");
                            }
                        }
                    }
                    map.put("COUNTY_CODE",rows.getCell(3) == null ? "" : rows.getCell(3).toString().replace(".0",""));//县编码
                    map.put("LONGITUDE",rows.getCell(4) == null ? "" : rows.getCell(4).toString());//经度
                    map.put("LATITUDE",rows.getCell(5) == null ? "" : rows.getCell(5).toString());//纬度
                    map.put("ALTITUDE",rows.getCell(6) == null ? "" : rows.getCell(6).toString());//高程
                    list.add(map);
                } else break;

            }
            EdatResult result = agricuturalService.saveBath(list);
            return result;
        } catch (Exception e ) {
            LogUtil.getLogger().error("importAgricuturalBatch 农药地批量导入异常",e);
            return EdatResult.build(1003, "importAgricuturalBatch 农药地批量导入异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-23 16:33
     * @param
     * @return
     * @Description 农用地批量导出
     */
    @RequestMapping("exportAgricuturalBatch")
    public EdatResult exportAgricuturalBatch(HttpServletRequest request , HttpServletResponse response ){
       try{
           TAGRICUTURALSOIL tagricuturalsoil1 = new TAGRICUTURALSOIL();
           if ( !"".equals(request.getParameter("agricuturalName"))){//农用地名称
               tagricuturalsoil1.setAgricuturalName(request.getParameter("agricuturalName"));
           }
           if (!"".equals(request.getParameter("agricuturalType"))){//土地利用类型
               tagricuturalsoil1.setAgricuturalType(request.getParameter("agricuturalType"));
           }
           if (!"".equals(request.getParameter("countyCode"))){//县区
               tagricuturalsoil1.setCountyCode(request.getParameter("countyCode"));
           }
           EdatResult edatResult = agricuturalService.selectListByAids(tagricuturalsoil1);
           String[] title = {"农用地名称","农用地编码","土地利用类型","省编码","市编码","县编码","经度","纬度","高程"};
           List<TAGRICUTURALSOIL> list = (List<TAGRICUTURALSOIL>) edatResult.getData();
           String [][] content = new String[list.size()][];
           if( list.size() > 0 ) {
               for( int i = 0 ; i < list.size() ; i ++ ) {
                   content[i] = new String[title.length];
                   TAGRICUTURALSOIL tagricuturalsoil = list.get(i);
                   content[i][0] = tagricuturalsoil.getAgricuturalName();//农用地名称
                   content[i][1] = tagricuturalsoil.getAgricuturalCode();//农用地编码
                   content[i][2] = tagricuturalsoil.getAgricuturalType();//土地利用类型
                   content[i][3] = tagricuturalsoil.getProvinceCode();//省编码
                   content[i][4] = tagricuturalsoil.getCityCode();//市编码
                   content[i][5] = tagricuturalsoil.getCountyCode();//县编码
                   content[i][6] = tagricuturalsoil.getLongitude();//经度
                   content[i][7] = tagricuturalsoil.getLatitude();//纬度
                   content[i][8] = tagricuturalsoil.getAltitude();//高程

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
           XSSFSheet sheet = wb.createSheet("农用地");
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
           return EdatResult.ok("导出成功");
       } catch (Exception e ) {
           e.printStackTrace();
           return EdatResult.build(1005,"导出失败");
       }
    }

    /**
     * @author chendong
     * @date 2018-11-24 15:25
     * @param
     * @return
     * @Description 查询所有农用地
     */
    @RequestMapping("selectAll")
    public EdatResult selectAll(HttpServletRequest request){
        try{
            //创建农用地实体类
            TAGRICUTURALSOIL tagricuturalsoil = new TAGRICUTURALSOIL();
            //获取session信息
            HttpSession session = request.getSession();
            //获取当前登录用户的信息
            SysUser user = (SysUser) session.getAttribute("sysUser");
            //判断当前用户的级别
            if("3".equals(user.getSuLevel())){
                //获取用户的区县的行政区划
                tagricuturalsoil.setCountyCode(user.getSuRegioncode());
            }
            //查询所有农用地的名称以及ID
            EdatResult edatResult = agricuturalService.selectAll(tagricuturalsoil);
            return edatResult;
        } catch(Exception e ) {
            LogUtil.getLogger().error("selectAll 查询农用地异常",e);
            return EdatResult.build(1001, "查询农用地异常");
        }
    }

}
