package com.qgschina.main.resume.service;

import com.qgschina.main.resume.model.ResumeOtherInfo;

/**
 * Service - 补充信息
 * */
public interface ResumeOtherInfoService {
	/**
	 * 根据补充信息编号查找补充信息
	 * 
	 * @param id
	 *            补充信息编号
	 * */
	public ResumeOtherInfo queryById(int id);

	/**
	 * 根据补充信息编号删除补充信息
	 * 
	 * @param id
	 *            补充信息编号
	 * */
	public void disposeDelById(int id);

	/**
	 * 保存补充信息
	 * 
	 * @param resumeOtherInfo
	 *            待保存补充信息
	 * */
	public void disposeSave(ResumeOtherInfo resumeOtherInfo);

	/**
	 * 更新补充信息
	 * 
	 * @param resumeOtherInfo
	 *            待更新补充信息
	 * */
	public void disposeUpdate(ResumeOtherInfo resumeOtherInfo);
}
