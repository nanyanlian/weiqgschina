package com.qgschina.main.resume.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/**
 * 简历内容 - 语言能力
 * */
@Entity
@Table(name="T_RESUME_LANGUAGE")
@DynamicUpdate(true)
public class ResumeLanguage {
	//语言能力编号
	private int id;
	//语言类别
	private String languageType;
	//掌握程度
	private String skill;
	//读写能力
	private String writeRead;
	//听说能力
	private String listenSpeak;
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
	@Column(name="LANGUAGE_TYPE")
	public String getLanguageType() {
		return languageType;
	}
	public void setLanguageType(String languageType) {
		this.languageType = languageType;
	}
	@Column(name="SKILL")
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	@Column(name="WRITE_READ")
	public String getWriteRead() {
		return writeRead;
	}
	public void setWriteRead(String writeRead) {
		this.writeRead = writeRead;
	}
	@Column(name="LISTEN_SPEAK")
	public String getListenSpeak() {
		return listenSpeak;
	}
	public void setListenSpeak(String listenSpeak) {
		this.listenSpeak = listenSpeak;
	}
	@Column(name="RESUME_ID")
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
}
