package com.qgschina.main.resume.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.ehcache.store.chm.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.qgschina.main.resume.dao.ResumeApplyJobDao;
import com.qgschina.main.resume.dao.ResumeCertificateDao;
import com.qgschina.main.resume.dao.ResumeDao;
import com.qgschina.main.resume.dao.ResumeEduDao;
import com.qgschina.main.resume.dao.ResumeITDao;
import com.qgschina.main.resume.dao.ResumeLanguageDao;
import com.qgschina.main.resume.dao.ResumeOtherInfoDao;
import com.qgschina.main.resume.dao.ResumePersonInfoDao;
import com.qgschina.main.resume.dao.ResumeProjectExpDao;
import com.qgschina.main.resume.dao.ResumeTrainDao;
import com.qgschina.main.resume.dao.ResumeWorkExpDao;
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
import com.qgschina.main.resume.service.ResumeService;
import com.qgschina.main.resume.util.ResumeCountUtil;

/**
 * Service - 简历
 * */
@Service("/resumeService")
public class ResumeServiceImpl implements ResumeService {
	@Resource
	private ResumeDao resumeDao;
	@Resource
	private ResumePersonInfoDao resumePersonInfoDao;
	@Resource
	private ResumeEduDao resumeEduDao;
	@Resource
	private ResumeWorkExpDao resumeWorkExpDao;
	@Resource
	private ResumeApplyJobDao resumeApplyJobDao;
	@Resource
	private ResumeTrainDao resumeTrainDao;
	@Resource
	private ResumeLanguageDao resumeLanguageDao;
	@Resource
	private ResumeITDao resumeITDao;
	@Resource
	private ResumeProjectExpDao resumeProjectExpDao;
	@Resource
	private ResumeCertificateDao resumeCertificateDao;
	@Resource
	private ResumeOtherInfoDao resumeOtherInfoDao;

	/**
	 * 根据用户编号查找简历列表
	 * 
	 * @param openid
	 *            用户编号
	 * */
	public List<Resume> disposeListResumeByOpenid(String openid) {
		return resumeDao.listByOpenId(openid);
	}

	/**
	 * 根据简历编号删除简历
	 * 
	 * @param 简历编号
	 * */
	public void disposeDelResume(int resumeId) {
		resumeDao.deleteById(resumeId);
	}

	/**
	 * 创建一个空简历
	 * 
	 * @param openid
	 *            用户编号
	 * */
	public int disposeCreateEmptyResume(String openid) {
		Resume resume = new Resume();
		resume.setOpenid(openid);
		return resumeDao.save(resume);
	}

	/**
	 * 根据简历编号查询简历(主要内容部分)
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public Resume disposeQueryResumeById(int resumeId) {
		Resume resume = resumeDao.get(resumeId);
		resume.setPersonInfo(resumePersonInfoDao.queryByResumeId(resumeId));
		resume.setEduList(resumeEduDao.queryByResumeId(resumeId));
		resume.setWorkExpList(resumeWorkExpDao.queryByResumeId(resumeId));
		resume.setApplyJob(resumeApplyJobDao.queryByResumeId(resumeId));
		resume.setTrainList(resumeTrainDao.queryByResumeId(resumeId));
		resume.setLanguageList(resumeLanguageDao.queryByResumeId(resumeId));
		return resume;
	}

	/**
	 * 根据简历编号查询简历(额外信息内容部分)
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public Resume disposeQueryResumeExtraInfoById(int resumeId) {
		Resume resume = resumeDao.get(resumeId);
		resume.setiTList(resumeITDao.queryByResumeId(resumeId));
		resume.setProjectExpList(resumeProjectExpDao.queryByResumeId(resumeId));
		resume.setCertificateList(resumeCertificateDao
				.queryByResumeId(resumeId));
		resume.setOtherInfoList(resumeOtherInfoDao.queryByResumeId(resumeId));
		return resume;
	}

	/**
	 * 保存个人信息
	 * 
	 * @param personInfo
	 *            待保存个人信息
	 * */
	public void disposeDealSavePersonInfo(ResumePersonInfo personInfo) {
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("name", personInfo.getResumeName());
		map.put("openLevel", personInfo.getOpeness());
		resumeDao.changeResumeField(personInfo, map);
	}

