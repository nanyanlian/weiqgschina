package com.qgschina.main.resume.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.qgschina.main.resume.model.ResumeApplyJob;
import com.qgschina.main.resume.service.ResumeApplyJobService;
import com.qgschina.main.resume.service.ResumeService;

/**
 * Controller - 简历求职意向
 * */
@Controller
@RequestMapping("/resumeApplyJob")
public class ResumeApplyJobController {
	@Resource
	private ResumeApplyJobService resumeApplyJobService;
	@Resource
	private ResumeService resumeService;

	/**
	 * 保存求职意向
	 * 
	 * @param oldInputNum
	 *            修改(保存)之前填入的域的数量
	 * @param applyJob
	 *            待保存的求职意向
	 * */
	@RequestMapping("/saveApplyJob.do")
	@ResponseBody
	public String saveApplyJob(int oldInputNum, ResumeApplyJob applyJob,
			HttpServletRequest request) {
		resumeService.disposeFeebBackInputNum(applyJob, oldInputNum);
		if (applyJob.getId() == 0) {
			resumeApplyJobService.disposeSaveApplyJob(applyJob);
		} else {
			resumeApplyJobService.disposeUpdateApplyJob(applyJob);
		}
		return "success";
	}

}
