package com.qgschina.main.resume.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qgschina.main.employ.model.Employ;
import com.qgschina.main.employ.service.EmployService;
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
import com.qgschina.main.resume.service.ResumeApplyJobService;
import com.qgschina.main.resume.service.ResumeCertificateService;
import com.qgschina.main.resume.service.ResumeEduService;
import com.qgschina.main.resume.service.ResumeITService;
import com.qgschina.main.resume.service.ResumeLanguageService;
import com.qgschina.main.resume.service.ResumeOtherInfoService;
import com.qgschina.main.resume.service.ResumePersonalInfoService;
import com.qgschina.main.resume.service.ResumeProjectExpService;
import com.qgschina.main.resume.service.ResumeRegisterService;
import com.qgschina.main.resume.service.ResumeService;
import com.qgschina.main.resume.service.ResumeTrainService;
import com.qgschina.main.resume.service.ResumeWorkExpService;
import com.qgschina.main.resume.util.ResumeCountUtil;
import com.qgschina.main.user.model.User;

@Controller
@RequestMapping("/resume")
public class ResumeController {
	@Resource
	private EmployService employService;
	@Resource
	private ResumeService resumeService;
	@Resource
	private ResumeEduService resumeEduService;
	@Resource
	private ResumeWorkExpService resumeWorkExpService;
	@Resource
	private ResumePersonalInfoService resumePersonalInfoService;
	@Resource
	private ResumeApplyJobService resumeApplyJobService;
	@Resource
	private ResumeTrainService resumeTrainService;
	@Resource
	private ResumeLanguageService resumeLanguageService;
	@Resource
	private ResumeITService resumeITService;
	@Resource
	private ResumeCertificateService resumeCertificateService;
	@Resource
	private ResumeProjectExpService resumeProjectExpService;
	@Resource
	private ResumeOtherInfoService resumeOtherInfoService;
	@Resource
	private ResumeRegisterService resumeRegisterService;

	/**
	 * 前往简历列表页面
	 * 
	 * @param employId
	 *            职位编号
	 * */
	@RequestMapping("/toResumeList.do")
	public String toResumeList(HttpSession session, int employId,
			HttpServletRequest request) {
		User user = (User) session.getAttribute("user");
		String openid = user.getOpenid();
		Employ employ = employService.disposeEmployById(employId);
		session.setAttribute("resumeEmploy", employ);
		request.setAttribute("employ", employ);
		request.setAttribute("resumeList",
				resumeService.disposeListResumeByOpenid(openid));
		return "resume/resumeList";
	}

	/**
	 * 简历申请
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	@RequestMapping("/registerResume.do")
	@ResponseBody
	public String registerResume(int resumeId) {
		resumeRegisterService.disposeCreate(resumeService
				.disposeQuerySimpleResumeById(resumeId));
		return "success";
	}

	/**
	 * 查询该简历是否能被申请(必须信息是否填写)
	 * */
	@RequestMapping("/queryCouldRegister.do")
	@ResponseBody
	public String queryCouldRegister(int resumeId) {
		if (resumePersonalInfoService.disposeExist(resumeId)
				&& resumeApplyJobService.disposeExist(resumeId))
			return "success";
		return "error";
	}

	/**
	 * 创建简历
	 * */
	@RequestMapping("/addNewResume.do")
	public String addNewResume(HttpSession session, HttpServletRequest request) {
		User user = (User) session.getAttribute("user");
		String openid = user.getOpenid();
		int resumeId = resumeService.disposeCreateEmptyResume(openid);
		request.setAttribute("resumeId", resumeId);
		request.setAttribute("mode", "add");
		return "resume/editResumeType";
	}

