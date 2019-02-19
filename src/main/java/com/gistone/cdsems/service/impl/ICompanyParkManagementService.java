package com.gistone.cdsems.service.impl;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.CompanyParkManagement;
import com.gistone.cdsems.database.mapper.CompanyParkManagementMapper;
import com.gistone.cdsems.database.mapper.CompanyParkPollutantsMapper;
import com.gistone.cdsems.service.CompanyParkManagementService;
import com.gistone.cdsems.util.EdatResult;
import com.gistone.cdsems.util.Result;

/**
 * 	工业园区基本信息查询service
 * @Title ICompanyParkManagementService
 * @author songqinjie
 * @date 2018年11月21日
 */
@Service
public class ICompanyParkManagementService implements CompanyParkManagementService{

	@Autowired
	CompanyParkManagementMapper CompanyParkManagementMapper;
	@Autowired
	CompanyParkPollutantsMapper CompanyParkPollutantsMapper;

	/**
	 * 	 工业园区基本信息
	 */
	@MyPermission(module="110")
	public EdatResult listPage(Map<String,Object> parmap) {
		try {
		    List<Map<String, Object>> list = CompanyParkManagementMapper.SelectParkManagementList(parmap);
            List<Map<String, Object>> countlist = CompanyParkManagementMapper.SelectParkManagementListCount(parmap);
            int total = 0;
            if(countlist!=null && countlist.size()>0 && countlist.get(0)!=null) {
            	total = Integer.parseInt(countlist.get(0).get("COUNT").toString());
            }
            int numb = 0;
            if(parmap.get("number")!=null && !"".equals(parmap.get("number").toString())) {
            	numb = Integer.parseInt(parmap.get("number").toString());
            }
            
            return EdatResult.build(list, numb, total);
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "查询失败！");
		}
	}
	/**
	 * 	 工业园区监测信息
	 */
	@MyPermission(module="117")
	public EdatResult SelectlistPage(Map<String,Object> parmap) {
		try {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			if(parmap.get("id")!=null && !"".equals(parmap.get("id").toString())) {
				
				list = CompanyParkManagementMapper.SelectParkPollutantsList(parmap);
				
				return EdatResult.build(list, 0,0);
			}else {
				return EdatResult.build(list, 0,0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "查询失败！");
		}
	}

	/**
	 * 
	 *  	新增工业园区基本信息
	 */
	@Override
	@MyPermission(module="111")
	public EdatResult save(BigDecimal userId,CompanyParkManagement parkManag,List<Map<String,Object>> lm) {
		
		List<Map<String, Object>> list = CompanyParkManagementMapper.SelectParkManagementInfor(parkManag);
		
		if(list.size()>0 && list.get(0)!=null) {
			return EdatResult.build(1,"工业园区名称重复!");
		}
		//插入
		int a  = CompanyParkManagementMapper.insertParkManagementInfor(parkManag);
		long id = parkManag.getId();
		for (int i = 0; i < lm.size(); i++) {
			lm.get(i).put("GROWTH", i);
		}
		if(lm!=null && lm.size()>0 && lm.get(0)!=null && id !=0) {
			for (Map<String, Object> map : lm) {
				map.put("PARK_ID", id);
			}
			a =CompanyParkPollutantsMapper.insertParkPollutantsInfor(lm);
		}
		
		if(a>0) {
			return EdatResult.ok(0,"用户（ID："+userId+"）新增工业园区基本信息成功!");
		}else {
			return EdatResult.ok(1,"用户（ID："+userId+"）新增工业园区基本信息失败!");
		}
	}

	@Override
	@MyPermission(module="115")
	public EdatResult saveBatch(BigDecimal userId, List<Map<String ,Object>> list) {
		try {
			int a = CompanyParkManagementMapper.saveBatch(list);
			
			if(a>0) {
				return EdatResult.ok(0,"用户（ID："+userId+"）新增工业园区基本信息成功！");
			}else {
				return EdatResult.ok(1,"用户（ID："+userId+"）新增工业园区基本信息失败！");
			}	
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.ok(1,"新增工业园区基本信息失败！");
		}
		
	}
	@MyPermission(module="112")
	public EdatResult update(BigDecimal userId, CompanyParkManagement parkManag, List<Map<String, Object>> lm) {
		List<Map<String, Object>> list = CompanyParkManagementMapper.SelectParkManagementInforByid(parkManag);
		if(list.size()>0 && list.get(0)!=null) {
			return EdatResult.ok(1,"工业园区名称重复，新增失败！");
		}
		int a = CompanyParkManagementMapper.updateParkManagementInfor(parkManag);
		
		if(lm!=null && lm.size()>0) {
			if(a>0 ) {
				List<String> idlist= new ArrayList<>();
				for (Map<String, Object> map : lm) {
					if(map.get("ID")!=null && !"".equals(map.get("ID").toString())) {
						idlist.add(map.get("ID").toString());
					}
				}
				if(idlist!=null && idlist.size()>0) {
					String id=idlist.toString().replace("[","").replace("]","");
					a =CompanyParkPollutantsMapper.delAllParkPollutantsInfor(id);
				}
				for (int i = 0; i < lm.size(); i++) {
					lm.get(i).put("GROWTH", i);
				}
				a = CompanyParkPollutantsMapper.insertParkPollutantsInfor(lm);
				
				return EdatResult.ok(0,"用户（ID："+userId+"）修改工业园区基本信息成功！");
			}else {
				return EdatResult.ok(1,"用户（ID："+userId+"）修改工业园区基本信息失败！");
			}
		}else if(a>0){
			return EdatResult.ok(0,"用户（ID："+userId+"）修改工业园区基本信息成功！");
		}else {
			return EdatResult.ok(1,"用户（ID："+userId+"）修改工业园区基本信息失败！");
			
		}
	}
	public EdatResult updatePollutants(BigDecimal userId, List<Map<String ,Object>> list) {
		int a = 0;
		List<String> idlist= new ArrayList<>();
		for (Map<String, Object> map : list) {
			if(map.get("ID")!=null && !"".equals(map.get("ID").toString())) {
				idlist.add(map.get("ID").toString());
			}
		}
		if(idlist!=null && idlist.size()>0) {
			String id=idlist.toString().replace("[","").replace("]","");
			a =CompanyParkPollutantsMapper.delAllParkPollutantsInfor(id);
		}

		for (int i = 0; i < list.size(); i++) {
			list.get(i).put("GROWTH", i);
		}
		a = CompanyParkPollutantsMapper.insertParkPollutantsInfor(list);
		
		if(a>0) {
			return EdatResult.ok(0,"用户（ID："+userId+"）修改成功！");
		}else {
			return EdatResult.ok(1,"用户（ID："+userId+"）修改失败！");
		}
	}
	@MyPermission(module="113")
	public EdatResult delete(BigDecimal bigDecimal,String id) {
		try {
			int temp = CompanyParkManagementMapper.delParkManagementInfor(id);
			if(temp>0) {
				int temps = CompanyParkPollutantsMapper.delParkPollutantsInfor(id);
				/*if(temps>0) {
				}else {
					return EdatResult.build(1, "用户（ID："+bigDecimal+"）删除工业园区基本信息数据失败！");
				}*/
				return EdatResult.ok(temps,"用户（ID："+bigDecimal+"）删除工业园区基本信息数据成功！");
			}else {
				return EdatResult.ok(1, "用户（ID："+bigDecimal+"）删除工业园区基本信息数据失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.ok(1, "用户（ID："+bigDecimal+"）删除工业园区基本信息数据失败！");
		}
	}
	public EdatResult deletePollutant(BigDecimal bigDecimal,String id) {
		try {
			int temps = CompanyParkPollutantsMapper.delAllParkPollutantsInfor(id);
			if(temps>0) {
				return EdatResult.ok(0,"用户（ID："+bigDecimal+"）删除工业园区监测数据成功！");
			}else {
				return EdatResult.ok(1, "用户（ID："+bigDecimal+"）删除工业园区监测信息数据失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.ok(1, "用户（ID："+bigDecimal+"）删除工业园区监测信息数据失败！");
		}
	}

	/**
	 * 	导出数据到excel
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@MyPermission(module="115")
	@RequestMapping(value="exportExcel",method=RequestMethod.POST)
	public Result exportInfor(Map<String, Object> resultMap, HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Map<String, Object>> list = CompanyParkManagementMapper.listAll(resultMap);
			//创建工作簿  
	        HSSFWorkbook workBook = new HSSFWorkbook();  
	        //创建工作表
	        HSSFSheet sheet = workBook.createSheet("数据");
	        HSSFRow rowTitle = sheet.createRow(0);
	        //插入标题行
	        rowTitle.getCell(0).setCellValue("市");
	        rowTitle.getCell(1).setCellValue("县");
	        rowTitle.getCell(2).setCellValue("工业园区名称");
	        rowTitle.getCell(3).setCellValue("规划面积");
	        rowTitle.getCell(4).setCellValue("联系人");
	        rowTitle.getCell(5).setCellValue("联系电话");
	      //遍历插入数据行
	        int len=list.size();
	        for(int i=0;i<len;i++){
	        	HSSFRow row = sheet.createRow(i+1);
	        	Map m = list.get(i);
	        	row.getCell(0).setCellValue(m.get("CITY_NAME").toString());
		        row.getCell(1).setCellValue(m.get("COUNTY_NAME").toString());
		        row.getCell(2).setCellValue(m.get("PARK_NAME").toString());
		        row.getCell(3).setCellValue(m.get("AREA").toString());
		        row.getCell(4).setCellValue(m.get("CONTACT_NAME").toString());
		        row.getCell(5).setCellValue(m.get("CONTACT_PHONE").toString());
	        }
	        //导出文件名
	        String name = "工业园区管理.xls";
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
			return Result.build(0, "导出成功");
		} catch (Exception e) {
			e.printStackTrace();
			return Result.build(1, "导出失败");
		}
	}
	public List<Map> selectByCounty(Map map) {
		return CompanyParkManagementMapper.selectByCounty(map);
	}
	public List<Map> selectByCity(Map map) {
		return CompanyParkManagementMapper.selectByCity(map);
	}
	public List<Map> selectAllCity(Map map) {
		return CompanyParkManagementMapper.selectAllCity(map);
	}
	
}
