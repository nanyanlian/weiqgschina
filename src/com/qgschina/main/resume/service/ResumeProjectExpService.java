package com.qgschina.main.resume.service;

import com.qgschina.main.resume.model.ResumeProjectExp;

/**
 * Service - 项目经历
 * */
public interface ResumeProjectExpService {
	/**
	 * 根据项目经历编号查找项目经历信息
	 * 
	 * @param id
	 *            项目经历编号
	 * */
	public ResumeProjectExp disposeQueryById(int id);

	/**
	 * 保存项目经历
	 * 
	 * @param projectExp
	 *            待保存项目经历
	 * */
	public void disposeSave(ResumeProjectExp projectExp);

	/**
	 * 更新项目经历
	 * 
	 * @param projectExp
	 *            待更新项目经历
	 * */
	public void disposeUpdate(ResumeProjectExp projectExp);

	/**
	 * 根据项目经历编号删除项目经历信息
	 * 
	 * @param id
	 *            项目经历编号
	 * */
	public void disposeDelById(int id);
}
