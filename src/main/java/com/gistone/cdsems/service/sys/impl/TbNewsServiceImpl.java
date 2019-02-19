package com.gistone.cdsems.service.sys.impl;

import java.io.File;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.SysRole;
import com.gistone.cdsems.database.entity.SysRoleModule;
import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.database.entity.TbNews;
import com.gistone.cdsems.database.entity.TbNewsFile;
import com.gistone.cdsems.database.mapper.SysRoleMapper;
import com.gistone.cdsems.database.mapper.SysUserMapper;
import com.gistone.cdsems.database.mapper.TbNewsFileMapper;
import com.gistone.cdsems.database.mapper.TbNewsMapper;
import com.gistone.cdsems.service.sys.SysUserService;
import com.gistone.cdsems.service.sys.TbNewsService;
import com.gistone.cdsems.util.EdatResult;
import com.gistone.cdsems.util.MD5Util;
import com.gistone.cdsems.util.UrlsUtil;
import com.gistone.cdsems.util.UuidUtil;

@SuppressWarnings("all")
@Service
public class TbNewsServiceImpl implements TbNewsService {

	@Autowired
	private TbNewsMapper tbNewsMapper;
	
	@Autowired
	private TbNewsFileMapper tbNewsFileMapper;
	
	@Autowired
	private UrlsUtil urlsUtil;
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	
	

	@Override
	@MyPermission(module="143")
	public EdatResult list(TbNews tbNews) throws Exception {
		//分页查询条件
		int size = tbNews.getPageSize();//每页条数
		int number = tbNews.getPageNumber();//开始索引
		int page = (number / size) + 1;//当前页码
		
		//分页查询
		List<TbNews> list = tbNewsMapper.list(tbNews);
		
		//查询数据总条数
		int total = tbNewsMapper.total(tbNews);
		
		EdatResult result = EdatResult.build(list, page, total);
		return result;
	}

	//添加用户
	@Override
	@MyPermission(module="144")
	public EdatResult saveNews(TbNews addNews, MultipartFile tnTbNewsFiles) throws Exception {
		//1.判断用户是否存在
		List<TbNews> userList = tbNewsMapper.findNewsByTnTitle(addNews);
		if (userList.size() > 0) {
			return EdatResult.build(10, "标题重复");
		}else{
			//1.保存新闻
			tbNewsMapper.insertSelective(addNews);
			
			if(tnTbNewsFiles!=null){
				//2.上传附件
				TbNewsFile tbNewsFile = uploadNewsFile(tnTbNewsFiles);
				//3.保存附件信息
				tbNewsFile.setTnfTnId(addNews.getTnId());
				tbNewsFileMapper.insertSelective(tbNewsFile);
			}
			
			//创建日志对象
			return EdatResult.build(0, "添加成功", null, "添加新闻成功（ID："+addNews.getTnId()+"）");
		}
	}

	//上传附件
	private TbNewsFile uploadNewsFile(MultipartFile tnTbNewsFiles) throws Exception{
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		//原始名称
		String oldFilename = tnTbNewsFiles.getOriginalFilename();
		//后缀
		String hzName = oldFilename.substring(oldFilename.lastIndexOf("."));
		//唯一文件名称
		String newFilename = UuidUtil.get32UUID()+hzName;
		//相对路径
		String xdUrl = "/File/NewsFile/"+df.format(new Date())+"/"+newFilename;
		
		//创建文件夹
		String directoryUrl = urlsUtil.geturl()+"/File/NewsFile/"+df.format(new Date())+"/";
		File directory = new File(directoryUrl);
		if(!directory.exists()){
			//不存在，就创建
			directory.mkdirs();
		}
		
		//生成文件
		//判断文件是否存在
		String fileUrl = directoryUrl + newFilename;
		File file = new File(fileUrl);
		if(!file.exists()){
			//文件不存在
			tnTbNewsFiles.transferTo(file);
		}else{
			//文件已经存在
			throw new RuntimeException("文件已经存在");
		}
		
		//附件对象
		TbNewsFile tbNewsFile = new TbNewsFile();
		tbNewsFile.setTnfOldname(oldFilename);
		tbNewsFile.setTnfUrl(xdUrl);
		
		//创建文件
		return tbNewsFile;
	}

