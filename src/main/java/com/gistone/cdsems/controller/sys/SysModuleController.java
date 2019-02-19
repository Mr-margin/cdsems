package com.gistone.cdsems.controller.sys;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.regexp.RegexpUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gistone.cdsems.database.entity.SysLog;
import com.gistone.cdsems.database.entity.SysRole;
import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.service.sys.SysLogService;
import com.gistone.cdsems.service.sys.SysModuleService;
import com.gistone.cdsems.service.sys.SysRoleService;
import com.gistone.cdsems.service.sys.SysUserService;
import com.gistone.cdsems.util.EdatResult;
import com.gistone.cdsems.util.RegUtil;

@RestController
@SuppressWarnings("all")
@RequestMapping("sys/module")
public class SysModuleController {
	
	@Autowired
	private SysModuleService SysModuleService;
	
	@RequestMapping("/listAll")
	public EdatResult listAll(@RequestBody Map<String, Object> requestData, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			
			EdatResult result = SysModuleService.listAll();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	
	
}