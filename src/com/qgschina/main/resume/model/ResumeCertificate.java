package com.qgschina.main.resume.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/**
 * 简历内容 - 证书
 * */
@Entity
@Table(name="T_RESUME_CERTIFICATE")
@DynamicUpdate(true)
public class ResumeCertificate {
	//证书简历编号
	private int id;
	//证书名称
	private String certificateName;
	//获得时间
	private String gainDate;
	//成绩
	private String score;
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
	@Column(name="CERTIFICATE_NAME")
	public String getCertificateName() {
		return certificateName;
	}
	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}
	@Column(name="GAIN_DATE")
	public String getGainDate() {
		return gainDate;
	}
	public void setGainDate(String gainDate) {
		this.gainDate = gainDate;
	}
	@Column(name="SCORE")
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	@Column(name="RESUME_ID")
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
}
