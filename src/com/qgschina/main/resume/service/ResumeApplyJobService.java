package com.qgschina.main.resume.service;

import com.qgschina.main.resume.model.ResumeApplyJob;

/**
 * Service - 求职意向
 * */
public interface ResumeApplyJobService {
	/**
	 * 保存求职意向
	 * 
	 * @param applyJob
	 *            待保存求职意向
	 * */
	public void disposeSaveApplyJob(ResumeApplyJob applyJob);

	/**
	 * 更新求职意向
	 * 
	 * @param applyJob
	 *            待更新求职意向
	 * */
	public void disposeUpdateApplyJob(ResumeApplyJob applyJob);

	/**
	 * 根据简历编号查找对应的求职意向
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public ResumeApplyJob disposeQueryByResumeId(int resumeId);

	/**
	 * 根据简历编号查找是否存在求职意向
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public boolean disposeExist(int resumeId);

}
