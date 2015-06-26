package com.qgschina.main.user.service;

import com.qgschina.main.user.model.User;

/**
 * Service - 微信用户
 * */
public interface UserService {
	/**
	 * 将用户信息持久化到数据库中,并返回
	 * 
	 * @param user
	 *            进入微网站的微信用户
	 * */
	public User disposeDealLogin(User user);
}
