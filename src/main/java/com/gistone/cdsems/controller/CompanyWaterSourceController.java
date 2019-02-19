package com.gistone.cdsems.controller;

import com.alibaba.druid.util.StringUtils;
import com.gistone.cdsems.database.entity.CompanyWaterSource;
import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.database.mapper.CompanyWaterSourceMapper;
import com.gistone.cdsems.service.CompanyWaterSourceService;
import com.gistone.cdsems.util.EdatResult;
import com.gistone.cdsems.util.LogUtil;
import com.gistone.cdsems.util.RegUtil;
import com.gistone.cdsems.util.Result;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("CompanyWaterMonitorController")
public class CompanyWaterSourceController {

    @Autowired
    private CompanyWaterSourceService CompanyWaterSourceService;
    @Autowired
    private CompanyWaterSourceMapper CompanyWaterSourceMapper;
	
    /**
     * @author songqinjie
     * @date 2018-11-26 15:20
     * @param
     * @return
     * @Description 水源地基本信息查询列表
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("SelectWaterMonitorList")
    public Result SelectWaterMonitorList(@RequestBody Map<String,Object> requestDate,HttpServletResponse response , HttpServletRequest request ) {
        try {
            Map<String,Object> data = (Map)requestDate.get("data");
            
            Map<String,Object> parmap = new HashMap<String,Object>();
            int pageNumber =0;     		//页码
            int pageSize =0;			//每页数量
            String waterSourceName = null;		//园区名称
            String countyCode = null;	//县code
            String id = null;		//市code
            if(data.get("pageNumber") !=null && !"".equals(data.get("pageNumber").toString())) {
            	pageNumber = Integer.parseInt(data.get("pageNumber").toString());
            	int number = pageNumber+1;
            	parmap.put("number", number);
            }
            if(data.get("pageSize") !=null && !"".equals(data.get("pageSize").toString())) {
            	pageSize= Integer.parseInt(data.get("pageSize").toString());
            	int size = pageSize+pageNumber;
            	parmap.put("size", size);
            }
            if(data.get("waterSourceName") !=null && !"".equals(data.get("waterSourceName").toString())) {
            	waterSourceName= data.get("waterSourceName").toString();
            	parmap.put("waterSourceName", waterSourceName);
            }
            if(data.get("countyCode") !=null && !"".equals(data.get("countyCode").toString())) {
            	countyCode= data.get("countyCode").toString();
            	parmap.put("countyCode", countyCode);
            }
            if(data.get("id") !=null && !"".equals(data.get("id").toString())) {
            	id= data.get("id").toString();
            	parmap.put("id", id);
            }
            
            //1.获取session
			HttpSession session = request.getSession();
			//判断session中是否有用户信息
			if (!RegUtil.CheckParameter(session.getAttribute("sysUser"), null, null, false)) {
				return Result.build(1002, "登陆超时");
			}
			//获取用户信息
			SysUser seUser = (SysUser) session.getAttribute("sysUser");
			//用户级别参数
			if(seUser.getSuLevel()!=null){
				if("3".equals(seUser.getSuLevel().toString())){
					parmap.put("suRegioncode", seUser.getSuRegioncode());
				}
			}
            
            EdatResult er =  CompanyWaterSourceService.listPage(parmap);
            
            return Result.ok(er);
        } catch (Exception e) {
            LogUtil.getLogger().error("SelectWaterMonitorList 查询数据异常",e);
            return Result.build(1003, "SelectWaterMonitorList 查询数据异常");
        }
    }
    
    
    
    
    /**
     * @author songqinjie
     * @date 2018-11-21 15:20
     * @param
     * @return
     * @Description 水源地监测信息查询列表
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping("SelectWaterMonitorsList")
    public Result SelectWaterMonitorsList(@RequestBody Map<String,Object> requestDate,HttpServletResponse response , HttpServletRequest request ) {
    	try {
    		Map<String,Object> data = (Map)requestDate.get("data");
    		
    		Map<String,Object> parmap = new HashMap<String,Object>();
    		String id = null;		//市code
    		if(data.get("id") !=null && !"".equals(data.get("id").toString())) {
    			id= data.get("id").toString();
    			parmap.put("id", id);
    		}/*else {
            	return Result.build(1006, "SelectParkPollutantsList 查询参数不能为空");
			}*/
    		
