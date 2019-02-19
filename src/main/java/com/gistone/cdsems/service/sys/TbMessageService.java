package com.gistone.cdsems.service.sys;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gistone.cdsems.aspect.MyPermission;
import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.database.entity.TbMessage;
import com.gistone.cdsems.util.EdatResult;

@Service
public interface TbMessageService {


	@MyPermission(module="138")
	EdatResult list(TbMessage tbMessage)throws Exception;

	@MyPermission(module="139")
	EdatResult saveMessage(TbMessage tbMessage)throws Exception;

	//根据id查询用户
	TbMessage getMessageByID(TbMessage tbMessage)throws Exception;

	@MyPermission(module="140")
	EdatResult updateMessage(TbMessage tbMessage)throws Exception;

	@MyPermission(module="141")
	EdatResult deleteMessage(TbMessage tbMessage)throws Exception;

	EdatResult listAll() throws Exception;

	//设置消息过期
	@MyPermission(module="142")
	EdatResult updateDeadMessage(TbMessage tbMessage) throws Exception;

	//根据数据条数和用户id，查询列表
	EdatResult getMessageListByUserId(TbMessage tbMessage);


}
