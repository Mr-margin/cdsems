package com.gistone.cdsems.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.mapper.SoilRemediationMapper;
import com.gistone.cdsems.service.SoilRemediationService;
import com.gistone.cdsems.util.EdatResult;

/**
 * 土壤治理与修复项目基本信息
 * @Title ISoilRemediationService
 * @author NingYudong
 * @date 2018年11月23日
 */
@Service
public class ISoilRemediationService implements SoilRemediationService{

	@Autowired
	SoilRemediationMapper soilRemediationMapper;

	@MyPermission(module="127")
	public EdatResult save(Map map) {
		try {
			int id = soilRemediationMapper.save(map);
			return EdatResult.ok(id,"新增土壤治理与修复项目基本信息（ID："+map.get("id")+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "新增失败！");
		}
	}

	@MyPermission(module="131")
	public EdatResult saveBatch(List<Map> list) {
		try {
			soilRemediationMapper.saveBatch(list);
			return EdatResult.ok("批量导入土壤治理与修复项目基本信息成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "批量导入失败！");
		}
	}

	@MyPermission(module="128")
	public EdatResult update(Map map) {
		try {
			soilRemediationMapper.update(map);
			return EdatResult.ok("修改土壤治理与修复项目基本信息（ID："+map.get("ID")+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "修改失败！");
		}
	}

	@MyPermission(module="129")
	public EdatResult delete(Long id) {
		try {
			soilRemediationMapper.delete(id);
			return EdatResult.ok("删除土壤治理与修复项目基本信息（ID："+id+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "删除失败！");
		}
	}
	
	@MyPermission(module="130")
	public EdatResult deleteBatch( String idsStr) {
		try {
			if(idsStr==null || idsStr.equals("")){
				return EdatResult.error(1,"没有选择要删除的数据！");
			}
			String[] ids = idsStr.split(",");
			soilRemediationMapper.deleteBatch(ids);
			return EdatResult.ok("批量删除土壤治理与修复项目基本信息（ID："+idsStr+"）成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "删除失败！");
		}
	}
	
	@MyPermission(module="126")
	public EdatResult listPage(Map map) {
		try {
			List<Map> list = new ArrayList<Map>();
			int total = 0;
			if(!"4".equals(map.get("suLevel"))){
				list = soilRemediationMapper.listPage(map);
				total = soilRemediationMapper.listPageTotal(map);
			}
			return EdatResult.build(list, Integer.parseInt(map.get("page").toString()), total);
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.error(1, "查询失败！");
		}
	}
	
	@MyPermission(module="132")
	public List<Map> listAll(Map map) {
		List<Map> list = new ArrayList<Map>();
		if(!"4".equals(map.get("suLevel"))){
			list = soilRemediationMapper.listAll(map);
		}
		return list;
	}

}
