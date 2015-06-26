package com.qgschina.main.address.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="T_USER_HAS_ADDRESS_BOOK")
@DynamicUpdate(true)
public class UserHasAddressBook {
	//微信用户通讯录匹配表编号
	private int id;
	//微信用户id
	private String openid;
	//工号
	private String jobNo;
	
	public UserHasAddressBook() {}
	public UserHasAddressBook(String openid) {
		this.openid = openid;
	}
	public UserHasAddressBook(String openid,String jobNo) {
		this.openid = openid;
		this.jobNo = jobNo;
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
	@Column(name="OPENID")
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	@Column(name="JOB_NO")
	public String getJobNo() {
		return jobNo;
	}
	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}
}
