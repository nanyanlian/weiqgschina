package com.qgschina.main.resume.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/**
 * 简历内容 - 个人信息
 * */
@Entity
@Table(name="T_RESUME_PERSONINFO")
@DynamicUpdate(true)
public class ResumePersonInfo {
	//个人信息编号
	private int id;
	//简历名称
	private String resumeName;
	//公开程度
	private String openess;
	//姓名
	private String name;
	//性别
	private String gender;
	//生日
	private String birthday;
	//工作年限
	private String workLife;
	//证件类别
	private String paperType;
	//证件号
	private String paperNo;
	//手机号
	private String phone;
	//居住省
	private String liveProvince;
	//居住市
	private String liveCity;
	//户口省
	private String houseProvince;
	//户口市
	private String houseCity;
	//邮箱
	private String email;
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
	@Column(name="RESUME_NAME")
	public String getResumeName() {
		return resumeName;
	}
	public void setResumeName(String resumeName) {
		this.resumeName = resumeName;
	}
	@Column(name="openess")
	public String getOpeness() {
		return openess;
	}
	public void setOpeness(String openess) {
		this.openess = openess;
	}
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="GENDER")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Column(name="BIRTHDAY")
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	@Column(name="WORK_LIFE")
	public String getWorkLife() {
		return workLife;
	}
	public void setWorkLife(String workLife) {
		this.workLife = workLife;
	}
	@Column(name="PAPER_TYPE")
	public String getPaperType() {
		return paperType;
	}
	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}
	@Column(name="PAPER_NO")
	public String getPaperNo() {
		return paperNo;
	}
	public void setPaperNo(String paperNo) {
		this.paperNo = paperNo;
	}
	@Column(name="PHONE")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name="LIVE_PROVINCE")
	public String getLiveProvince() {
		return liveProvince;
	}
	public void setLiveProvince(String liveProvince) {
		this.liveProvince = liveProvince;
	}
	@Column(name="LIVE_CITY")
	public String getLiveCity() {
		return liveCity;
	}
	public void setLiveCity(String liveCity) {
		this.liveCity = liveCity;
	}
	@Column(name="HOUSE_PROVINCE")
	public String getHouseProvince() {
		return houseProvince;
	}
	public void setHouseProvince(String houseProvince) {
		this.houseProvince = houseProvince;
	}
	@Column(name="HOUSE_CITY")
	public String getHouseCity() {
		return houseCity;
	}
	public void setHouseCity(String houseCity) {
		this.houseCity = houseCity;
	}
	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="RESUME_ID")
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
}
