package com.qgschina.main.resume.dao;

import java.util.List;

import com.qgschina.main.base.dao.BaseDao;
import com.qgschina.main.resume.model.ResumeCertificate;

/**
 * Dao - 简历证书
 * */
public interface ResumeCertificateDao extends
		BaseDao<ResumeCertificate, Integer> {
	/**
	 * 根据简历编号查询简历证书列表
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public List<ResumeCertificate> queryByResumeId(int resumeId);
	/**
	 * 根据简历证书编号删除证书
	 * 
	 * @param id
	 *            简历证书编号
	 * */
	public void deleteById(int id);
}
