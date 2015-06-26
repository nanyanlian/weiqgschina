package com.qgschina.main.resume.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/**
 * 简历内容 - 培训经历
 * */
@Entity
@Table(name="T_RESUME_TRAIN")
@DynamicUpdate(true)
public class ResumeTrain {
	//培训经历编号
	private int id;
	//开始时间
	private String startDate;
	//结束时间
	private String endDate;
	//培训机构
	private String school;
	//培训地点
	private String schoolPosition;
	//培训课程
	private String course;
	//获得证书
	private String certificate;
	//详细描述
	private String trainDesc;
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
	@Column(name="SCHOOL")
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	@Column(name="SCHOOL_POSITION")
	public String getSchoolPosition() {
		return schoolPosition;
	}
	public void setSchoolPosition(String schoolPosition) {
		this.schoolPosition = schoolPosition;
	}
	@Column(name="COURSE")
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Column(name="CERTIFICATE")
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	@Column(name="TRAIN_DESC")
	public String getTrainDesc() {
		return trainDesc;
	}
	public void setTrainDesc(String trainDesc) {
		this.trainDesc = trainDesc;
	}
	@Column(name="RESUME_ID")
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
}
