package com.qgschina.main.resume.dao.impl;

import java.util.List;
import java.util.Map;

import net.sf.ehcache.store.chm.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.qgschina.main.base.dao.impl.BaseDaoImpl;
import com.qgschina.main.resume.dao.ResumeCertificateDao;
import com.qgschina.main.resume.model.ResumeCertificate;

/**
 * Dao - 简历证书
 * */
@SuppressWarnings("unchecked")
@Repository("/resumeCertificateDao")
public class ResumeCertificateDaoImpl extends
		BaseDaoImpl<ResumeCertificate, Integer> implements ResumeCertificateDao {

	/**
	 * 根据简历编号查询简历证书列表
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public List<ResumeCertificate> queryByResumeId(int resumeId) {
		String hql = "from ResumeCertificate where resumeId = :resumeId";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("resumeId", resumeId);
		return (List<ResumeCertificate>) find(hql, map);
	}

	/**
	 * 根据简历证书编号删除证书
	 * 
	 * @param id
	 *            简历证书编号
	 * */
	public void deleteById(int id) {
		String hql = "delete from ResumeCertificate where id = :id";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("id", id);
		executeUpdate(hql, map);
	}

}
