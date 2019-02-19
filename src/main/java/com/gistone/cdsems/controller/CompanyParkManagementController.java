package com.gistone.cdsems.controller;

import com.gistone.cdsems.database.entity.CompanyParkManagement;
import com.gistone.cdsems.database.entity.CompanyParkPollutants;
import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.database.mapper.CompanyParkManagementMapper;
import com.gistone.cdsems.service.impl.ICompanyParkManagementService;
import com.gistone.cdsems.util.EdatResult;
import com.gistone.cdsems.util.LogUtil;
import com.gistone.cdsems.util.Result;
import com.gistone.cdsems.util.RegUtil;

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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("CompanyParkManagementController")
public class CompanyParkManagementController {

    @Autowired
    private ICompanyParkManagementService CompanyParkManagementService;
    @Autowired
    private CompanyParkManagementMapper CompanyParkManagementMapper;
    /**
     * @author songqinjie
     * @date 2018-11-21 15:20
     * @param
     * @return
     * @Description 工业园区基本信息查询列表
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("SelectParkManagementList")
    public Result SelectParkManagementList(@RequestBody Map<String,Object> requestDate,HttpServletResponse response , HttpServletRequest request ) {
        try {
            Map<String,Object> data = (Map)requestDate.get("data");
            
            Map<String,Object> parmap = new HashMap<String,Object>();
            int pageNumber =0;     		//页码
            int pageSize =0;			//每页数量
            String parkName = null;		//园区名称
            String countyCode = null;	//县code
            String cityCode = null;		//市code
            String id = null;		//市code
            if(data.get("pageNumber") !=null && !"".equals(data.get("pageNumber").toString())) {
            	pageNumber = Integer.parseInt(data.get("pageNumber").toString());
            	int number = pageNumber+1;
            	parmap.put("number", number);
            }
            /*else {
            	return Result.build(1006, "SelectParkManagementList 查询参数不能为空");
			}*/
            if(data.get("pageSize") !=null && !"".equals(data.get("pageSize").toString())) {
            	pageSize= Integer.parseInt(data.get("pageSize").toString());
            	int size = pageSize+pageNumber;
            	parmap.put("size", size);
            }/*else {
            	return Result.build(1006, "SelectParkManagementList 查询参数不能为空");
            }*/
            if(data.get("parkName") !=null && !"".equals(data.get("parkName").toString())) {
            	parkName= data.get("parkName").toString();
            	parmap.put("parkName", parkName);
            }
            if(data.get("cityCode") !=null && !"".equals(data.get("cityCode").toString())) {
            	cityCode= data.get("cityCode").toString();
            	parmap.put("cityCode", cityCode);
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
            
            EdatResult er =  CompanyParkManagementService.listPage(parmap);
            
            return Result.ok(er);
        } catch (Exception e) {
            LogUtil.getLogger().error("SelectParkManagementList 查询数据异常",e);
            return Result.build(1003, "SelectParkManagementList 查询数据异常");
        }
    }
    /**
     * @author songqinjie
     * @date 2018-11-21 15:20
     * @param
     * @return
     * @Description 工业园区监测信息查询列表
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping("SelectParkPollutantsList")
    public Result SelectParkPollutantsList(@RequestBody Map<String,Object> requestDate,HttpServletResponse response , HttpServletRequest request ) {
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
    		
    		EdatResult er =  CompanyParkManagementService.SelectlistPage(parmap);
    		
    		return Result.ok(er);
    	} catch (Exception e) {
    		LogUtil.getLogger().error("SelectParkPollutantsList 查询数据异常",e);
    		return Result.build(1003, "SelectParkPollutantsList 查询数据异常");
    	}
    }
    /**
     * @author songqinjie
     * @date 2018-11-21 16:20
     * @param
     * @return
     * @Description 删除工业园区基本信息
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping("DelParkManagementList")
    public Result DelParkManagementList(@RequestBody Map<String,Object> requestDate,HttpServletResponse response , HttpServletRequest request ) {
    	try {
    		Map<String,Object> data = (Map)requestDate.get("data");
    		Map<String,Object> parmap = new HashMap<String,Object>();
    		String id = null;     		//页码
    		if(data.get("id") !=null && !"".equals(data.get("id").toString())) {
    			id= data.get("id").toString();
    			parmap.put("id", id);
    		}else {
    			return Result.build(1006, "DelParkManagementList 查询参数不能为空");
    		}
    		
            EdatResult er =  CompanyParkManagementService.delete(this.getUserId(request), id); //

            return Result.ok(er);
    	} catch (Exception e) {
    		LogUtil.getLogger().error("DelParkManagementList 查询数据异常",e);
    		return Result.build(1003, "DelParkManagementList 查询数据异常");
    	}
    }
    /**
     * @author songqinjie
     * @date 2018-11-21 16:20
     * @param
     * @return
     * @Description 删除工业园区监测信息
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping("DelParkPollutantList")
    public Result DelParkPollutantList(@RequestBody Map<String,Object> requestDate,HttpServletResponse response , HttpServletRequest request ) {
    	try {
    		Map<String,Object> data = (Map)requestDate.get("data");
    		Map<String,Object> parmap = new HashMap<String,Object>();
    		String id = null;     		//页码
    		if(data.get("id") !=null && !"".equals(data.get("id").toString())) {
    			id= data.get("id").toString();
    			parmap.put("id", id);
    		}else {
    			return Result.build(1006, "DelParkPollutantList 查询参数不能为空");
    		}
    		
    		EdatResult er =  CompanyParkManagementService.deletePollutant(this.getUserId(request), id); //
    		
    		return Result.ok(er);
    	} catch (Exception e) {
    		LogUtil.getLogger().error("DelParkPollutantList 查询数据异常",e);
    		return Result.build(1003, "DelParkPollutantList 查询数据异常");
    	}
    }

    /**
	 * 	新增工业园区基本信息
	 * @param requestData
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/saveparkManagInfor")
	public Result saveparkManagInfor(@RequestBody Map<String, Object> requestData,HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		Map<String, Object> data = (Map) requestData.get("data");
		Result res = null;
		//获取前端传递的参数
		CompanyParkManagement parkManag = new CompanyParkManagement();
		try {
			//园区名称
			if (RegUtil.CheckParameter(data.get("parkName"), null, null, false)) {
				parkManag.setParkName(data.get("parkName").toString());
			}
			//市code
			if (RegUtil.CheckParameter(data.get("cityCode"), null, null, false)) {
				parkManag.setCityCode(data.get("cityCode").toString());
			}
			//县code
			if (RegUtil.CheckParameter(data.get("countyCode").toString(), null, null, false)) {
				parkManag.setCountyCode(data.get("countyCode").toString());
			}
			//面积
			if (RegUtil.CheckParameter(data.get("area"), null, null, false)) {
				parkManag.setArea(data.get("area").toString());
			}
			//地址
			if (RegUtil.CheckParameter(data.get("address"), null, null, false)) {
				parkManag.setAddress(data.get("address").toString());
			}
			//交通
			if (RegUtil.CheckParameter(data.get("traffic"), null, null, false)) {
				parkManag.setTraffic(data.get("traffic").toString());
			}
			//基础设施
			if (RegUtil.CheckParameter(data.get("infrastructure"), null, null, false)) {
				parkManag.setInfrastructure(data.get("infrastructure").toString());
			}
			//园区优势
			if (RegUtil.CheckParameter(data.get("advantage"), null, null, false)) {
				parkManag.setAdvantage(data.get("advantage").toString());
			}
			//联系人
			if (RegUtil.CheckParameter(data.get("contactName"), null, null, false)) {
				parkManag.setContactName(data.get("contactName").toString());
			}
			//联系人电话
			if (RegUtil.CheckParameter(data.get("contactPhone"), null, null, false)) {
				parkManag.setContactPhone(data.get("contactPhone").toString());
			}
			//子表
			List<Map<String,Object>> lm = null;
			if (RegUtil.CheckParameter(data.get("parkManag"), null, null, false)) {
				lm= (List<Map<String,Object>>) data.get("parkManag");
			}
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			for (Map<String, Object> map : lm) {
				map.put("CREATE_TIME", df.format(new Date()));
				map.put("CREATE_USER_ID", this.getUserId(request).toString());
			}
			//新增时间
			parkManag.setCreateTime(df.format(new Date()));
			//新增用户id
			parkManag.setCreateUserId(this.getUserId(request).toString());
		
		    EdatResult er = CompanyParkManagementService.save(this.getUserId(request),parkManag,lm);
		    return Result.ok(er);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res; 
	}
	/**
	 *  	修改工业园区基本信息
	 * @param requestData
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/updateparkManagInfor")
	public Result updateparkManagInfor(@RequestBody Map<String, Object> requestData,HttpServletRequest request,HttpServletResponse response)throws Exception{
		Map<String, Object> data = (Map) requestData.get("data");
		Result res = null;
		//获取前端传递的参数
		CompanyParkManagement parkManag = new CompanyParkManagement();
		try {
			//园区名称
			if (RegUtil.CheckParameter(data.get("parkName"), null, null, false)) {
				parkManag.setParkName(data.get("parkName").toString());
			}
			//id
			Long id = null;
			if (RegUtil.CheckParameter(data.get("id"), null, null, false)) {
				id = Long.parseLong(data.get("id").toString());
				parkManag.setId(Long.valueOf((data.get("id").toString())));
			}
			//面积
			if (RegUtil.CheckParameter(data.get("area"), null, null, false)) {
				parkManag.setArea(data.get("area").toString());
			}
			//地址
			if (RegUtil.CheckParameter(data.get("address"), null, null, false)) {
				parkManag.setAddress(data.get("address").toString());
			}
			//交通
			if (RegUtil.CheckParameter(data.get("traffic"), null, null, false)) {
				parkManag.setTraffic(data.get("traffic").toString());
			}
			//基础设施
			if (RegUtil.CheckParameter(data.get("infrastructure"), null, null, false)) {
				parkManag.setInfrastructure(data.get("infrastructure").toString());
			}
			//园区优势
			if (RegUtil.CheckParameter(data.get("advantage"), null, null, false)) {
				parkManag.setAdvantage(data.get("advantage").toString());
			}
			//联系人
			if (RegUtil.CheckParameter(data.get("contactName"), null, null, false)) {
				parkManag.setContactName(data.get("contactName").toString());
			}
			//联系人电话
			if (RegUtil.CheckParameter(data.get("contactPhone"), null, null, false)) {
				parkManag.setContactPhone(data.get("contactPhone").toString());
			}
			
			List<Map<String,Object>> lm = null;
			if (RegUtil.CheckParameter(data.get("parkManag"), null, null, false)) {
				lm= (List<Map<String,Object>>) data.get("parkManag");
			}
			for (Map<String, Object> map : lm) {
				String reg = "^[0-9]+(.[0-9]+)?$";
				if(map.get("HEXAVALENTCHROMIUM")!=null && !"".equals(map.get("HEXAVALENTCHROMIUM").toString())) {
					if(!map.get("HEXAVALENTCHROMIUM").toString().matches(reg)) {
						Result.build(1, "数据格式错误，请重新输入");
					}
				}
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
				if(map.get("BENZOPYRENE")!=null && !"".equals(map.get("BENZOPYRENE").toString())) {
					if(!map.get("BENZOPYRENE").toString().matches(reg)) {
						Result.build(1, "数据格式错误，请重新输入");
					}
				}
				if(map.get("OILTYPE")!=null && !"".equals(map.get("OILTYPE").toString())) {
					if(!map.get("OILTYPE").toString().matches(reg)) {
						Result.build(1, "数据格式错误，请重新输入");
					}
				}
				if(map.get("OTHERPOLLUTANTS")!=null && !"".equals(map.get("OTHERPOLLUTANTS").toString())) {
					if(!map.get("OTHERPOLLUTANTS").toString().matches(reg)) {
						Result.build(1, "数据格式错误，请重新输入");
					}
				}
			}
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			for (Map<String, Object> map : lm) {
				map.put("UPDATE_TIME", df.format(new Date()));
				map.put("UPDATE_USER_ID", this.getUserId(request).toString());
				map.put("PARK_ID", id);
			}
			
			//修改时间
			parkManag.setUpdateTime(df.format(new Date()));
			//修改用户id
			parkManag.setUpdateUserId(this.getUserId(request).toString());
			
			EdatResult er = CompanyParkManagementService.update(this.getUserId(request),parkManag,lm);
		    return Result.ok(er);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res; 
	}
	/**
	 *  	修改工业园区基本信息
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
		try {
			//id
			Long id = null;
			if (RegUtil.CheckParameter(data.get("id"), null, null, false)) {
				id = Long.parseLong(data.get("id").toString());
			}
			List<Map<String,Object>> lm = null;
			if (RegUtil.CheckParameter(data.get("parkManag"), null, null, false)) {
				lm= (List<Map<String,Object>>) data.get("parkManag");
			}
			for (Map<String, Object> map : lm) {
				String reg = "^[0-9]+(.[0-9]+)?$";
				if(map.get("HEXAVALENTCHROMIUM")!=null && !"".equals(map.get("HEXAVALENTCHROMIUM").toString())) {
					if(!map.get("HEXAVALENTCHROMIUM").toString().matches(reg)) {
						Result.build(1, "数据格式错误，请重新输入");
					}
				}
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
				if(map.get("BENZOPYRENE")!=null && !"".equals(map.get("BENZOPYRENE").toString())) {
					if(!map.get("BENZOPYRENE").toString().matches(reg)) {
						Result.build(1, "数据格式错误，请重新输入");
					}
				}
				if(map.get("OILTYPE")!=null && !"".equals(map.get("OILTYPE").toString())) {
					if(!map.get("OILTYPE").toString().matches(reg)) {
						Result.build(1, "数据格式错误，请重新输入");
					}
				}
				if(map.get("OTHERPOLLUTANTS")!=null && !"".equals(map.get("OTHERPOLLUTANTS").toString())) {
					if(!map.get("OTHERPOLLUTANTS").toString().matches(reg)) {
						Result.build(1, "数据格式错误，请重新输入");
					}
				}
			}
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			for (Map<String, Object> map : lm) {
				map.put("UPDATE_TIME", df.format(new Date()));
				map.put("UPDATE_USER_ID", this.getUserId(request).toString());
				map.put("PARK_ID", id);
			}
			
			EdatResult er = CompanyParkManagementService.updatePollutants(this.getUserId(request),lm);
		
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
	@RequestMapping(value="importExcel",method=RequestMethod.POST)
	public Object importExcel(HttpServletRequest request,HttpServletResponse response, 
			@RequestParam("file") MultipartFile file) throws IOException {
		InputStream is = null;
		try {
			String upName = file.getOriginalFilename();//获取上传的文件名
	        String suffix = upName.substring(upName.lastIndexOf(".") + 1);//获取后缀名
	        if (!suffix.equals("xls") && !suffix.equals("xlsx")) {
	            return EdatResult.error(2, "上传文件格式错误！");
	        }
	        
	        String[] title = {"区县编码","工业园区名称","规划面积（平方米）","位置",
            		"交通","基础设施","功能定位/园区优势","联系人","联系电话"};
	       
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
            String reg = "^[0-9]+(.[0-9]+)?$";
			
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
            	}
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
    			if(row.getCell(1)==null || "".equals(row.getCell(1).toString())){
    				errInfo+="[第"+i+"行工业园区名称为空]";
    				errNum++;
    				continue;
    			}else{
    				map.put("parkName", row.getCell(1));
    			}
    			//面积
    			if(row.getCell(2)!=null && !"".equals(row.getCell(2).toString())){
    				if(!row.getCell(2).toString().matches(reg)) {
    					errInfo+="[第"+i+"行 面积数据格式有误！]";
    					errNum++;
    					continue;
    				}else {
    					map.put("area", row.getCell(2));
					}
    			}
    			//地址
    			map.put("address", row.getCell(3)==null?"":row.getCell(3));
    			//交通
    			map.put("traffic", row.getCell(4)==null?"":row.getCell(4));
    			//基础设施
    			map.put("infrastructure", row.getCell(5)==null?"":row.getCell(5));
    			//优势
    			map.put("advantage", row.getCell(6)==null?"":row.getCell(6));
    			//联系人
    			map.put("contactName", row.getCell(7)==null?"":row.getCell(7));
    			//联系电话
    			if(row.getCell(8)!=null && !"".equals(row.getCell(8))){
	    			NumberFormat nf = NumberFormat.getInstance();
	    			String contactPhone = nf.format(row.getCell(8).getNumericCellValue());
	    			if (contactPhone.indexOf(",") >= 0) {
	    				contactPhone = contactPhone.replace(",", "");
	    			}
	    			boolean temp = false;
	    			if(contactPhone.length()==11) {
	    				temp = isMobile(contactPhone);
	    			}else {
	    				temp = isPhone(contactPhone);
					}
	    			if(temp) {
	    				map.put("contactPhone", contactPhone);
	    			}else {
	    				errInfo+="[第"+i+"行县联系电话格式错误]";
	    				errNum++;
	    				continue;
					}
	    			
    			}else {
    				map.put("contactPhone", "");
				}
    			
    			//创建用户id
    			map.put("createUserId", this.getUserId(request));
    			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    			//新增时间
    			map.put("createTime", df.format(new Date()));
    			list.add(map);
            }
            EdatResult er = null;
            if(errNum==0 && list!=null && list.size()>0){
            	er = CompanyParkManagementService.saveBatch(this.getUserId(request),list);
            	return Result.ok(er);
            }else {
            	return Result.ok(EdatResult.error(2, "导入失败，错误原因"+errInfo));
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
	@SuppressWarnings({ "deprecation", "rawtypes" })
	@RequestMapping("/exportLmMarkerInfor")
	public void exportLmMarkerInfor(HttpServletRequest request,HttpServletResponse response)throws Exception{
//		HttpSession session = request.getSession();
//		SysUser seUser = (SysUser) session.getAttribute("user");
//		Map<String, Object> data = (Map) requestData.get("data");
		Map<String, Object> resultMap = new HashMap<>();
		//获取前端传递的参数
		//园区名称
		if (RegUtil.CheckParameter(request.getParameter("parkName"), null, null, false)) {
			resultMap.put("parkName",request.getParameter("parkName"));
		}
		//县code
		if (RegUtil.CheckParameter(request.getParameter("countyCode"), null, null, false)) {
			resultMap.put("countyCode",request.getParameter("countyCode"));
		}
		 try{

	            String[] title = {"区县名称","工业园区名称","规划面积（平方米）","位置",
	            		"交通","基础设施","功能定位/园区优势","联系人","联系电话"};

				List<Map<String, Object>> list = CompanyParkManagementMapper.listAll(resultMap);
	            String [][] content = new String[list.size()][];
	            if ( list.size() > 0 ) {
	                for( int i = 0 ; i < list.size(); i ++ ) {
	                    content[i] = new String[title.length];
	                    Map m = list.get(i);
	                    content[i][0] = (m.get("COUNTY_NAME")!=null?m.get("COUNTY_NAME").toString():"");
	                    content[i][1] = (m.get("PARK_NAME")!=null?m.get("PARK_NAME").toString():"");
	                    content[i][2] = (m.get("AREA")!=null?m.get("AREA").toString():"");
	                    content[i][3] = (m.get("ADDRESS")!=null?m.get("ADDRESS").toString():"");
	                    content[i][4] = (m.get("TRAFFIC")!=null?m.get("TRAFFIC").toString():"");
	                    content[i][5] = (m.get("INFRASTRUCTURE")!=null?m.get("INFRASTRUCTURE").toString():"");
	                    content[i][6] = (m.get("ADVANTAGE")!=null?m.get("ADVANTAGE").toString():"");
	                    content[i][7] = (m.get("CONTACT_NAME")!=null?m.get("CONTACT_NAME").toString():"");
	                    content[i][8] = (m.get("CONTACT_PHONE")!=null?m.get("CONTACT_PHONE").toString():"");
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
     * 手机号验证
     *
     * @param str
     * @return 验证通过返回true
     */
    public static boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }
    /**
     * 电话号码验证
     *
     * @param str
     * @return 验证通过返回true
     */
    public static boolean isPhone(String str) {
        Pattern p1 = null, p2 = null;
        Matcher m  = null;
        boolean b  = false;
        p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");  // 验证带区号的
        p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的
        if (str.length() > 9) {
            m = p1.matcher(str);
            b = m.matches();
        } else {
            m = p2.matcher(str);
            b = m.matches();
        }
        return b;
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
