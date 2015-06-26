package com.qgschina.main.resume.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qgschina.main.resume.model.ResumeLanguage;
import com.qgschina.main.resume.service.ResumeLanguageService;
import com.qgschina.main.resume.service.ResumeService;

/**
 * Controller - 语言能力
 * */
@Controller
@RequestMapping("/resumeLanguage")
public class ResumeLanguageController {
	@Resource
	private ResumeLanguageService resumeLanguageService;
	@Resource
	private ResumeService resumeService;

	/**
	 * 保存语言能力
	 * 
	 * @param oldInputNum
	 *            编辑或保存前,现有语言能力的输入域的最大数
	 * @param language
	 *            待保存的语言能力
	 * */
	@RequestMapping("/saveLanguage.do")
	@ResponseBody
	public String saveLanguage(int oldInputNum, ResumeLanguage language) {
		if (language.getId() == 0) {
			resumeLanguageService.disposeSave(language);
		} else {
			resumeLanguageService.disposeUpdate(language);
		}
		resumeService.disposeFeebBackInputNum(language, oldInputNum);
		return "success";
	}

	/**
	 * 删除语言能力
	 * 
	 * @param resumeId
	 *            简历编号
	 * @param languageId
	 *            语言能力编号
	 * */
	@RequestMapping("/delLanguage.do")
	@ResponseBody
	public String deleteLanguage(int resumeId, int languageId) {
		resumeService.disposeFeebBackInputNum(resumeId, languageId,
				new ResumeLanguage());
		resumeLanguageService.disposeDelById(languageId);
		return "success";
	}
}
