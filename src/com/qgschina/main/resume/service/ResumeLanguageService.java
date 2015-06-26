package com.qgschina.main.resume.service;

import com.qgschina.main.resume.model.ResumeLanguage;

/**
 * Service - 语言能力
 * */
public interface ResumeLanguageService {
	/**
	 * 根据语言能力编号删除语言能力信息
	 * 
	 * @param id
	 *            语言能力编号
	 * */
	public void disposeDelById(int id);

	/**
	 * 根据语言能力编号查找语言能力
	 * 
	 * @param id
	 *            语言能力编号
	 * */
	public ResumeLanguage disposeQueryById(int id);

	/**
	 * 保存语言能力信息
	 * 
	 * @param language
	 *            待保存语言能力信息
	 * */
	public void disposeSave(ResumeLanguage language);

	/**
	 * 更新语言能力信息
	 * 
	 * @param language
	 *            待更新语言能力信息
	 * */
	public void disposeUpdate(ResumeLanguage language);
}
