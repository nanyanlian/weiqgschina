package com.qgschina.main.resume.service;

import java.util.List;

import com.qgschina.main.resume.model.Resume;
import com.qgschina.main.resume.model.ResumeApplyJob;
import com.qgschina.main.resume.model.ResumeCertificate;
import com.qgschina.main.resume.model.ResumeEdu;
import com.qgschina.main.resume.model.ResumeIT;
import com.qgschina.main.resume.model.ResumeLanguage;
import com.qgschina.main.resume.model.ResumeOtherInfo;
import com.qgschina.main.resume.model.ResumePersonInfo;
import com.qgschina.main.resume.model.ResumeProjectExp;
import com.qgschina.main.resume.model.ResumeTrain;
import com.qgschina.main.resume.model.ResumeWorkExp;

/**
 * Service - 简历
 * */
public interface ResumeService {
	/**
	 * 根据用户编号查找简历列表
	 * 
	 * @param openid
	 *            用户编号
	 * */
	public List<Resume> disposeListResumeByOpenid(String openid);

	/**
	 * 根据简历编号删除简历
	 * 
	 * @param 简历编号
	 * */
	public void disposeDelResume(int resumeId);

	/**
	 * 创建一个空简历
	 * 
	 * @param openid
	 *            用户编号
	 * */
	public int disposeCreateEmptyResume(String openid);

	/**
	 * 根据简历编号查询简历(主要内容部分)
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public Resume disposeQueryResumeById(int resumeId);

	/**
	 * 保存个人信息
	 * 
	 * @param personInfo
	 *            待保存个人信息
	 * */
	public void disposeDealSavePersonInfo(ResumePersonInfo personInfo);

	/**
	 * 根据简历编号查询简历(额外信息内容部分)
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public Resume disposeQueryResumeExtraInfoById(int resumeId);

	/**
	 * 回调个人信息的输入数量,根据个人信息中的输入数量修改简历完整度
	 * 
	 * @param personInfo
	 *            简历个人信息内容
	 * @param oldInputNum
	 *            先前的输入数量
	 * */
	public void disposeFeebBackInputNum(ResumePersonInfo personInfo,
			int oldInputNum);

	/**
	 * 回调求职意向的输入数量,根据求职意向中的输入数量修改简历完整度
	 * 
	 * @param applyJon
	 *            求职意向
	 * @param oldInputNum
	 *            先前的输入数量
	 * */
	public void disposeFeebBackInputNum(ResumeApplyJob applyJob, int oldInputNum);

	/**
	 * 回调教育经历的输入数量,根据教育经历中的输入数量修改简历完整度
	 * 
	 * @param resumeEdu
	 *            教育经历
	 * @param oldInputNum
	 *            先前的输入数量
	 * */
	public void disposeFeebBackInputNum(ResumeEdu resumeEdu, int oldInputNum);

	/**
	 * 回调工作经验的输入数量,根据工作经验中的输入数量修改简历完整度
	 * 
	 * @param workExp
	 *            工作经验
	 * @param oldInputNum
	 *            先前的输入数量
	 * */
	public void disposeFeebBackInputNum(ResumeWorkExp workExp, int oldInputNum);

	/**
	 * 回调培训经历的输入数量,根据培训经历中的输入数量修改简历完整度
	 * 
	 * @param train
	 *            培训经历
	 * @param oldInputNum
	 *            先前的输入数量
	 * */
	public void disposeFeebBackInputNum(ResumeTrain train, int oldInputNum);

	/**
	 * 回调语言能力的输入数量,根据语言能力中的输入数量修改简历完整度
	 * 
	 * @param language
	 *            语言能力
	 * @param oldInputNum
	 *            先前的输入数量
	 * */
	public void disposeFeebBackInputNum(ResumeLanguage language, int oldInputNum);

	/**
	 * 回调IT技能的输入数量,根据IT技能中的输入数量修改简历完整度
	 * 
	 * @param IT
	 *            IT技能
	 * @param oldInputNum
	 *            先前的输入数量
	 * */
	public void disposeFeebBackInputNum(ResumeIT iT, int oldInputNum);

