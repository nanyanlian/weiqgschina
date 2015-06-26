package com.qgschina.main.resume.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qgschina.main.resume.model.ResumeProjectExp;
import com.qgschina.main.resume.service.ResumeProjectExpService;
import com.qgschina.main.resume.service.ResumeService;

/**
 * Controller - 项目经验
 * */
@Controller
@RequestMapping("/resumeProjectExp")
public class ResumeProjectExpController {
	@Resource
	private ResumeProjectExpService resumeProjectExpService;
	@Resource
	private ResumeService resumeService;

	/**
	 * 删除项目经验
	 * 
	 * @param resumeId
	 *            简历编号
	 * @param projectExpId
	 *            项目经验编号
	 * */
	@RequestMapping("/deleteProjectExp.do")
	@ResponseBody
	public String deleteProjectExp(int resumeId, int projectExpId,
			HttpServletResponse response, PrintWriter out) {
		resumeService.disposeFeebBackInputNum(resumeId, projectExpId,
				new ResumeProjectExp());
		resumeProjectExpService.disposeDelById(projectExpId);
		return "success";
	}

	/**
	 * 保存项目经验
	 * 
	 * @param oldInputNum
	 *            编辑或保存前,现有语言能力的输入域的最大数
	 * @param projectExp
	 *            待保存的项目经验
	 * */
	@RequestMapping("/saveProjectExp.do")
	@ResponseBody
	public String saveProjectExp(int oldInputNum, ResumeProjectExp projectExp,
			HttpServletResponse response, PrintWriter out) {
		if (projectExp.getId() == 0) {
			resumeProjectExpService.disposeSave(projectExp);
		} else {
			resumeProjectExpService.disposeUpdate(projectExp);
		}
		resumeService.disposeFeebBackInputNum(projectExp, oldInputNum);
		return "success";
	}
}
