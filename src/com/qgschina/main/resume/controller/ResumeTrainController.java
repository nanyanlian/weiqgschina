package com.qgschina.main.resume.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qgschina.main.resume.model.ResumeTrain;
import com.qgschina.main.resume.service.ResumeService;
import com.qgschina.main.resume.service.ResumeTrainService;

/**
 * Controller - 培训经历
 * */
@RequestMapping("/resumeTrain")
@Controller
public class ResumeTrainController {
	@Resource
	private ResumeTrainService resumeTrainService;
	@Resource
	private ResumeService resumeService;

	
	/**
	 * 保存培训经历
	 * 
	 * @param oldInputNum
	 *            编辑或保存前,现有语言能力的输入域的最大数
	 * @param train
	 *            待保存的培训经历
	 * */
	@RequestMapping("/saveTrain.do")
	@ResponseBody
	public String saveTrain(int oldInputNum, ResumeTrain train) {
		if (train.getId() == 0) {
			resumeTrainService.disposeSave(train);
		} else {
			resumeTrainService.disposeUpdate(train);
		}
		resumeService.disposeFeebBackInputNum(train, oldInputNum);
		return "success";
	}

	/**
	 * 删除培训经历
	 * 
	 * @param resumeId
	 *            简历编号
	 * @param trainId
	 *            培训经历编号
	 * */
	@RequestMapping("/delTrain.do")
	@ResponseBody
	public String delTrain(int trainId, int resumeId) {
		resumeService.disposeFeebBackInputNum(resumeId, trainId,
				new ResumeTrain());
		resumeTrainService.disposeDelById(trainId);
		return "success";
	}
}
