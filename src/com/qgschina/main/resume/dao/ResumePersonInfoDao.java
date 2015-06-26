package com.qgschina.main.resume.dao;

import com.qgschina.main.base.dao.BaseDao;
import com.qgschina.main.resume.model.ResumePersonInfo;

/**
 * Dao - 个人信息
 * */
public interface ResumePersonInfoDao extends BaseDao<ResumePersonInfo, Integer> {
	/**
	 * 根据简历编号查询个人信息
	 * 
	 * @param resumeId 简历编号
	 * */
	public ResumePersonInfo queryByResumeId(int resumeId);
	/**
	 * 查看该简历编号是否有个人信息
	 * 
	 * @param resumeId 简历编号
	 * */
	public boolean queryExist(int resumeId);
}
