package com.qgschina.main.resume.dao.impl;

import java.util.List;
import java.util.Map;

import net.sf.ehcache.store.chm.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.qgschina.main.base.dao.impl.BaseDaoImpl;
import com.qgschina.main.resume.dao.ResumeApplyJobDao;
import com.qgschina.main.resume.model.ResumeApplyJob;

/**
 * Dao - 求职意向
 * */
@SuppressWarnings("unchecked")
@Repository("/resumeApplyJobDao")
public class ResumeApplyJobDaoImpl extends BaseDaoImpl<ResumeApplyJob, Integer> 
	implements ResumeApplyJobDao{

	/**
	 * 根据简历编号查询求职意向信息
	 * 
	 * @param resumeId 简历编号
	 * */
	@SuppressWarnings("rawtypes")
	public ResumeApplyJob queryByResumeId(int resumeId) {
		String hql = "from ResumeApplyJob where resumeId = :resumeId";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("resumeId", resumeId);
		List list = find(hql, map);
		if( list != null && list.size() != 0 )
			return (ResumeApplyJob) list.get(0);
		return null;
	}

	/**
	 * 查看该简历编号是否有求职意向
	 * 
	 * @param resumeId 简历编号
	 * */
	public boolean queryExist(int resumeId) {
		String hql = "from ResumeApplyJob where resumeId = :resumeId";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("resumeId", resumeId);
		return queryCount(hql, map) != 0;
	}

}
