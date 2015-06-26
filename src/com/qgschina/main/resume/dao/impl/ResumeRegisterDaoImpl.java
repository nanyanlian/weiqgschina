package com.qgschina.main.resume.dao.impl;

import org.springframework.stereotype.Repository;

import com.qgschina.main.base.dao.impl.BaseDaoImpl;
import com.qgschina.main.resume.dao.ResumeRegisterDao;
import com.qgschina.main.resume.model.ResumeRegister;

/**
 * Dao - 简历申请
 * */
@SuppressWarnings("unchecked")
@Repository("/resumeRegisterDao")
public class ResumeRegisterDaoImpl extends BaseDaoImpl<ResumeRegister, Integer> implements
		ResumeRegisterDao {

}