	/**
	 * 前往编辑个人信息的页面
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	@RequestMapping("/toEditPersonInfo.do")
	public String toEditPersonInfo(int resumeId, HttpServletRequest request) {
		request.setAttribute("resumeId", resumeId);
		ResumePersonInfo personInfo = resumePersonalInfoService
				.disposeQueryByResumeId(resumeId);
		if (personInfo == null) {
			request.setAttribute("mode", "add");
			personInfo = new ResumePersonInfo();
		} else {
			request.setAttribute("mode", "edit");
		}
		request.setAttribute("oldInputNum",
				ResumeCountUtil.countResume(personInfo));
		request.setAttribute("personInfo", personInfo);
		return "/resume/editResume_personInfo";
	}

	/**
	 * 前往添加教育经历页面
	 * */
	@RequestMapping("/toAddEduExper.do")
	public String toAddEduExper(int resumeId, HttpServletRequest request) {
		request.setAttribute("resumeId", resumeId);
		request.setAttribute("eduId", 0);
		request.setAttribute("mode", "add");
		request.setAttribute("edu", new ResumeEdu());
		request.setAttribute("oldInputNum", 0);
		return "/resume/editResume_edu";
	}

	/**
	 * 前往编辑教育经历页面
	 * 
	 * @param resumeId
	 *            简历编号
	 * @param eduId
	 *            教育经历编号
	 * */
	@RequestMapping("/toEditEduExper.do")
	public String toEditEduExper(int resumeId, int eduId,
			HttpServletRequest request) {
		ResumeEdu edu = resumeEduService.disposeQueryEduById(eduId);
		request.setAttribute("resumeId", resumeId);
		request.setAttribute("mode", "edit");
		request.setAttribute("edu", edu);
		request.setAttribute("eduId", eduId);
		request.setAttribute("oldInputNum", ResumeCountUtil.countResume(edu));
		return "/resume/editResume_edu";
	}

	/**
	 * 前往添加工作经历页面
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	@RequestMapping("/toAddWorkExp.do")
	public String toAddWorkExp(int resumeId, HttpServletRequest request) {
		request.setAttribute("resumeId", resumeId);
		request.setAttribute("id", 0);
		request.setAttribute("mode", "add");
		request.setAttribute("oldInputNum", 0);
		return "/resume/editResume_workExp";
	}

	/**
	 * 前往编辑工作经历页面
	 * 
	 * @param resumeId
	 *            简历编号
	 * @param workExpId
	 *            工作经验编号
	 * */
	@RequestMapping("/toEditWorkExp.do")
	public String toEditWorkExp(int resumeId, int workExpId,
			HttpServletRequest request) {
		ResumeWorkExp workExp = resumeWorkExpService
				.disposeQueryById(workExpId);
		request.setAttribute("resumeId", resumeId);
		request.setAttribute("id", workExpId);
		request.setAttribute("mode", "edit");
		request.setAttribute("workExp", workExp);
		request.setAttribute("oldInputNum",
				ResumeCountUtil.countResume(workExp));
		return "/resume/editResume_workExp";
	}

	/**
	 * 前往编辑求职意向页面
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	@RequestMapping("/toEditSearchWork.do")
	public String toEditSearchWork(int resumeId, HttpServletRequest request) {
		ResumeApplyJob resumeApplyJob = resumeApplyJobService
				.disposeQueryByResumeId(resumeId);
		if (resumeApplyJob == null) {
			resumeApplyJob = new ResumeApplyJob();
			request.setAttribute("id", 0);
			request.setAttribute("mode", "add");
		} else {
			request.setAttribute("id", resumeApplyJob.getId());
			request.setAttribute("mode", "edit");
		}
		request.setAttribute("applyJob", resumeApplyJob);
		request.setAttribute("oldInputNum",
				ResumeCountUtil.countResume(resumeApplyJob));
		request.setAttribute("resumeId", resumeId);
		return "/resume/editResume_applyJob";
	}

	/**
	 * 前往添加培训经历页面
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	@RequestMapping("/toAddTrain.do")
	public String toAddTrain(int resumeId, HttpServletRequest request) {
		request.setAttribute("resumeId", resumeId);
		request.setAttribute("mode", "add");
		request.setAttribute("id", 0);
		request.setAttribute("oldInputNum", 0);
		return "/resume/editResume_train";
	}

	/**
	 * 前往编辑培训经历页面
	 * 
	 * @param resumeId
	 *            简历编号
	 * @param trainId
	 *            培训经历编号
	 * */
	@RequestMapping("/toEditTrain.do")
	public String toEditTrain(int resumeId, int trainId,
			HttpServletRequest request) {
		ResumeTrain train = resumeTrainService.disposeQueryById(trainId);
		request.setAttribute("resumeId", resumeId);
		request.setAttribute("mode", "edit");
		request.setAttribute("train", train);
		request.setAttribute("id", trainId);
		request.setAttribute("oldInputNum", ResumeCountUtil.countResume(train));
		return "/resume/editResume_train";
	}

