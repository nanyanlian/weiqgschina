package com.qgschina.main.resume.service;

import com.qgschina.main.resume.model.ResumeCertificate;

/**
 * Service - 简历证书
 * */
public interface ResumeCertificateService {
	/**
	 * 根据证书编号查找证书信息
	 * 
	 * @param id
	 *            证书编号
	 * */
	public ResumeCertificate disposeQueryById(int id);

	/**
	 * 保存证书信息
	 * 
	 * @param certificate
	 *            待保存证书
	 * */
	public void disposeSave(ResumeCertificate certificate);

	/**
	 * 更新证书信息
	 * 
	 * @param certificate
	 *            待保存证书
	 * */
	public void disposeUpdate(ResumeCertificate certificate);

	/**
	 * 根据编号删除证书信息
	 * 
	 * @param id
	 *            待删除证书编号
	 * */
	public void disposeDelById(int id);
}
