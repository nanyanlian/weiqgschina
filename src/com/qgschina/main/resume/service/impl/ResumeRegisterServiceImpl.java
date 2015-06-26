package com.qgschina.main.resume.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qgschina.main.resume.dao.ResumeRegisterDao;
import com.qgschina.main.resume.model.Resume;
import com.qgschina.main.resume.model.ResumeRegister;
import com.qgschina.main.resume.service.ResumeRegisterService;

/**
 * Service - 简历申请
 * */
@Service("/resumeRegisterService")
public class ResumeRegisterServiceImpl implements ResumeRegisterService {
	@Resource
	private ResumeRegisterDao resumeRegisterDao;

	/**
	 * 以某份简历申请职位
	 * 
	 * @param resume
	 *            申请职位使用简历
	 * */
	public void disposeCreate(Resume resume) {
		ResumeRegister register = new ResumeRegister();
		resumeRegisterDao.save(register);
	}
}
