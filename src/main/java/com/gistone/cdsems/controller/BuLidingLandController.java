package com.gistone.cdsems.controller;

import com.alibaba.fastjson.JSONObject;
import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.database.entity.TBASICSCONTAMINATED;
import com.gistone.cdsems.database.entity.TBULIDINGLAND;
import com.gistone.cdsems.database.entity.TINVESTIGATIONLAND;
import com.gistone.cdsems.database.mapper.TBULIDINGLANDMapper;
import com.gistone.cdsems.database.mapper.TINVESTIGATIONLANDMapper;
import com.gistone.cdsems.service.BuLidingLand.BuLidingLandService;
import com.gistone.cdsems.service.BuLidingLand.InvestigationService;
import com.gistone.cdsems.util.*;
import com.google.gson.Gson;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
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
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chendong  
 * @date 2018-11-24 10:22
 * @param   
 * @return  
 * @Description 建设用地
 */
@RestController
@RequestMapping("BuLidingLandController")
public class BuLidingLandController {
    @Autowired
    private BuLidingLandService buLidingLandService;
    @Autowired
    private InvestigationService investigationService;
    @Autowired
    private UrlsUtil urlsUtil;
    /**
     * @author chendong
     * @date 2018-11-23 19:09
     * @param
     * @return
     * @Description 建设用地添加修改
     */
    @RequestMapping("saveBuLidingLand")
    public EdatResult saveBuLidingLand(@RequestBody Map<String,Object> requestDate ){
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            BeanInfo beanInfo = Introspector.getBeanInfo(TBULIDINGLAND.class);
            Object obj = TBULIDINGLAND.class.newInstance();
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor descriptor : propertyDescriptors ){
                String propertyName = descriptor.getName();
                if(data.containsKey(propertyName)){
                    Object value = data.get(propertyName);
                    if ( "lid".equals(propertyName)){
                        value = Long.parseLong(value.toString());
                    }
                    descriptor.getWriteMethod().invoke(obj,value);
                }
            }
            EdatResult edatResult = null;
            if ( data.containsKey("lid")) edatResult = buLidingLandService.updateByPrimaryKeySelective(obj);
            else edatResult = buLidingLandService.save(obj);
            return edatResult.ok();
        } catch( Exception e ) {
            LogUtil.getLogger().error("saveBuLidingLand 建设用地添加数据异常",e);
            return EdatResult.build(1001, "saveBuLidingLand 建设用地添加数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-23 19:12
     * @param
     * @return
     * @Description 建设用地调查添加修改
     */
    @RequestMapping("saveInvestigationLand")
    public EdatResult saveInvestigationLand(@RequestParam( value="files",required=false)MultipartFile  file,@RequestParam( value="files1",required=false)MultipartFile  file1,HttpServletRequest request){
        try{
            String xdUrl = "";
            String xdUrl1 = "";
            if ( file != null || file1 != null ) {
                DateFormat df = new SimpleDateFormat("yyyyMMdd");
                //唯一文件名称
                String newFilename = UuidUtil.get32UUID()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                String newFilename1 = UuidUtil.get32UUID()+file1.getOriginalFilename().substring(file1.getOriginalFilename().lastIndexOf("."));
                //相对路径
                xdUrl = "/File/lidingLand/"+df.format(new Date())+"/"+newFilename;
                xdUrl1 = "/File/lidingLand/"+df.format(new Date())+"/"+newFilename1;
                //创建文件夹
                String directoryUrl = urlsUtil.geturl()+"/File/lidingLand/"+df.format(new Date())+"/";
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
            if ("".equals(data.get("preliminaryCompilingTime")))  data.remove("preliminaryCompilingTime");

            BeanInfo beanInfo = Introspector.getBeanInfo(TINVESTIGATIONLAND.class);
            Object obj = TINVESTIGATIONLAND.class.newInstance();
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor descriptor : propertyDescriptors ){
                String propertyName = descriptor.getName();
                if(data.containsKey(propertyName)){
                    Object value = data.get(propertyName);
                    if ( "preliminaryCompilingTime".equals(propertyName)){
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        value = sdf.parse(value.toString());
                    }
                    if ( "lid".equals(propertyName)){
                        value = Long.parseLong(value.toString());
                    }
                    if ( "iid".equals(propertyName)){
                        value = Long.parseLong(value.toString());
                    }

                    descriptor.getWriteMethod().invoke(obj,value);
                }
            }
            EdatResult edatResult = null;
            if ( data.containsKey("iid")) edatResult = investigationService.updateByPrimaryKeySelective(obj);
            else edatResult=investigationService.save(obj);
            return edatResult;
        } catch( Exception e ) {
            LogUtil.getLogger().error("saveInvestigationLand 建设用地调查添加数据异常",e);
            return EdatResult.build(1001, "saveInvestigationLand 建设用地调查添加数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-23 19:16
     * @param
     * @return
     * @Description 删除建设用地
     */
    @RequestMapping("deleteBuLiding")
    public EdatResult deleteBuLiding(@RequestBody Map<String,Object> requestDate){
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            long lid = Integer.parseInt(data.get("lid").toString());
            EdatResult result =buLidingLandService.deleteByPrimaryKey(lid);
            return  result;
        } catch ( Exception e ) {
            LogUtil.getLogger().error("deleteBuLiding 建设用地删除数据异常",e);
            return EdatResult.build(1002, "建设用地删除数据异常！");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-23 19:18
     * @param
     * @return
     * @Description 批量删除建设用地
     */
    @RequestMapping("deleteBuLidingBatch")
    public EdatResult deleteBuLidingBatch(@RequestBody Map<String,Object> requestDate){
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            String  cd = (String) data.get("data");
            String[] str = cd.split(",");
            buLidingLandService.deleteByPrimaryKeyBatch(str);
            return  EdatResult.ok("建设用地批量删除成功！");
        } catch ( Exception e ) {
            LogUtil.getLogger().error("deleteBuLidingBatch 建设用地批量删除异常",e);
            return EdatResult.build(1002, "建设用地批量删除异常！");
        }
    }
    
    /**
     * @author chendong  
     * @date 2018-11-23 19:20  
     * @param   
     * @return  
     * @Description 删除建设用地调查
     */
    @RequestMapping("deleteInvestigation")
    public EdatResult deleteInvestigation(@RequestBody Map<String,Object> requestDate){
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            long lid = Integer.parseInt(data.get("lid").toString());
            EdatResult edatResult = investigationService.deleteByPrimaryKey(lid);
            return  edatResult;
        } catch ( Exception e ) {
            LogUtil.getLogger().error("deleteInvestigation 删除数据异常",e);
            return EdatResult.build(1002, "建设用地调查删除异常！");
        }
    }
    /**
     * @author chendong  
     * @date 2018-11-23 19:22  
     * @param   
     * @return  
     * @Description 批量删除建设用地调查
     */
    @RequestMapping("deleteInvestigationBatch")
    public EdatResult deleteInvestigationBatch(@RequestBody Map<String,Object> requestDate){
        try{
            Map<String,Object> data = (Map<String, Object>) requestDate.get("data");
            String  cd = (String) data.get("data");
            String[] str = cd.split(",");
            investigationService.deleteByPrimaryKeyBatch(str);
            return  EdatResult.ok();
        } catch (Exception e ) {
            LogUtil.getLogger().error("deleteInvestigationBatch 删除数据异常！",e);
            return EdatResult.build(1002, "批量删除建设用地调查异常！");
        }
    }

    /**
     * @author chendong  
     * @date 2018-11-24 10:40
     * @param   
     * @return  
     * @Description 农用地数据表格
     */
    @RequestMapping("selectBuLidingTable")
    public EdatResult selectBuLidingTable(@RequestBody Map<String,Object> requestDate,HttpServletRequest request ) {
        try{
            Map<String,Object > data = (Map<String, Object>) requestDate.get("data");
            TBULIDINGLAND tbulidingland = new TBULIDINGLAND();
            //地块名称
            if(!"".equals(data.get("massifName"))){
                tbulidingland.setMassifName(data.get("massifName").toString());
            }
            //组织机构代码
            if (!"".equals(data.get("organizationCode"))){
                tbulidingland.setOrganizationCode(data.get("organizationCode").toString());
            }
            //地块位置
            if(!"".equals(data.get("massifAddress"))){
                tbulidingland.setMassifAddress(data.get("massifAddress").toString());
            }
            //县
            if(!"".equals(data.get("countyCode"))){
                tbulidingland.setCountyCode(data.get("countyCode").toString());
            }
            HttpSession session = request.getSession();
            SysUser user = (SysUser) session.getAttribute("sysUser");
            if("3".equals(user.getSuLevel())){
                tbulidingland.setCountyCode(user.getSuRegioncode());
            }
            Integer pageNumber = Integer.valueOf(data.get("pageNumber").toString());
            Integer pageSize = Integer.valueOf(data.get("pageSize").toString());
            tbulidingland.setPageNumber(pageNumber+1);
            tbulidingland.setPageSize(pageSize+pageNumber);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            EdatResult edatResult = buLidingLandService.list(tbulidingland);
            return edatResult;
        } catch (Exception  e ) {
            LogUtil.getLogger().error("selectBuLidingTable 查询数据异常",e);
            return EdatResult.build(1003, "selectBuLidingTable 查询数据异常");
        }


    }
    
    /**
     * @author chendong  
     * @date 2018-11-24 10:48  
     * @param   
     * @return  
     * @Description 农用地监测数据表格
     */
    @RequestMapping("selectInvestigationTable")
    public EdatResult selectInvestigationTable(@RequestBody Map<String,Object> requestDate,HttpServletRequest request ) {
        try {
            Map<String,Object> data = (Map)requestDate.get("data");
            TINVESTIGATIONLAND tinvestigationland = new TINVESTIGATIONLAND();
            TBULIDINGLAND tbulidingland = new TBULIDINGLAND();
            //地块名称
            if(!"".equals(data.get("massifName"))){
                tbulidingland.setMassifName(data.get("massifName").toString());
            }
            //组织机构代码
            if (!"".equals(data.get("organizationCode"))){
                tbulidingland.setOrganizationCode(data.get("organizationCode").toString());
            }
            //地块位置
            if(!"".equals(data.get("massifAddress"))){
                tbulidingland.setMassifAddress(data.get("massifAddress").toString());
            }
            //县
            if(!"".equals(data.get("countyCode"))){
                tbulidingland.setCountyCode(data.get("countyCode").toString());
            }
            HttpSession session = request.getSession();
            SysUser user = (SysUser) session.getAttribute("sysUser");
            if("3".equals(user.getSuLevel())){
                tbulidingland.setCountyCode(user.getSuRegioncode());
            }
            Integer pageNumber = Integer.valueOf(data.get("pageNumber").toString());
            Integer pageSize = Integer.valueOf(data.get("pageSize").toString());
            tbulidingland.setPageNumber(pageNumber+1);
            tbulidingland.setPageSize(pageSize+pageNumber);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            EdatResult edatResult = investigationService.list(tbulidingland);

            return edatResult;
        } catch(Exception e ) {
            LogUtil.getLogger().error("selectInvestigationTable 查询数据异常",e);
            return EdatResult.build(1003, "selectInvestigationTable 查询数据异常");
        }
    }
    /**
     * @author chendong
     * @date 2018-11-24 11:14
     * @param
     * @return
     * @Description 批量导入
     */
    @RequestMapping("importBuLiding")
    public EdatResult importBuLiding(@RequestParam( value="files",required=false)MultipartFile file,HttpServletRequest request){
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
                    if (rows.getCell(0) == null || "".equals(rows.getCell(0))){
                        return EdatResult.error(2, "导入失败，错误原因[第"+i+"地块名称为空]");
                    }
                    if (rows.getCell(1) == null || "".equals(rows.getCell(1))){
                        return EdatResult.error(2, "导入失败，错误原因[第"+i+"地块编码为空]");
                    }
                    map.put("MASSIF_NAME",rows.getCell(0).toString());//地块名称
                    map.put("MASSIF_CODE",rows.getCell(1).toString());//地块编码
                    map.put("MASSIF_ADDRESS",rows.getCell(2) == null ? "" : rows.getCell(2).toString());//污染地块地址
                    String reg = "^[0-9]+(.[0-9]+)?$";
                    if (rows.getCell(3) != null){
                        if(!rows.getCell(3).toString().matches(reg))  return EdatResult.error(2, "导入失败，错误原因面积有别的字符]");
                    }
                    if(!rows.getCell(3).toString().matches(reg))  return EdatResult.error(2, "导入失败，错误原因面积有别的字符]");
                    map.put("MASSIF_COVERED",rows.getCell(3) == null ? "" : rows.getCell(3).toString());//占地面积
//                map.put("PROVINCE_CODE",rows.getCell(4) == null ? "" : rows.getCell(4).toString());//省编码
//                map.put("CITY_CODE",rows.getCell(5) == null ? "" : rows.getCell(5).toString());//市编码
                    if (rows.getCell(4) != null && "".equals(rows.getCell(4))){
                        if ( !"".equals(quanxian)){
                            if (!quanxian.equals(rows.getCell(4))){
                                return EdatResult.build(1002, "[第"+i+"区县编码错误]");
                            }
                        }
                    }
                    map.put("COUNTY_CODE",rows.getCell(4) == null ? "" : rows.getCell(4).toString().replace(".0",""));//县编码
                    map.put("RISK_LEVEL",rows.getCell(5) == null ? "" : rows.getCell(5).toString());//风险级别
                    map.put("ENTERPRISE_NAME",rows.getCell(6) == null ? "" : rows.getCell(6).toString());//企业名称
                    map.put("LEGAL_REPRESENTATIVE",rows.getCell(7) == null ? "" : rows.getCell(7).toString());//法人代表
                    map.put("BUSINESS_LICENSE",rows.getCell(8) == null ? "" : rows.getCell(8).toString());//工商营业执照
                    map.put("POSTAL_CODE",rows.getCell(9) == null ? "" : rows.getCell(9).toString());//邮政编码
                    map.put("MASSIF_AROUND_AREA",rows.getCell(10) == null ? "" : rows.getCell(10).toString());//地块四周范围
                    map.put("MASSIF_LONGITUDE",rows.getCell(11) == null ? "" : rows.getCell(11).toString());//污染地块中心经度
                    map.put("MASSIF_LATITUDE",rows.getCell(12) == null ? "" : rows.getCell(12).toString());//污染地块中心纬度
                    map.put("COORDINATE_DESCRIPTION",rows.getCell(13) == null ? "" : rows.getCell(13).toString());//坐标说明
                    map.put("ACCESS_UNIT_CONTACTS",rows.getCell(14) == null ? "" : rows.getCell(14).toString());//使用权单位联系人
                    map.put("ACCESS_UNIT_PHONE",rows.getCell(15) == null ? "" : rows.getCell(15).toString());//使用权单位联系电话
                    map.put("CONTACT_FACSIMILE",rows.getCell(16) == null ? "" : rows.getCell(16).toString());//联系传真
                    map.put("MAILBOX",rows.getCell(17) == null ? "" : rows.getCell(17).toString());//电子邮箱
                    map.put("FAX",rows.getCell(18) == null ? "" : rows.getCell(18).toString());//传真
                    map.put("CONSTRUCTION_UNIT",rows.getCell(19) == null ? "" : rows.getCell(19).toString());//建设单位
                    map.put("CONSTRUCTION_PEOPLE",rows.getCell(20) == null ? "" : rows.getCell(20).toString());//建设单位联系人
                    map.put("CONSTRUCTION_PHONE",rows.getCell(21) == null ? "" : rows.getCell(21).toString());//联系电话
                    map.put("ORGANIZATION_CODE",rows.getCell(22) == null ? "" : rows.getCell(22).toString());//组织机构代码
                    map.put("LAND_USE",rows.getCell(23) == null ? "" : rows.getCell(23).toString());//土地规划用途
                    list.add(map);
                } else break;

            }
            EdatResult edatResult = buLidingLandService.saveBath(list);
            return edatResult;
        } catch (Exception e ) {
            LogUtil.getLogger().error("importBuLiding 批量导入异常",e);
            return EdatResult.build(1003, "importBuLiding 批量导入异常");
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * @author chendong
     * @date 2018-11-24 11:29
     * @param
     * @return
     * @Description 批量导出
     */
    @RequestMapping("exportBuLiding")
    public EdatResult exportBuLiding(HttpServletRequest request , HttpServletResponse response ){
        try{
            TBULIDINGLAND tbulidingland1 = new TBULIDINGLAND();
            if (!"".equals(request.getParameter("massifName"))){//地块名称
                tbulidingland1.setMassifName(request.getParameter("massifName"));
            }
            if (!"".equals(request.getParameter("countyCode"))){//区县
                tbulidingland1.setCountyCode(request.getParameter("countyCode"));
            }
            if( !"".equals(request.getParameter("massifAddress"))){//污染地块地址
                tbulidingland1.setMassifAddress(request.getParameter("massifAddress"));
            }
            if (!"".equals(request.getParameter("organizationCode"))){//组织机构代码
                tbulidingland1.setOrganizationCode(request.getParameter("organizationCode"));
            }
            EdatResult edatResult = buLidingLandService.selectListByLids(tbulidingland1);
            String[] title = {"地块名称","地块编码","污染地块地址","占地面积（平方米）","县编码","风险级别",
                    "企业名称","法人代表","工商营业执照","邮政编码","地块四周范围","污染地块中心经度","污染地块中心纬度","坐标说明","使用权单位联系人",
                    "使用权单位联系电话","联系传真","电子邮箱","传真","建设单位","建设单位联系人","联系电话","组织机构代码","土地规划用途"};
            List<TBULIDINGLAND> list = (List<TBULIDINGLAND>) edatResult.getData();
            String [][] content = new String[list.size()][];
            if ( list.size() > 0 ) {
                for( int i = 0 ; i < list.size(); i ++ ) {
                    content[i] = new String[title.length];
                    TBULIDINGLAND tbulidingland = list.get(i);
                    content[i][0] = tbulidingland.getMassifName();
                    content[i][1] = tbulidingland.getMassifCode();
                    content[i][2] = tbulidingland.getMassifAddress();
                    content[i][3] = tbulidingland.getMassifCovered();
//                    content[i][4] = tbulidingland.getProvinceCode();
//                    content[i][5] = tbulidingland.getCityCode();
                    content[i][4] = tbulidingland.getCountyCode();
                    content[i][5] = tbulidingland.getRiskLevel();
                    content[i][6] = tbulidingland.getEnterpriseName();
                    content[i][7] = tbulidingland.getLegalRepresentative();
                    content[i][8] = tbulidingland.getBusinessLicense();
                    content[i][9] = tbulidingland.getPostalCode();
                    content[i][10] = tbulidingland.getMassifAroundArea();
                    content[i][11] = tbulidingland.getMassifLongitude();
                    content[i][12] = tbulidingland.getMassifLatitude();
                    content[i][13] = tbulidingland.getCoordinateDescription();
                    content[i][14] = tbulidingland.getAccessUnitContacts();
                    content[i][15] = tbulidingland.getAccessUnitPhone();
                    content[i][16] = tbulidingland.getContactFacsimile();
                    content[i][17] = tbulidingland.getMailbox();
                    content[i][18] = tbulidingland.getFax();
                    content[i][19] = tbulidingland.getConstructionUnit();
                    content[i][20] = tbulidingland.getConstructionPeople();
                    content[i][21] = tbulidingland.getConstructionPhone();
                    content[i][22] = tbulidingland.getOrganizationCode();
                    content[i][23] = tbulidingland.getLandUse();
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
            XSSFSheet sheet = wb.createSheet("建设用地基本信息");
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
        }catch (Exception e ) {
            LogUtil.getLogger().error("exportBuLiding 批量导出异常",e);
            return EdatResult.build(1004, "exportBuLiding 批量导出异常");
        }
    }

    /**
     * @author chendong
     * @date 2018-11-24 17:21
     * @param
     * @return
     * @Description 查询所有的建设用地
     */
    @RequestMapping("selectBuLidingAll")
    public EdatResult selectBuLidingAll(HttpServletRequest request){
        try{
            HttpSession session = request.getSession();
            SysUser user = (SysUser) session.getAttribute("sysUser");
            TBULIDINGLAND tbulidingland = new TBULIDINGLAND();
            if("3".equals(user.getSuLevel())){
                tbulidingland.setCountyCode(user.getSuRegioncode());
            }
            EdatResult edatResult = buLidingLandService.selectAll(tbulidingland);

            return edatResult;
        } catch(Exception e ) {
            LogUtil.getLogger().error("selectBuLidingAll 查询异常",e);
            return EdatResult.build(1001, "selectBuLidingAll 查询异常");
        }
    }

}
