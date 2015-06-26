package com.qgschina.main.resume.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qgschina.main.resume.dao.ResumeITDao;
import com.qgschina.main.resume.model.ResumeIT;
import com.qgschina.main.resume.service.ResumeITService;

/**
 * Service - IT技能
 * */
@Service("/resumeITService")
public class ResumeITServiceImpl implements
		ResumeITService {
	@Resource
	private ResumeITDao resumeITDao;

	/**
	 * 根据IT技能编号查找IT技能信息
	 * 
	 * @param id
	 *            IT技能编号
	 * */
	public ResumeIT disposeQueryById(int id) {
		return resumeITDao.get(id);
	}

	/**
	 * 保存IT技能信息
	 * 
	 * @param IT
	 *            待保存IT技能信息
	 * */
	public void disposeSaveIT(ResumeIT iT) {
		resumeITDao.save(iT);
	}

	/**
	 * 更新IT技能信息
	 * 
	 * @param IT
	 *            待更新IT技能信息
	 * */
	public void disposeUpdateIT(ResumeIT iT) {
		resumeITDao.update(iT);
	}

	/**
	 * 根据IT技能编号删除IT技能信息
	 * 
	 * @param id
	 *            IT技能编号
	 * */
	public void disposeDelById(int id) {
		resumeITDao.deleteById(id);
	}
}
