package com.qgschina.main.resume.service.impl;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import com.qgschina.main.resume.dao.ResumeTrainDao;
import com.qgschina.main.resume.model.ResumeTrain;
import com.qgschina.main.resume.service.ResumeTrainService;

/**
 * Service - 培训经历
 * */
@Service("/resumeTrainService")
public class ResumeTrainServiceImpl implements ResumeTrainService {
	@Resource
	private ResumeTrainDao resumeTrainDao;

	/**
	 * 保存培训经历
	 * 
	 * @param train
	 *            待保存培训经历
	 * */
	public void disposeSave(ResumeTrain train) {
		if( train.getEndDate() == null || train.getEndDate().length() == 0 )
			train.setEndDate("至今");
		resumeTrainDao.save(train);
	}

	/**
	 * 更新培训经历
	 * 
	 * @param train
	 *            待更新培训经历
	 * */
	public void disposeUpdate(ResumeTrain train) {
		if( train.getEndDate() == null || train.getEndDate().length() == 0 )
			train.setEndDate("至今");
		resumeTrainDao.update(train);
	}

	/**
	 * 根据培训经历编号查询培训经历
	 * 
	 * @param id
	 *            培训经历编号
	 * */
	public ResumeTrain disposeQueryById(int id) {
		return resumeTrainDao.get(id);
	}

	/**
	 * 根据简历编号查询培训经历
	 * 
	 * @param resumeId
	 *            简历
	 * */
	public List<ResumeTrain> disposeQueryByResumeId(int resumeId) {
		return resumeTrainDao.queryByResumeId(resumeId);
	}

	/**
	 * 根据培训经历编号删除培训经历
	 * 
	 * @param id
	 *            培训经历编号
	 * */
	public void disposeDelById(int id) {
		resumeTrainDao.deleteById(id);
	}
}
