package com.gistone.cdsems.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.service.impl.ICompanyService;
import com.gistone.cdsems.util.EdatResult;

/**
 * 企业信息管理类
 * @Title CompanyController
 * @author NingYudong
 * @date 2018年11月16日
 */
@RestController
@RequestMapping("company")
public class CompanyController {

	@Autowired
	ICompanyService companyService;
	
	/**
	 * 新增一条数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public Object insert(HttpServletRequest request,HttpServletResponse response,
			@RequestBody Map<String, Object> requestData) {
		Map map = (Map) requestData.get("data");
		if(map.get("COMPANY_NAME")==null || map.get("COMPANY_NAME").toString().equals("")){
			return EdatResult.error(1, "失败", "新增企业名称为空！");
		}
		try {
			Map company = companyService.getByName(map.get("COMPANY_NAME").toString());
			if(company!=null){
				return EdatResult.error(1, "新增企业信息失败，该企业名称已存在！");
			}
			//创建用户id
			map.put("CREATE_USER_ID", this.getUserId(request));
			EdatResult er = companyService.save(map);
			return er;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "新增企业信息失败");
		}
	}
	
	/**
	 * 批量导入数据
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="importExcel",method=RequestMethod.POST)
	public Object importExcel(HttpServletRequest request,HttpServletResponse response, @RequestParam("file") MultipartFile file) throws IOException {
		String upName = file.getOriginalFilename();//获取上传的文件名
        String suffix = upName.substring(upName.lastIndexOf(".") + 1);//获取后缀名
        if (!suffix.equals("xls") && !suffix.equals("xlsx")) {
            return EdatResult.error(2, "上传文件格式错误！");
        }
        HttpSession session = request.getSession();
		String suLevel = session.getAttribute("suLevel")==null?"":session.getAttribute("suLevel").toString();
		String suRegioncode = session.getAttribute("suRegioncode")==null?"":session.getAttribute("suRegioncode").toString();
		String suCompanyname = session.getAttribute("suCompanyname")==null?"":session.getAttribute("suCompanyname").toString();
        InputStream is = null;
		try {
			//文件转输入流
			is = file.getInputStream();
			//解析文件生成Workbook
            Workbook wb = WorkbookFactory.create(is);
            //Excel工作表
            Sheet sheet1 = wb.getSheetAt(0);
            //获取行数
            int rowNum = sheet1.getLastRowNum() + 1;
            
            //定义保存读取的文件数据的list
            List<Map> list = new ArrayList<Map>();
            //定义错误行数和错误信息
            int errNum=0;String errInfo="";
            BigDecimal userId = this.getUserId(request);
            //循环文件内容插入到数据库
            for (int i = 1; i < rowNum; i++) {
            	//存放行的数据
            	Map map = new HashMap();
            	//获取本行内容
                Row row = sheet1.getRow(i);
                //企业名称
                if(row.getCell(0)==null || "".equals(row.getCell(0).toString())){
                	errInfo+="[第"+i+"行企业名称不能为空]";
                	errNum++;
                	continue;
                }else{
                	if(suLevel!=null && suLevel.equals("4") && !suCompanyname.equals(row.getCell(0).toString())){
                		errInfo+="[第"+i+"行企业名称不正确]";
                    	errNum++;
                    	continue;
                	}
                	Map company = companyService.getByName(row.getCell(0).toString());
        			if(company!=null){
        				errInfo+="[第"+i+"行企业名称已存在]";
                    	errNum++;
                    	continue;
        			}
                	map.put("COMPANY_NAME", row.getCell(0).toString());
                }
                //法定代表人
                if(row.getCell(1)!=null||!"".equals(row.getCell(1).toString())){
                	map.put("LEGAL_PERSON", row.getCell(1).toString());
                }else{
                	errInfo+="[第"+i+"行法定代表人必填]";
                	errNum++;
                	continue;
                }
    			//组织机构代码
                if(row.getCell(2)!=null||!"".equals(row.getCell(2).toString())){
                	map.put("ORGANIZING_CODE", row.getCell(2).toString());
                }else{
                	errInfo+="[第"+i+"行组织机构代码必填]";
                	errNum++;
                	continue;
                }
    			//省级编码
    			//map.put("PROVINCE_CODE", row.getCell(3)==null?"":row.getCell(3).toString());
    			//城市编码
                if(row.getCell(3)!=null && !"".equals(row.getCell(3).toString())){
                	String[] arr=row.getCell(3).toString().split("\\.");
                	map.put("CITY_CODE", arr[0]);
                }else{
                	map.put("CITY_CODE", "");
                }
    			//区县编码
                if(row.getCell(4)!=null && !"".equals(row.getCell(4).toString())){
                	String[] arr=row.getCell(4).toString().split("\\.");
                	if(suLevel!=null && suLevel.equals("3") && !suRegioncode.equals(arr[0])){
                		errInfo+="[第"+i+"行区县编码跟用户所属区县编码不一致]";
                    	errNum++;
                    	continue;
                	}
                	map.put("COUNTY_CODE", arr[0]);
                }else{
                	map.put("COUNTY_CODE", "");
                }
    			//map.put("COUNTY_CODE", row.getCell(4)==null?"":row.getCell(4).toString());
    			//地址
                if(row.getCell(5)!=null||!"".equals(row.getCell(5).toString())){
                	map.put("ADDRESS", row.getCell(5).toString());
                }else{
                	errInfo+="[第"+i+"行地址必填]";
                	errNum++;
                	continue;
                }
    			//经度
    			if(row.getCell(6)!=null && !row.getCell(6).toString().equals("")){
                	if(!this.isValidNumber(row.getCell(6).toString())){
                		errInfo+="[第"+i+"行经度值格式错误]";
                    	errNum++;
                    	continue;
                	}
                }
    			map.put("LONGITUDE", row.getCell(6)==null?"":row.getCell(6).toString());
    			//纬度
    			if(row.getCell(7)!=null && !row.getCell(7).toString().equals("")){
                	if(!this.isValidNumber(row.getCell(7).toString())){
                		errInfo+="[第"+i+"行纬度值格式错误]";
                    	errNum++;
                    	continue;
                	}
                }
    			map.put("LATITUDE", row.getCell(7)==null?"":row.getCell(7).toString());
    			//企业规模
    			map.put("SCALE", row.getCell(8)==null?"":row.getCell(8).toString());
    			//营业期限
    			if(row.getCell(9)!=null||!"".equals(row.getCell(9).toString())){
                	map.put("BUSNISS_TERM", row.getCell(9).toString());
                }else{
                	errInfo+="[第"+i+"行营业期限必填]";
                	errNum++;
                	continue;
                }
    			//map.put("BUSNISS_TERM", row.getCell(9)==null?"":row.getCell(9).toString());
    			//行业类型
    			map.put("INDUSTRY_TYPE", row.getCell(10)==null?"":row.getCell(10).toString());
    			//行业代码
    			map.put("INDUSTRY_CODE", row.getCell(11)==null?"":row.getCell(11).toString());
    			//地块面积
    			if(row.getCell(12)!=null && !row.getCell(12).toString().equals("")){
                	if(!this.isValidNumber(row.getCell(12).toString())){
                		errInfo+="[第"+i+"行地块面积格式错误]";
                    	errNum++;
                    	continue;
                	}
                }
    			map.put("AREA", row.getCell(12)==null?"":row.getCell(12).toString());
    			//现使用权属
    			map.put("OWNERSHIP", row.getCell(13)==null?"":row.getCell(13).toString());
    			//地块利用历史
    			map.put("USING_HISTORY", row.getCell(14)==null?"":row.getCell(14).toString());
    			//地块规划用途
    			map.put("LAND_USAGE", row.getCell(15)==null?"":row.getCell(15).toString());
    			//状态
    			map.put("STATUS", row.getCell(16)==null?"":row.getCell(16).toString());
    			//所属化工园区/聚集区
    			map.put("INDUSTRY_ZONE", row.getCell(17)==null?"":row.getCell(17).toString());
    			//数据来源
    			map.put("DATA_SOURCES", row.getCell(18)==null?"":row.getCell(18).toString());
    			//所属级别（国控、省控、市控）
    			map.put("RANK", row.getCell(19)==null?"":row.getCell(19).toString());
    			//污染地块风险等级
    			map.put("RISK_GRADE", row.getCell(20)==null?"":row.getCell(20).toString());
    			//创建用户id
    			map.put("CREATE_USER_ID", userId);
    			
    			list.add(map);
            }
			
            if(errNum==0){
            	System.out.println("-------------"+list);
            	EdatResult er = companyService.saveBatch(list);
            	return er;
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
	 * 修改一条数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public Object update(HttpServletRequest request,HttpServletResponse response,
			@RequestBody Map<String, Object> requestData) {
		Map map = (Map) requestData.get("data");
		try {
			
			//修改用户id
			map.put("UPDATE_USER_ID", this.getUserId(request));
			
			EdatResult er = companyService.update(map);
			return er;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "修改企业信息失败");
		}
	}
	
	/**
	 * 删除数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public Object delete(HttpServletRequest request,HttpServletResponse response,
			@RequestBody Map<String, Object> requestData) {
		Map map = (Map) requestData.get("data");
		if(map.get("id")==null || map.get("id").toString().equals("")){
			return EdatResult.error(1, "失败", "没有选择要删除的企业！");
		}
		try {
			EdatResult er = companyService.delete(Long.parseLong(map.get("id").toString()));
			return er;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "删除企业信息失败");
		}
	}
	
	/**
	 * 批量删除数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="deleteBatch",method=RequestMethod.POST)
	public Object deleteBatch(HttpServletRequest request,HttpServletResponse response,
			@RequestBody Map<String, Object> requestData) {
		Map map = (Map) requestData.get("data");
		try {
			String idsStr = map.get("ids")==null?"":map.get("ids").toString();
			EdatResult er = companyService.deleteBatch(idsStr);
			return er;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "批量删除企业信息失败");
		}
	}
	
	/**
	 * 分页查询数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="listPage",method=RequestMethod.POST)
	public Object listPage(HttpServletRequest request,HttpServletResponse response,
			@RequestBody Map<String, Object> requestData) {
		
		Map map = (Map) requestData.get("data");
		int pageNum = Integer.parseInt(map.get("pageNumber").toString());
		int pageSize = Integer.parseInt(map.get("pageSize").toString());
		int page =  pageNum%pageSize>0?(pageNum/pageSize+1):pageNum/pageSize;
		try {
			map.put("startrow", pageNum);
			map.put("endrow", pageNum+pageSize);
			map.put("page", page);
			HttpSession session = request.getSession();
			map.put("suLevel", session.getAttribute("suLevel")==null?"":session.getAttribute("suLevel"));
			map.put("suRegioncode", session.getAttribute("suRegioncode")==null?"":session.getAttribute("suRegioncode"));
			map.put("suCompanyname", session.getAttribute("suCompanyname")==null?"":session.getAttribute("suCompanyname"));
			EdatResult er = companyService.listPage(map);
			return er;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "查询失败！");
		}
	}
	
	/**
	 * 查询全部企业信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="listAllCompany",method=RequestMethod.POST)
	public Object listAllCompany(HttpServletRequest request,HttpServletResponse response) {
		try {
			Map map = new HashMap();
			HttpSession session = request.getSession();
			map.put("suLevel", session.getAttribute("suLevel")==null?"":session.getAttribute("suLevel"));
			map.put("suRegioncode", session.getAttribute("suRegioncode")==null?"":session.getAttribute("suRegioncode"));
			map.put("suCompanyname", session.getAttribute("suCompanyname")==null?"":session.getAttribute("suCompanyname"));
			List<Map> list = companyService.listAll(map);
			return EdatResult.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "查询失败");
		}
	}
	
	/**
	 * 查询全部行业信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="listAllIndustry",method=RequestMethod.POST)
	public Object listAllIndustry(HttpServletRequest request,HttpServletResponse response) {
		try {
			List<Map> list = companyService.listAllIndustry();
			return EdatResult.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "查询失败");
		}
	}
	
	/**
	 * 导出数据到excel
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="exportExcel",method=RequestMethod.GET)
	public Object exportExcel(HttpServletRequest request,HttpServletResponse response) {
		try {
			Map map = new HashMap();
			map.put("company_name", request.getParameter("company_name"));
			map.put("organizing_code", request.getParameter("organizing_code"));
			map.put("legal_person", request.getParameter("legal_person"));
			map.put("address", request.getParameter("address"));
			HttpSession session = request.getSession();
			map.put("suLevel", session.getAttribute("suLevel")==null?"":session.getAttribute("suLevel"));
			map.put("suRegioncode", session.getAttribute("suRegioncode")==null?"":session.getAttribute("suRegioncode"));
			map.put("suCompanyname", session.getAttribute("suCompanyname")==null?"":session.getAttribute("suCompanyname"));
			List<Map> list = companyService.listAllExport(map);
			//创建工作簿  
	        HSSFWorkbook workBook = new HSSFWorkbook();  
	        //创建工作表
	        HSSFSheet sheet = workBook.createSheet("数据");
	        HSSFRow rowTitle = sheet.createRow(0);
	        //插入标题行
	        rowTitle.createCell(0).setCellValue("企业名称");
	        rowTitle.createCell(1).setCellValue("法定代表人");
	        rowTitle.createCell(2).setCellValue("组织机构代码");
	        rowTitle.createCell(3).setCellValue("市编码");
	        rowTitle.createCell(4).setCellValue("县编码");
	        rowTitle.createCell(5).setCellValue("地址");
	        rowTitle.createCell(6).setCellValue("经度");
	        rowTitle.createCell(7).setCellValue("纬度");
	        rowTitle.createCell(8).setCellValue("企业规模");
	        rowTitle.createCell(9).setCellValue("营业期限");
	        rowTitle.createCell(10).setCellValue("行业类别");
	        rowTitle.createCell(11).setCellValue("行业代码");
	        rowTitle.createCell(12).setCellValue("地块面积");
	        rowTitle.createCell(13).setCellValue("现使用权属");
	        rowTitle.createCell(14).setCellValue("地块利用历史");
	        rowTitle.createCell(15).setCellValue("地块规划用途");
	        rowTitle.createCell(16).setCellValue("状态");
	        rowTitle.createCell(17).setCellValue("所属化工园区/聚集区");
	        rowTitle.createCell(18).setCellValue("数据来源");
	        rowTitle.createCell(19).setCellValue("所属级别");
	        rowTitle.createCell(20).setCellValue("污染地块风险等级");
	        //遍历插入数据行
	        int len=list.size();
	        for(int i=0;i<len;i++){
	        	HSSFRow row = sheet.createRow(i+1);
	        	Map m = list.get(i);
	        	row.createCell(0).setCellValue(m.get("COMPANY_NAME")==null?"":m.get("COMPANY_NAME").toString());
		        row.createCell(1).setCellValue(m.get("LEGAL_PERSON")==null?"":m.get("LEGAL_PERSON").toString());
		        row.createCell(2).setCellValue(m.get("ORGANIZING_CODE")==null?"":m.get("ORGANIZING_CODE").toString());
		        //row.createCell(3).setCellValue(m.get("PROVINCE_CODE")==null?"":m.get("PROVINCE_CODE").toString());
		        row.createCell(3).setCellValue(m.get("CITY_CODE")==null?"":m.get("CITY_CODE").toString());
		        row.createCell(4).setCellValue(m.get("COUNTY_CODE")==null?"":m.get("COUNTY_CODE").toString());
		        row.createCell(5).setCellValue(m.get("ADDRESS")==null?"":m.get("ADDRESS").toString());
		        row.createCell(6).setCellValue(m.get("LONGITUDE")==null?"":m.get("LONGITUDE").toString());
		        row.createCell(7).setCellValue(m.get("LATITUDE")==null?"":m.get("LATITUDE").toString());
		        row.createCell(8).setCellValue(m.get("SCALE")==null?"":m.get("SCALE").toString());
		        row.createCell(9).setCellValue(m.get("BUSNISS_TERM")==null?"":m.get("BUSNISS_TERM").toString());
		        row.createCell(10).setCellValue(m.get("INDUSTRY_TYPE")==null?"":m.get("INDUSTRY_TYPE").toString());
		        row.createCell(11).setCellValue(m.get("INDUSTRY_CODE")==null?"":m.get("INDUSTRY_CODE").toString());
		        row.createCell(12).setCellValue(m.get("AREA")==null?"":m.get("AREA").toString());
		        row.createCell(13).setCellValue(m.get("OWNERSHIP")==null?"":m.get("OWNERSHIP").toString());
		        row.createCell(14).setCellValue(m.get("USING_HISTORY")==null?"":m.get("USING_HISTORY").toString());
		        row.createCell(15).setCellValue(m.get("LAND_USAGE")==null?"":m.get("LAND_USAGE").toString());
		        row.createCell(16).setCellValue(m.get("STATUS")==null?"":m.get("STATUS").toString());
		        row.createCell(17).setCellValue(m.get("INDUSTRY_ZONE")==null?"":m.get("INDUSTRY_ZONE").toString());
		        row.createCell(18).setCellValue(m.get("DATA_SOURCES")==null?"":m.get("DATA_SOURCES").toString());
		        row.createCell(19).setCellValue(m.get("RANK")==null?"":m.get("RANK").toString());
		        row.createCell(20).setCellValue(m.get("RISK_GRADE")==null?"":m.get("RISK_GRADE").toString());
	        }
	        //导出文件名
	        String name = "企业信息数据.xls";
	        //第一步：设置响应类型
			response.setContentType(request.getServletContext().getMimeType(name));//应用程序强制下载
		    //设置响应头，对文件进行url编码
		    try {
				name = URLEncoder.encode(name, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    response.setHeader("Content-Disposition", "attachment;filename="+name);   
		    
		    //第三步：老套路，开始copy
		    OutputStream out = response.getOutputStream();
		    
			workBook.write(out);
			workBook.close();//最后记得关闭工作簿 
			
			out.flush();
		    out.close();
			return EdatResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(2, "导出失败");
		}
	}
	
	/**
	 * 查询全部工业园区
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="listAllPark",method=RequestMethod.POST)
	public Object listAllPark(HttpServletRequest request,HttpServletResponse response) {
		try {
			List<Map> list = companyService.listAllPark();
			return EdatResult.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "查询失败");
		}
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
	
	/**
	 * 验证字符串是否为正确的数字格式
	 * @param str
	 * @return
	 */
	public boolean isValidNumber(String str) {
		if(str==null || str.equals("")){
			return false;
		}
		Pattern pattern = Pattern.compile("^(-?\\d+)(\\.\\d+)?$");
		Matcher matcher1 = pattern.matcher(str);
		boolean flag = matcher1.matches();
		return flag;
	}
}
