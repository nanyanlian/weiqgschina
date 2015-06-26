package com.qgschina.main.resume.dao.impl;

import java.util.List;
import java.util.Map;

import net.sf.ehcache.store.chm.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.qgschina.main.base.dao.impl.BaseDaoImpl;
import com.qgschina.main.resume.dao.ResumeEduDao;
import com.qgschina.main.resume.model.ResumeEdu;

/**
 * Dao - 简历教育经历
 * */
@Repository("/resumeEduDao")
@SuppressWarnings("unchecked")
public class ResumeEduDaoImpl extends BaseDaoImpl<ResumeEdu, Integer> implements
		ResumeEduDao {
	/**
	 * 根据简历编号查询教育经历列表
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public List<ResumeEdu> queryByResumeId(int resumeId) {
		String hql = "from ResumeEdu where resumeId = :resumeId";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("resumeId", resumeId);
		return (List<ResumeEdu>) find(hql, map);
	}

	/**
	 * 根据简历教育经历编号删除教育经历
	 * 
	 * @param id
	 *            简历教育经历编号
	 * */
	public void deleteById(int id) {
		String hql = "delete from ResumeEdu where id = :id";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("id", id);
		executeUpdate(hql, map);
	}

}
