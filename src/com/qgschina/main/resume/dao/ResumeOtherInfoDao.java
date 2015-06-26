package com.qgschina.main.resume.dao;

import java.util.List;

import com.qgschina.main.base.dao.BaseDao;
import com.qgschina.main.resume.model.ResumeOtherInfo;

/**
 * Dao - 补充信息
 * */
public interface ResumeOtherInfoDao extends BaseDao<ResumeOtherInfo, Integer> {
	/**
	 * 根据简历编号查询补充信息列表
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public List<ResumeOtherInfo> queryByResumeId(int resumeId);
	/**
	 * 根据简历补充信息编号删除补充信息
	 * 
	 * @param id
	 *            简历补充信息编号
	 * */
	public void deleteById(int id);
}
