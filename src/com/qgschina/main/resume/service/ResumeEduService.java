package com.qgschina.main.resume.service;

import com.qgschina.main.resume.model.ResumeEdu;

/**
 * Service - 教育经历
 * */
public interface ResumeEduService {
	/**
	 * 保存教育经历
	 * 
	 * @param resumeEdu
	 *            待保存教育经历
	 * */
	public void disposeSave(ResumeEdu resumeEdu);

	/**
	 * 更新教育经历
	 * 
	 * @param resumeEdu
	 *            待更新教育经历
	 * */
	public void disposeUpdate(ResumeEdu resumeEdu);

	/**
	 * 根据教育经历编号查找教育经历信息
	 * 
	 * @param eduId
	 *            教育经历编号
	 * */
	public ResumeEdu disposeQueryEduById(int eduId);

	/**
	 * 根据教育经历编号删除教育经历对象
	 * 
	 * @param id
	 *            教育经历编号
	 * */
	public void disposeDelById(int id);

}
