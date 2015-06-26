package com.qgschina.main.employ.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/**
 * 招聘细目(项目)
 * */
@Entity
@Table(name = "T_EMPLOY_ITEM")
@DynamicUpdate(true)
public class EmployItem {
	// 项目编号
	private int id;
	// 项目内容
	private String content;
	// 所属的招聘信息的编号
	private int employId;
	// 序列号
	private int serial;
	// 招聘项目类型 1|2 , 1工作描述 , 2工作需求
	private int type;
	// 招聘细目类别 - 工作描述
	public static final int EMPLOY_ITEM_TYPE_JOB_DESC = 1;
	// 招聘细目类别 - 工作需求
	public static final int EMPLOY_ITEM_TYPE_JOB_REQ = 2;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "CONTENT")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "EMPLOY_ID")
	public int getEmployId() {
		return employId;
	}

	public void setEmployId(int employId) {
		this.employId = employId;
	}

	@Column(name = "serial")
	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	@Column(name = "TYPE")
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
