package com.qgschina.main.resume.dao;

import java.util.List;

import com.qgschina.main.base.dao.BaseDao;
import com.qgschina.main.resume.model.ResumeLanguage;

/**
 * Dao - 语言能力
 * */
public interface ResumeLanguageDao extends BaseDao<ResumeLanguage, Integer> {
	/**
	 * 根据简历语言能力编号删除语言能力
	 * 
	 * @param id
	 *            简历语言能力编号
	 * */
	public void deleteById(int id);
	/**
	 * 根据简历编号查询语言能力列表
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public List<ResumeLanguage> queryByResumeId(int resumeId);
}
