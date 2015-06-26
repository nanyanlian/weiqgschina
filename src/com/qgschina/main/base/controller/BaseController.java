package com.qgschina.main.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Controller - 基础
 * */
@Controller
@RequestMapping("/base")
public class BaseController {

	/**
	 * 获取HttpServletRequest对象
	 * */
	public static HttpServletRequest getRequest() {
		System.out.println(RequestContextHolder.getRequestAttributes());
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		return request;
	}

	/**
	 * 获取HttpSession对象
	 * */
	public static HttpSession getSession() {
		return getRequest().getSession();
	}
}
