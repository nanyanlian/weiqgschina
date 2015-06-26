package com.qgschina.main.resume.dao;

import java.util.List;

import com.qgschina.main.base.dao.BaseDao;
import com.qgschina.main.resume.model.ResumeIT;

/**
 * Dao - IT技能
 * */
public interface ResumeITDao extends BaseDao<ResumeIT, Integer> {
	/**
	 * 根据简历编号查询IT技能列表
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public List<ResumeIT> queryByResumeId(int resumeId);
	/**
	 * 根据简历IT技能编号删除IT技能
	 * 
	 * @param id
	 *            简历IT技能编号
	 * */
	public void deleteById(int id);
}
