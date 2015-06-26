package com.qgschina.main.resume.dao;

import java.util.List;

import com.qgschina.main.base.dao.BaseDao;
import com.qgschina.main.resume.model.ResumeWorkExp;

/**
 * Dao - 工作经验
 * */
public interface ResumeWorkExpDao extends BaseDao<ResumeWorkExp, Integer> {
	/**
	 * 根据简历编号查询工作经验列表
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public List<ResumeWorkExp> queryByResumeId(int resumeId);

	/**
	 * 根据简历工作经验编号删除工作经验
	 * 
	 * @param id
	 *            简历工作经验编号
	 * */
	public void deleteById(int id);
}
