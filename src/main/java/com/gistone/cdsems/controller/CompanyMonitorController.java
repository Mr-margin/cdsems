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
import com.gistone.cdsems.service.impl.ICompanyMonitorService;
import com.gistone.cdsems.service.impl.ICompanyService;
import com.gistone.cdsems.util.EdatResult;

/**
 * 企业自监测数据管理类
 * @Title CompanyMonitorController
 * @author NingYudong
 * @date 2018年11月19日
 */
@RestController
@RequestMapping("companyMonitor")
public class CompanyMonitorController {

	@Autowired
	ICompanyMonitorService companyMonitorService;
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
		if(map.get("COMPANY_ID")==null || map.get("COMPANY_ID").toString().equals("")){
			return EdatResult.error(1, "失败,未选择企业！");
		}
		if(map.get("MONITOR_TIME")==null || map.get("MONITOR_TIME").toString().equals("")){
			return EdatResult.error(1, "新增失败，未填写监测时间！");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			map.put("MONITOR_TIME", sdf.parse(map.get("MONITOR_TIME").toString()));
			//创建用户id
			map.put("CREATE_USER_ID", this.getUserId(request));
			EdatResult er = companyMonitorService.save(map);
			return er;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "失败", "新增企业自监测数据失败");
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        InputStream is = null;
        HttpSession session = request.getSession();
		String suLevel = session.getAttribute("suLevel")==null?"":session.getAttribute("suLevel").toString();
		String suRegioncode = session.getAttribute("suRegioncode")==null?"":session.getAttribute("suRegioncode").toString();
		String suCompanyname = session.getAttribute("suCompanyname")==null?"":session.getAttribute("suCompanyname").toString();
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
                	errInfo+="[第"+i+"行企业名称为空]";
                	errNum++;
                	continue;
                }else{
                	if(suLevel!=null && suLevel.equals("4") && !suCompanyname.equals(row.getCell(0).toString())){
                		errInfo+="[第"+i+"行企业名称不正确]";
                    	errNum++;
                    	continue;
                	}
                	Map company = companyService.getByName(row.getCell(0).toString());
                	if(company==null){
                		errInfo+="[第"+i+"行企业名称不存在]";
                    	errNum++;
                    	continue;
                	}else{
                		if(suLevel!=null && suLevel.equals("3") && !suRegioncode.equals(company.get("COUNTY_CODE").toString())){
                    		errInfo+="[第"+i+"行企业所属区县跟用户所属区县不一致]";
                        	errNum++;
                        	continue;
                    	}
                		map.put("COMPANY_ID", company.get("ID"));
                	}
                }
                //监测时间
                if(row.getCell(1)==null || "".equals(row.getCell(1).toString())){
                	errInfo+="[第"+i+"行监测时间为空]";
                	errNum++;
                	continue;
                }else{
                	if(!isValidDate(row.getCell(1).toString())){
                		errInfo+="[第"+i+"行监测时间格式错误]";
                    	errNum++;
                    	continue;
                	}
                	map.put("MONITOR_TIME", sdf.parse(row.getCell(1).toString()));
                }
                //PH值
                if(row.getCell(2)!=null && !row.getCell(2).toString().equals("")){
                	if(!this.isValidNumber(row.getCell(2).toString())){
                		errInfo+="[第"+i+"行PH值格式错误]";
                    	errNum++;
                    	continue;
                	}
                }
    			map.put("PH", row.getCell(2)==null?"":row.getCell(2).toString());
    			//镉值
    			if(row.getCell(3)!=null && !row.getCell(3).toString().equals("")){
                	if(!this.isValidNumber(row.getCell(3).toString())){
                		errInfo+="[第"+i+"行镉值格式错误]";
                    	errNum++;
                    	continue;
                	}
                }
    			map.put("CD", row.getCell(3)==null?"":row.getCell(3).toString());
    			//汞值
    			if(row.getCell(4)!=null && !row.getCell(4).toString().equals("")){
                	if(!this.isValidNumber(row.getCell(4).toString())){
                		errInfo+="[第"+i+"行汞值格式错误]";
                    	errNum++;
                    	continue;
                	}
                }
    			map.put("HG", row.getCell(4)==null?"":row.getCell(4).toString());
    			//铅值
    			if(row.getCell(5)!=null && !row.getCell(5).toString().equals("")){
                	if(!this.isValidNumber(row.getCell(5).toString())){
                		errInfo+="[第"+i+"行铅值格式错误]";
                    	errNum++;
                    	continue;
                	}
                }
    			map.put("PB", row.getCell(5)==null?"":row.getCell(5).toString());
    			//砷值
    			if(row.getCell(6)!=null && !row.getCell(6).toString().equals("")){
                	if(!this.isValidNumber(row.getCell(6).toString())){
                		errInfo+="[第"+i+"行砷值格式错误]";
                    	errNum++;
                    	continue;
                	}
                }
    			map.put("ARSENIC", row.getCell(6)==null?"":row.getCell(6).toString());
    			//铬值
    			if(row.getCell(7)!=null && !row.getCell(7).toString().equals("")){
                	if(!this.isValidNumber(row.getCell(7).toString())){
                		errInfo+="[第"+i+"行铬值格式错误]";
                    	errNum++;
                    	continue;
                	}
                }
    			map.put("CR", row.getCell(7)==null?"":row.getCell(7).toString());
    			//铜值
    			if(row.getCell(8)!=null && !row.getCell(8).toString().equals("")){
                	if(!this.isValidNumber(row.getCell(8).toString())){
                		errInfo+="[第"+i+"行铜值格式错误]";
                    	errNum++;
                    	continue;
                	}
                }
    			map.put("CU", row.getCell(8)==null?"":row.getCell(8).toString());
    			//锌值
    			if(row.getCell(9)!=null && !row.getCell(9).toString().equals("")){
                	if(!this.isValidNumber(row.getCell(9).toString())){
                		errInfo+="[第"+i+"行锌值格式错误]";
                    	errNum++;
                    	continue;
                	}
                }
    			map.put("ZN", row.getCell(9)==null?"":row.getCell(9).toString());
    			//镍值
    			if(row.getCell(10)!=null && !row.getCell(10).toString().equals("")){
                	if(!this.isValidNumber(row.getCell(10).toString())){
                		errInfo+="[第"+i+"行镍值格式错误]";
                    	errNum++;
                    	continue;
                	}
                }
    			map.put("NI", row.getCell(10)==null?"":row.getCell(10).toString());
    			//创建用户id
    			map.put("CREATE_USER_ID", userId);
    			
    			list.add(map);
            }
			
            if(errNum==0){
            	EdatResult er = companyMonitorService.saveBatch(list);
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
		if(map.get("MONITOR_TIME")==null || map.get("MONITOR_TIME").toString().equals("")){
			return EdatResult.error(1, "修改失败，未填写监测时间！");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			map.put("MONITOR_TIME", sdf.parse(map.get("MONITOR_TIME").toString()));
			//修改用户id
			map.put("UPDATE_USER_ID", this.getUserId(request));
			
			EdatResult er = companyMonitorService.update(map);
			return er;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "失败", "修改企业自监测数据失败");
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
			EdatResult er = companyMonitorService.delete(Long.parseLong(map.get("id").toString()));
			return er;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "删除失败");
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
			EdatResult er = companyMonitorService.deleteBatch(idsStr);
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
			EdatResult er = companyMonitorService.listPage(map);
			return er;
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
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Map map = new HashMap();
			map.put("company_name", request.getParameter("company_name"));
			map.put("organizing_code", request.getParameter("organizing_code"));
			map.put("legal_person", request.getParameter("legal_person"));
			map.put("address", request.getParameter("address"));
			map.put("start_time", request.getParameter("start_time"));
			map.put("end_time", request.getParameter("end_time"));
			HttpSession session = request.getSession();
			map.put("suLevel", session.getAttribute("suLevel")==null?"":session.getAttribute("suLevel"));
			map.put("suRegioncode", session.getAttribute("suRegioncode")==null?"":session.getAttribute("suRegioncode"));
			map.put("suCompanyname", session.getAttribute("suCompanyname")==null?"":session.getAttribute("suCompanyname"));
			List<Map> list = companyMonitorService.listAll(map);
			//创建工作簿  
	        HSSFWorkbook workBook = new HSSFWorkbook();  
	        //创建工作表
	        HSSFSheet sheet = workBook.createSheet("数据");
	        HSSFRow rowTitle = sheet.createRow(0);
	        //插入标题行
	        rowTitle.createCell(0).setCellValue("企业名称");
	        rowTitle.createCell(1).setCellValue("监测时间");
	        rowTitle.createCell(2).setCellValue("PH值");
	        rowTitle.createCell(3).setCellValue("镉值");
	        rowTitle.createCell(4).setCellValue("汞值");
	        rowTitle.createCell(5).setCellValue("铅值");
	        rowTitle.createCell(6).setCellValue("砷值");
	        rowTitle.createCell(7).setCellValue("铬值");
	        rowTitle.createCell(8).setCellValue("铜值");
	        rowTitle.createCell(9).setCellValue("锌值");
	        rowTitle.createCell(10).setCellValue("镍值");
	        //遍历插入数据行
	        int len=list.size();
	        for(int i=0;i<len;i++){
	        	HSSFRow row = sheet.createRow(i+1);
	        	Map m = list.get(i);
	        	row.createCell(0).setCellValue(m.get("COMPANY_NAME")==null?"":m.get("COMPANY_NAME").toString());
		        row.createCell(1).setCellValue(m.get("MONITOR_TIME")==null?"":m.get("MONITOR_TIME").toString());
		        row.createCell(2).setCellValue(m.get("PH")==null?"":m.get("PH").toString());
		        row.createCell(3).setCellValue(m.get("CD")==null?"":m.get("CD").toString());
		        row.createCell(4).setCellValue(m.get("HG")==null?"":m.get("HG").toString());
		        row.createCell(5).setCellValue(m.get("PB")==null?"":m.get("PB").toString());
		        row.createCell(6).setCellValue(m.get("ARSENIC")==null?"":m.get("ARSENIC").toString());
		        row.createCell(7).setCellValue(m.get("CR")==null?"":m.get("CR").toString());
		        row.createCell(8).setCellValue(m.get("CU")==null?"":m.get("CU").toString());
		        row.createCell(9).setCellValue(m.get("ZN")==null?"":m.get("ZN").toString());
		        row.createCell(10).setCellValue(m.get("NI")==null?"":m.get("NI").toString());
	        }
	        //导出文件名
	        String name = "企业自行监测数据.xls";
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
			return EdatResult.error(2);
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
	 * 验证字符串是否为时间格式
	 * @param str
	 * @return
	 */
	public boolean isValidDate(String str) {
		boolean convertSuccess=true;
		if (str == null || str.length() == 0 || str.equals("")) {
	        return false;
	    }
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
		    format.setLenient(false);
		    format.parse(str);
		} catch (ParseException e) {
		    // e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
		    convertSuccess=false;
		} 
		return convertSuccess;
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
