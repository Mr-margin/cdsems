package com.gistone.cdsems.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.CompanyWaterSource;
import com.gistone.cdsems.database.mapper.CompanyWaterSourceMapper;
import com.gistone.cdsems.service.CompanyWaterSourceService;
import com.gistone.cdsems.util.EdatResult;

/**
 * 	饮用水源地基本信息查询service
 * @Title ICompanyParkManagementService
 * @author songqinjie
 * @date 2018年11月21日
 */
@Service
public class ICompanyWaterSourceService implements CompanyWaterSourceService{

	@Autowired
	CompanyWaterSourceMapper CompanyWaterSourceMapper;

	/**
	 * 	 饮用水源地基本信息
	 */
	@MyPermission(module="118")
	public EdatResult listPage(Map<String,Object> parmap) {
		try {
		    List<Map<String, Object>> list = CompanyWaterSourceMapper.SelectWaterSourceList(parmap);
            List<Map<String, Object>> countlist = CompanyWaterSourceMapper.SelectWaterSourceListCount(parmap);
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
	 * 	 饮用水源地监测信息
	 */
	@MyPermission(module="125")
	public EdatResult SelectlistPage(Map<String,Object> parmap) {
		try {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			if(parmap.get("id")!=null && !"".equals(parmap.get("id").toString())) {
				
				list = CompanyWaterSourceMapper.SelectWaterMonitorList(parmap);
				
				return EdatResult.build(list, 0,0);
			}else {
				return EdatResult.build(list, 0,0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "查询失败！");
		}
	}

	@MyPermission(module="121")
	public EdatResult delete(BigDecimal bigDecimal,String id) {
		try {
			int temp = CompanyWaterSourceMapper.delWaterSourceInfor(id);
			if(temp>=0) {
				int temps = CompanyWaterSourceMapper.delWaterMonitorInforBySourceId(id);
				if(temps>=0) {
		            return EdatResult.ok(temps,"用户（ID："+bigDecimal+"）删除饮用水源地基本信息数据成功！");
				}else {
					return EdatResult.ok(1, "用户（ID："+bigDecimal+"）删除饮用水源地基本信息数据失败！");
				}
			}else {
				return EdatResult.ok(1, "用户（ID："+bigDecimal+"）删除饮用水源地基本信息数据失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.ok(1, "用户（ID："+bigDecimal+"）删除饮用水源地基本信息数据失败！");
		}
	}
	
	public EdatResult deleteWaterMonitor(BigDecimal bigDecimal,String id) {
		try {
			int temps = CompanyWaterSourceMapper.delWaterMonitorInfor(id);
			if(temps>0) {
				return EdatResult.ok(0,"用户（ID："+bigDecimal+"）删除饮用水源地监测数据成功！");
			}else {
				return EdatResult.ok(1, "用户（ID："+bigDecimal+"）删除饮用水源地监测信息数据失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.ok(1, "用户（ID："+bigDecimal+"）删除饮用水源地监测信息数据失败！");
		}
	}
	
	/**
	 * 
	 *  	新增水源地基本信息
	 */
	@MyPermission(module="119")
	public EdatResult save(BigDecimal userId,CompanyWaterSource waterSource,List<Map<String,Object>> lm) {
		
		List<Map<String, Object>> list = CompanyWaterSourceMapper.SelectWaterSourceInfor(waterSource);
		
		if(list.size()>0 && list.get(0)!=null) {
			return EdatResult.build(1,"饮用水源地名称重复!");
		}
		//插入
		int a  = CompanyWaterSourceMapper.insertWaterSourceInfor(waterSource);
		long id = waterSource.getId();
		
		if(lm!=null && lm.size()>0 && lm.get(0)!=null && id !=0) {
			for (Map<String, Object> map : lm) {
				map.put("WATER_ID", id);
			}
			a =CompanyWaterSourceMapper.insertWaterMonitorInfor(lm);
		}
		
		
		if(a>0) {
			return EdatResult.ok(0,"用户（ID："+userId+"）新增饮用水源地基本信息成功!");
		}else {
			return EdatResult.ok(1,"用户（ID："+userId+"）新增饮用水源地基本信息失败!");
		}
	}
	@MyPermission(module="120")
	public EdatResult updateWaterMonitor(BigDecimal userId,CompanyWaterSource waterSource, List<Map<String ,Object>> list) {
		int a = 0;
		
		a =CompanyWaterSourceMapper.updateWaterMonitorInfor(waterSource);
		List<String> idlist= new ArrayList<>();
		for (Map<String, Object> map : list) {
			if(map.get("ID")!=null && !"".equals(map.get("ID").toString())) {
				idlist.add(map.get("ID").toString());
			}
		}
		if(idlist!=null && idlist.size()>0) {
			String id=idlist.toString().replace("[","").replace("]","");
			a =CompanyWaterSourceMapper.delWaterMonitorInfor(id);
		}

		if(list!=null && list.size()>0) {
			a = CompanyWaterSourceMapper.insertWaterMonitorInfor(list);
		}
		
		if(a>0) {
			return EdatResult.ok(0,"用户（ID："+userId+"）修改成功！");
		}else {
			return EdatResult.ok(1,"用户（ID："+userId+"）修改失败！");
		}
	}
	
	
	@MyPermission(module="123")
	public EdatResult saveBatch(BigDecimal userId, List<Map<String ,Object>> list) {
		try {
			int a = CompanyWaterSourceMapper.saveBatch(list);
			
			if(a>0) {
				return EdatResult.ok(0,"用户（ID："+userId+"）新增饮用水源地基本信息成功！");
			}else {
				return EdatResult.ok(1,"用户（ID："+userId+"）新增饮用水源地基本信息失败！");
			}	
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.ok(1,"用户（ID："+userId+"）新增饮用水源地基本信息失败！");
		}
		
	}
	
}
