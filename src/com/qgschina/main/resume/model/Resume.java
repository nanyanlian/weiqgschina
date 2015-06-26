package com.qgschina.main.resume.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

/**
 * 简历
 * */
@Entity
@Table(name="T_RESUME")
@DynamicUpdate(true)
public class Resume {
	//所有可输入的域
	public static final int ALL_INPUT_NUM = 60;
	//简历编号
	private int id;
	//建立名称
	private String name;
	//简历完整度
	private int complete;
	//简历开放程度
	private String openLevel;
	//创建时间
	private Date createDate;
	//已经输入值的域
	private int hasInputNum;
	//简历所属用户的用户编号
	private String openid;
	//个人信息
	private ResumePersonInfo personInfo;
	//求职意向
	private ResumeApplyJob applyJob;
	//教育经历
	private List<ResumeEdu> eduList = new ArrayList<ResumeEdu>();
	//工作经验
	private List<ResumeWorkExp> workExpList = new ArrayList<ResumeWorkExp>();
	//培训经历
	private List<ResumeTrain> trainList = new ArrayList<ResumeTrain>();
	//语言能力
	private List<ResumeLanguage> languageList = new ArrayList<ResumeLanguage>();
	//IT技能
	private List<ResumeIT> iTList = new ArrayList<ResumeIT>();
	//项目经验
	private List<ResumeProjectExp> projectExpList = new ArrayList<ResumeProjectExp>();
	//证书
	private List<ResumeCertificate> certificateList = new ArrayList<ResumeCertificate>();
	//其他
	private List<ResumeOtherInfo> otherInfoList = new ArrayList<ResumeOtherInfo>();
	
	public Resume() {
		createDate = new Date();
		name = "未命名简历";
		complete = 0;
		openLevel = "保密";
	}
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="COMPLETE")
	public int getComplete() {
		return complete;
	}
	public void setComplete(int complete) {
		this.complete = complete;
	}
	@Column(name="OPEN_LEVEL")
	public String getOpenLevel() {
		return openLevel;
	}
	public void setOpenLevel(String openLevel) {
		this.openLevel = openLevel;
	}
	@Column(name="CREATE_DATE")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Column(name="HAS_INPUT_NUM")
	public int getHasInputNum() {
		return hasInputNum;
	}
	public void setHasInputNum(int hasInputNum) {
		this.hasInputNum = hasInputNum;
	}
	@Column(name="OPEN_ID")
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	@Transient
	public ResumePersonInfo getPersonInfo() {
		return personInfo;
	}
	public void setPersonInfo(ResumePersonInfo personInfo) {
		this.personInfo = personInfo;
	}
	@Transient
	public List<ResumeEdu> getEduList() {
		return eduList;
	}
	public void setEduList(List<ResumeEdu> eduList) {
		this.eduList = eduList;
	}
	@Transient
	public List<ResumeWorkExp> getWorkExpList() {
		return workExpList;
	}
	public void setWorkExpList(List<ResumeWorkExp> workExpList) {
		this.workExpList = workExpList;
	}
	@Transient
	public ResumeApplyJob getApplyJob() {
		return applyJob;
	}
	public void setApplyJob(ResumeApplyJob applyJob) {
		this.applyJob = applyJob;
	}
	@Transient
	public List<ResumeTrain> getTrainList() {
		return trainList;
	}
	public void setTrainList(List<ResumeTrain> trainList) {
		this.trainList = trainList;
	}
	@Transient
	public List<ResumeLanguage> getLanguageList() {
		return languageList;
	}
	public void setLanguageList(List<ResumeLanguage> languageList) {
		this.languageList = languageList;
	}
	@Transient
	public List<ResumeIT> getiTList() {
		return iTList;
	}
	public void setiTList(List<ResumeIT> iTList) {
		this.iTList = iTList;
	}
	@Transient
	public List<ResumeProjectExp> getProjectExpList() {
		return projectExpList;
	}
	public void setProjectExpList(List<ResumeProjectExp> projectExpList) {
		this.projectExpList = projectExpList;
	}
	@Transient
	public List<ResumeCertificate> getCertificateList() {
		return certificateList;
	}
	public void setCertificateList(List<ResumeCertificate> certificateList) {
		this.certificateList = certificateList;
	}
	@Transient
	public List<ResumeOtherInfo> getOtherInfoList() {
		return otherInfoList;
	}
	public void setOtherInfoList(List<ResumeOtherInfo> otherInfoList) {
		this.otherInfoList = otherInfoList;
	}
}
