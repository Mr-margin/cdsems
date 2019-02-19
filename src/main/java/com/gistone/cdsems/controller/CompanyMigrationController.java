package com.gistone.cdsems.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
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
import com.gistone.cdsems.service.impl.ICompanyMigrationService;
import com.gistone.cdsems.service.impl.ICompanyService;
import com.gistone.cdsems.util.EdatResult;

/**
 * 企业迁移信息管理类
 * @Title CompanyMigrationController
 * @author NingYudong
 * @date 2018年11月20日
 */
@RestController
@RequestMapping("companyMigration")
public class CompanyMigrationController {

	@Autowired
	ICompanyMigrationService companyMigrationService;
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
		
		try {
			//创建用户id
			map.put("CREATE_USER_ID", this.getUserId(request));
			EdatResult er = companyMigrationService.save(map);
			return er;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "新增企业迁移信息失败");
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
//            return EdatResult.error(2, "上传文件格式错误！");
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
                //土壤质地
                if(row.getCell(1)!=null||!"".equals(row.getCell(1).toString())){
                	map.put("SOIL_TEXTURE", row.getCell(1).toString());
                }else{
                	errInfo+="[第"+i+"行土壤质地必填]";
                	errNum++;
                	continue;
                }
    			//map.put("SOIL_TEXTURE", row.getCell(1)==null?"":row.getCell(1).toString());
    			//地面覆盖
    			if(row.getCell(2)!=null||!"".equals(row.getCell(2).toString())){
                	map.put("GROUND_COVERAGE", row.getCell(2).toString());
                }else{
                	errInfo+="[第"+i+"行地面覆盖必填]";
                	errNum++;
                	continue;
                }
    			//map.put("GROUND_COVERAGE", row.getCell(2)==null?"":row.getCell(2).toString());
    			//土壤分层
    			if(row.getCell(3)!=null||!"".equals(row.getCell(3).toString())){
                	map.put("SOIL_LAYER", row.getCell(3).toString());
                }else{
                	errInfo+="[第"+i+"行土壤分层必填]";
                	errNum++;
                	continue;
                }
    			//map.put("SOIL_LAYER", row.getCell(3)==null?"":row.getCell(3).toString());
    			//地下水深埋深度
    			if(row.getCell(4)!=null && !row.getCell(4).toString().equals("")){
                	if(!this.isValidNumber(row.getCell(4).toString())){
                		errInfo+="[第"+i+"行地下水深埋深度格式错误]";
                    	errNum++;
                    	continue;
                	}
                }
    			map.put("DEPTH", row.getCell(4)==null?"":row.getCell(4).toString());
    			//地下水渗透特性
    			map.put("PERMEABILITY", row.getCell(5)==null?"":row.getCell(5).toString());
    			//降雨量
    			if(row.getCell(6)!=null && !row.getCell(6).toString().equals("")){
                	if(!this.isValidNumber(row.getCell(6).toString())){
                		errInfo+="[第"+i+"行降雨量格式错误]";
                    	errNum++;
                    	continue;
                	}
                }
    			map.put("PRECIPITATION", row.getCell(6)==null?"":row.getCell(6).toString());
    			//地块所在区域是否属于碦斯特地貌
    			map.put("LANDFORM", row.getCell(7)==null?"":row.getCell(7).toString());
    			//创建用户id
    			map.put("CREATE_USER_ID", userId);
    			
    			list.add(map);
            }
			
            if(errNum==0){
            	EdatResult er = companyMigrationService.saveBatch(list);
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
			
			EdatResult er = companyMigrationService.update(map);
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
			EdatResult er = companyMigrationService.delete(Long.parseLong(map.get("id").toString()));
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
			EdatResult er = companyMigrationService.deleteBatch(idsStr);
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
			EdatResult er = companyMigrationService.listPage(map);
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
			Map map = new HashMap();
			map.put("company_name", request.getParameter("company_name"));
			map.put("organizing_code", request.getParameter("organizing_code"));
			map.put("legal_person", request.getParameter("legal_person"));
			map.put("address", request.getParameter("address"));
			map.put("permeability", request.getParameter("permeability"));
			HttpSession session = request.getSession();
			map.put("suLevel", session.getAttribute("suLevel")==null?"":session.getAttribute("suLevel"));
			map.put("suRegioncode", session.getAttribute("suRegioncode")==null?"":session.getAttribute("suRegioncode"));
			map.put("suCompanyname", session.getAttribute("suCompanyname")==null?"":session.getAttribute("suCompanyname"));
			List<Map> list = companyMigrationService.listAll(map);
			//创建工作簿  
	        HSSFWorkbook workBook = new HSSFWorkbook();  
	        //创建工作表
	        HSSFSheet sheet = workBook.createSheet("数据");
	        HSSFRow rowTitle = sheet.createRow(0);
	        //插入标题行
	        rowTitle.createCell(0).setCellValue("企业名称");
	        rowTitle.createCell(1).setCellValue("土壤质地");
	        rowTitle.createCell(2).setCellValue("地面覆盖");
	        rowTitle.createCell(3).setCellValue("土壤分层");
	        rowTitle.createCell(4).setCellValue("地下水深埋（m）");
	        rowTitle.createCell(5).setCellValue("地下水渗透特性");
	        rowTitle.createCell(6).setCellValue("降雨量");
	        rowTitle.createCell(7).setCellValue("是否属于碦斯特地貌");
	        //遍历插入数据行
	        int len=list.size();
	        for(int i=0;i<len;i++){
	        	HSSFRow row = sheet.createRow(i+1);
	        	Map m = list.get(i);
	        	row.createCell(0).setCellValue(m.get("COMPANY_NAME")==null?"":m.get("COMPANY_NAME").toString());
		        row.createCell(1).setCellValue(m.get("SOIL_TEXTURE")==null?"":m.get("SOIL_TEXTURE").toString());
		        row.createCell(2).setCellValue(m.get("GROUND_COVERAGE")==null?"":m.get("GROUND_COVERAGE").toString());
		        row.createCell(3).setCellValue(m.get("SOIL_LAYER")==null?"":m.get("SOIL_LAYER").toString());
		        row.createCell(4).setCellValue(m.get("DEPTH")==null?"":m.get("DEPTH").toString());
		        row.createCell(5).setCellValue(m.get("PERMEABILITY")==null?"":m.get("PERMEABILITY").toString());
		        row.createCell(6).setCellValue(m.get("PRECIPITATION")==null?"":m.get("PRECIPITATION").toString());
		        row.createCell(7).setCellValue(m.get("LANDFORM")==null?"":m.get("LANDFORM").toString());
	        }
	        //导出文件名
	        String name = "企业迁移信息数据.xls";
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