	/**
	 * 前往添加语言能力页面
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	@RequestMapping("/toAddLanguage.do")
	public String toAddLanguage(int resumeId, HttpServletRequest request) {
		request.setAttribute("resumeId", resumeId);
		request.setAttribute("mode", "add");
		request.setAttribute("id", 0);
		request.setAttribute("language", new ResumeLanguage());
		request.setAttribute("oldInputNum", 0);
		return "/resume/editResume_language";
	}

	/**
	 * 前往编辑语言能力页面
	 * 
	 * @param resumeId
	 *            简历编号
	 * @param languageId
	 *            语言能力编号
	 * */
	@RequestMapping("/toEditLanguage.do")
	public String toEditLanguage(int resumeId, int languageId,
			HttpServletRequest request) {
		ResumeLanguage language = resumeLanguageService
				.disposeQueryById(languageId);
		request.setAttribute("resumeId", resumeId);
		request.setAttribute("id", languageId);
		request.setAttribute("language", language);
		request.setAttribute("mode", "edit");
		request.setAttribute("oldInputNum",
				ResumeCountUtil.countResume(language));
		return "/resume/editResume_language";
	}

	/**
	 * 前往添加IT技能页面
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	@RequestMapping("/toAddIT.do")
	public String toAddIT(int resumeId, HttpServletRequest request) {
		request.setAttribute("resumeId", resumeId);
		request.setAttribute("mode", "add");
		request.setAttribute("id", 0);
		request.setAttribute("oldInputNum", 0);
		request.setAttribute("IT", new ResumeIT());
		return "/resume/editResume_IT";
	}

	/**
	 * 前往编辑IT技能页面
	 * 
	 * @param resumeId
	 *            简历编号
	 * @param ITId
	 *            IT编号
	 * */
	@RequestMapping("/toEditIT.do")
	public String toEditIT(int resumeId, int ITId, HttpServletRequest request) {
		ResumeIT IT = resumeITService.disposeQueryById(ITId);
		request.setAttribute("resumeId", resumeId);
		request.setAttribute("mode", "edit");
		request.setAttribute("IT", IT);
		request.setAttribute("oldInputNum", ResumeCountUtil.countResume(IT));
		request.setAttribute("id", ITId);
		return "/resume/editResume_IT";
	}

	/**
	 * 前往添加项目经验页面
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	@RequestMapping("/toAddProjectExp.do")
	public String toAddProjectExp(int resumeId, HttpServletRequest request) {
		request.setAttribute("resumeId", resumeId);
		request.setAttribute("mode", "add");
		request.setAttribute("id", 0);
		request.setAttribute("oldInputNum", 0);
		request.setAttribute("projectExp", new ResumeProjectExp());
		return "/resume/editResume_projectExp";
	}

	/**
	 * 前往编辑项目经验页面
	 * 
	 * @param resumeId
	 *            简历编号
	 * 
	 * @param projectExpId
	 *            项目经验编号
	 * */
	@RequestMapping("/toEditProjectExp.do")
	public String toEditProjectExp(int resumeId, int projectExpId,
			HttpServletRequest request) {
		ResumeProjectExp projectExp = resumeProjectExpService
				.disposeQueryById(projectExpId);
		request.setAttribute("resumeId", resumeId);
		request.setAttribute("mode", "edit");
		request.setAttribute("id", projectExpId);
		request.setAttribute("oldInputNum",
				ResumeCountUtil.countResume(projectExp));
		request.setAttribute("projectExp", projectExp);
		return "/resume/editResume_projectExp";
	}

