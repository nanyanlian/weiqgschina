package com.qgschina.main.address.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/**
 * 通讯录
 * */
@Entity
@Table(name="T_ADDRESS_BOOK")
@DynamicUpdate(true)
public class AddressBook {
	//通讯录编号
	private int id;
	//工号
	private String jobNo;
	//姓名
	private String name;
	//座机
	private String telePhone;
	//移动电话
	private String mobilePhone;
	//移动电话2
	private String mobilePhoneBak;
	//邮箱
	private String email;
	//拼音缩写
	private String pinyinFirst;		
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="JOB_NO")
	public String getJobNo() {
		return jobNo;
	}
	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="TELEPHONE")
	public String getTelePhone() {
		return telePhone;
	}
	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}
	@Column(name="MOBILE_PHONE")
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	@Column(name="MOBILE_PHONE_BAK")
	public String getMobilePhoneBak() {
		return mobilePhoneBak;
	}
	public void setMobilePhoneBak(String mobilePhoneBak) {
		this.mobilePhoneBak = mobilePhoneBak;
	}
	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="PINYIN_FIRST")
	public String getPinyinFirst() {
		return pinyinFirst;
	}
	public void setPinyinFirst(String pinyinFirst) {
		this.pinyinFirst = pinyinFirst;
	}
}
