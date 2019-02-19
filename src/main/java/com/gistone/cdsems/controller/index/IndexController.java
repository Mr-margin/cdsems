package com.gistone.cdsems.controller.index;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.database.entity.TbMessage;
import com.gistone.cdsems.database.entity.TbNews;
import com.gistone.cdsems.service.index.IndexService;
import com.gistone.cdsems.service.sys.SysUserService;
import com.gistone.cdsems.service.sys.TbMessageService;
import com.gistone.cdsems.service.sys.TbNewsService;
import com.gistone.cdsems.util.EdatResult;
import com.gistone.cdsems.util.RegUtil;

@RestController
@SuppressWarnings("all")
@RequestMapping("index")
public class IndexController {
	
	@Autowired
	private TbNewsService tbNewsService;
	
	@Autowired
	private TbMessageService tbMessageService;
	
	@Autowired
	private IndexService indexService;
	
	//获取法律法规与标准规范数据
	@RequestMapping("/getNewsListByType")
	public EdatResult getNewsListByType(@RequestBody Map<String, Object> requestData, HttpServletRequest request,HttpServletResponse response){
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
			TbNews tbNews = new TbNews();
			Map<String, Object> data = (Map) requestData.get("data");
			//Id
			if (!RegUtil.CheckParameter(data.get("tnType"), "Integer", null, false)) {
				return EdatResult.build(1003, "tnType(新闻类型)不能为空");
			}else{
				if("1".equals(data.get("tnType").toString()) || "2".equals(data.get("tnType").toString())){
					tbNews.setTnType(data.get("tnType").toString());
				}else{
					return EdatResult.build(1003, "tnType(新闻类型)数据不正确");
				}
			}
			//开始索引
			if (!RegUtil.CheckParameter(data.get("pageNumber"), "Integer", null, false)) {
				return EdatResult.build(1003, "pageNumber(开始索引)不能为空");
			}else{
				tbNews.setPageNumber(Integer.parseInt(data.get("pageNumber").toString()));
			}
			//数据条数
			if (!RegUtil.CheckParameter(data.get("pageSize"), "Integer", null, false)) {
				return EdatResult.build(1003, "pageSize(数据条数)不能为空");
			}else{
				tbNews.setPageSize(Integer.parseInt(data.get("pageSize").toString()));
			}
			
			EdatResult edatResult = tbNewsService.getNewsListByType(tbNews);
			
			return edatResult;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	//获取系统通知
	@RequestMapping("/getMessageListByUserId")
	public EdatResult getMessageListByUserId(@RequestBody Map<String, Object> requestData, HttpServletRequest request,HttpServletResponse response){
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
			//开始索引
			if (!RegUtil.CheckParameter(data.get("pageNumber"), "Integer", null, false)) {
				return EdatResult.build(1003, "pageNumber(开始索引)不能为空");
			}else{
				tbMessage.setPageNumber(Integer.parseInt(data.get("pageNumber").toString()));
			}
			//数据条数
			if (!RegUtil.CheckParameter(data.get("pageSize"), "Integer", null, false)) {
				return EdatResult.build(1003, "pageSize(数据条数)不能为空");
			}else{
				tbMessage.setPageSize(Integer.parseInt(data.get("pageSize").toString()));
			}
			//用户id
			tbMessage.setTmSuIds(seUser.getSuId().toString());
			
			EdatResult edatResult = tbMessageService.getMessageListByUserId(tbMessage);
			
			return edatResult;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	//首页数量统计
	@RequestMapping("/getIndexCount")
	public EdatResult getIndexCount(@RequestBody Map<String, Object> requestData, HttpServletRequest request,HttpServletResponse response){
		try {
			
			//1.获取session
			HttpSession session = request.getSession();
			//判断session中是否有用户信息
			if (!RegUtil.CheckParameter(session.getAttribute("sysUser"), null, null, false)) {
				return EdatResult.build(1002, "登陆超时");
			}
			//获取用户信息
			SysUser seUser = (SysUser) session.getAttribute("sysUser");
			
			//用户级别参数
			Map map = new HashMap<String, String>();
			if(seUser.getSuLevel()!=null){
				if("3".equals(seUser.getSuLevel().toString())){
					map.put("suRegioncode", seUser.getSuRegioncode());
				}
				if("4".equals(seUser.getSuLevel().toString())){
					map.put("suCompanyname", seUser.getSuCompanyname());
				}
			}
			
			
			EdatResult edatResult = indexService.getIndexCount(map);
			return edatResult;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
}