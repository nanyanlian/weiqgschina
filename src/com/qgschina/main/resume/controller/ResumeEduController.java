package com.qgschina.main.resume.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qgschina.main.resume.model.ResumeEdu;
import com.qgschina.main.resume.service.ResumeEduService;
import com.qgschina.main.resume.service.ResumeService;

/**
 * Controller - 简历教育经历
 * */
@Controller
@RequestMapping("/resumeEdu")
public class ResumeEduController {
	@Resource
	private ResumeEduService resumeEduService;
	@Resource
	private ResumeService resumeService;

	/**
	 * 删除教育经历
	 * 
	 * @param resumeId
	 *            简历编号
	 * @param eduId
	 *            教育经历编号
	 * */
	@RequestMapping("/delEdu")
	public String delEdu(int resumeId, int eduId) {
		resumeService.disposeFeebBackInputNum(resumeId, eduId, new ResumeEdu());
		resumeEduService.disposeDelById(eduId);
		return "success";
	}

	/**
	 * 保存教育经历
	 * 
	 * @param oldInputNum
	 *            编辑或保存前,现有教育经历的输入域的最大数
	 * @param resumeEdu
	 *            待保存的教育经历
	 * @param mode
	 *            模式 add或edit
	 * */
	@RequestMapping("/saveEdu.do")
	public String saveEdu(int oldInputNum, String mode, ResumeEdu resumeEdu) {
		if (mode.equals("add")) {
			resumeEduService.disposeSave(resumeEdu);
		} else if (mode.equals("edit")) {
			resumeEduService.disposeUpdate(resumeEdu);
		}
		resumeService.disposeFeebBackInputNum(resumeEdu, oldInputNum);
		return "success";
	}
}
