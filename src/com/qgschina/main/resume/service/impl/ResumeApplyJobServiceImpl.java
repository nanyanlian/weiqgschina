package com.qgschina.main.resume.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qgschina.main.resume.dao.ResumeApplyJobDao;
import com.qgschina.main.resume.model.ResumeApplyJob;
import com.qgschina.main.resume.service.ResumeApplyJobService;

/**
 * Service - 求职意向
 * */
@Service("/resumeApplyJobService")
public class ResumeApplyJobServiceImpl implements ResumeApplyJobService{
	@Resource
	private ResumeApplyJobDao resumeApplyJobDao;

	/**
	 * 保存求职意向
	 * 
	 * @param applyJob
	 *            待保存求职意向
	 * */
	public void disposeSaveApplyJob(ResumeApplyJob applyJob) {
		resumeApplyJobDao.save(applyJob);
	}

	/**
	 * 更新求职意向
	 * 
	 * @param applyJob
	 *            待更新求职意向
	 * */
	public void disposeUpdateApplyJob(ResumeApplyJob applyJob) {
		resumeApplyJobDao.update(applyJob);
	}

	/**
	 * 根据简历编号查找对应的求职意向
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public ResumeApplyJob disposeQueryByResumeId(int resumeId) {
		return resumeApplyJobDao.queryByResumeId(resumeId);
	}

	/**
	 * 根据简历编号查找是否存在求职意向
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public boolean disposeExist(int resumeId) {
		return resumeApplyJobDao.queryExist(resumeId);
	}
}
