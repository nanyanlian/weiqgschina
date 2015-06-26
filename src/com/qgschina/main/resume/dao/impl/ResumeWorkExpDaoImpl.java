package com.qgschina.main.resume.dao.impl;

import java.util.List;
import java.util.Map;

import net.sf.ehcache.store.chm.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.qgschina.main.base.dao.impl.BaseDaoImpl;
import com.qgschina.main.resume.dao.ResumeWorkExpDao;
import com.qgschina.main.resume.model.ResumeWorkExp;

/**
 * Dao - 工作经验
 * */
@SuppressWarnings("unchecked")
@Repository("/resumeWorkExpDao")
public class ResumeWorkExpDaoImpl extends BaseDaoImpl<ResumeWorkExp, Integer> implements ResumeWorkExpDao {
	/**
	 * 根据简历编号查询工作经验列表
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public List<ResumeWorkExp> queryByResumeId(int resumeId) {
		String hql = "from ResumeWorkExp where resumeId = :resumeId";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("resumeId", resumeId);
		return (List<ResumeWorkExp>) find(hql, map);
	}

	/**
	 * 根据简历工作经验编号删除工作经验
	 * 
	 * @param id
	 *            简历工作经验编号
	 * */
	public void deleteById(int id) {
		String hql = "delete from ResumeWorkExp where id = :id";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("id", id);
		executeUpdate(hql, map);
	}

}
