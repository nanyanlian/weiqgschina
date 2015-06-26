package com.qgschina.main.resume.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qgschina.main.resume.dao.ResumeCertificateDao;
import com.qgschina.main.resume.model.ResumeCertificate;
import com.qgschina.main.resume.service.ResumeCertificateService;

/**
 * Service - 简历证书
 * */
@Service("/resumeCertificateService")
public class ResumeCertificateServiceImpl implements
		ResumeCertificateService {
	@Resource
	private ResumeCertificateDao resumeCertificateDao;

	/**
	 * 根据证书编号查找证书信息
	 * 
	 * @param id
	 *            证书编号
	 * */
	public ResumeCertificate disposeQueryById(int id) {
		return resumeCertificateDao.get(id);
	}

	/**
	 * 保存证书信息
	 * 
	 * @param certificate
	 *            待保存证书
	 * */
	public void disposeSave(ResumeCertificate certificate) {
		resumeCertificateDao.save(certificate);
	}

	/**
	 * 更新证书信息
	 * 
	 * @param certificate
	 *            待保存证书
	 * */
	public void disposeUpdate(ResumeCertificate certificate) {
		resumeCertificateDao.update(certificate);
	}

	/**
	 * 根据编号删除证书信息
	 * 
	 * @param id
	 *            待删除证书编号
	 * */
	public void disposeDelById(int id) {
		resumeCertificateDao.deleteById(id);
	}
}
