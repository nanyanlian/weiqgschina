package com.qgschina.main.resume.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qgschina.main.resume.dao.ResumeProjectExpDao;
import com.qgschina.main.resume.model.ResumeProjectExp;
import com.qgschina.main.resume.service.ResumeProjectExpService;

/**
 * Service - 项目经历
 * */
@Service("/resumeProjectExpService")
public class ResumeProjectExpServiceImpl  implements ResumeProjectExpService {
	@Resource
	private ResumeProjectExpDao resumeProjectExpDao;

	/**
	 * 根据项目经历编号查找项目经历信息
	 * 
	 * @param id
	 *            项目经历编号
	 * */
	public ResumeProjectExp disposeQueryById(int id) {
		return resumeProjectExpDao.get(id);
	}

	/**
	 * 保存项目经历
	 * 
	 * @param projectExp
	 *            待保存项目经历
	 * */
	public void disposeSave(ResumeProjectExp projectExp) {
		if( projectExp.getEndDate() == null || projectExp.getEndDate().length() == 0 ) {
			projectExp.setEndDate("至今");
		}
		resumeProjectExpDao.save(projectExp);
	}

	/**
	 * 更新项目经历
	 * 
	 * @param projectExp
	 *            待更新项目经历
	 * */
	public void disposeUpdate(ResumeProjectExp projectExp) {
		if( projectExp.getEndDate() == null || projectExp.getEndDate().length() == 0 ) {
			projectExp.setEndDate("至今");
		}
		resumeProjectExpDao.update(projectExp);
	}

	/**
	 * 根据项目经历编号删除项目经历信息
	 * 
	 * @param id
	 *            项目经历编号
	 * */
	public void disposeDelById(int id) {
		resumeProjectExpDao.deleteById(id);
	}
}
