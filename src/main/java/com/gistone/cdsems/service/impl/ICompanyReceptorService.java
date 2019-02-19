package com.gistone.cdsems.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.mapper.CompanyReceptorMapper;
import com.gistone.cdsems.service.CompanyReceptorService;
import com.gistone.cdsems.util.EdatResult;

/**
 * 企业敏感受体信息管理service
 * @Title ICompanyReceptorService
 * @author NingYudong
 * @date 2018年11月20日
 */
@Service
public class ICompanyReceptorService implements CompanyReceptorService{

	@Autowired
	CompanyReceptorMapper companyReceptorMapper;

	@MyPermission(module="77")
	public EdatResult save(Map map) {
		try {
			int id = companyReceptorMapper.save(map);
			return EdatResult.ok("新增企业敏感受体信息（ID："+map.get("id")+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "新增失败！");
		}
	}

	@MyPermission(module="81")
	public EdatResult saveBatch(List<Map> list) {
		try {
			companyReceptorMapper.saveBatch(list);
			return EdatResult.ok("批量导入企业敏感受体信息成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "批量导入失败！");
		}
	}

	@MyPermission(module="78")
	public EdatResult update(Map map) {
		try {
			companyReceptorMapper.update(map);
			return EdatResult.ok("修改企业敏感受体信息（ID："+map.get("ID")+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "修改失败！");
		}
	}

	@MyPermission(module="79")
	public EdatResult delete(Long id) {
		try {
			companyReceptorMapper.delete(id);
			return EdatResult.ok("删除企业敏感受体信息（ID："+id+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "删除失败！");
		}
	}
	
	@MyPermission(module="80")
	public EdatResult deleteBatch(String idsStr) {
		try {
			if(idsStr==null || idsStr.equals("")){
				return EdatResult.error(1,"没有选择要删除的数据！");
			}
			String[] ids = idsStr.split(",");
			companyReceptorMapper.deleteBatch(ids);
			return EdatResult.ok("批量删除企业敏感受体信息（ID："+idsStr+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "批量删除失败！");
		}
	}

	@MyPermission(module="76")
	public EdatResult listPage(Map map) {
		try {
			List<Map> list = companyReceptorMapper.listPage(map);
			int total = companyReceptorMapper.listPageTotal(map);
			return EdatResult.build(list, Integer.parseInt(map.get("page").toString()), total);
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "查询失败！");
		}
	}
	
	@MyPermission(module="82")
	public List<Map> listAll(Map map) {
		
		return companyReceptorMapper.listAll(map);
	}
}
