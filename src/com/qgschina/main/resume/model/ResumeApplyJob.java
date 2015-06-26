package com.qgschina.main.resume.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/**
 * 简历内容 - 求职意向
 * */
@Entity
@Table(name="T_RESUME_APPLYJOB")
@DynamicUpdate(true)
public class ResumeApplyJob {
	//求职意向编号
	private int id;
	//工作类型
	private String workType;
	//期望薪水
	private String salary;
	//到岗时间
	private String workDate;
	//自我评价
	private String selfDesc;
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
	@Column(name="WORK_TYPE")
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	@Column(name="SALARY")
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	@Column(name="WORK_DATE")
	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	@Column(name="SELF_DESC")
	public String getSelfDesc() {
		return selfDesc;
	}
	public void setSelfDesc(String selfDesc) {
		this.selfDesc = selfDesc;
	}
	@Column(name="RESUME_ID")
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
}
