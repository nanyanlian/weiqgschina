package com.qgschina.main.message.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller - 文章内容
 * */
@Controller
@RequestMapping("/message")
public class MessageController {

	/**
	 * 进入文章内容内页
	 * */
	@RequestMapping("/iframeInfoPage.do")
	public ModelAndView iframeInfoPage() {
		return new ModelAndView("common/iframeInfoPage");
	}
}
