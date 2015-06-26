package com.qgschina.main.user.dao.impl;

import java.util.Map;

import net.sf.ehcache.store.chm.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.qgschina.main.base.dao.impl.BaseDaoImpl;
import com.qgschina.main.user.dao.UserDao;
import com.qgschina.main.user.model.User;

/**
 * Dao - 微信用户
 * */
@Repository("/userDao")
@SuppressWarnings("unchecked")
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {
	/**
	 * 根据微信用户信息判断微信用户是否存在
	 * 
	 * @param user
	 *            微信用户
	 * */
	public boolean exist(User user) {
		return exist(user.getOpenid());
	}

	/**
	 * 根据微信帐号判断微信用户是否存在
	 * 
	 * @param openid
	 *            微信帐号
	 * */
	public boolean exist(String openid) {
		String hql = "from User where openid =:openid";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("openid", openid);
		return exist(hql, map);
	}

}
