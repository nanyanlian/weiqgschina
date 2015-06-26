package com.qgschina.main.resume.dao;

import java.util.List;

import com.qgschina.main.base.dao.BaseDao;
import com.qgschina.main.resume.model.ResumeTrain;

/**
 * Dao - 培训经历
 * */
public interface ResumeTrainDao extends BaseDao<ResumeTrain, Integer> {
	/**
	 * 根据简历编号查询培训经历列表
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public List<ResumeTrain> queryByResumeId(int resumeId);

	/**
	 * 根据简历培训经历编号删除培训经历
	 * 
	 * @param id
	 *            简历培训经历编号
	 * */
	public void deleteById(int id);

}
