package com.qgschina.main.employ.model;

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
 * 招聘信息
 * */
@Entity
@Table(name="T_EMPLOY")
@DynamicUpdate(true)
public class Employ {
	//编号
	private int id;
	//招聘职位名称
	private String name;
	//创建时间
	private Date createDate;
	//职位描述的数量
	private int jobDescNum;
	//职位需求的数量
	private int jobRequestNum;
	//专业要求
	private String specialtyRequest;
	//学历要求
	private String educationRequest;
	//工作经验
	private String workExp;
	//招聘数量
	private int employNum;
	//年龄条件
	private String ageLimit;
	//职位描述
	private List<EmployItem> jobDesc;
	//职位要求
	private List<EmployItem> jobRequest;
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Transient
	public List<EmployItem> getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(List<EmployItem> jobDesc) {
		this.jobDesc = jobDesc;
	}
	@Transient
	public List<EmployItem> getJobRequest() {
		return jobRequest;
	}
	public void setJobRequest(List<EmployItem> jobRequest) {
		this.jobRequest = jobRequest;
	}
	@Column(name="CREATE_DATE")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Transient
	public int getJobDescNum() {
		return jobDescNum;
	}
	public void setJobDescNum(int jobDescNum) {
		this.jobDescNum = jobDescNum;
	}
	@Transient
	public int getJobRequestNum() {
		return jobRequestNum;
	}
	public void setJobRequestNum(int jobRequestNum) {
		this.jobRequestNum = jobRequestNum;
	}
	@Column(name="specialty_request")
	public String getSpecialtyRequest() {
		return specialtyRequest;
	}
	public void setSpecialtyRequest(String specialtyRequest) {
		this.specialtyRequest = specialtyRequest;
	}
	@Column(name="education_request")
	public String getEducationRequest() {
		return educationRequest;
	}
	public void setEducationRequest(String educationRequest) {
		this.educationRequest = educationRequest;
	}
	@Column(name="work_exp")
	public String getWorkExp() {
		return workExp;
	}
	public void setWorkExp(String workExp) {
		this.workExp = workExp;
	}
	@Column(name="employ_num")
	public int getEmployNum() {
		return employNum;
	}
	public void setEmployNum(int employNum) {
		this.employNum = employNum;
	}
	@Column(name="age_limit")
	public String getAgeLimit() {
		return ageLimit;
	}
	public void setAgeLimit(String ageLimit) {
		this.ageLimit = ageLimit;
	}
}
