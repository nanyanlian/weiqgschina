package com.qgschina.main.employ.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qgschina.main.employ.model.Employ;
import com.qgschina.main.employ.service.EmployService;

/**
 * Controller - 招聘信息
 * */
@Controller
@RequestMapping("/employ")
public class EmployController {
	@Resource
	private EmployService employService;

	/**
	 * 打开招聘列表页面
	 * */
	@RequestMapping("/toEmployList.do")
	public String toEmployList(HttpServletRequest request) {
		List<Employ> employList = employService.disposeQueryAllEmploy();
		request.setAttribute("employList", employList);
		return "employ/employList";
	}

	/**
	 * 打开招聘职位详细信息页
	 * 
	 * @param employId
	 *            职位编号
	 * */
	@RequestMapping("/lookEmployInfo.do")
	public String lookEmployInfo(HttpServletRequest request, int employId) {
		Employ employ = employService.disposeEmployById(employId);
		request.setAttribute("employ", employ);
		return "employ/employInfo";
	}
}
