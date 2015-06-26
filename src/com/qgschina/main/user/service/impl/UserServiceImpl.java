package com.qgschina.main.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qgschina.main.user.dao.UserDao;
import com.qgschina.main.user.model.User;
import com.qgschina.main.user.service.UserService;

/**
 * Service - 微信用户
 * */
@Service("/userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	/**
	 * 将用户信息持久化到数据库中,并返回
	 * 
	 * @param user
	 *            进入微网站的微信用户
	 * */
	public User disposeDealLogin(User user) {
		if (!userDao.exist(user)) {
			int id = userDao.save(user);
			user.setId(id);
		}
		return user;
	}
}