	@Override
	public TbNews getNewsByID(TbNews tbNews) throws Exception{
		TbNews resultNews = tbNewsMapper.selectByPrimaryKey(tbNews.getTnId());
		return resultNews;
	}
	
	@Override
	@MyPermission(module="145")
	public EdatResult updateNews(TbNews addNews, MultipartFile tnTbNewsFiles) throws Exception {
		//1.判断用户是否存在
		List<TbNews> userList = tbNewsMapper.findNewsByTnTitle(addNews);
		if (userList.size() > 0) {
			return EdatResult.build(10, "标题重复");
		}else{
			//1.保存新闻
			tbNewsMapper.updateByPrimaryKeyWithBLOBs(addNews);
			
			if(tnTbNewsFiles!=null){
				//获取附件信息
				List<TbNewsFile> tbNewsFiles = tbNewsFileMapper.selectByTnfTnId(addNews.getTnId());
				
				//删除附件信息
				tbNewsFileMapper.deleteByTnfTnId(addNews.getTnId());
				
				//删除附件
				if(tbNewsFiles.size()>0){
					for (TbNewsFile tbNewsFile : tbNewsFiles) {
						File currFile = new File(urlsUtil.geturl()+tbNewsFile.getTnfUrl());
						if(currFile.exists()){
							currFile.delete();
						}
					}
				}
				
				//2.上传附件
				TbNewsFile tbNewsFile = uploadNewsFile(tnTbNewsFiles);
				//3.保存附件信息
				tbNewsFile.setTnfTnId(addNews.getTnId());
				tbNewsFileMapper.insertSelective(tbNewsFile);
			}
			
			//创建日志对象
			return EdatResult.build(0, "修改成功", null, "修改新闻成功（ID："+addNews.getTnId()+"）");
		}
	}

	//删除用户
	@Override
	@MyPermission(module="146")
	public EdatResult deleteNews(TbNews addNews) throws Exception {
		//设置删除状态
		int updateNedws = tbNewsMapper.deleteByPrimaryKey(addNews.getTnId());
		//获取附件信息
		List<TbNewsFile> tbNewsFiles = tbNewsFileMapper.selectByTnfTnId(addNews.getTnId());
		
		//删除附件信息
		tbNewsFileMapper.deleteByTnfTnId(addNews.getTnId());
		
		//删除附件
		if(tbNewsFiles.size()>0){
			for (TbNewsFile tbNewsFile : tbNewsFiles) {
				File currFile = new File(urlsUtil.geturl()+tbNewsFile.getTnfUrl());
				if(currFile.exists()){
					currFile.delete();
				}
			}
		}
		
		if(updateNedws > 0){
			//创建日志对象
			return EdatResult.build(0, "删除成功", null, "删除新闻成功（ID："+addNews.getTnId()+"）");
		}else{
			return EdatResult.build(1, "删除失败");
		}
	}


	@Override
	public EdatResult listAll() throws Exception {
		//所有角色
		List<SysUser> data = sysUserMapper.listAll();
		return EdatResult.ok(data);
	}

	//审核、置顶新闻
	@Override
	@MyPermission(module="148")
	public EdatResult updateNewsWithoutTnContent(TbNews tbNews)
			throws Exception {
		int updateNews = tbNewsMapper.updateByPrimaryKeySelective(tbNews);
		if(updateNews > 0){
			if(tbNews.getTnCheckstatue()!=null){
				//创建日志对象
				if("2".equals(tbNews.getTnCheckstatue())){
					return EdatResult.build(0, "审核通过成功", null, "审核通过新闻成功（ID："+tbNews.getTnId()+"）");
				}
				if("3".equals(tbNews.getTnCheckstatue())){
					return EdatResult.build(0, "审核不通过成功", null, "审核不通过新闻成功（ID："+tbNews.getTnId()+"）");
				}
			}
			if(tbNews.getTnIstop()!=null){
				//创建日志对象
				if("0".equals(tbNews.getTnIstop())){
					return EdatResult.build(0, "取消置顶成功", null, "取消置顶新闻成功（ID："+tbNews.getTnId()+"）");
				}
				if("1".equals(tbNews.getTnIstop())){
					return EdatResult.build(0, "置顶成功", null, "置顶新闻成功（ID："+tbNews.getTnId()+"）");
				}
			}
		}else{
			if(tbNews.getTnCheckstatue()!=null){
				//创建日志对象
				return EdatResult.build(1, "审核失败");
			}
			if(tbNews.getTnIstop()!=null){
				//创建日志对象
				return EdatResult.build(1, "置顶失败");
			}
			
		}
		return null;
	}
	
