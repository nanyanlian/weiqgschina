package com.qgschina.main.resume.service;

import com.qgschina.main.resume.model.ResumeWorkExp;

/**
 * Service - 工作经验
 * */
public interface ResumeWorkExpService {
	/**
	 * 保存工作经验
	 * 
	 * @param workExp
	 *            待保存工作经验
	 * */
	public void disposeSave(ResumeWorkExp workExp);

	/**
	 * 根据工作经验编号查找工作经验信息
	 * 
	 * @param workExpId
	 *            工作经验编号
	 * */
	public ResumeWorkExp disposeQueryById(int workExpId);

	/**
	 * 更新工作经验
	 * 
	 * @param workExp
	 *            待更新工作经验
	 * */
	public void disposeUpdate(ResumeWorkExp workExp);

	/**
	 * 根据工作经验编号删除工作经验信息
	 * 
	 * @param workExpId
	 *            工作经验编号
	 * */
	public void disposeDeleteById(int id);

}
