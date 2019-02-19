package com.gistone.cdsems.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.database.mapper.CompanyMapper;
import com.gistone.cdsems.service.CompanyService;
import com.gistone.cdsems.util.EdatResult;

/**
 * 企业信息管理service
 * @Title ICompanyService
 * @author NingYudong
 * @date 2018年11月16日
 */
@Service
public class ICompanyService implements CompanyService{

	@Autowired
	CompanyMapper companyMapper;

	@MyPermission(module="56")
	public EdatResult save(Map map) {
		try {
			int id = companyMapper.save(map);
			return EdatResult.ok(id,"新增企业信息（ID："+map.get("id")+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "新增失败！");
		}
	}

	@MyPermission(module="60")
	public EdatResult saveBatch(List<Map> list) {
		try {
			companyMapper.saveBatch(list);
			return EdatResult.ok("批量导入企业信息成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "批量导入失败！");
		}
	}

	@MyPermission(module="57")
	public EdatResult update(Map map) {
		try {
			companyMapper.update(map);
			return EdatResult.ok("修改企业信息（ID："+map.get("ID")+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "修改失败！");
		}
	}

	@MyPermission(module="58")
	public EdatResult delete(Long id) {
		try {
			companyMapper.delete(id);
			companyMapper.deleteCorrelation("T_COMPANY_MIGRATION", id);//删除迁移信息
			companyMapper.deleteCorrelation("T_COMPANY_POLLUTER", id);//删除污染源信息
			companyMapper.deleteCorrelation("T_COMPANY_RECEPTOR", id);//删除敏感受体信息
			companyMapper.deleteCorrelation("T_COMPANY_MONITOR", id);//删除自监测数据
			companyMapper.deleteCorrelation("T_COMPANY_POLLUTANT_MONITOR", id);//删除特征污染物监测数据
			return EdatResult.ok("删除企业信息（ID："+id+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "删除失败！");
		}
	}
	
	@MyPermission(module="59")
	public EdatResult deleteBatch(String idsStr) {
		try {
			if(idsStr==null || idsStr.equals("")){
				return EdatResult.error(1,"没有选择要删除的数据！");
			}
			String[] ids = idsStr.split(",");
			companyMapper.deleteBatch(ids);
			companyMapper.deleteCorrelationBatch("T_COMPANY_MIGRATION", ids);//删除迁移信息
			companyMapper.deleteCorrelationBatch("T_COMPANY_POLLUTER", ids);//删除污染源信息
			companyMapper.deleteCorrelationBatch("T_COMPANY_RECEPTOR", ids);//删除敏感受体信息
			companyMapper.deleteCorrelationBatch("T_COMPANY_MONITOR", ids);//删除自监测数据
			companyMapper.deleteCorrelationBatch("T_COMPANY_POLLUTANT_MONITOR", ids);//删除特征污染物监测数据
			return EdatResult.ok("批量删除企业信息（ID："+idsStr+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "删除失败！");
		}
	}
	
	public Map getByName(String companyName) {
		return companyMapper.getByName(companyName);
	}
	
	@MyPermission(module="55")
	public EdatResult listPage(Map map) {
		try {
			List<Map> list = companyMapper.listPage(map);
			int total = companyMapper.listPageTotal(map);
			return EdatResult.build(list, Integer.parseInt(map.get("page").toString()), total);
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "查询失败！");
		}
	}
	
	@MyPermission(module="61")
	public List<Map> listAllExport(Map map) {
		
		return companyMapper.listAll(map);
	}
	
	public List<Map> listAll(Map map) {
		
		return companyMapper.listAll(map);
	}
	
	public List<Map> listAllPark() {
		
		return companyMapper.listAllPark();
	}
	
	public List<Map> listAllIndustry() {
		
		return companyMapper.listAllIndustry();
	}
	

	
	public List<Map> selectByCounty(Map map) {
		return companyMapper.selectByCounty(map);
	}

	
	public List<Map> selectByCity(Map map) {
		return companyMapper.selectByCity(map);
	}

	public List<Map> selectAllCity(Map map) {
		return companyMapper.selectAllCity(map);
	}

	@Override
	public int alreadyShown(Map map) {
		int yst = companyMapper.alreadyShown(map);
		return yst;
	}

	@Override
	public List<Map> selectIndustryType() {
		
		return companyMapper.selectIndustryType();
	}
}
