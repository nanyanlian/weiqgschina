package com.qgschina.main.resume.dao.impl;

import java.util.List;
import java.util.Map;

import net.sf.ehcache.store.chm.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.qgschina.main.base.dao.impl.BaseDaoImpl;
import com.qgschina.main.resume.dao.ResumePersonInfoDao;
import com.qgschina.main.resume.model.ResumePersonInfo;

/**
 * Dao - 个人信息
 * */
@SuppressWarnings("unchecked")
@Repository("/resumePersonalDao")
public class ResumePersonInfoDaoImpl extends
		BaseDaoImpl<ResumePersonInfo, Integer> implements ResumePersonInfoDao {

	/**
	 * 根据简历编号查询个人信息
	 * 
	 * @param resumeId 简历编号
	 * */
	@SuppressWarnings("rawtypes")
	public ResumePersonInfo queryByResumeId(int resumeId) {
		String hql = "from ResumePersonInfo where resumeId = :resumeId";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("resumeId", resumeId);
		List list = find(hql, map);
		if (list != null && list.size() != 0)
			return (ResumePersonInfo) list.get(0);
		return null;
	}

	/**
	 * 查看该简历编号是否有个人信息
	 * 
	 * @param resumeId 简历编号
	 * */
	public boolean queryExist(int resumeId) {
		String hql = "from ResumePersonInfo where resumeId = :resumeId";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("resumeId", resumeId);
		return queryCount(hql, map) != 0;
	}

}
