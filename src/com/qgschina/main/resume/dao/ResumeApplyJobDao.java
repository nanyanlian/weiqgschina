package com.qgschina.main.resume.dao;

import com.qgschina.main.base.dao.BaseDao;
import com.qgschina.main.resume.model.ResumeApplyJob;

/**
 * Dao - 求职意向
 * */
public interface ResumeApplyJobDao extends BaseDao<ResumeApplyJob, Integer>{
	/**
	 * 根据简历编号查询求职意向信息
	 * 
	 * @param resumeId 简历编号
	 * */
	public ResumeApplyJob queryByResumeId(int resumeId);
	/**
	 * 查看该简历编号是否有求职意向
	 * 
	 * @param resumeId 简历编号
	 * */
	public boolean queryExist(int resumeId);
}
