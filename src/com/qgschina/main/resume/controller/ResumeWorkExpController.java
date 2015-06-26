package com.qgschina.main.resume.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qgschina.main.resume.model.ResumeWorkExp;
import com.qgschina.main.resume.service.ResumeService;
import com.qgschina.main.resume.service.ResumeWorkExpService;

/**
 * Controller - 工作经验
 * */
@Controller
@RequestMapping("/resumeWorkExp")
public class ResumeWorkExpController {
	@Resource
	private ResumeWorkExpService resumeWorkExpService;
	@Resource
	private ResumeService resumeService;

	/**
	 * 删除工作经验
	 * 
	 * @param resumeId
	 *            简历编号
	 * @param workExpId
	 *            工作经验编号
	 * */
	@RequestMapping("/delWorkExp.do")
	public String delWorkExp(int resumeId, int workExpId) {
		resumeService.disposeFeebBackInputNum(resumeId, workExpId,
				new ResumeWorkExp());
		resumeWorkExpService.disposeDeleteById(workExpId);
		return "success";
	}

	/**
	 * 保存工作经验
	 * 
	 * @param oldInputNum
	 *            编辑或保存前,现有语言能力的输入域的最大数
	 * @param workExp
	 *            待保存的工作经验
	 * */
	@RequestMapping("/saveWorkExp.do")
	public String saveWorkExp(int oldInputNum, ResumeWorkExp workExp) {
		if (workExp.getId() == 0) {
			resumeWorkExpService.disposeSave(workExp);
		} else {
			resumeWorkExpService.disposeUpdate(workExp);
		}
		resumeService.disposeFeebBackInputNum(workExp, oldInputNum);
		return "success";
	}

}
