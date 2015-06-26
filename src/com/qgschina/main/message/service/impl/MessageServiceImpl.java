package com.qgschina.main.message.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qgschina.main.message.dao.MessageDao;
import com.qgschina.main.message.model.Message;
import com.qgschina.main.message.service.MessageService;
import com.qgschina.main.module.model.Module;

/**
 * Service - 文章内容
 * */
@Service("/messageService")
public class MessageServiceImpl implements
		MessageService {
	@Resource
	private MessageDao messageDao;
	
	/**
	 * 根据模块信息查找内容
	 * 
	 * @param module
	 *            模块信息
	 * */
	public Message disposeQueryMessageByModuleId(Module module) {
		return messageDao.queryMessageByModuleId(module.getId());
	}

}
