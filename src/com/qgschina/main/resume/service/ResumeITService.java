package com.qgschina.main.resume.service;

import com.qgschina.main.resume.model.ResumeIT;

/**
 * Service - IT技能
 * */
public interface ResumeITService {
	/**
	 * 根据IT技能编号查找IT技能信息
	 * 
	 * @param id
	 *            IT技能编号
	 * */
	public ResumeIT disposeQueryById(int id);

	/**
	 * 保存IT技能信息
	 * 
	 * @param IT
	 *            待保存IT技能信息
	 * */
	public void disposeSaveIT(ResumeIT iT);

	/**
	 * 更新IT技能信息
	 * 
	 * @param IT
	 *            待更新IT技能信息
	 * */
	public void disposeUpdateIT(ResumeIT iT);

	/**
	 * 根据IT技能编号删除IT技能信息
	 * 
	 * @param id
	 *            IT技能编号
	 * */
	public void disposeDelById(int id);
}
