package com.qgschina.main.message.service;

import com.qgschina.main.message.model.Message;
import com.qgschina.main.module.model.Module;

/**
 * Service - 文章内容
 * */
public interface MessageService {
	/**
	 * 根据模块信息查找内容
	 * 
	 * @param module
	 *            模块信息
	 * */
	public Message disposeQueryMessageByModuleId(Module module);
}