	/**
	 * 回调个人信息的输入数量,根据个人信息中的输入数量修改简历完整度
	 * 
	 * @param personInfo
	 *            简历个人信息内容
	 * @param oldInputNum
	 *            先前的输入数量
	 * */
	public void disposeFeebBackInputNum(ResumePersonInfo personInfo,
			int oldInputNum) {
		int newInputNum = ResumeCountUtil.countResume(personInfo);
		int hasInputNum = 0;
		if (newInputNum != oldInputNum) {
			Resume resume = resumeDao.get(personInfo.getResumeId());

			Map<String, Object> map = new ConcurrentHashMap<String, Object>();
			hasInputNum = resume.getHasInputNum() - oldInputNum + newInputNum;
			map.put("hasInputNum", hasInputNum);
			map.put("complete", (int) (hasInputNum
					/ (double) Resume.ALL_INPUT_NUM * 100));
			resumeDao.changeResumeField(personInfo.getResumeId(), map);
		}
	}

	/**
	 * 回调求职意向的输入数量,根据求职意向中的输入数量修改简历完整度
	 * 
	 * @param applyJon
	 *            求职意向
	 * @param oldInputNum
	 *            先前的输入数量
	 * */
	public void disposeFeebBackInputNum(ResumeApplyJob applyJob, int oldInputNum) {
		int newInputNum = ResumeCountUtil.countResume(applyJob);
		int hasInputNum = 0;
		if (newInputNum != oldInputNum) {
			Resume resume = resumeDao.get(applyJob.getResumeId());
			Map<String, Object> map = new ConcurrentHashMap<String, Object>();
			hasInputNum = resume.getHasInputNum() - oldInputNum + newInputNum;
			map.put("hasInputNum", hasInputNum);
			map.put("complete", (int) (hasInputNum
					/ (double) Resume.ALL_INPUT_NUM * 100));
			resumeDao.changeResumeField(applyJob.getResumeId(), map);
		}
	}

	/**
	 * 回调教育经历的输入数量,根据教育经历中的输入数量修改简历完整度
	 * 
	 * @param resumeEdu
	 *            教育经历
	 * @param oldInputNum
	 *            先前的输入数量
	 * */
	public void disposeFeebBackInputNum(ResumeEdu resumeEdu, int oldInputNum) {
		int newInputNum = ResumeCountUtil.countResume(resumeEdu);
		int hasInputNum = 0, tempInputNum = 0, id = resumeEdu.getId(), lastMax = 0, currMax = 0;
		if (newInputNum != oldInputNum) {
			Resume resume = resumeDao.get(resumeEdu.getResumeId());
			Map<String, Object> map = new ConcurrentHashMap<String, Object>();
			int max = -1;
			List<ResumeEdu> dataList = resumeEduDao.queryByResumeId(resumeEdu
					.getResumeId());
			for (ResumeEdu tempData : dataList) {
				if (tempData.getId() == id)
					continue;
				tempInputNum = ResumeCountUtil.countResume(tempData);
				if (tempInputNum > max)
					max = tempInputNum;
			}
			lastMax = oldInputNum > max ? oldInputNum : max;
			currMax = newInputNum > max ? newInputNum : max;
			hasInputNum = resume.getHasInputNum() - lastMax + currMax;
			map.put("hasInputNum", hasInputNum);
			map.put("complete", (int) (hasInputNum
					/ (double) Resume.ALL_INPUT_NUM * 100));
			resumeDao.changeResumeField(resumeEdu.getResumeId(), map);
		}
	}

	/**
	 * 回调工作经验的输入数量,根据工作经验中的输入数量修改简历完整度
	 * 
	 * @param workExp
	 *            工作经验
	 * @param oldInputNum
	 *            先前的输入数量
	 * */
	public void disposeFeebBackInputNum(ResumeWorkExp workExp, int oldInputNum) {
		int newInputNum = ResumeCountUtil.countResume(workExp);
		int hasInputNum = 0, tempInputNum = 0, id = workExp.getId(), lastMax = 0, currMax = 0;
		if (newInputNum != oldInputNum) {
			Resume resume = resumeDao.get(workExp.getResumeId());
			Map<String, Object> map = new ConcurrentHashMap<String, Object>();
			int max = -1;
			List<ResumeWorkExp> dataList = resumeWorkExpDao
					.queryByResumeId(workExp.getResumeId());
			for (ResumeWorkExp tempData : dataList) {
				if (tempData.getId() == id)
					continue;
				tempInputNum = ResumeCountUtil.countResume(tempData);
				if (tempInputNum > max)
					max = tempInputNum;
			}
			lastMax = oldInputNum > max ? oldInputNum : max;
			currMax = newInputNum > max ? newInputNum : max;
			hasInputNum = resume.getHasInputNum() - lastMax + currMax;
			map.put("hasInputNum", hasInputNum);
			map.put("complete", (int) (hasInputNum
					/ (double) Resume.ALL_INPUT_NUM * 100));
			resumeDao.changeResumeField(workExp.getResumeId(), map);
		}
	}

