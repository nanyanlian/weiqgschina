package com.qgschina.main.resume.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qgschina.main.resume.dao.ResumeOtherInfoDao;
import com.qgschina.main.resume.model.ResumeOtherInfo;
import com.qgschina.main.resume.service.ResumeOtherInfoService;

/**
 * Service - 补充信息
 * */
@Service("/resumeOtherInfoService")
public class ResumeOtherInfoServiceImpl implements ResumeOtherInfoService {
	@Resource
	private ResumeOtherInfoDao resumeOtherInfoDao;

	/**
	 * 根据补充信息编号查找补充信息
	 * 
	 * @param id
	 *            补充信息编号
	 * */
	public ResumeOtherInfo queryById(int id) {
		return resumeOtherInfoDao.get(id);
	}

	/**
	 * 根据补充信息编号删除补充信息
	 * 
	 * @param id
	 *            补充信息编号
	 * */
	public void disposeDelById(int id) {
		resumeOtherInfoDao.deleteById(id);
	}

	/**
	 * 保存补充信息
	 * 
	 * @param resumeOtherInfo
	 *            待保存补充信息
	 * */
	public void disposeSave(ResumeOtherInfo resumeOtherInfo) {
		resumeOtherInfoDao.save(resumeOtherInfo);
	}

	/**
	 * 更新补充信息
	 * 
	 * @param resumeOtherInfo
	 *            待更新补充信息
	 * */
	public void disposeUpdate(ResumeOtherInfo resumeOtherInfo) {
		resumeOtherInfoDao.update(resumeOtherInfo);
	}
}
