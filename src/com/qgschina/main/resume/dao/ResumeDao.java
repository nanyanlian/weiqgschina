package com.qgschina.main.resume.dao;

import java.util.List;
import java.util.Map;

import com.qgschina.main.base.dao.BaseDao;
import com.qgschina.main.resume.model.Resume;
import com.qgschina.main.resume.model.ResumePersonInfo;

/**
 * Dao - 简历
 * */
public interface ResumeDao extends BaseDao<Resume, Integer> {
	/**
	 * 获取微信号为openid的用户的所有简历
	 * 
	 * @param openid
	 *            微信号
	 * */
	public List<Resume> listByOpenId(String openid);

	/**
	 * 根据简历编号删除简历
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public void deleteById(int resumeId);

	/**
	 * 修改简历字段
	 * 
	 * @param personInfo
	 *            简历个人信息
	 * @param map
	 *            修改的键值对
	 * */
	public void changeResumeField(ResumePersonInfo personInfo,
			Map<String, Object> map);

	/**
	 * 修改简历字段
	 * 
	 * @param id
	 *            简历编号
	 * @param map
	 *            修改的键值对
	 * */
	public void changeResumeField(int id, Map<String, Object> map);
}