	/**
	 * 回调项目经验的输入数量,根据项目经验中的输入数量修改简历完整度
	 * 
	 * @param projectExp
	 *            项目经验
	 * @param oldInputNum
	 *            先前的输入数量
	 * */
	public void disposeFeebBackInputNum(ResumeProjectExp projectExp,
			int oldInputNum);

	/**
	 * 回调证书信息的输入数量,根据证书信息中的输入数量修改简历完整度
	 * 
	 * @param certificate
	 *            证书信息
	 * @param oldInputNum
	 *            先前的输入数量
	 * */
	public void disposeFeebBackInputNum(ResumeCertificate certificate,
			int oldInputNum);

	/**
	 * 回调补充信息的输入数量,根据补充信息中的输入数量修改简历完整度
	 * 
	 * @param otherInfo
	 *            补充信息
	 * @param oldInputNum
	 *            先前的输入数量
	 * */
	public void disposeFeebBackInputNum(ResumeOtherInfo otherInfo,
			int oldInputNum);

	/**
	 * 回调教育经历的输入数量,根据教育经历中的输入数量修改简历完整度
	 * 
	 * @param resumeEdu
	 *            教育经历
	 * @param resumeId
	 *            简历编号
	 * @param id
	 *            教育经历编号
	 * 
	 * */
	public void disposeFeebBackInputNum(int resumeId, int id,
			ResumeEdu resumeEdu);

	/**
	 * 回调工作经验的输入数量,根据工作经验中的输入数量修改简历完整度
	 * 
	 * @param workExp
	 *            工作经验
	 * @param resumeId
	 *            简历编号
	 * @param id
	 *            工作经验编号
	 * 
	 * */
	public void disposeFeebBackInputNum(int resumeId, int id,
			ResumeWorkExp resumeWorkExp);

	/**
	 * 回调培训经历的输入数量,根据培训经历中的输入数量修改简历完整度
	 * 
	 * @param resumeTrain
	 *            培训经历
	 * @param resumeId
	 *            简历编号
	 * @param id
	 *            培训经历编号
	 * 
	 * */
	public void disposeFeebBackInputNum(int resumeId, int id,
			ResumeTrain resumeTrain);

	/**
	 * 回调项目经验的输入数量,根据项目经验中的输入数量修改简历完整度
	 * 
	 * @param resumeProjectExp
	 *            项目经验
	 * @param resumeId
	 *            简历编号
	 * @param id
	 *            项目经验编号
	 * 
	 * */
	public void disposeFeebBackInputNum(int resumeId, int id,
			ResumeProjectExp resumeProjectExp);

	/**
	 * 回调补充信息的输入数量,根据补充信息中的输入数量修改简历完整度
	 * 
	 * @param resumeOtherInfo
	 *            补充信息
	 * @param resumeId
	 *            简历编号
	 * @param id
	 *            补充信息编号
	 * 
	 * */
	public void disposeFeebBackInputNum(int resumeId, int id,
			ResumeOtherInfo resumeOtherInfo);

	/**
	 * 回调语言能力的输入数量,根据语言能力中的输入数量修改简历完整度
	 * 
	 * @param resumeLanguage
	 *            语言能力
	 * @param resumeId
	 *            简历编号
	 * @param id
	 *            语言能力编号
	 * 
	 * */
	public void disposeFeebBackInputNum(int resumeId, int id,
			ResumeLanguage resumeLanguage);

	/**
	 * 回调IT技能的输入数量,根据IT技能中的输入数量修改简历完整度
	 * 
	 * @param resumeIT
	 *            IT技能
	 * @param resumeId
	 *            简历编号
	 * @param id
	 *            IT技能编号
	 * 
	 * */
	public void disposeFeebBackInputNum(int resumeId, int id, ResumeIT resumeIT);

	/**
	 * 回调证书信息的输入数量,根据证书信息中的输入数量修改简历完整度
	 * 
	 * @param resumeCertificate
	 *            证书信息
	 * @param resumeId
	 *            简历编号
	 * @param id
	 *            证书信息编号
	 * 
	 * */
	public void disposeFeebBackInputNum(int resumeId, int id,
			ResumeCertificate resumeCertificate);

	/**
	 * 根据简历编号查询简历对象
	 * 
	 * @param id
	 *            简历编号
	 * */
	public Resume disposeQuerySimpleResumeById(int id);
}
