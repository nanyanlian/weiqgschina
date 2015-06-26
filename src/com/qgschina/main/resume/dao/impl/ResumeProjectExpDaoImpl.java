package com.qgschina.main.resume.dao.impl;

import java.util.List;
import java.util.Map;

import net.sf.ehcache.store.chm.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.qgschina.main.base.dao.impl.BaseDaoImpl;
import com.qgschina.main.resume.dao.ResumeProjectExpDao;
import com.qgschina.main.resume.model.ResumeProjectExp;

/**
 * Dao - 项目经验
 * */
@SuppressWarnings("unchecked")
@Repository("/resumeProjectExpDao")
public class ResumeProjectExpDaoImpl extends
		BaseDaoImpl<ResumeProjectExp, Integer> implements ResumeProjectExpDao {
	/**
	 * 根据简历编号查询项目经验列表
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public List<ResumeProjectExp> queryByResumeId(int resumeId) {
		String hql = "from ResumeProjectExp where resumeId = :resumeId";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("resumeId", resumeId);
		return (List<ResumeProjectExp>) find(hql, map);
	}

	/**
	 * 根据简历项目经验编号删除项目经验
	 * 
	 * @param id
	 *            简历项目经验编号
	 * */
	public void deleteById(int id) {
		String hql = "delete from ResumeProjectExp where id = :id";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("id", id);
		executeUpdate(hql, map);
	}

}
