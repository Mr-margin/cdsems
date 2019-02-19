package com.gistone.cdsems.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.mapper.CompanyPollutantMonitorMapper;
import com.gistone.cdsems.service.CompanyPollutantMonitorService;
import com.gistone.cdsems.util.EdatResult;

/**
 * 企业特征污染物监测数据管理service
 * @Title ICompanyPollutantPollutantMonitorService
 * @author NingYudong
 * @date 2018年11月19日
 */
@Service
public class ICompanyPollutantMonitorService implements CompanyPollutantMonitorService{

	@Autowired
	CompanyPollutantMonitorMapper companyPollutantMonitorMapper;

	@MyPermission(module="91")
	public EdatResult save(Map map) {
		try {
			int id = companyPollutantMonitorMapper.save(map);
			return EdatResult.ok("新增企业特征污染物监测数据（ID："+map.get("id")+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "新增失败！");
		}
	}

	@MyPermission(module="95")
	public EdatResult saveBatch(List<Map> list) {
		try {
			companyPollutantMonitorMapper.saveBatch(list);
			return EdatResult.ok("批量导入企业特征污染物监测数据成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "批量导入失败！");
		}
	}

	@MyPermission(module="92")
	public EdatResult update(Map map) {
		try {
			companyPollutantMonitorMapper.update(map);
			return EdatResult.ok("修改企业特征污染物监测数据（ID："+map.get("ID")+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "修改失败！");
		}
	}

	@MyPermission(module="93")
	public EdatResult delete(Long id) {
		try {
			companyPollutantMonitorMapper.delete(id);
			return EdatResult.ok("删除企业特征污染物监测数据（ID："+id+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "删除失败！");
		}
	}
	
	@MyPermission(module="94")
	public EdatResult deleteBatch(String idsStr) {
		try {
			if(idsStr==null || idsStr.equals("")){
				return EdatResult.error(1,"没有选择要删除的数据！");
			}
			String[] ids = idsStr.split(",");
			companyPollutantMonitorMapper.deleteBatch(ids);
			return EdatResult.ok("批量删除企业特征污染物监测数据（ID："+idsStr+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "批量删除失败！");
		}
	}

	@MyPermission(module="90")
	public EdatResult listPage(Map map) {
		try {
			List<Map> list = companyPollutantMonitorMapper.listPage(map);
			int total = companyPollutantMonitorMapper.listPageTotal(map);
			return EdatResult.build(list, Integer.parseInt(map.get("page").toString()), total);
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "查询失败！");
		}
	}
	
	@MyPermission(module="96")
	public List<Map> listAll(Map map) {
		
		return companyPollutantMonitorMapper.listAll(map);
	}
	
	public Map getPollutantByName(String name) {
		
		return companyPollutantMonitorMapper.getPollutantByName(name);
	}
	
	public List<Map> listAllPollutant() {
		
		return companyPollutantMonitorMapper.listAllPollutant();
	}
}
