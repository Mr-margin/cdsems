package com.gistone.cdsems.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.mapper.CompanyMonitorMapper;
import com.gistone.cdsems.service.CompanyMonitorService;
import com.gistone.cdsems.util.EdatResult;

/**
 * 企业自监测数据管理service
 * @Title ICompanyMonitorService
 * @author NingYudong
 * @date 2018年11月19日
 */
@Service
public class ICompanyMonitorService implements CompanyMonitorService{

	@Autowired
	CompanyMonitorMapper companyMonitorMapper;

	@MyPermission(module="84")
	public EdatResult save(Map map) {
		try {
			int id = companyMonitorMapper.save(map);
			return EdatResult.ok("新增企业自监测数据（ID："+map.get("id")+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "新增失败！");
		}
	}

	@MyPermission(module="88")
	public EdatResult saveBatch(List<Map> list) {
		try {
			companyMonitorMapper.saveBatch(list);
			return EdatResult.ok("批量导入企业自监测数据成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "批量导入失败！");
		}
	}

	@MyPermission(module="85")
	public EdatResult update(Map map) {
		try {
			companyMonitorMapper.update(map);
			return EdatResult.ok("修改企业自监测数据（ID："+map.get("ID")+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "修改失败！");
		}
	}

	@MyPermission(module="86")
	public EdatResult delete(Long id) {
		try {
			companyMonitorMapper.delete(id);
			return EdatResult.ok("删除企业自监测数据（ID："+id+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "删除失败！");
		}
	}

	@MyPermission(module="87")
	public EdatResult deleteBatch(String idsStr) {
		try {
			if(idsStr==null || idsStr.equals("")){
				return EdatResult.error(1,"没有选择要删除的数据！");
			}
			String[] ids = idsStr.split(",");
			companyMonitorMapper.deleteBatch(ids);
			return EdatResult.ok("批量删除企业自监测数据（ID："+idsStr+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "批量删除失败！");
		}
	}
	
	@MyPermission(module="83")
	public EdatResult listPage(Map map) {
		try {
			List<Map> list = companyMonitorMapper.listPage(map);
			int total = companyMonitorMapper.listPageTotal(map);
			return EdatResult.build(list, Integer.parseInt(map.get("page").toString()), total);
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "查询失败！");
		}
	}
	
	@MyPermission(module="89")
	public List<Map> listAll(Map map) {
		
		return companyMonitorMapper.listAll(map);
	}
}
