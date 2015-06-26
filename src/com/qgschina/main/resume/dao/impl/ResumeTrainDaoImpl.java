package com.qgschina.main.resume.dao.impl;

import java.util.List;
import java.util.Map;

import net.sf.ehcache.store.chm.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.qgschina.main.base.dao.impl.BaseDaoImpl;
import com.qgschina.main.resume.dao.ResumeTrainDao;
import com.qgschina.main.resume.model.ResumeTrain;

/**
 * Dao - 培训经历
 * */
@SuppressWarnings("unchecked")
@Repository("/resumeTrainDao")
public class ResumeTrainDaoImpl extends BaseDaoImpl<ResumeTrain, Integer> implements ResumeTrainDao {

	/**
	 * 根据简历编号查询培训经历列表
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public List<ResumeTrain> queryByResumeId(int resumeId) {
		String hql = "from ResumeTrain where resumeId = :resumeId";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("resumeId", resumeId);
		return (List<ResumeTrain>) find(hql, map);
	}

	/**
	 * 根据简历培训经历编号删除培训经历
	 * 
	 * @param id
	 *            简历培训经历编号
	 * */
	public void deleteById(int id) {
		String hql = "delete from ResumeTrain where id = :id";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("id", id);
		executeUpdate(hql, map);
	}

}
