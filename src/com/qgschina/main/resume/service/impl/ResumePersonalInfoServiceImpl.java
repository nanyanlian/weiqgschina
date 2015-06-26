package com.qgschina.main.resume.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qgschina.main.resume.dao.ResumePersonInfoDao;
import com.qgschina.main.resume.model.ResumePersonInfo;
import com.qgschina.main.resume.service.ResumePersonalInfoService;

/**
 * Service - 个人信息
 * */
@Service("/resumePersonalInfoService")
public class ResumePersonalInfoServiceImpl implements ResumePersonalInfoService {
	@Resource
	private ResumePersonInfoDao resumePersonInfoDao;

	/**
	 * 保存用户个人信息
	 * 
	 * @param personInfo
	 *            待保存个人信息
	 * */
	public void disposeSavePersonInfo(ResumePersonInfo personInfo) {
		resumePersonInfoDao.save(personInfo);
	}

	/**
	 * 根据简历编号查找个人信息
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public ResumePersonInfo disposeQueryByResumeId(int resumeId) {
		return resumePersonInfoDao.queryByResumeId(resumeId);
	}

	/**
	 * 更新用户个人信息
	 * 
	 * @param personInfo
	 *            待更新个人信息
	 * */
	public void disposeUpdatePersonInfo(ResumePersonInfo personInfo) {
		resumePersonInfoDao.update(personInfo);
	}

	/**
	 * 根据简历编号查找个人信息是否存在
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public boolean disposeExist(int resumeId) {
		return resumePersonInfoDao.queryExist(resumeId);
	}
}
