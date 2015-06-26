package com.qgschina.main.resume.service;

import com.qgschina.main.resume.model.Resume;

/**
 * Service - 简历申请
 * */
public interface ResumeRegisterService {
	/**
	 * 以某份简历申请职位
	 * 
	 * @param resume
	 *            申请职位使用简历
	 * */
	public void disposeCreate(Resume resume);

}
