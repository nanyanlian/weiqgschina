package com.qgschina.main.resume.dao.impl;

import java.util.List;
import java.util.Map;

import net.sf.ehcache.store.chm.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.qgschina.main.base.dao.impl.BaseDaoImpl;
import com.qgschina.main.resume.dao.ResumeITDao;
import com.qgschina.main.resume.model.ResumeIT;

/**
 * Dao - IT技能
 * */
@SuppressWarnings("unchecked")
@Repository("/resumeITDao")
public class ResumeITDaoImpl extends BaseDaoImpl<ResumeIT, Integer> implements ResumeITDao{

	/**
	 * 根据简历编号查询IT技能列表
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public List<ResumeIT> queryByResumeId(int resumeId) {
		String hql = "from ResumeIT where resumeId = :resumeId";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("resumeId", resumeId);
		return (List<ResumeIT>) find(hql, map);
	}

	/**
	 * 根据简历IT技能编号删除IT技能
	 * 
	 * @param id
	 *            简历IT技能编号
	 * */
	public void deleteById(int id) {
		String hql = "delete from ResumeIT where id = :id";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("id", id);
		executeUpdate(hql, map);
	}

}
