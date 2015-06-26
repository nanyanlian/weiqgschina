package com.qgschina.main.resume.service;

import java.util.List;

import com.qgschina.main.resume.model.ResumeTrain;

/**
 * Service - 培训经历
 * */
public interface ResumeTrainService {
	/**
	 * 保存培训经历
	 * 
	 * @param train
	 *            待保存培训经历
	 * */
	public void disposeSave(ResumeTrain train);

	/**
	 * 更新培训经历
	 * 
	 * @param train
	 *            待更新培训经历
	 * */
	public void disposeUpdate(ResumeTrain train);

	/**
	 * 根据培训经历编号查询培训经历
	 * 
	 * @param id
	 *            培训经历编号
	 * */
	public ResumeTrain disposeQueryById(int id);

	/**
	 * 根据简历编号查询培训经历
	 * 
	 * @param resumeId
	 *            简历
	 * */
	public List<ResumeTrain> disposeQueryByResumeId(int resumeId);

	/**
	 * 根据培训经历编号删除培训经历
	 * 
	 * @param id
	 *            培训经历编号
	 * */
	public void disposeDelById(int id);
}
