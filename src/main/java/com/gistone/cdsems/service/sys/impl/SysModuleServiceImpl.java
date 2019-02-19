package com.gistone.cdsems.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gistone.cdsems.database.entity.SysModule;
import com.gistone.cdsems.database.entity.SysRole;
import com.gistone.cdsems.database.mapper.SysModuleMapper;
import com.gistone.cdsems.service.sys.SysModuleService;
import com.gistone.cdsems.util.EdatResult;

@Service
public class SysModuleServiceImpl implements SysModuleService{

	@Autowired
	private SysModuleMapper sysModuleMapper;
	
	private static Integer flag =0;
	
	@Override
	public EdatResult listAll() throws Exception {
		List<SysModule> list = sysModuleMapper.listAll();
		
		JSONObject js = new JSONObject();
		JSONArray array = new JSONArray();
		for(int i = 0 ; i < list.size() ; i++){
			JSONObject json = new JSONObject();
			json.put("id", list.get(i).getSmId());
			json.put("name", list.get(i).getSmName());
			json.put("smDesc",  list.get(i).getSmDesc());
			json.put("smPid", list.get(i).getSmPid());
			json.put("children", "");
			array = inserts(array,json);
			if(flag ==0){
				array.add(json);
			}
			flag =0;
		}
		js.put("msg", array);
		return EdatResult.ok(array);
	}
	
	private JSONArray inserts(JSONArray array,JSONObject object){
		array = check(array, object);
		for (int j = 0 ; j < array.size() ; j ++){
			JSONObject currObj = (JSONObject) array.get(j);
			if(currObj.get("children")!=""){
				JSONArray array4=inserts((JSONArray)currObj.get("children"), object);
				currObj.put("children", array4);
				array.set(j, currObj);
			}
		}
		return array;
	}
	
	private JSONArray check(JSONArray array,JSONObject object){
		for (int j = 0 ; j < array.size() ; j ++){
			JSONObject currObj = (JSONObject) array.get(j);
			if(object.get("smPid").equals(currObj.get("id"))){
				flag = 1;
				if(currObj.get("children")==""){
					JSONArray array3 = new JSONArray();
					array3.add(object);
					currObj.put("children",array3);
					array.set(j, currObj);
				}else{
					JSONArray array2 = (JSONArray)currObj.get("children");
					array2.add(object);
					currObj.put("children",array2);
					array.set(j, currObj);
				}
			}
		}
		return array;
	}

}
