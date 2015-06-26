package com.qgschina.main.resume.dao.impl;

import java.util.List;
import java.util.Map;

import net.sf.ehcache.store.chm.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.qgschina.main.base.dao.impl.BaseDaoImpl;
import com.qgschina.main.resume.dao.ResumeLanguageDao;
import com.qgschina.main.resume.model.ResumeLanguage;

/**
 * Dao - 语言能力
 * */
@SuppressWarnings("unchecked")
@Repository("/ResumeLanguageDao")
public class ResumeLanguageDaoImpl extends BaseDaoImpl<ResumeLanguage, Integer> 
	implements ResumeLanguageDao {

	/**
	 * 根据简历语言能力编号删除语言能力
	 * 
	 * @param id
	 *            简历语言能力编号
	 * */
	public void deleteById(int id) {
		String hql = "delete from ResumeLanguage where id = :id";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("id", id);
		executeUpdate(hql, map);
	}

	/**
	 * 根据简历编号查询语言能力列表
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public List<ResumeLanguage> queryByResumeId(int resumeId) {
		String hql = "from ResumeLanguage where resumeId = :resumeId";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("resumeId", resumeId);
		return (List<ResumeLanguage>) find(hql, map);
	}

}
