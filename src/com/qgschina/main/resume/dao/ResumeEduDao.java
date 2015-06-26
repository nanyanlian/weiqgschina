package com.qgschina.main.resume.dao;

import java.util.List;

import com.qgschina.main.base.dao.BaseDao;
import com.qgschina.main.resume.model.ResumeEdu;

/**
 * Dao - 简历教育经历
 * */
public interface ResumeEduDao extends BaseDao<ResumeEdu, Integer> {
	/**
	 * 根据简历编号查询教育经历列表
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public List<ResumeEdu> queryByResumeId(int resumeId);
	/**
	 * 根据简历教育经历编号删除教育经历
	 * 
	 * @param id
	 *            简历教育经历编号
	 * */
	public void deleteById(int id);

}
