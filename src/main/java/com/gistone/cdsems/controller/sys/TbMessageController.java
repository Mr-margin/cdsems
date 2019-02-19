package com.gistone.cdsems.controller.sys;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.gistone.cdsems.database.entity.TbMessage;
import com.gistone.cdsems.service.sys.SysUserService;
import com.gistone.cdsems.service.sys.TbMessageService;
import com.gistone.cdsems.util.EdatResult;
import com.gistone.cdsems.util.RegUtil;

@RestController
@SuppressWarnings("all")
@RequestMapping("sys/message")
public class TbMessageController {
	
	@Autowired
	private TbMessageService tbMessageService;
	
	@Autowired
	private SysUserService sysUserService;
	
	
	/**
	 * 分页查询系统通知
	 */
	@RequestMapping("/list")
	public EdatResult list(@RequestBody Map<String, Object> requestData,HttpServletRequest request,HttpServletResponse response) throws Exception{
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
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			TbMessage tbMessage = new TbMessage();
			Map<String, Object> data = (Map) requestData.get("data");
			//每页条数
			if (!RegUtil.CheckParameter(data.get("pageSize"), "Integer", null, false)) {
				return EdatResult.build(1003, "pageSize(每页条数)不能为空");
			}else{
				tbMessage.setPageSize(Integer.parseInt(data.get("pageSize").toString()));
			}
			//开始索引
			if (!RegUtil.CheckParameter(data.get("pageNumber"), "Integer", null, false)) {
				return EdatResult.build(1003, "pageNumber(开始索引)不能为空");
			}else{
				tbMessage.setPageNumber(Integer.parseInt(data.get("pageNumber").toString()));
			}
			
			//过期状态
			if (RegUtil.CheckParameter(data.get("tmIsdead"), null, null, false)) {
				if("0".equals(data.get("tmIsdead").toString()) || "1".equals(data.get("tmIsdead").toString())){
					tbMessage.setTmIsdead(data.get("tmIsdead").toString());
				}else{
					return EdatResult.build(1003, "tmIsdead(过期状态)数据不正确");
				}
			}
			//开始时间
			if (RegUtil.CheckParameter(data.get("tmStartTime"), null, null, false)) {
				String tmStartTimeStr = data.get("tmStartTime").toString();
				 Date tmStartTime = df.parse(tmStartTimeStr+" 00:00:00");
				 tbMessage.setTmStartTime(tmStartTime);
			}
			//结束时间
			if (RegUtil.CheckParameter(data.get("tmEndTime"), null, null, false)) {
				String tmEndTimeStr = data.get("tmEndTime").toString();
				 Date tmEndTime = df.parse(tmEndTimeStr+" 23:59:59");
				 tbMessage.setTmEndTime(tmEndTime);
			}
			
			//3.调用service
			EdatResult result = tbMessageService.list(tbMessage);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	@RequestMapping("/saveMessage")
	public EdatResult saveMessage(@RequestBody Map<String, Object> requestData,HttpServletRequest request,HttpServletResponse response){
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
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			TbMessage tbMessage = new TbMessage();
			Map<String, Object> data = (Map) requestData.get("data");
			//通知标题
			if (!RegUtil.CheckParameter(data.get("tmTitle"), null, null, false)) {
				return EdatResult.build(1003, "tmTitle(通知标题)不能为空");
			}else{
				tbMessage.setTmTitle(data.get("tmTitle").toString());
			}
			//用户集合
			if (!RegUtil.CheckParameter(data.get("tmSuIds"), null, null, false)) {
				return EdatResult.build(1003, "tmSuIds(用户集合)不能为空");
			}else{
				tbMessage.setTmSuIds(data.get("tmSuIds").toString());
			}
			//过期时间
			if (!RegUtil.CheckParameter(data.get("tmDeadtime"), "yyyy-MM-dd")) {
				return EdatResult.build(1003, "tmDeadtime(过期时间)不能为空");
			}else{
				tbMessage.setTmDeadtime(df.parse(data.get("tmDeadtime").toString()));
			}
			//内容
			if (!RegUtil.CheckParameter(data.get("tmContent"), null, null, false)) {
				return EdatResult.build(1003, "tmContent(通知内容)不能为空");
			}else{
				tbMessage.setTmContent(data.get("tmContent").toString());
			}
			
			//创建用户
			tbMessage.setAddSuId(seUser.getSuId());
			//创建时间
			tbMessage.setAddTime(new Date());
			//过期状态
			tbMessage.setTmIsdead("0");
			//用户删除状态
			tbMessage.setIsDel("0");
			
			EdatResult result = tbMessageService.saveMessage(tbMessage);
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	@RequestMapping("/getMessageByID")
	public EdatResult getMessageByID(@RequestBody Map<String, Object> requestData, HttpServletRequest request,HttpServletResponse response){
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
			TbMessage tbMessage = new TbMessage();
			Map<String, Object> data = (Map) requestData.get("data");
			//Id
			if (!RegUtil.CheckParameter(data.get("tmId"), "Integer", null, false)) {
				return EdatResult.build(1003, "tmId(消息ID)不能为空");
			}else{
				tbMessage.setTmId(new BigDecimal(data.get("tmId").toString()));
			}
			
			TbMessage resultMessage = tbMessageService.getMessageByID(tbMessage);
			
			return EdatResult.ok(resultMessage);
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	@RequestMapping("/updateMessage")
	public EdatResult updateMessage(@RequestBody Map<String, Object> requestData,HttpServletRequest request,HttpServletResponse response) throws Exception{
		try{
			//1.获取session
			HttpSession session = request.getSession();
			//判断session中是否有用户信息
			if (!RegUtil.CheckParameter(session.getAttribute("sysUser"), null, null, false)) {
				return EdatResult.build(1002, "登陆超时");
			}
			//获取用户信息
			SysUser seUser = (SysUser) session.getAttribute("sysUser");
			
			//2.获取前端传递的参数
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			TbMessage tbMessage = new TbMessage();
			Map<String, Object> data = (Map) requestData.get("data");
			//ID
			if (!RegUtil.CheckParameter(data.get("tmId"), null, null, false)) {
				return EdatResult.build(1003, "tmId(主键)不能为空");
			}else{
				tbMessage.setTmId(new BigDecimal(data.get("tmId").toString()));
			}
			if (!RegUtil.CheckParameter(data.get("tmTitle"), null, null, false)) {
				return EdatResult.build(1003, "tmTitle(通知标题)不能为空");
			}else{
				tbMessage.setTmTitle(data.get("tmTitle").toString());
			}
			//用户集合
			if (!RegUtil.CheckParameter(data.get("tmSuIds"), null, null, false)) {
				return EdatResult.build(1003, "tmSuIds(用户集合)不能为空");
			}else{
				tbMessage.setTmSuIds(data.get("tmSuIds").toString());
			}
			//过期时间
			if (!RegUtil.CheckParameter(data.get("tmDeadtime"), "yyyy-MM-dd")) {
				return EdatResult.build(1003, "tmDeadtime(过期时间)不能为空");
			}else{
				tbMessage.setTmDeadtime(df.parse(data.get("tmDeadtime").toString()));
			}
			//内容
			if (!RegUtil.CheckParameter(data.get("tmContent"), null, null, false)) {
				return EdatResult.build(1003, "tmContent(通知内容)不能为空");
			}else{
				tbMessage.setTmContent(data.get("tmContent").toString());
			}
			
			//创建用户
			tbMessage.setUpdSuId(seUser.getSuId());
			//创建时间
			tbMessage.setUpdTime(new Date());
			//过期状态
			tbMessage.setTmIsdead("0");
			//用户删除状态
			tbMessage.setIsDel("0");
			
			EdatResult result = tbMessageService.updateMessage(tbMessage);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	@RequestMapping("/deleteMessage")
	public EdatResult deleteMessage(@RequestBody Map<String, Object> requestData,HttpServletRequest request,HttpServletResponse response){
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
			TbMessage tbMessage = new TbMessage();
			Map<String, Object> data = (Map) requestData.get("data");
			//Id
			if (!RegUtil.CheckParameter(data.get("tmId"), "Integer", null, false)) {
				return EdatResult.build(1003, "tmId(消息ID)不能为空");
			}else{
				tbMessage.setTmId(new BigDecimal(data.get("tmId").toString()));
			}
			
			EdatResult result = tbMessageService.deleteMessage(tbMessage);
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	@RequestMapping("/deadMessage")
	public EdatResult deadMessage(@RequestBody Map<String, Object> requestData,HttpServletRequest request,HttpServletResponse response){
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
			TbMessage tbMessage = new TbMessage();
			Map<String, Object> data = (Map) requestData.get("data");
			//Id
			if (!RegUtil.CheckParameter(data.get("tmId"), "Integer", null, false)) {
				return EdatResult.build(1003, "tmId(消息ID)不能为空");
			}else{
				tbMessage.setTmId(new BigDecimal(data.get("tmId").toString()));
			}
			
			EdatResult result = tbMessageService.updateDeadMessage(tbMessage);
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	
	
	//所有用户
	@RequestMapping("/listAll")
	public EdatResult listAll(@RequestBody Map<String, Object> requestData, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			
			EdatResult result = sysUserService.listAll();
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
		
	}
	
}