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
import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.service.sys.SysLogService;
import com.gistone.cdsems.service.sys.SysUserService;
import com.gistone.cdsems.util.EdatResult;
import com.gistone.cdsems.util.RegUtil;

@RestController
@SuppressWarnings("all")
@RequestMapping("sys/log")
public class SysLogController {
	
	@Autowired
	private SysLogService sysLogService;
	
	//查询日志分页
	@RequestMapping("list")	
	public EdatResult list(@RequestBody Map<String, Object> requestDate,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			
			//1.获取session
			HttpSession session = request.getSession();
			//判断session中是否有用户信息
			if (!RegUtil.CheckParameter(session.getAttribute("sysUser"), null, null, false)) {
				return EdatResult.build(1002, "登陆超时");
			}
			//获取用户信息
			SysUser seUser = (SysUser) session.getAttribute("sysUser");

			//2.接收参数
			//创建插入数据对象，并将参数放入
			SysLog sysLog=new SysLog();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Map<String, Object> data = (Map) requestDate.get("data");
			// 用户名
			if (RegUtil.CheckParameter(data.get("suUsername"), null, null, false)) {
				if(sysLog.getSlSysUser() == null){
					SysUser sysUser = new SysUser();
					sysUser.setSuUsername(data.get("suUsername").toString());
					sysLog.setSlSysUser(sysUser);
				}else{
					sysLog.getSlSysUser().setSuUsername(data.get("suUsername").toString());
				}
			}
			//日志类型
			if (RegUtil.CheckParameter(data.get("slSltId"), "Integer", null, false)) {
				sysLog.setSlSltId(new BigDecimal(data.get("slSltId").toString()));
			}
			
			//开始时间
			if (RegUtil.CheckParameter(data.get("startTime"), null, null, false)) {
				String startTimeStr=data.get("startTime").toString();
				 Date startTime = sdf.parse(startTimeStr+" 00:00:00");
				 sysLog.setSlStartTime(startTime);
			}
			//结束时间
			if (RegUtil.CheckParameter(data.get("endTime"), null, null, false)) {
				String endTimeStr=data.get("endTime").toString();
				 Date endTime = sdf.parse(endTimeStr+" 23:59:59");
				 sysLog.setSlEndTime(endTime);
			}
			//开始索引
			if (!RegUtil.CheckParameter(data.get("pageNumber"), "Integer", null, false)) {
				return EdatResult.build(1003, "pageNumber不能为空");
			}else{
				sysLog.setPageNumber(Integer.valueOf(data.get("pageNumber").toString()));
			}
			//每页条数
			if (!RegUtil.CheckParameter(data.get("pageSize"), "Integer", null, false)) {
				return EdatResult.build(1003, "pageSize不能为空");
			}else{
				sysLog.setPageSize(Integer.valueOf(data.get("pageSize").toString()));
			}
			
			//3.调用Service
			EdatResult result = sysLogService.list(sysLog);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
}