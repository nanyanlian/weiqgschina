package com.qgschina.main.resume.service;

import com.qgschina.main.resume.model.ResumePersonInfo;

/**
 * Service - 个人信息
 * */
public interface ResumePersonalInfoService {
	/**
	 * 保存用户个人信息
	 * 
	 * @param personInfo
	 *            待保存个人信息
	 * */
	public void disposeSavePersonInfo(ResumePersonInfo personInfo);

	/**
	 * 根据简历编号查找个人信息
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public ResumePersonInfo disposeQueryByResumeId(int resumeId);

	/**
	 * 更新用户个人信息
	 * 
	 * @param personInfo
	 *            待更新个人信息
	 * */
	public void disposeUpdatePersonInfo(ResumePersonInfo personInfo);

	/**
	 * 根据简历编号查找个人信息是否存在
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public boolean disposeExist(int resumeId);

}
