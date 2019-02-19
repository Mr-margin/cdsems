package com.gistone.cdsems.controller;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.regexp.RegexpUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.GitProperties;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.database.entity.TbCity;
import com.gistone.cdsems.service.TbCityService;
import com.gistone.cdsems.service.sys.SysUserService;
import com.gistone.cdsems.util.EdatResult;
import com.gistone.cdsems.util.RegUtil;

@RestController
@SuppressWarnings("all")
@RequestMapping("city")
public class TbCityController {
	
	@Autowired
	private TbCityService tbCityService;
	
	
	//通过城市ID 获取 县的数据
	@RequestMapping("/getCountyByCityID")
	public EdatResult getCountyByCityID(@RequestBody Map<String, Object> requestData, HttpServletRequest request,HttpServletResponse response){
		try {
			
			//1.获取session
			HttpSession session = request.getSession();
			//判断session中是否有用户信息
			if (!RegUtil.CheckParameter(session.getAttribute("sysUser"), null, null, false)) {
				return EdatResult.build(1002, "登陆超时");
			}
			//获取用户信息
			SysUser seUser = (SysUser) session.getAttribute("sysUser");
			
			//2.获取前端传递的参数
			TbCity tbCity = new TbCity();
			Map<String, Object> data = (Map) requestData.get("data");
			//如果是县级用户
			if("3".equals(seUser.getSuLevel().toString())){
				if(seUser.getSuRegioncode()!=null){
					tbCity.setTcCode(seUser.getSuRegioncode());
				}
			}
			
			//Id
			if (!RegUtil.CheckParameter(data.get("tcId"), "Long", null, false)) {
				return EdatResult.build(1003, "tcId(城市ID)不能为空");
			}else{
				tbCity.setTcId(Long.parseLong(data.get("tcId").toString()));
			}
			
			
			
			List<TbCity> result = tbCityService.getCountyByCityID(tbCity);
			
			return EdatResult.ok(result);
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	
	
}