	/**
	 * 回调培训经历的输入数量,根据培训经历中的输入数量修改简历完整度
	 * 
	 * @param train
	 *            培训经历
	 * @param oldInputNum
	 *            先前的输入数量
	 * */
	public void disposeFeebBackInputNum(ResumeTrain train, int oldInputNum) {
		int newInputNum = ResumeCountUtil.countResume(train);
		int hasInputNum = 0, tempInputNum = 0, id = train.getId(), lastMax = 0, currMax = 0;
		if (newInputNum != oldInputNum) {
			Resume resume = resumeDao.get(train.getResumeId());
			Map<String, Object> map = new ConcurrentHashMap<String, Object>();
			int max = -1;
			List<ResumeTrain> dataList = resumeTrainDao.queryByResumeId(train
					.getResumeId());
			for (ResumeTrain tempData : dataList) {
				if (tempData.getId() == id)
					continue;
				tempInputNum = ResumeCountUtil.countResume(tempData);
				if (tempInputNum > max)
					max = tempInputNum;
			}
			lastMax = oldInputNum > max ? oldInputNum : max;
			currMax = newInputNum > max ? newInputNum : max;
			hasInputNum = resume.getHasInputNum() - lastMax + currMax;
			map.put("hasInputNum", hasInputNum);
			map.put("complete", (int) (hasInputNum
					/ (double) Resume.ALL_INPUT_NUM * 100));
			resumeDao.changeResumeField(train.getResumeId(), map);
		}
	}

	/**
	 * 回调语言能力的输入数量,根据语言能力中的输入数量修改简历完整度
	 * 
	 * @param language
	 *            语言能力
	 * @param oldInputNum
	 *            先前的输入数量
	 * */
	public void disposeFeebBackInputNum(ResumeLanguage language, int oldInputNum) {
		int newInputNum = ResumeCountUtil.countResume(language);
		int hasInputNum = 0, tempInputNum = 0, id = language.getId(), lastMax = 0, currMax = 0;
		if (newInputNum != oldInputNum) {
			Resume resume = resumeDao.get(language.getResumeId());
			Map<String, Object> map = new ConcurrentHashMap<String, Object>();
			int max = -1;
			List<ResumeLanguage> dataList = resumeLanguageDao
					.queryByResumeId(language.getResumeId());
			for (ResumeLanguage tempData : dataList) {
				if (tempData.getId() == id)
					continue;
				tempInputNum = ResumeCountUtil.countResume(tempData);
				if (tempInputNum > max)
					max = tempInputNum;
			}
			lastMax = oldInputNum > max ? oldInputNum : max;
			currMax = newInputNum > max ? newInputNum : max;
			hasInputNum = resume.getHasInputNum() - lastMax + currMax;
			map.put("hasInputNum", hasInputNum);
			map.put("complete", (int) (hasInputNum
					/ (double) Resume.ALL_INPUT_NUM * 100));
			resumeDao.changeResumeField(language.getResumeId(), map);
		}
	}

	/**
	 * 回调IT技能的输入数量,根据IT技能中的输入数量修改简历完整度
	 * 
	 * @param IT
	 *            IT技能
	 * @param oldInputNum
	 *            先前的输入数量
	 * */
	public void disposeFeebBackInputNum(ResumeIT iT, int oldInputNum) {
		int newInputNum = ResumeCountUtil.countResume(iT);
		int hasInputNum = 0, tempInputNum = 0, id = iT.getId(), lastMax = 0, currMax = 0;
		if (newInputNum != oldInputNum) {
			Resume resume = resumeDao.get(iT.getResumeId());
			Map<String, Object> map = new ConcurrentHashMap<String, Object>();
			int max = -1;
			List<ResumeIT> dataList = resumeITDao.queryByResumeId(iT
					.getResumeId());
			for (ResumeIT tempData : dataList) {
				if (tempData.getId() == id)
					continue;
				tempInputNum = ResumeCountUtil.countResume(tempData);
				if (tempInputNum > max)
					max = tempInputNum;
			}
			lastMax = oldInputNum > max ? oldInputNum : max;
			currMax = newInputNum > max ? newInputNum : max;
			hasInputNum = resume.getHasInputNum() - lastMax + currMax;
			map.put("hasInputNum", hasInputNum);
			map.put("complete", (int) (hasInputNum
					/ (double) Resume.ALL_INPUT_NUM * 100));
			resumeDao.changeResumeField(iT.getResumeId(), map);
		}
	}

