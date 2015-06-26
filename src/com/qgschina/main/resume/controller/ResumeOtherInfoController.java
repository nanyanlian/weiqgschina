package com.qgschina.main.resume.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qgschina.main.resume.model.ResumeOtherInfo;
import com.qgschina.main.resume.service.ResumeOtherInfoService;
import com.qgschina.main.resume.service.ResumeService;

/**
 * Controller - 补充信息
 * */
@Controller
@RequestMapping("/resumeOtherInfo")
public class ResumeOtherInfoController {
	@Resource
	private ResumeOtherInfoService resumeOtherInfoService;
	@Resource
	private ResumeService resumeService;

	/**
	 * 删除补充信息
	 * 
	 * @param resumeId
	 *            简历编号
	 * @param otherInfoId
	 *            补充信息编号
	 * */
	@RequestMapping("/deleteOtherInfo.do")
	@ResponseBody
	public String deleteOtherInfo(int resumeId, int otherInfoId) {
		resumeService.disposeFeebBackInputNum(resumeId, otherInfoId,
				new ResumeOtherInfo());
		resumeOtherInfoService.disposeDelById(otherInfoId);
		return "success";
	}

	/**
	 * 保存补充信息
	 * 
	 * @param oldInputNum
	 *            编辑或保存前,现有语言能力的输入域的最大数
	 * @param resumeOtherInfo
	 *            待保存的补充信息
	 * */
	@RequestMapping("/saveOtherInfo.do")
	@ResponseBody
	public String saveOtherInfo(ResumeOtherInfo resumeOtherInfo, int oldInputNum) {
		if (resumeOtherInfo.getId() == 0) {
			resumeOtherInfoService.disposeSave(resumeOtherInfo);
		} else {
			resumeOtherInfoService.disposeUpdate(resumeOtherInfo);
		}
		resumeService.disposeFeebBackInputNum(resumeOtherInfo, oldInputNum);
		return "success";
	}
}
