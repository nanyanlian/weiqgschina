package com.qgschina.main.resume.dao;

import java.util.List;

import com.qgschina.main.base.dao.BaseDao;
import com.qgschina.main.resume.model.ResumeProjectExp;

/**
 * Dao - 项目经验
 * */
public interface ResumeProjectExpDao extends BaseDao<ResumeProjectExp, Integer> {
	/**
	 * 根据简历编号查询项目经验列表
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public List<ResumeProjectExp> queryByResumeId(int resumeId);
	/**
	 * 根据简历项目经验编号删除项目经验
	 * 
	 * @param id
	 *            简历项目经验编号
	 * */
	public void deleteById(int id);
}