	/**
	 * 回调项目经验的输入数量,根据项目经验中的输入数量修改简历完整度
	 * 
	 * @param projectExp
	 *            项目经验
	 * @param oldInputNum
	 *            先前的输入数量
	 * */
	public void disposeFeebBackInputNum(ResumeProjectExp projectExp,
			int oldInputNum) {
		int newInputNum = ResumeCountUtil.countResume(projectExp);
		int hasInputNum = 0, tempInputNum = 0, id = projectExp.getId(), lastMax = 0, currMax = 0;
		if (newInputNum != oldInputNum) {
			Resume resume = resumeDao.get(projectExp.getResumeId());
			Map<String, Object> map = new ConcurrentHashMap<String, Object>();
			int max = -1;
			List<ResumeProjectExp> dataList = resumeProjectExpDao
					.queryByResumeId(projectExp.getResumeId());
			for (ResumeProjectExp tempData : dataList) {
				if (tempData.getId() == id)
					continue;
				tempInputNum = ResumeCountUtil.countResume(tempData);
				if (tempInputNum > max)
					max = tempInputNum;
			}
			lastMax = oldInputNum > max ? oldInputNum : max;
			currMax = newInputNum > max ? newInputNum : max;
			hasInputNum = resume.getHasInputNum() - lastMax + currMax;
			map.put("hasInputNum", hasInputNum);
			map.put("complete", (int) (hasInputNum
					/ (double) Resume.ALL_INPUT_NUM * 100));
			resumeDao.changeResumeField(projectExp.getResumeId(), map);
		}
	}

	/**
	 * 回调证书信息的输入数量,根据证书信息中的输入数量修改简历完整度
	 * 
	 * @param certificate
	 *            证书信息
	 * @param oldInputNum
	 *            先前的输入数量
	 * */
	public void disposeFeebBackInputNum(ResumeCertificate certificate,
			int oldInputNum) {
		int newInputNum = ResumeCountUtil.countResume(certificate);
		int hasInputNum = 0, tempInputNum = 0, id = certificate.getId(), lastMax = 0, currMax = 0;
		if (newInputNum != oldInputNum) {
			Resume resume = resumeDao.get(certificate.getResumeId());
			Map<String, Object> map = new ConcurrentHashMap<String, Object>();
			int max = -1;
			List<ResumeCertificate> dataList = resumeCertificateDao
					.queryByResumeId(certificate.getResumeId());
			for (ResumeCertificate tempData : dataList) {
				if (tempData.getId() == id)
					continue;
				tempInputNum = ResumeCountUtil.countResume(tempData);
				if (tempInputNum > max)
					max = tempInputNum;
			}
			lastMax = oldInputNum > max ? oldInputNum : max;
			currMax = newInputNum > max ? newInputNum : max;
			hasInputNum = resume.getHasInputNum() - lastMax + currMax;
			map.put("hasInputNum", hasInputNum);
			map.put("complete", (int) (hasInputNum
					/ (double) Resume.ALL_INPUT_NUM * 100));
			resumeDao.changeResumeField(certificate.getResumeId(), map);
		}
	}

