package com.qgschina.main.resume.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qgschina.main.resume.dao.ResumeLanguageDao;
import com.qgschina.main.resume.model.ResumeLanguage;
import com.qgschina.main.resume.service.ResumeLanguageService;

/**
 * Service - 语言能力
 * */
@Service("/resumeLanguageServie")
public class ResumeLanguageServiceImpl  
	implements ResumeLanguageService {
	@Resource
	private ResumeLanguageDao resumeLanguageDao;

	/**
	 * 根据语言能力编号删除语言能力信息
	 * 
	 * @param id
	 *            语言能力编号
	 * */
	public void disposeDelById(int id) {
		resumeLanguageDao.deleteById(id);
	}

	/**
	 * 根据语言能力编号查找语言能力
	 * 
	 * @param id
	 *            语言能力编号
	 * */
	public ResumeLanguage disposeQueryById(int id) {
		return resumeLanguageDao.get(id);
	}

	/**
	 * 保存语言能力信息
	 * 
	 * @param language
	 *            待保存语言能力信息
	 * */
	public void disposeSave(ResumeLanguage language) {
		resumeLanguageDao.save(language);
	}

	/**
	 * 更新语言能力信息
	 * 
	 * @param language
	 *            待更新语言能力信息
	 * */
	public void disposeUpdate(ResumeLanguage language) {
		resumeLanguageDao.update(language);
	}
}
