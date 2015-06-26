package com.qgschina.main.resume.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.qgschina.main.resume.model.ResumePersonInfo;
import com.qgschina.main.resume.service.ResumePersonalInfoService;
import com.qgschina.main.resume.service.ResumeService;

/**
 * Controller - 个人信息
 * */
@Controller
@RequestMapping("/resumePersonalInfo")
public class ResumePersonalInfoController {
	@Resource
	private ResumePersonalInfoService resumePersonalInfoService;
	@Resource
	private ResumeService resumeService;

	/**
	 * 保存个人信息
	 * 
	 * @param oldInputNum
	 *            修改(保存)之前填入的域的数量
	 * @param personInfo
	 *            待保存的个人信息
	 * */
	@RequestMapping("/savePersonalInfo.do")
	@ResponseBody
	public String savePersonInfo(int oldInputNum, ResumePersonInfo personInfo,
			HttpServletRequest request) {
		resumeService.disposeDealSavePersonInfo(personInfo);
		resumeService.disposeFeebBackInputNum(personInfo, oldInputNum);
		if (personInfo.getId() == 0) {
			resumePersonalInfoService.disposeSavePersonInfo(personInfo);
		} else {
			resumePersonalInfoService.disposeUpdatePersonInfo(personInfo);
		}
		return "success";
	}
}
