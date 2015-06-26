package com.qgschina.main.resume.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/**
 * 简历申请
 * */
@Entity
@Table(name="T_RESUME_REGISTER")
@DynamicUpdate(true)
public class ResumeRegister {
	//编号
	private int id;
	//简历编号
	private int resumeId;
	//简历名称
	private String resumeName;
	//申请时间
	private Date createDate;
	
	public ResumeRegister() {
		createDate = new Date();
	}
	public ResumeRegister(Resume resume) {
		resumeId = resume.getId();
		resumeName = resume.getName();
		createDate = new Date();
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
	@Column(name="RESUME_ID")
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
	@Column(name="RESUME_NAME")
	public String getResumeName() {
		return resumeName;
	}
	public void setResumeName(String resumeName) {
		this.resumeName = resumeName;
	}
	@Column(name="CREATE_DATE")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
