package com.qgschina.main.resume.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qgschina.main.resume.dao.ResumeWorkExpDao;
import com.qgschina.main.resume.model.ResumeWorkExp;
import com.qgschina.main.resume.service.ResumeWorkExpService;

/**
 * Service - 工作经验
 * */
@Service("/resumeWorkExpServie")
public class ResumeWorkExpServiceImpl implements ResumeWorkExpService {
	@Resource
	private ResumeWorkExpDao resumeWorkExpDao;

	/**
	 * 保存工作经验
	 * 
	 * @param workExp
	 *            待保存工作经验
	 * */
	public void disposeSave(ResumeWorkExp workExp) {
		if( workExp.getEndDate() == null || workExp.getEndDate().length() == 0 )
			workExp.setEndDate("至今");
		resumeWorkExpDao.save(workExp);
	}

	/**
	 * 根据工作经验编号查找工作经验信息
	 * 
	 * @param workExpId
	 *            工作经验编号
	 * */
	public ResumeWorkExp disposeQueryById(int workExpId) {
		return resumeWorkExpDao.get(workExpId);
	}

	/**
	 * 更新工作经验
	 * 
	 * @param workExp
	 *            待更新工作经验
	 * */
	public void disposeUpdate(ResumeWorkExp workExp) {
		if( workExp.getEndDate() == null || workExp.getEndDate().length() == 0 )
			workExp.setEndDate("至今");
		resumeWorkExpDao.update(workExp);
	}

	/**
	 * 根据工作经验编号删除工作经验信息
	 * 
	 * @param workExpId
	 *            工作经验编号
	 * */
	public void disposeDeleteById(int id) {
		resumeWorkExpDao.deleteById(id);
	}
}