	//审核、置顶新闻
		@Override
		public EdatResult updateNewsWithoutTnContentByTnIds(TbNews tbNews)
				throws Exception {
			int updateNews = tbNewsMapper.updateNewsWithoutTnContentByTnIds(tbNews);
			if(updateNews > 0){
				if(tbNews.getTnCheckstatue()!=null){
					//创建日志对象
					if("2".equals(tbNews.getTnCheckstatue())){
						return EdatResult.build(0, "审核通过成功", null, "审核通过新闻成功（ID："+tbNews.getTnIds()+"）");
					}
					if("3".equals(tbNews.getTnCheckstatue())){
						return EdatResult.build(0, "审核不通过成功", null, "审核不通过新闻成功（ID："+tbNews.getTnIds()+"）");
					}
				}
				if(tbNews.getTnIstop()!=null){
					//创建日志对象
					if("0".equals(tbNews.getTnIstop())){
						return EdatResult.build(0, "取消置顶成功", null, "取消置顶新闻成功（ID："+tbNews.getTnIds()+"）");
					}
					if("1".equals(tbNews.getTnIstop())){
						return EdatResult.build(0, "置顶成功", null, "置顶新闻成功（ID："+tbNews.getTnIds()+"）");
					}
				}
			}else{
				if(tbNews.getTnCheckstatue()!=null){
					//创建日志对象
					return EdatResult.build(1, "审核失败");
				}
				if(tbNews.getTnIstop()!=null){
					//创建日志对象
					return EdatResult.build(1, "置顶失败");
				}
				
			}
			return null;
		}

		@Override
		@MyPermission(module="147")
		public EdatResult deleteNewsByTnIds(TbNews tbNews) throws Exception {
			String tnIds = tbNews.getTnIds();
			String[] tnIdArr = tnIds.split(",");
			for (String tnId : tnIdArr) {
				//设置删除状态
				int updateNedws = tbNewsMapper.deleteByPrimaryKey(new BigDecimal(tnId));
				//获取附件信息
				List<TbNewsFile> tbNewsFiles = tbNewsFileMapper.selectByTnfTnId(new BigDecimal(tnId));
				
				//删除附件信息
				tbNewsFileMapper.deleteByTnfTnId(new BigDecimal(tnId));
				
				//删除附件
				if(tbNewsFiles.size()>0){
					for (TbNewsFile tbNewsFile : tbNewsFiles) {
						File currFile = new File(urlsUtil.geturl()+tbNewsFile.getTnfUrl());
						if(currFile.exists()){
							currFile.delete();
						}
					}
				}
			}
				//创建日志对象
			return EdatResult.build(0, "删除成功", null, "删除新闻成功（ID："+tbNews.getTnIds()+"）");
		}

		@Override
		//首页，根据新闻类型和数据条数获取数据
		public EdatResult getNewsListByType(TbNews tbNews) throws Exception {
			
			//分页查询条件
			int size = tbNews.getPageSize();//每页条数
			int number = tbNews.getPageNumber();//开始索引
			int page = (number / size) + 1;//当前页码
			
			//分页查询
			List<TbNews> list = tbNewsMapper.getNewsListByType(tbNews);
			
			//查询数据总条数
			int total = tbNewsMapper.totalByType(tbNews);
			
			EdatResult result = EdatResult.build(list, tbNews.getPageNumber(), total);
			return result;
		}
	
	

}
