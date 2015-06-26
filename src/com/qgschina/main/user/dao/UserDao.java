package com.qgschina.main.user.dao;

import com.qgschina.main.base.dao.BaseDao;
import com.qgschina.main.user.model.User;

/**
 * Dao - 微信用户
 * */
public interface UserDao extends BaseDao<User, Integer> {
	/**
	 * 根据微信帐号判断微信用户是否存在
	 * 
	 * @param openid
	 *            微信帐号
	 * */
	public boolean exist(String openid);

	/**
	 * 根据微信用户信息判断微信用户是否存在
	 * 
	 * @param user
	 *            微信用户
	 * */
	public boolean exist(User user);
}
