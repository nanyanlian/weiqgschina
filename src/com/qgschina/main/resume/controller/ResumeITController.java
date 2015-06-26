package com.qgschina.main.resume.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qgschina.main.resume.model.ResumeIT;
import com.qgschina.main.resume.service.ResumeITService;
import com.qgschina.main.resume.service.ResumeService;

/**
 * Controller - IT技能
 * */
@Controller
@RequestMapping("/resumeIT")
public class ResumeITController {
	@Resource
	private ResumeITService resumeITService;
	@Resource
	private ResumeService resumeService;

	/**
	 * 删除IT技能
	 * 
	 * @param resumeId
	 *            简历编号
	 * @param ITId
	 *            IT技能编号
	 * */
	@RequestMapping("/deleteIT.do")
	@ResponseBody
	public String deleteIT(int resumeId, int ITId) {
		resumeService.disposeFeebBackInputNum(resumeId, ITId, new ResumeIT());
		resumeITService.disposeDelById(ITId);
		return "success";
	}

	/**
	 * 保存IT技能
	 * 
	 * @param oldInputNum
	 *            编辑或保存前,现有IT技能的输入域的最大数
	 * @param IT
	 *            待保存的IT技能
	 * */
	@RequestMapping("/saveIT.do")
	@ResponseBody
	public String saveIT(int oldInputNum, ResumeIT IT) {
		if (IT.getId() == 0) {
			resumeITService.disposeSaveIT(IT);
		} else {
			resumeITService.disposeUpdateIT(IT);
		}
		resumeService.disposeFeebBackInputNum(IT, oldInputNum);
		return "success";
	}

}
