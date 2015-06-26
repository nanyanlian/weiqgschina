package com.qgschina.main.resume.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/**
 * 简历内容 - IT
 * */
@Entity
@Table(name="T_RESUME_IT")
@DynamicUpdate(true)
public class ResumeIT {
	//IT编号
	private int id;
	//技能大类
	private String bigSkill;
	//技能小类
	private String skill;
	//使用时间
	private String useDate;
	//掌握程度
	private String level;
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
	@Column(name="BIG_SKILL")
	public String getBigSkill() {
		return bigSkill;
	}
	public void setBigSkill(String bigSkill) {
		this.bigSkill = bigSkill;
	}
	@Column(name="SKILL")
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	@Column(name="USE_DATE")
	public String getUseDate() {
		return useDate;
	}
	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}
	@Column(name="SKILL_LEVEL")
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	@Column(name="RESUME_ID")
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
	
	
}
