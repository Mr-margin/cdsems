package com.gistone.cdsems.service.sys;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.database.entity.TbNews;
import com.gistone.cdsems.util.EdatResult;

@Service
public interface TbNewsService {

	@MyPermission(module="143")
	EdatResult list(TbNews tbNews)throws Exception;

	@MyPermission(module="144")
	EdatResult saveNews(TbNews addNews, MultipartFile tnTbNewsFiles) throws Exception;

	//根据id查询新闻
	TbNews getNewsByID(TbNews tbNews)throws Exception;

	@MyPermission(module="145")
	EdatResult updateNews(TbNews addNews, MultipartFile tnTbNewsFiles)throws Exception;

	@MyPermission(module="146")
	EdatResult deleteNews(TbNews addNews) throws Exception;

	EdatResult listAll() throws Exception;

	//更新审核状态与置顶状态
	@MyPermission(module="148")
	EdatResult updateNewsWithoutTnContent(TbNews tbNews) throws Exception;

	//批量更新审核状态与置顶状态
	EdatResult updateNewsWithoutTnContentByTnIds(TbNews tbNews)throws Exception;

	//批量删除新闻
	@MyPermission(module="147")
	EdatResult deleteNewsByTnIds(TbNews tbNews)throws Exception;

	//首页，根据新闻类型和数据条数获取数据
	EdatResult getNewsListByType(TbNews tbNews) throws Exception;

	


}
