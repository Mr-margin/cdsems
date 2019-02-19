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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.database.entity.TbNews;
import com.gistone.cdsems.service.sys.SysUserService;
import com.gistone.cdsems.service.sys.TbNewsService;
import com.gistone.cdsems.util.EdatResult;
import com.gistone.cdsems.util.RegUtil;

@RestController
@SuppressWarnings("all")
@RequestMapping("sys/news")
public class TbNewsController {
	
	@Autowired
	private TbNewsService tbNewsService;
	
	@Autowired
	private SysUserService sysUserService;
	
	
	
	/**
	 * 分页查询用户信息
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
			TbNews tbNews = new TbNews();
			Map<String, Object> data = (Map) requestData.get("data");
			//每页条数
			if (!RegUtil.CheckParameter(data.get("pageSize"), "Integer", null, false)) {
				return EdatResult.build(1003, "pageSize(每页条数)不能为空");
			}else{
				tbNews.setPageSize(Integer.parseInt(data.get("pageSize").toString()));
			}
			//开始索引
			if (!RegUtil.CheckParameter(data.get("pageNumber"), "Integer", null, false)) {
				return EdatResult.build(1003, "pageNumber(开始索引)不能为空");
			}else{
				tbNews.setPageNumber(Integer.parseInt(data.get("pageNumber").toString()));
			}
			
			//模糊查询条件，新闻标题
			if (RegUtil.CheckParameter(data.get("tnTitle"), null, null, false)) {
				tbNews.setTnTitle(data.get("tnTitle").toString());
			}
			//新闻类型
			if (RegUtil.CheckParameter(data.get("tnType"), "Integer", null, false)) {
				tbNews.setTnType(data.get("tnType").toString());
			}
			//审核状态
			if (RegUtil.CheckParameter(data.get("tnCheckstatue"), "Integer", null, false)) {
				tbNews.setTnCheckstatue(data.get("tnCheckstatue").toString());
			}
			//置顶状态
			if (RegUtil.CheckParameter(data.get("tnIstop"), "Integer", null, false)) {
				tbNews.setTnIstop(data.get("tnIstop").toString());
			}
			
			//3.调用service
			EdatResult result = tbNewsService.list(tbNews);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	@RequestMapping("/saveNews")
	public EdatResult saveNews(@RequestParam(value="tnTbNewsFiles",required=false) MultipartFile tnTbNewsFiles,HttpServletRequest request,HttpServletResponse response){
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
			TbNews addNews = new TbNews();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			//标题
			if (!RegUtil.CheckParameter(request.getParameter("tnTitle"), null, null, false)) {
				return EdatResult.build(1003, "tnTitle(标题)不能为空");
			}else{
				addNews.setTnTitle(request.getParameter("tnTitle").toString());
			}
			//来源
			if (RegUtil.CheckParameter(request.getParameter("tnSource"), null, null, false)) {
				addNews.setTnSource(request.getParameter("tnSource").toString());
			}
			//类型
			if (!RegUtil.CheckParameter(request.getParameter("tnType"), "Integer", null, false)) {
				return EdatResult.build(1003, "tnType(类型)不能为空");
			}else{
				addNews.setTnType(request.getParameter("tnType").toString());
			}
			//作者
			if (RegUtil.CheckParameter(request.getParameter("tnAuthor"), null, null, false)) {
				addNews.setTnAuthor(request.getParameter("tnAuthor").toString());
			}
			//发布时间
			if (!RegUtil.CheckParameter(request.getParameter("tnPosttime"), "yyyy-MM-dd")) {
				return EdatResult.build(1003, "tnPosttime(发布时间)不能为空");
			}else{
				Date tnPosttime = df.parse(request.getParameter("tnPosttime").toString());
				addNews.setTnPosttime(tnPosttime);
			}
			//校核人
			if (RegUtil.CheckParameter(request.getParameter("tnCheckperson"), null, null, false)) {
				addNews.setTnCheckperson(request.getParameter("tnCheckperson").toString());
			}
			//置顶
			if (!RegUtil.CheckParameter(request.getParameter("tnIstop"), "Integer", null, false)) {
				return EdatResult.build(1003, "tnIstop(置顶)不能为空");
			}else{
				//置顶状态
				if (RegUtil.CheckParameter(request.getParameter("tnIstop"), "Integer", null, false)) {
					if("0".equals(request.getParameter("tnIstop").toString()) || "1".equals(request.getParameter("tnIstop").toString())){
						addNews.setTnIstop(request.getParameter("tnIstop").toString());
					}else{
						return EdatResult.build(1003, "tnIstop(指定状态)数据不正确");
					}
				}
				
			}
			//内容
			if (!RegUtil.CheckParameter(request.getParameter("tnContent"), null, null, false)) {
				return EdatResult.build(1003, "tnContent(内容)不能为空");
			}else{
				addNews.setTnContent(request.getParameter("tnContent").toString());
			}
			//审核状态
			addNews.setTnCheckstatue("1");
			
			//创建用户
			addNews.setAddSuId(seUser.getSuId());
			//创建时间
			addNews.setAddTime(new Date());
			
			EdatResult result = tbNewsService.saveNews(addNews, tnTbNewsFiles);
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	@RequestMapping("/getNewsByID")
	public EdatResult getNewsByID(@RequestBody Map<String, Object> requestData, HttpServletRequest request,HttpServletResponse response){
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
			TbNews addNews = new TbNews();
			Map<String, Object> data = (Map) requestData.get("data");
			//Id
			if (!RegUtil.CheckParameter(data.get("tnId"), "Integer", null, false)) {
				return EdatResult.build(1003, "tnId(新闻ID)不能为空");
			}else{
				addNews.setTnId(new BigDecimal(data.get("tnId").toString()));
			}
			
			TbNews resultNews = tbNewsService.getNewsByID(addNews);
			
			return EdatResult.ok(resultNews);
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	@RequestMapping("/updateNews")
	public EdatResult updateNews(@RequestParam(value="tnTbNewsFiles",required=false) MultipartFile tnTbNewsFiles,HttpServletRequest request,HttpServletResponse response) throws Exception{
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
			TbNews addNews = new TbNews();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			//ID
			if (!RegUtil.CheckParameter(request.getParameter("tnId"), "Integer", null, false)) {
				return EdatResult.build(1003, "tnId(主键)不能为空");
			}else{
				addNews.setTnId(new BigDecimal(request.getParameter("tnId")));
			}
			//标题
			if (!RegUtil.CheckParameter(request.getParameter("tnTitle"), null, null, false)) {
				return EdatResult.build(1003, "tnTitle(标题)不能为空");
			}else{
				addNews.setTnTitle(request.getParameter("tnTitle").toString());
			}
			//来源
			if (RegUtil.CheckParameter(request.getParameter("tnSource"), null, null, false)) {
				addNews.setTnSource(request.getParameter("tnSource").toString());
			}
			//类型
			if (!RegUtil.CheckParameter(request.getParameter("tnType"), "Integer", null, false)) {
				return EdatResult.build(1003, "tnType(类型)不能为空");
			}else{
				addNews.setTnType(request.getParameter("tnType").toString());
			}
			//作者
			if (RegUtil.CheckParameter(request.getParameter("tnAuthor"), null, null, false)) {
				addNews.setTnAuthor(request.getParameter("tnAuthor").toString());
			}
			//发布时间
			if (!RegUtil.CheckParameter(request.getParameter("tnPosttime"), "yyyy-MM-dd")) {
				return EdatResult.build(1003, "tnPosttime(发布时间)不能为空");
			}else{
				Date tnPosttime = df.parse(request.getParameter("tnPosttime").toString());
				addNews.setTnPosttime(tnPosttime);
			}
			//校核人
			if (RegUtil.CheckParameter(request.getParameter("tnCheckperson"), null, null, false)) {
				addNews.setTnCheckperson(request.getParameter("tnCheckperson").toString());
			}
			//置顶
			if (!RegUtil.CheckParameter(request.getParameter("tnIstop"), "Integer", null, false)) {
				return EdatResult.build(1003, "tnIstop(置顶)不能为空");
			}else{
				//置顶状态
				if (RegUtil.CheckParameter(request.getParameter("tnIstop"), "Integer", null, false)) {
					if("0".equals(request.getParameter("tnIstop").toString()) || "1".equals(request.getParameter("tnIstop").toString())){
						addNews.setTnIstop(request.getParameter("tnIstop").toString());
					}else{
						return EdatResult.build(1003, "tnIstop(指定状态)数据不正确");
					}
				}
			}
			//内容
			if (!RegUtil.CheckParameter(request.getParameter("tnContent"), null, null, false)) {
				return EdatResult.build(1003, "tnContent(内容)不能为空");
			}else{
				addNews.setTnContent(request.getParameter("tnContent").toString());
			}
			//审核状态
			addNews.setTnCheckstatue("1");
			
			//创建用户
			addNews.setUpdSuId(seUser.getSuId());
			//创建时间
			addNews.setUpdTime(new Date());
			
			EdatResult result = tbNewsService.updateNews(addNews, tnTbNewsFiles);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	@RequestMapping("/deleteNews")
	public EdatResult deleteNews(@RequestBody Map<String, Object> requestData,HttpServletRequest request,HttpServletResponse response){
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
			//ID
			if (!RegUtil.CheckParameter(data.get("tnId"), "Integer", null, false)) {
				return EdatResult.build(1003, "tnId(主键)不能为空");
			}else{
				tbNews.setTnId(new BigDecimal(data.get("tnId").toString()));
			}
			
			EdatResult result = tbNewsService.deleteNews(tbNews);
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	@RequestMapping("/checkNews")
	public EdatResult checkNews(@RequestBody Map<String, Object> requestData,HttpServletRequest request,HttpServletResponse response){
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
			//ID
			if (!RegUtil.CheckParameter(data.get("tnId"), "Integer", null, false)) {
				return EdatResult.build(1003, "tnId(主键)不能为空");
			}else{
				tbNews.setTnId(new BigDecimal(data.get("tnId").toString()));
			}
			//审核状态
			if (RegUtil.CheckParameter(data.get("tnCheckstatue"), "Integer", null, false)) {
				if("2".equals(data.get("tnCheckstatue").toString()) || "3".equals(data.get("tnCheckstatue").toString())){
					tbNews.setTnCheckstatue(data.get("tnCheckstatue").toString());
				}else{
					return EdatResult.build(1003, "tnCheckstatue(审核状态)数据不正确");
				}
			}
			//置顶状态
			if (RegUtil.CheckParameter(data.get("tnIstop"), "Integer", null, false)) {
				if("0".equals(data.get("tnIstop").toString()) || "1".equals(data.get("tnIstop").toString())){
					tbNews.setTnCheckstatue(data.get("tnIstop").toString());
				}else{
					return EdatResult.build(1003, "tnIstop(指定状态)数据不正确");
				}
			}
			
			
			EdatResult result = tbNewsService.updateNewsWithoutTnContent(tbNews);
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	@RequestMapping("/checkNewsByTnIds")
	public EdatResult checkNewsByTnIds(@RequestBody Map<String, Object> requestData,HttpServletRequest request,HttpServletResponse response){
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
			//ID
			if (!RegUtil.CheckParameter(data.get("tnIds"), null, null, false)) {
				return EdatResult.build(1003, "tnIds(主键)不能为空");
			}else{
				tbNews.setTnIds(data.get("tnIds").toString());
			}
			//审核状态
			if (RegUtil.CheckParameter(data.get("tnCheckstatue"), "Integer", null, false)) {
				if("2".equals(data.get("tnCheckstatue").toString()) || "3".equals(data.get("tnCheckstatue").toString())){
					tbNews.setTnCheckstatue(data.get("tnCheckstatue").toString());
				}else{
					return EdatResult.build(1003, "tnCheckstatue(审核状态)数据不正确");
				}
			}
			//置顶状态
			if (RegUtil.CheckParameter(data.get("tnIstop"), "Integer", null, false)) {
				if("0".equals(data.get("tnIstop").toString()) || "1".equals(data.get("tnIstop").toString())){
					tbNews.setTnCheckstatue(data.get("tnIstop").toString());
				}else{
					return EdatResult.build(1003, "tnIstop(指定状态)数据不正确");
				}
			}
			
			
			EdatResult result = tbNewsService.updateNewsWithoutTnContentByTnIds(tbNews);
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	@RequestMapping("/deleteNewsByTnIds")
	public EdatResult deleteNewsByTnIds(@RequestBody Map<String, Object> requestData,HttpServletRequest request,HttpServletResponse response){
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
			//ID
			if (!RegUtil.CheckParameter(data.get("tnIds"), null, null, false)) {
				return EdatResult.build(1003, "tnIds(主键)不能为空");
			}else{
				tbNews.setTnIds(data.get("tnIds").toString());
			}
			
			EdatResult result = tbNewsService.deleteNewsByTnIds(tbNews);
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return EdatResult.build(1001, "系统异常");
		}
	}
	
	
	
	
	
}