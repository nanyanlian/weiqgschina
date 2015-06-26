package com.qgschina.main.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.nyl.wxframework.task.usermanager.support.OauthUserInfo;

/**
 * 微信用户
 * */
@Entity
@Table(name="T_USER")
@DynamicUpdate(true)
public class User {
	//用户编号
	private int id;
	//用户微信openid
	private String openid;
	//用户昵称
	private String nickname;
	//用户性别
	private String sex;
	//用户所在省份
	private String province;
	//用户所在城市
	private String city;
	//用户所在国家
	private String country;
	//用户头像url
	private String headimgurl;
	
	public User() {}
	public User(OauthUserInfo oauthUserInfo) {
		this.setOpenid(oauthUserInfo.getOpenid());
		this.setNickname(oauthUserInfo.getNickname());
		this.setHeadimgurl(oauthUserInfo.getHeadimgurl());
		this.setSex(oauthUserInfo.getSex());
		this.setProvince(oauthUserInfo.getProvince());
		this.setCity(oauthUserInfo.getCity());
		this.setCountry(oauthUserInfo.getCountry());
	}
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="openid")
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	@Column(name="nickname")
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Column(name="sex")
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Column(name="province")
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Column(name="city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name="country")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Column(name="head_img_url")
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
}
