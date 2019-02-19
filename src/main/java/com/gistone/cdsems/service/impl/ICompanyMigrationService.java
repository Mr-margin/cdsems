package com.gistone.cdsems.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.mapper.CompanyMigrationMapper;
import com.gistone.cdsems.service.CompanyMigrationService;
import com.gistone.cdsems.util.EdatResult;

/**
 * 企业迁移信息管理service
 * @Title ICompanyMigrationService
 * @author NingYudong
 * @date 2018年11月20日
 */
@Service
public class ICompanyMigrationService implements CompanyMigrationService{

	@Autowired
	CompanyMigrationMapper companyMigrationMapper;

	@MyPermission(module="63")
	public EdatResult save(Map map) {
		try {
			int id = companyMigrationMapper.save(map);
			return EdatResult.ok("新增企业迁移信息（ID："+map.get("id")+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "新增失败！");
		}
	}

	@MyPermission(module="67")
	public EdatResult saveBatch(List<Map> list) {
		try {
			companyMigrationMapper.saveBatch(list);
			return EdatResult.ok("批量导入企业迁移信息成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "批量导入失败！");
		}
	}

	@MyPermission(module="64")
	public EdatResult update(Map map) {
		try {
			companyMigrationMapper.update(map);
			return EdatResult.ok("修改企业迁移信息（ID："+map.get("ID")+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "修改失败！");
		}
	}

	@MyPermission(module="65")
	public EdatResult delete(Long id) {
		try {
			companyMigrationMapper.delete(id);
			return EdatResult.ok("删除企业迁移信息（ID："+id+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "删除失败！");
		}
	}
	
	@MyPermission(module="66")
	public EdatResult deleteBatch(String idsStr) {
		try {
			if(idsStr==null || idsStr.equals("")){
				return EdatResult.error(1,"没有选择要删除的数据！");
			}
			String[] ids = idsStr.split(",");
			companyMigrationMapper.deleteBatch(ids);
			return EdatResult.ok("批量删除企业迁移信息（ID："+idsStr+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "批量删除失败！");
		}
	}

	@MyPermission(module="62")
	public EdatResult listPage(Map map) {
		try {
			List<Map> list = companyMigrationMapper.listPage(map);
			int total = companyMigrationMapper.listPageTotal(map);
			return EdatResult.build(list, Integer.parseInt(map.get("page").toString()), total);
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "查询失败！");
		}
	}
	
	@MyPermission(module="68")
	public List<Map> listAll(Map map) {
		
		return companyMigrationMapper.listAll(map);
	}
}