	/**
	 * 前往添加证书页面
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	@RequestMapping("/toAddCertificate.do")
	public String toAddCertificate(int resumeId, HttpServletRequest request) {
		request.setAttribute("resumeId", resumeId);
		request.setAttribute("mode", "add");
		request.setAttribute("oldInputNum", 0);
		request.setAttribute("id", 0);
		request.setAttribute("certificate", new ResumeCertificate());
		return "/resume/editResume_certificate";
	}

	/**
	 * 前往编辑证书页面
	 * 
	 * @param resumeId
	 *            简历编号
	 * @param certificateId
	 *            证书编号
	 * */
	@RequestMapping("/toEditCertificate.do")
	public String toEditCertificate(int resumeId, int certificateId,
			HttpServletRequest request) {
		ResumeCertificate certificate = resumeCertificateService
				.disposeQueryById(certificateId);
		request.setAttribute("resumeId", resumeId);
		request.setAttribute("mode", "add");
		request.setAttribute("id", certificateId);
		request.setAttribute("oldInputNum",
				ResumeCountUtil.countResume(certificate));
		request.setAttribute("certificate", certificate);
		return "/resume/editResume_certificate";
	}

	/**
	 * 前往添加补充信息页面
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	@RequestMapping("/toAddOtherInfo.do")
	public String toAddOtherInfo(int resumeId, HttpServletRequest request) {
		request.setAttribute("resumeId", resumeId);
		request.setAttribute("mode", "add");
		request.setAttribute("id", 0);
		request.setAttribute("otherInfo", new ResumeOtherInfo());
		request.setAttribute("oldInputNum", 0);
		return "/resume/editResume_other";
	}

	/**
	 * 前往编辑补充信息页面
	 * 
	 * @param resumeId
	 *            简历编号
	 * @param otherInfoId
	 *            补充信息编号
	 * */
	@RequestMapping("/toEditOtherInfo.do")
	public String toEditOtherInfo(int resumeId, int otherInfoId,
			HttpServletRequest request) {
		ResumeOtherInfo otherInfo = resumeOtherInfoService
				.queryById(otherInfoId);
		request.setAttribute("resumeId", resumeId);
		request.setAttribute("mode", "edit");
		request.setAttribute("id", otherInfoId);
		request.setAttribute("oldInputNum",
				ResumeCountUtil.countResume(otherInfo));
		request.setAttribute("otherInfo", otherInfo);
		return "/resume/editResume_other";
	}

	/**
	 * 前往添加额外信息页面
	 * */
	@RequestMapping("/toEditExtraInfo.do")
	public String toEditExtraInfo(int resumeId, String mode,
			HttpServletRequest request) {
		request.setAttribute("resume",
				resumeService.disposeQueryResumeExtraInfoById(resumeId));
		request.setAttribute("resumeId", resumeId);
		request.setAttribute("mode", mode);
		return "/resume/editExtraMessageType";
	}

	/**
	 * 前往编辑简历页面
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	@RequestMapping("/editResume.do")
	public String editResume(HttpServletRequest request, int resumeId) {
		Resume resume = resumeService.disposeQueryResumeById(resumeId);
		request.setAttribute("resume", resume);
		request.setAttribute("resumeId", resumeId);
		return "/resume/editResumeType";
	}

	/**
	 * 删除简历
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	@RequestMapping("/delResume.do")
	@ResponseBody
	public String delResume(int resumeId) {
		resumeService.disposeDelResume(resumeId);
		return "success";
	}
}
