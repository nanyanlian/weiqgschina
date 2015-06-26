package com.qgschina.main.message.dao.impl;

import java.util.Map;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.qgschina.main.base.dao.impl.BaseDaoImpl;
import com.qgschina.main.message.dao.MessageDao;
import com.qgschina.main.message.model.Message;

/**
 * Dao - 文章内容
 * */
@SuppressWarnings("unchecked")
@Repository("/messageDao")
public class MessageDaoImpl extends BaseDaoImpl<Message, Integer> implements
		MessageDao {
	/**
	 * 根据模块编号查找内容
	 * 
	 * @param moduleId
	 *            模块编号
	 * */
	public Message queryMessageByModuleId(int moduleId) {
		String hql = "from Message where moduleId =:moduleId ";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("moduleId", moduleId);
		return (Message) find(hql, map).get(0);
	}

}
