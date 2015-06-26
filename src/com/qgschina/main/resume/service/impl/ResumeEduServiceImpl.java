package com.qgschina.main.resume.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qgschina.main.resume.dao.ResumeEduDao;
import com.qgschina.main.resume.model.ResumeEdu;
import com.qgschina.main.resume.service.ResumeEduService;

/**
 * Service - 教育经历
 * */
@Service("/resumeEduService")
public class ResumeEduServiceImpl implements ResumeEduService {
	@Resource
	private ResumeEduDao resumeEduDao;

	/**
	 * 保存教育经历
	 * 
	 * @param resumeEdu
	 *            待保存教育经历
	 * */
	public void disposeSave(ResumeEdu resumeEdu) {
		if (resumeEdu.getEndDate() == null
				|| resumeEdu.getEndDate().length() == 0) {
			resumeEdu.setEndDate("至今");
		}
		resumeEduDao.save(resumeEdu);
	}

	/**
	 * 更新教育经历
	 * 
	 * @param resumeEdu
	 *            待更新教育经历
	 * */
	public void disposeUpdate(ResumeEdu resumeEdu) {
		if (resumeEdu.getEndDate() == null
				|| resumeEdu.getEndDate().length() == 0) {
			resumeEdu.setEndDate("至今");
		}
		resumeEduDao.update(resumeEdu);
	}

	/**
	 * 根据教育经历编号查找教育经历信息
	 * 
	 * @param eduId
	 *            教育经历编号
	 * */
	public ResumeEdu disposeQueryEduById(int eduId) {
		return resumeEduDao.get(eduId);
	}

	/**
	 * 根据教育经历编号删除教育经历对象
	 * 
	 * @param id
	 *            教育经历编号
	 * */
	public void disposeDelById(int id) {
		resumeEduDao.deleteById(id);
	}

}
