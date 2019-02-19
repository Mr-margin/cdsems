package com.gistone.cdsems.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.service.impl.ISoilRemediationService;
import com.gistone.cdsems.util.EdatResult;

/**
 * 土壤治理与修复项目基本信息
 * @Title SoilRemediationController
 * @author NingYudong
 * @date 2018年11月23日
 */
@RestController
@RequestMapping("soilRemediation")
public class SoilRemediationController {

	@Autowired
	ISoilRemediationService soilRemediationService;
	
	/**
	 * 上传附件
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="uploadAccessory",method=RequestMethod.POST)
	public Object uploadAccessory(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		try {
			String path="";
			//项目中的存储目录
			String dir = "/files/soilRemediation";
			//获取上传总目录
			String dirPath = request.getSession().getServletContext().getRealPath(dir);
			MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
			Map<String,MultipartFile> map = req.getFileMap();
			//迭代文件
			Iterator<MultipartFile> it = map.values().iterator();
			while(it.hasNext()) {
				MultipartFile file = it.next();
				String fileName = file.getOriginalFilename();//获取文件名
				InputStream is = file.getInputStream();
				File newfile = new File(dirPath, fileName);
				//判断文件是否存在，并创建
				if (!newfile.exists()) {
		            if (!newfile.getParentFile().exists()) {
		            	newfile.getParentFile().mkdirs();
		            }
		            newfile.createNewFile();
		        }
				//流复制文件到新文件
		        FileUtils.copyInputStreamToFile(is, newfile);
		        is.close();
		        if(path.equals("")){
		        	path+=dirPath+"/"+fileName;
		        }else{
		        	path+=","+dirPath+"/"+fileName;
		        }
			}
			return EdatResult.ok(path);
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "上传附件失败");
		} finally {
			
		}
	}
	
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
		if(map.get("NAME")==null || map.get("NAME").toString().equals("")){
			return EdatResult.error(1, "失败，项目名称为空！");
		}
		if(map.get("TYPE")==null || map.get("TYPE").toString().equals("")){
			return EdatResult.error(1, "失败，项目类型为空！");
		}
		if(map.get("ADDRESS")==null || map.get("ADDRESS").toString().equals("")){
			return EdatResult.error(1, "失败，项目地址为空！");
		}
		if(map.get("START_DATE")==null || map.get("START_DATE").toString().equals("")){
			return EdatResult.error(1, "失败，项目启动时间为空！");
		}
		if(map.get("END_DATE")==null || map.get("END_DATE").toString().equals("")){
			return EdatResult.error(1, "失败，项目截止时间为空！");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			map.put("START_DATE", sdf.parse(map.get("START_DATE").toString()));
			map.put("END_DATE", sdf.parse(map.get("END_DATE").toString()));
			//创建用户id
			map.put("CREATE_USER_ID", this.getUserId(request));
			EdatResult er = soilRemediationService.save(map);
			return er;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "新增失败");
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
              //项目名称
                if(row.getCell(0)==null || "".equals(row.getCell(0).toString())){
                	errInfo+="[第"+i+"行项目名称为空]";
                	errNum++;
                	continue;
                }else{
                	map.put("NAME", row.getCell(0).toString());
                }
                //项目类型
                if(row.getCell(1)!=null||!"".equals(row.getCell(1).toString())){
                	map.put("TYPE", row.getCell(1).toString());
                }else{
                	errInfo+="[第"+i+"行项目类型必填]";
                	errNum++;
                	continue;
                }
                //区县编码
    			if(row.getCell(2)==null || "".equals(row.getCell(2).toString())){
                	errInfo+="[第"+i+"行区县编码为空]";
                	errNum++;
                	continue;
                }else{
                	String[] arr=row.getCell(2).toString().split("\\.");
                	if(suLevel!=null && suLevel.equals("3") && !suRegioncode.equals(arr[0])){
                		errInfo+="[第"+i+"行区县编码跟用户所属区县编码不一致]";
                    	errNum++;
                    	continue;
                	}
                	map.put("COUNTY", arr[0]);
                }
    			//项目地址
    			if(row.getCell(3)==null || "".equals(row.getCell(3).toString())){
                	errInfo+="[第"+i+"行项目地址为空]";
                	errNum++;
                	continue;
                }else{
                	map.put("ADDRESS", row.getCell(3).toString());
                }
    			//启动时间
    			if(row.getCell(4)==null || "".equals(row.getCell(4).toString())){
                	errInfo+="[第"+i+"行启动时间为空]";
                	errNum++;
                	continue;
                }else{
                	map.put("START_DATE", sdf.parse(row.getCell(4).toString()));
                }
    			//截止时间
    			if(row.getCell(5)==null || "".equals(row.getCell(5).toString())){
                	errInfo+="[第"+i+"行截止时间为空]";
                	errNum++;
                	continue;
                }else{
                	map.put("END_DATE", sdf.parse(row.getCell(5).toString()));
                }
    			//总体资金
    			map.put("FUND", row.getCell(6)==null?"":row.getCell(6).toString());
    			//资金来源
    			map.put("FUND_SOURCE", row.getCell(7)==null?"":row.getCell(7).toString());
    			//资金使用情况
    			map.put("FUND_USE", row.getCell(8)==null?"":row.getCell(8).toString());
    			//当前实施进度
    			map.put("PROGRESS", row.getCell(9)==null?"":row.getCell(9).toString());
    			//实施单位名称
    			map.put("IMPLEMENT", row.getCell(10)==null?"":row.getCell(10).toString());
    			//实施单位联系人
    			map.put("CONTACTS", row.getCell(11)==null?"":row.getCell(11).toString());
    			//联系人电话
    			map.put("PHONE", row.getCell(12)==null?"":row.getCell(12).toString());
    			//项目主要内容
    			map.put("CONTENT", row.getCell(13)==null?"":row.getCell(13).toString());
    			//技术简介
    			map.put("TECHNOLOGY", row.getCell(14)==null?"":row.getCell(14).toString());
    			//创建用户id
    			map.put("CREATE_USER_ID", userId);
    			
    			list.add(map);
            }
			
            if(errNum==0){
            	EdatResult er = soilRemediationService.saveBatch(list);
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
		if(map.get("NAME")==null || map.get("NAME").toString().equals("")){
			return EdatResult.error(1, "失败，项目名称不能为空！");
		}
		if(map.get("TYPE")==null || map.get("TYPE").toString().equals("")){
			return EdatResult.error(1, "失败，项目类型为空！");
		}
		if(map.get("ADDRESS")==null || map.get("ADDRESS").toString().equals("")){
			return EdatResult.error(1, "失败，项目地址为空！");
		}
		if(map.get("START_DATE")==null || map.get("START_DATE").toString().equals("")){
			return EdatResult.error(1, "失败，项目启动时间为空！");
		}
		if(map.get("END_DATE")==null || map.get("END_DATE").toString().equals("")){
			return EdatResult.error(1, "失败，项目截止时间为空！");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			map.put("START_DATE", sdf.parse(map.get("START_DATE").toString()));
			map.put("END_DATE", sdf.parse(map.get("END_DATE").toString()));
			//修改用户id
			map.put("UPDATE_USER_ID", this.getUserId(request));
			
			EdatResult er = soilRemediationService.update(map);
			return er;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "修改失败");
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
			return EdatResult.error(1, "失败", "没有选择要删除的数据！");
		}
		try {
			EdatResult er = soilRemediationService.delete(Long.parseLong(map.get("id").toString()));
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
			EdatResult er = soilRemediationService.deleteBatch(idsStr);
			return er;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "批量删除失败");
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
			EdatResult er = soilRemediationService.listPage(map);
			return er;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "查询失败！");
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
			map.put("name", request.getParameter("name"));
			map.put("implement", request.getParameter("implement"));
			map.put("county", request.getParameter("county"));
			HttpSession session = request.getSession();
			map.put("suLevel", session.getAttribute("suLevel")==null?"":session.getAttribute("suLevel"));
			map.put("suRegioncode", session.getAttribute("suRegioncode")==null?"":session.getAttribute("suRegioncode"));
			List<Map> list = soilRemediationService.listAll(map);
			//创建工作簿  
	        HSSFWorkbook workBook = new HSSFWorkbook();  
	        //创建工作表
	        HSSFSheet sheet = workBook.createSheet("数据");
	        HSSFRow rowTitle = sheet.createRow(0);
	        //插入标题行
	        rowTitle.createCell(0).setCellValue("项目名称");
	        rowTitle.createCell(1).setCellValue("项目类型");
	        rowTitle.createCell(2).setCellValue("区县编码");
	        rowTitle.createCell(3).setCellValue("项目地址");
	        rowTitle.createCell(4).setCellValue("启动时间");
	        rowTitle.createCell(5).setCellValue("截止时间");
	        rowTitle.createCell(6).setCellValue("总体资金");
	        rowTitle.createCell(7).setCellValue("资金来源");
	        rowTitle.createCell(8).setCellValue("资金使用情况");
	        rowTitle.createCell(9).setCellValue("当前实施进度");
	        rowTitle.createCell(10).setCellValue("实施单位名称");
	        rowTitle.createCell(11).setCellValue("实施单位联系人");
	        rowTitle.createCell(12).setCellValue("联系人电话");
	        rowTitle.createCell(13).setCellValue("项目主要内容");
	        rowTitle.createCell(14).setCellValue("技术简介");
	        //遍历插入数据行
	        int len=list.size();
	        for(int i=0;i<len;i++){
	        	HSSFRow row = sheet.createRow(i+1);
	        	Map m = list.get(i);
	        	row.createCell(0).setCellValue(m.get("NAME")==null?"":m.get("NAME").toString());
		        row.createCell(1).setCellValue(m.get("TYPE")==null?"":m.get("TYPE").toString());
		        row.createCell(2).setCellValue(m.get("COUNTY")==null?"":m.get("COUNTY").toString());
		        row.createCell(3).setCellValue(m.get("ADDRESS")==null?"":m.get("ADDRESS").toString());
		        row.createCell(4).setCellValue(m.get("START_DATE")==null?"":m.get("START_DATE").toString());
		        row.createCell(5).setCellValue(m.get("END_DATE")==null?"":m.get("END_DATE").toString());
		        row.createCell(6).setCellValue(m.get("FUND")==null?"":m.get("FUND").toString());
		        row.createCell(7).setCellValue(m.get("FUND_SOURCE")==null?"":m.get("FUND_SOURCE").toString());
		        row.createCell(8).setCellValue(m.get("FUND_USE")==null?"":m.get("FUND_USE").toString());
		        row.createCell(9).setCellValue(m.get("PROGRESS")==null?"":m.get("PROGRESS").toString());
		        row.createCell(10).setCellValue(m.get("IMPLEMENT")==null?"":m.get("IMPLEMENT").toString());
		        row.createCell(11).setCellValue(m.get("CONTACTS")==null?"":m.get("CONTACTS").toString());
		        row.createCell(12).setCellValue(m.get("PHONE")==null?"":m.get("PHONE").toString());
		        row.createCell(13).setCellValue(m.get("CONTENT")==null?"":m.get("CONTENT").toString());
		        row.createCell(14).setCellValue(m.get("TECHNOLOGY")==null?"":m.get("TECHNOLOGY").toString());
		    }
	        //导出文件名
	        String name = "土壤治理与修复项目基本信息数据.xls";
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
}
