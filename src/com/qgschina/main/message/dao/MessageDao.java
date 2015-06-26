package com.qgschina.main.message.dao;

import com.qgschina.main.message.model.Message;

/**
 * Dao - 文章内容
 * */
public interface MessageDao {
	/**
	 * 根据模块编号查找内容
	 * 
	 * @param moduleId
	 *            模块编号
	 * */
	public Message queryMessageByModuleId(int moduleId);
}
