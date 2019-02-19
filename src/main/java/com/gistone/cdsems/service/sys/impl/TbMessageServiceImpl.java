package com.gistone.cdsems.service.sys.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.SysRole;
import com.gistone.cdsems.database.entity.SysRoleModule;
import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.database.entity.TbMessage;
import com.gistone.cdsems.database.entity.TbNews;
import com.gistone.cdsems.database.mapper.SysRoleMapper;
import com.gistone.cdsems.database.mapper.SysUserMapper;
import com.gistone.cdsems.database.mapper.TbMessageMapper;
import com.gistone.cdsems.service.sys.SysUserService;
import com.gistone.cdsems.service.sys.TbMessageService;
import com.gistone.cdsems.util.EdatResult;
import com.gistone.cdsems.util.MD5Util;

@SuppressWarnings("all")
@Service
public class TbMessageServiceImpl implements TbMessageService {
	
	@Autowired
	private TbMessageMapper tbMessageMapper;

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	

	@Override
	@MyPermission(module="138")
	public EdatResult list(TbMessage tbMessage) throws Exception {
		//分页查询条件
		int size = tbMessage.getPageSize();//每页条数
		int number = tbMessage.getPageNumber();//开始索引
		int page = (number / size) + 1;//当前页码
		
		//分页查询
		List<TbMessage> list = tbMessageMapper.list(tbMessage);
		
		//处理数据
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		for (TbMessage tbMessage2 : list) {
			if(tbMessage2.getTmDeadtime()!=null){
				//如果过期时间小于当前日期，设置过期状态
				Date todayDate = df.parse(df.format(new Date()));
				Date tbDeadtime = tbMessage2.getTmDeadtime();
				if(tbDeadtime.getTime()<todayDate.getTime()){
					tbMessage2.setTmIsdead("1");
				}
			}
		}
		
		//查询数据总条数
		int total = tbMessageMapper.total(tbMessage);
		
		EdatResult result = EdatResult.build(list, page, total);
		return result;
	}

	//添加用户
	@Override
	@MyPermission(module="139")
	public EdatResult saveMessage(TbMessage tbMessage) throws Exception {
		int number = tbMessageMapper.insertSelective(tbMessage);
		if(number>0){
			//创建日志对象
			return EdatResult.build(0, "添加成功", null, "添加系统通知成功（ID："+tbMessage.getTmId()+"）");
		}else{
			return EdatResult.build(1, "添加失败");
		}
	}

	@Override
	public TbMessage getMessageByID(TbMessage tbMessage) throws Exception{
		TbMessage resutlMessage = tbMessageMapper.selectByPrimaryKey(tbMessage.getTmId());
		return resutlMessage;
	}
	
	@Override
	@MyPermission(module="140")
	public EdatResult updateMessage(TbMessage tbMessage) throws Exception {
		//2.调用Dao
		int number = tbMessageMapper.updateByPrimaryKeySelective(tbMessage);
		if(number>0){
			return EdatResult.build(0, "修改成功", null, "修改系统通知成功（ID："+tbMessage.getTmId()+"）");
		}else{
			return EdatResult.build(1, "修改失败");
		}
	}

	//删除用户
	@Override
	@MyPermission(module="141")
	public EdatResult deleteMessage(TbMessage tbMessage) throws Exception {
		//设置删除状态
		tbMessage.setIsDel("1");
		int updateUser = tbMessageMapper.updateByPrimaryKeySelective(tbMessage);
		if(updateUser > 0){
			//创建日志对象
			return EdatResult.build(0, "删除成功", null, "删除系统通知成功（ID："+tbMessage.getTmId()+"）");
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

	@Override
	@MyPermission(module="142")
	public EdatResult updateDeadMessage(TbMessage tbMessage) throws Exception {
		//设置过期状态
		tbMessage.setTmIsdead("1");
		int updateUser = tbMessageMapper.updateByPrimaryKeySelective(tbMessage);
		if(updateUser > 0){
			//创建日志对象
			return EdatResult.build(0, "修改成功", null, "修改系统通知成功（ID："+tbMessage.getTmId()+"）");
		}else{
			return EdatResult.build(1, "修改失败");
		}
	}

	//根据数据条数和用户id，查询数据列表
	@Override
	public EdatResult getMessageListByUserId(TbMessage tbMessage) {
		//分页查询条件
		int size = tbMessage.getPageSize();//每页条数
		int number = tbMessage.getPageNumber();//开始索引
		int page = (number / size) + 1;//当前页码
		
		//分页查询
		List<TbMessage> list = tbMessageMapper.getMessageListByUserId(tbMessage);
		
		//查询数据总条数
		int total = tbMessageMapper.totalByUserId(tbMessage);
		
		EdatResult result = EdatResult.build(list, page, total);
		return result;
	}
	
	

}
