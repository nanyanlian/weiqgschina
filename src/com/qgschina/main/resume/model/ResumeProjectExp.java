package com.qgschina.main.resume.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/**
 * 简历内容 - 项目经验
 * */
@Entity
@Table(name="T_RESUME_PROJECTEXP")
@DynamicUpdate(true)
public class ResumeProjectExp {
	//项目经验编号
	private int id;
	//开始时间
	private String startDate;
	//结束时间
	private String endDate;
	//项目名称
	private String projectName;
	//开发工具
	private String devTool;
	//硬件环境
	private String hardwareEnvir;
	//软件环境
	private String softwareEnvir;
	//项目描述
	private String projectDesc;
	//责任描述
	private String jobDesc;
	//所属简历编号
	private int resumeId;
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="START_DATE")
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	@Column(name="END_DATE")
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Column(name="PROJECT_NAME")
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	@Column(name="DEV_TOOL")
	public String getDevTool() {
		return devTool;
	}
	public void setDevTool(String devTool) {
		this.devTool = devTool;
	}
	@Column(name="HARDWARE_ENVIR")
	public String getHardwareEnvir() {
		return hardwareEnvir;
	}
	public void setHardwareEnvir(String hardwareEnvir) {
		this.hardwareEnvir = hardwareEnvir;
	}
	@Column(name="SOFTWARE_ENVIR")
	public String getSoftwareEnvir() {
		return softwareEnvir;
	}
	public void setSoftwareEnvir(String softwareEnvir) {
		this.softwareEnvir = softwareEnvir;
	}
	@Column(name="PROJECT_DESC")
	public String getProjectDesc() {
		return projectDesc;
	}
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}
	@Column(name="JOB_DESC")
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	@Column(name="RESUME_ID")
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
	
}