    		EdatResult er =  CompanyWaterSourceService.SelectlistPage(parmap);
    		
    		return Result.ok(er);
    	} catch (Exception e) {
    		LogUtil.getLogger().error("SelectWaterMonitorsList 查询数据异常",e);
    		return Result.build(1003, "SelectWaterMonitorsList 查询数据异常");
    	}
    }
    
    
    /**
     * @author songqinjie
     * @date 2018-11-27 13:20
     * @param
     * @return
     * @Description 删除水源地基本信息（单个删除。支持批量删除）
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping("DelWaterMonitor")
    public Result DelWaterMonitor(@RequestBody Map<String,Object> requestDate,HttpServletResponse response , HttpServletRequest request ) {
    	try {
    		Map<String,Object> data = (Map)requestDate.get("data");
    		Map<String,Object> parmap = new HashMap<String,Object>();
    		String id = null;     		//页码
    		if(data.get("id") !=null && !"".equals(data.get("id").toString())) {
    			id= data.get("id").toString();
    			parmap.put("id", id);
    		}else {
    			return Result.build(1006, "DelWaterMonitor 查询参数不能为空");
    		}
    		
            EdatResult er =  CompanyWaterSourceService.delete(this.getUserId(request), id); //

            return Result.ok(er);
    	} catch (Exception e) {
    		LogUtil.getLogger().error("DelWaterMonitor 查询数据异常",e);
    		return Result.build(1003, "DelWaterMonitor 查询数据异常");
    	}
    }
    /**
     * @author songqinjie
     * @date 2018-11-21 16:20
     * @param
     * @return
     * @Description 删除饮用水源地监测信息
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping("DelWaterMonitorList")
    public Result DelWaterMonitorList(@RequestBody Map<String,Object> requestDate,HttpServletResponse response , HttpServletRequest request ) {
    	try {
    		Map<String,Object> data = (Map)requestDate.get("data");
    		Map<String,Object> parmap = new HashMap<String,Object>();
    		String id = null;     		//页码
    		if(data.get("id") !=null && !"".equals(data.get("id").toString())) {
    			id= data.get("id").toString();
    			parmap.put("id", id);
    		}else {
    			return Result.build(1006, "DelWaterMonitorList 查询参数不能为空");
    		}
    		
    		EdatResult er =  CompanyWaterSourceService.deleteWaterMonitor(this.getUserId(request), id); //
    		
    		return Result.ok(er);
    	} catch (Exception e) {
    		LogUtil.getLogger().error("DelWaterMonitorList 查询数据异常",e);
    		return Result.build(1003, "DelWaterMonitorList 查询数据异常");
    	}
    }
    
    /**
   	 * 	新增水源地基本信息
   	 * @param requestData
   	 * @param request
   	 * @param response
   	 * @return
   	 * @throws Exception
   	 */
   	@SuppressWarnings({ "unchecked", "rawtypes" })
   	@RequestMapping("/saveWaterSourceInfor")
   	public Result saveWaterSourceInfor(@RequestBody Map<String, Object> requestData,HttpServletRequest request,HttpServletResponse response)throws Exception{
   		
   		HttpSession session = request.getSession();
   		SysUser user = (SysUser) session.getAttribute("sysUser");
   		String code = user.getSuRegioncode();
   		Map<String, Object> data = (Map) requestData.get("data");
   		Result res = null;
   		//获取前端传递的参数
   		CompanyWaterSource parkManag = new CompanyWaterSource();
   		
   		try {
   			//水源地名称
   			if (RegUtil.CheckParameter(data.get("waterSourceName"), null, null, false)) {
   				parkManag.setWaterSourceName(data.get("waterSourceName").toString());
   			}
   			//县code
   			if (RegUtil.CheckParameter(data.get("countyCode"), null, null, false)) {
   				parkManag.setCountyCode(data.get("countyCode").toString());
   			}
   			//水源地编码
   			if (RegUtil.CheckParameter(data.get("waterSourceCode"), null, null, false)) {
   				parkManag.setWaterSourceCode(data.get("waterSourceCode").toString());
   			}
   			//水源地类型
   			if (RegUtil.CheckParameter(data.get("waterSourceType"), null, null, false)) {
   				parkManag.setWaterSourceType(data.get("waterSourceType").toString());
   			}
   			//子表
   			List<Map<String,Object>> lm = null;
   			if (RegUtil.CheckParameter(data.get("waterSource"), null, null, false)) {
   				lm= (List<Map<String,Object>>) data.get("waterSource");
   			}
   			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
   			if(lm!=null && lm.size()>0) {
   				for (Map<String, Object> map : lm) {
   					map.put("CREATE_TIME", df.format(new Date()));
   					map.put("CREATE_USER_ID", this.getUserId(request).toString());
   				}
   			}
   			//新增时间
   			parkManag.setCreateTime(df.format(new Date()));
   			//新增用户id
   			parkManag.setCreateUserId(this.getUserId(request).toString());
   		
   		    EdatResult er = CompanyWaterSourceService.save(this.getUserId(request),parkManag,lm);
   		    return Result.ok(er);
   		} catch (Exception e) {
   			e.printStackTrace();
   		}
   		return res; 
   	}
    
   	/**
	 *  	修改水源地监测信息
	 * @param requestData
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/updaPolluterInfor")
	public Result updaPolluterInfor(@RequestBody Map<String, Object> requestData,HttpServletRequest request,HttpServletResponse response)throws Exception{
		Map<String, Object> data = (Map) requestData.get("data");
		Result res = null;
		//获取前端传递的参数
		CompanyWaterSource waterSource = new CompanyWaterSource();
		try {
			//id
			Long id = null;
			if (RegUtil.CheckParameter(data.get("id"), null, null, false)) {
				id = Long.parseLong(data.get("id").toString());
				waterSource.setId(id);
			}
			
			//水源地名称
   			if (RegUtil.CheckParameter(data.get("waterSourceName"), null, null, false)) {
   				waterSource.setWaterSourceName(data.get("waterSourceName").toString());
   			}
   			//县code
   			if (RegUtil.CheckParameter(data.get("countyCode"), null, null, false)) {
   				waterSource.setCountyCode(data.get("countyCode").toString());
   			}
   			//水源地编码
   			if (RegUtil.CheckParameter(data.get("waterSourceCode"), null, null, false)) {
   				waterSource.setWaterSourceCode(data.get("waterSourceCode").toString());
   			}
   			//水源地类型
   			if (RegUtil.CheckParameter(data.get("waterSourceType"), null, null, false)) {
   				waterSource.setWaterSourceType(data.get("waterSourceType").toString());
   			}
			
			List<Map<String,Object>> lm = null;
			if (RegUtil.CheckParameter(data.get("waterSource"), null, null, false)) {
				lm= (List<Map<String,Object>>) data.get("waterSource");
			}
			if(lm != null && lm.size()>0 && lm.get(0)!=null) {
				for (Map<String, Object> map : lm) {
					String reg = "^[0-9]+(.[0-9]+)?$";
					if(map.get("THE_TOTAL_CHROMIUM")!=null && !"".equals(map.get("THE_TOTAL_CHROMIUM").toString())) {
						if(!map.get("THE_TOTAL_CHROMIUM").toString().matches(reg)) {
							Result.build(1, "数据格式错误，请重新输入");
						}
					}
					if(map.get("CADMIUM")!=null && !"".equals(map.get("CADMIUM").toString())) {
						if(!map.get("CADMIUM").toString().matches(reg)) {
							Result.build(1, "数据格式错误，请重新输入");
						}
					}
					if(map.get("MERCURY")!=null && !"".equals(map.get("MERCURY").toString())) {
						if(!map.get("MERCURY").toString().matches(reg)) {
							Result.build(1, "数据格式错误，请重新输入");
						}
					}
					if(map.get("ARSENIC")!=null && !"".equals(map.get("ARSENIC").toString())) {
						if(!map.get("ARSENIC").toString().matches(reg)) {
							Result.build(1, "数据格式错误，请重新输入");
						}
					}
					if(map.get("LEAD")!=null && !"".equals(map.get("LEAD").toString())) {
						if(!map.get("LEAD").toString().matches(reg)) {
							Result.build(1, "数据格式错误，请重新输入");
						}
					}
					if(map.get("NICKEL")!=null && !"".equals(map.get("NICKEL").toString())) {
						if(!map.get("NICKEL").toString().matches(reg)) {
							Result.build(1, "数据格式错误，请重新输入");
						}
					}
					if(map.get("COPPER")!=null && !"".equals(map.get("COPPER").toString())) {
						if(!map.get("COPPER").toString().matches(reg)) {
							Result.build(1, "数据格式错误，请重新输入");
						}
					}
				}
			}
			
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			for (Map<String, Object> map : lm) {
				map.put("UPDATE_TIME", df.format(new Date()));
				map.put("UPDATE_USER_ID", this.getUserId(request).toString());
				map.put("WATER_ID", id);
			}
			
			EdatResult er = CompanyWaterSourceService.updateWaterMonitor(this.getUserId(request),waterSource,lm);
		
		    return Result.ok(er);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res; 
	}
   	
	/**
	 * 	批量导入数据
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "unlikely-arg-type", "rawtypes" })
	@RequestMapping(value="importWaterSourceExcel",method=RequestMethod.POST)
	public Object importWaterSourceExcel(HttpServletRequest request,HttpServletResponse response, 
			@RequestParam("file") MultipartFile file) throws IOException {
		InputStream is = null;
		try {
			String upName = file.getOriginalFilename();//获取上传的文件名
	        String suffix = upName.substring(upName.lastIndexOf(".") + 1);//获取后缀名
	        if (!suffix.equals("xls") && !suffix.equals("xlsx")) {
	            return EdatResult.error(2, "上传文件格式错误！");
	        }
	        
            String[] title = {"区县编码","水源地名称","水源地编码","水源地类型"};

			//文件转输入流
			is = file.getInputStream();
			//解析文件生成Workbook
            Workbook wb = WorkbookFactory.create(is);
            //Excel工作表
            Sheet sheet1 = wb.getSheetAt(0);
            //获取行数
            int rowNum = sheet1.getLastRowNum() + 1;
            String[] colName = readExcelTitle(sheet1);// 读取excel表头名称
            for (String string : colName) {
            	if(!Arrays.asList(title).contains(string)) {
            		return EdatResult.error(2, "导入失败，错误原因表头和模板不一致");
            	}
			}
            //定义保存读取的文件数据的list
            List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
            //定义错误行数和错误信息
            int errNum=0;String errInfo="";
            //循环文件内容插入到数据库
            for (int i = 1; i < rowNum; i++) {
            	//存放行的数据
            	Map map = new HashMap();
            	//获取本行内容
                Row row = sheet1.getRow(i);
                
                
                if(row==null){
                	continue;
            	}/* else if(StringUtils.isEmpty(getValue(row.getCell(0)))&&StringUtils.isEmpty(getValue(row.getCell(1)))){
                	errInfo+="[第"+i+"行 存在为空的列]";
                    continue;
                } */
                
    			//县code 
    			if(row.getCell(0)==null || "".equals(row.getCell(0))){
    				errInfo+="[第"+i+"行县行政编码为空]";
    				errNum++;
    				continue;
    			}else{
    				String temp = row.getCell(0).toString();
    				if(temp.indexOf(".")>-1) {
    					temp = temp.substring(0,temp.indexOf("."));
    				}
    				map.put("countyCode", temp);
    			}
    			//企业名称
    			if(row.getCell(1)==null || "".equals(row.getCell(1))){
    				errInfo+="[第"+i+"行企业名称为空]";
    				errNum++;
    				continue;
    			}else{
    				map.put("waterSourceName", row.getCell(1));
    			}
    			//面积
    			map.put("waterSourceCode", row.getCell(2)==null?"":row.getCell(2));
    			//地址
    			map.put("waterSourceType", row.getCell(3)==null?"":changeData(row.getCell(3).toString()));
    			//创建用户id
    			map.put("createUserId", this.getUserId(request));
    			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    			//新增时间
    			map.put("createTime", df.format(new Date()));
    			list.add(map);
            }
            EdatResult er = null;
            if(errNum==0 && list!=null && list.size()>0){
            	er = CompanyWaterSourceService.saveBatch(this.getUserId(request),list);
            	return Result.ok(er);
            }else if(list.size()==0 || list==null){
            	return EdatResult.error(2, "导入失败，错误原因:Excel内容为空！");
            }else{
            	return EdatResult.error(2, "导入失败，错误原因"+errInfo);
            }
            
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "批量导入企业信息失败");
		} finally {
			is.close();
		}
	}
	
	/**
	 * 	数据导出
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "deprecation" })
	@RequestMapping("/exportWaterSourceInfor")
	public void exportWaterSourceInfor(HttpServletRequest request,HttpServletResponse response)throws Exception{
//		HttpSession session = request.getSession();
//		SysUser seUser = (SysUser) session.getAttribute("user");
//		Map<String, Object> data = (Map) requestData.get("data");
		Map<String, Object> resultMap = new HashMap<>();
		//获取前端传递的参数
		//园区名称
		if (RegUtil.CheckParameter(request.getParameter("waterSourceName"), null, null, false)) {
			resultMap.put("waterSourceName",request.getParameter("waterSourceName"));
		}
		//县code
		if (RegUtil.CheckParameter(request.getParameter("countyCode"), null, null, false)) {
			resultMap.put("countyCode",request.getParameter("countyCode"));
		}
		
		try{

	            String[] title = {"区县","水源地名称","水源地编码","水源地类型"};

				List<Map<String, Object>> list = CompanyWaterSourceMapper.SelectWaterSourceList(resultMap);
	            String [][] content = new String[list.size()][];
	            if ( list.size() > 0 ) {
	                for( int i = 0 ; i < list.size(); i ++ ) {
	                    content[i] = new String[title.length];
	                    Map m = list.get(i);
	                    content[i][0] = (m.get("COUNTY_NAME")!=null?m.get("COUNTY_NAME").toString():"");
	                    content[i][1] = (m.get("WATER_SOURCE_NAME")!=null?m.get("WATER_SOURCE_NAME").toString():"");
	                    content[i][2] = (m.get("WATER_SOURCE_CODE")!=null?m.get("WATER_SOURCE_CODE").toString():"");
	                    content[i][3] = (m.get("WATER_SOURCE_TYPE")!=null?changeDates(m.get("WATER_SOURCE_TYPE").toString()):"");
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
	        } catch( Exception  e ) {
	            e.printStackTrace();
	        }
	}
	/**
	 * 
	 * @description TODO 读取表格表头的内容
	 * @method readExcelTitle
	 * @return String[]
	 * @auto SongQinjie
	 * @date 2018年11月28日 下午2:55:02
	 */
	@SuppressWarnings("deprecation")
	public String[] readExcelTitle(Sheet sheet) throws IOException {

		Row row = sheet.getRow(0);
		// 标题总列数
		int colNum = row.getPhysicalNumberOfCells();
		int count = 0;
		// 初始化 数组用 统计有几个有效列
		for (int i = 0; i < colNum; i++) {
			if (row.getCell(i).getCellType() == XSSFCell.CELL_TYPE_BLANK) {
			} else {
				count++;
			}
		}
		String[] title = new String[count];

		for (int i = 0; i < count; i++) {
			title[i] = getTitleValue(row.getCell(i));
		}
		return title;
	}

	// 获取表格表头
	public String getTitleValue(Cell cell) {
		String strCell = cell.getStringCellValue();
		return strCell;
	}
	private String changeData(String str) {
		if(str!=null && !"".equals(str)) {
			if(str.equals("河流型")) {
				str = "0";
			} else if(str.equals("湖库型")) {
				str = "1";
			} else if(str.equals("地下水型")) {
				str = "2";
			}
		}

		return str;
	}
	private String changeDates(String str) {
		if(str!=null && !"".equals(str)) {
			if(str.equals("0")) {
				str = "河流型";
			} else if(str.equals("1")) {
				str = "湖库型";
			} else if(str.equals("2")) {
				str = "地下水型";
			}
		}
		return str;
	}




	/**
	 * 获取登录的用户id
	 * @param request
	 * @return
	 */
	private BigDecimal getUserId(HttpServletRequest request){
		HttpSession session = request.getSession();
		SysUser user = (SysUser) session.getAttribute("sysUser");
		return user.getSuId();
	}
}