	/**
	 * 回调补充信息的输入数量,根据补充信息中的输入数量修改简历完整度
	 * 
	 * @param otherInfo
	 *            补充信息
	 * @param oldInputNum
	 *            先前的输入数量
	 * */
	public void disposeFeebBackInputNum(ResumeOtherInfo otherInfo,
			int oldInputNum) {
		int newInputNum = ResumeCountUtil.countResume(otherInfo);
		int hasInputNum = 0, tempInputNum = 0, id = otherInfo.getId(), lastMax = 0, currMax = 0;
		if (newInputNum != oldInputNum) {
			Resume resume = resumeDao.get(otherInfo.getResumeId());
			Map<String, Object> map = new ConcurrentHashMap<String, Object>();
			int max = -1;
			List<ResumeOtherInfo> dataList = resumeOtherInfoDao
					.queryByResumeId(otherInfo.getResumeId());
			for (ResumeOtherInfo tempData : dataList) {
				if (tempData.getId() == id)
					continue;
				tempInputNum = ResumeCountUtil.countResume(tempData);
				if (tempInputNum > max)
					max = tempInputNum;
			}
			lastMax = oldInputNum > max ? oldInputNum : max;
			currMax = newInputNum > max ? newInputNum : max;
			hasInputNum = resume.getHasInputNum() - lastMax + currMax;
			map.put("hasInputNum", hasInputNum);
			map.put("complete", (int) (hasInputNum
					/ (double) Resume.ALL_INPUT_NUM * 100));
			resumeDao.changeResumeField(otherInfo.getResumeId(), map);
		}
	}

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
			ResumeEdu resumeEdu) {
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		Resume resume = resumeDao.get(resumeId);
		List<ResumeEdu> dataList = resumeEduDao.queryByResumeId(resumeId);
		int tempNum = 0, lastMax = 0, max = 0;
		for (ResumeEdu tempData : dataList) {
			if (tempData.getId() == id) {
				lastMax = ResumeCountUtil.countResume(tempData);
				continue;
			}
			tempNum = ResumeCountUtil.countResume(tempData);
			if (tempNum > max)
				max = tempNum;
		}
		if (lastMax != max) {
			int hasInputNum = resume.getHasInputNum() - lastMax + max;
			map.put("hasInputNum", hasInputNum);
			map.put("complete", (int) (hasInputNum
					/ (double) Resume.ALL_INPUT_NUM * 100));
			resumeDao.changeResumeField(resumeId, map);
		}
	}

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
			ResumeWorkExp resumeWorkExp) {
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		Resume resume = resumeDao.get(resumeId);
		List<ResumeWorkExp> dataList = resumeWorkExpDao
				.queryByResumeId(resumeId);
		int tempNum = 0, lastMax = 0, max = 0;
		for (ResumeWorkExp tempData : dataList) {
			if (tempData.getId() == id) {
				lastMax = ResumeCountUtil.countResume(tempData);
				continue;
			}
			tempNum = ResumeCountUtil.countResume(tempData);
			if (tempNum > max)
				max = tempNum;
		}
		if (lastMax != max) {
			int hasInputNum = resume.getHasInputNum() - lastMax + max;
			map.put("hasInputNum", hasInputNum);
			map.put("complete", (int) (hasInputNum
					/ (double) Resume.ALL_INPUT_NUM * 100));
			resumeDao.changeResumeField(resumeId, map);
		}
	}

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
			ResumeTrain resumeTrain) {
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		Resume resume = resumeDao.get(resumeId);
		List<ResumeTrain> dataList = resumeTrainDao.queryByResumeId(resumeId);
		int tempNum = 0, lastMax = 0, max = 0;
		for (ResumeTrain tempData : dataList) {
			if (tempData.getId() == id) {
				lastMax = ResumeCountUtil.countResume(tempData);
				continue;
			}
			tempNum = ResumeCountUtil.countResume(tempData);
			if (tempNum > max)
				max = tempNum;
		}
		if (lastMax != max) {
			int hasInputNum = resume.getHasInputNum() - lastMax + max;
			map.put("hasInputNum", hasInputNum);
			map.put("complete", (int) (hasInputNum
					/ (double) Resume.ALL_INPUT_NUM * 100));
			resumeDao.changeResumeField(resumeId, map);
		}
	}

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
			ResumeProjectExp resumeProjectExp) {
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		Resume resume = resumeDao.get(resumeId);
		List<ResumeProjectExp> dataList = resumeProjectExpDao
				.queryByResumeId(resumeId);
		int tempNum = 0, lastMax = 0, max = 0;
		for (ResumeProjectExp tempData : dataList) {
			if (tempData.getId() == id) {
				lastMax = ResumeCountUtil.countResume(tempData);
				continue;
			}
			tempNum = ResumeCountUtil.countResume(tempData);
			if (tempNum > max)
				max = tempNum;
		}
		if (lastMax != max) {
			int hasInputNum = resume.getHasInputNum() - lastMax + max;
			map.put("hasInputNum", hasInputNum);
			map.put("complete", (int) (hasInputNum
					/ (double) Resume.ALL_INPUT_NUM * 100));
			resumeDao.changeResumeField(resumeId, map);
		}
	}

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
			ResumeOtherInfo resumeOtherInfo) {
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		Resume resume = resumeDao.get(resumeId);
		List<ResumeOtherInfo> dataList = resumeOtherInfoDao
				.queryByResumeId(resumeId);
		int tempNum = 0, lastMax = 0, max = 0;
		for (ResumeOtherInfo tempData : dataList) {
			if (tempData.getId() == id) {
				lastMax = ResumeCountUtil.countResume(tempData);
				continue;
			}
			tempNum = ResumeCountUtil.countResume(tempData);
			if (tempNum > max)
				max = tempNum;
		}
		if (lastMax != max) {
			int hasInputNum = resume.getHasInputNum() - lastMax + max;
			map.put("hasInputNum", hasInputNum);
			map.put("complete", (int) (hasInputNum
					/ (double) Resume.ALL_INPUT_NUM * 100));
			resumeDao.changeResumeField(resumeId, map);
		}
	}

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
			ResumeLanguage resumeLanguage) {
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		Resume resume = resumeDao.get(resumeId);
		List<ResumeLanguage> dataList = resumeLanguageDao
				.queryByResumeId(resumeId);
		int tempNum = 0, lastMax = 0, max = 0;
		for (ResumeLanguage tempData : dataList) {
			if (tempData.getId() == id) {
				lastMax = ResumeCountUtil.countResume(tempData);
				continue;
			}
			tempNum = ResumeCountUtil.countResume(tempData);
			if (tempNum > max)
				max = tempNum;
		}
		if (lastMax != max) {
			int hasInputNum = resume.getHasInputNum() - lastMax + max;
			map.put("hasInputNum", hasInputNum);
			map.put("complete", (int) (hasInputNum
					/ (double) Resume.ALL_INPUT_NUM * 100));
			resumeDao.changeResumeField(resumeId, map);
		}
	}

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
	public void disposeFeebBackInputNum(int resumeId, int id, ResumeIT resumeIT) {
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		Resume resume = resumeDao.get(resumeId);
		List<ResumeIT> dataList = resumeITDao.queryByResumeId(resumeId);
		int tempNum = 0, lastMax = 0, max = 0;
		for (ResumeIT tempData : dataList) {
			if (tempData.getId() == id) {
				lastMax = ResumeCountUtil.countResume(tempData);
				continue;
			}
			tempNum = ResumeCountUtil.countResume(tempData);
			if (tempNum > max)
				max = tempNum;
		}
		if (lastMax != max) {
			int hasInputNum = resume.getHasInputNum() - lastMax + max;
			map.put("hasInputNum", hasInputNum);
			map.put("complete", (int) (hasInputNum
					/ (double) Resume.ALL_INPUT_NUM * 100));
			resumeDao.changeResumeField(resumeId, map);
		}
	}

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
	public void disposeFeebBackInputNum(int resumeId, int id,
			ResumeCertificate resumeCertificate) {
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		Resume resume = resumeDao.get(resumeId);
		List<ResumeCertificate> dataList = resumeCertificateDao
				.queryByResumeId(resumeId);
		int tempNum = 0, lastMax = 0, max = 0;
		for (ResumeCertificate tempData : dataList) {
			if (tempData.getId() == id) {
				lastMax = ResumeCountUtil.countResume(tempData);
				continue;
			}
			tempNum = ResumeCountUtil.countResume(tempData);
			if (tempNum > max)
				max = tempNum;
		}
		if (lastMax != max) {
			int hasInputNum = resume.getHasInputNum() - lastMax + max;
			map.put("hasInputNum", hasInputNum);
			map.put("complete", (int) (hasInputNum
					/ (double) Resume.ALL_INPUT_NUM * 100));
			resumeDao.changeResumeField(resumeId, map);
		}
	}

	/**
	 * 根据简历编号查询简历对象
	 * 
	 * @param id
	 *            简历编号
	 * */
	public Resume disposeQuerySimpleResumeById(int id) {
		return resumeDao.get(id);
	}

}
