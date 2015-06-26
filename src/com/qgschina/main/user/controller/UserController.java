package com.qgschina.main.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.nyl.wxframework.exception.WechatInterfaceException;
import org.nyl.wxframework.task.usermanager.UserManagerFactory;
import org.nyl.wxframework.task.usermanager.support.OauthUserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qgschina.main.user.model.User;
import com.qgschina.main.user.service.UserService;

/**
 * Controller - 微信用户
 * */
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;

	/**
	 * 用户进入微网站时候获取用户信息
	 * 
	 * @param code
	 *            微信oauth_code
	 * */
	@RequestMapping("/userEnter.do")
	public void userEnter(String code, HttpSession session) {
		try {
			OauthUserInfo oauthUserInfo = UserManagerFactory
					.getUserInfo(UserManagerFactory.getOauthTokenByCode(code));
			User user = new User(oauthUserInfo);
			System.out.println( user.getNickname() );
			userService.disposeDealLogin(user);
			session.setAttribute("user", user);
		} catch (WechatInterfaceException e) {
			e.printStackTrace();
			User user = new User();
			user.setOpenid("oyF3Yjomj3NikCIIWpY8i5Ea-IF0");
			session.setAttribute("user", user);
		}
	}
}
