package com.qgschina.main.resume.dao.impl;

import java.util.List;
import java.util.Map;

import net.sf.ehcache.store.chm.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.qgschina.main.base.dao.impl.BaseDaoImpl;
import com.qgschina.main.resume.dao.ResumeOtherInfoDao;
import com.qgschina.main.resume.model.ResumeOtherInfo;

@SuppressWarnings("unchecked")
@Repository("/resumeOtherInfoDao")
public class ResumeOtherInfoDaoImpl extends BaseDaoImpl<ResumeOtherInfo, Integer> 
	implements ResumeOtherInfoDao {

	public List<ResumeOtherInfo> queryByResumeId(int resumeId) {
		String hql = "from ResumeOtherInfo where resumeId = :resumeId";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("resumeId", resumeId);
		return (List<ResumeOtherInfo>) find(hql, map);
	}

	public void deleteById(int id) {
		String hql = "delete from ResumeOtherInfo where id = :id";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("id", id);
		executeUpdate(hql, map);
	}

}
