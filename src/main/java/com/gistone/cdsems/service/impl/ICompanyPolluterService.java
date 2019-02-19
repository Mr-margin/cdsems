package com.gistone.cdsems.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.mapper.CompanyPolluterMapper;
import com.gistone.cdsems.service.CompanyPolluterService;
import com.gistone.cdsems.util.EdatResult;

/**
 * 企业污染源信息管理service
 * @Title ICompanyPolluterService
 * @author NingYudong
 * @date 2018年11月20日
 */
@Service
public class ICompanyPolluterService implements CompanyPolluterService{

	@Autowired
	CompanyPolluterMapper companyPolluterMapper;

	@MyPermission(module="70")
	public EdatResult save(Map map) {
		try {
			int id = companyPolluterMapper.save(map);
			return EdatResult.ok("新增企业污染源信息（ID："+map.get("id")+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "新增失败！");
		}
	}

	@MyPermission(module="74")
	public EdatResult saveBatch(List<Map> list) {
		try {
			companyPolluterMapper.saveBatch(list);
			return EdatResult.ok("批量导入企业污染源信息成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "批量导入失败！");
		}
	}

	@MyPermission(module="71")
	public EdatResult update(Map map) {
		try {
			companyPolluterMapper.update(map);
			return EdatResult.ok("修改企业污染源信息（ID："+map.get("ID")+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "修改失败！");
		}
	}

	@MyPermission(module="72")
	public EdatResult delete(Long id) {
		try {
			companyPolluterMapper.delete(id);
			return EdatResult.ok("删除企业污染源信息（ID："+id+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "删除失败！");
		}
	}
	
	@MyPermission(module="73")
	public EdatResult deleteBatch(String idsStr) {
		try {
			if(idsStr==null || idsStr.equals("")){
				return EdatResult.error(1,"没有选择要删除的数据！");
			}
			String[] ids = idsStr.split(",");
			companyPolluterMapper.deleteBatch(ids);
			return EdatResult.ok("批量删除企业污染源信息（ID："+idsStr+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "批量删除失败！");
		}
	}

	@MyPermission(module="69")
	public EdatResult listPage(Map map) {
		try {
			List<Map> list = companyPolluterMapper.listPage(map);
			int total = companyPolluterMapper.listPageTotal(map);
			return EdatResult.build(list, Integer.parseInt(map.get("page").toString()), total);
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "查询失败！");
		}
	}
	
	@MyPermission(module="75")
	public List<Map> listAll(Map map) {
		
		return companyPolluterMapper.listAll(map);
	}
}
