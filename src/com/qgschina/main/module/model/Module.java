package com.qgschina.main.module.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.qgschina.main.base.model.PageData;

/**
 * 模块
 * */
@Entity
@Table(name = "T_MODULE")
@DynamicUpdate(true)
public class Module extends PageData {
	// 模块编号
	private int id;
	// 模块标题
	private String title;
	// 模块类型,可选值 0|1|2, 0表示内容是一个列表 , 1表示内容是一篇文章 , 2表示一个需要开发的页面
	private int type;
	// 父模块编号
	private int parentId;
	// 是否显示,可选值0|1 , 0表示显示 , 1表示隐藏
	private int showFlag;
	// 当type=0时起作用,表示列表内容的顶图
	private String topPicUrl;
	// 当type=2时起作用,引导进入另外开发的页面
	private String url;
	// 是否分页,可选值0|1 , 0表示分页 , 1表示不分页
	private int listbyPageFlag;
	// 模块类型_列表页
	public static final int TYPE_LIST_PAGE = 0;
	// 模块类型_内容页
	public static final int TYPE_CONTENT_PAGE = 1;
	// 模块类型_开发页
	public static final int TYPE_DEVELOP_PAGE = 2;
	// 显示标识_显示
	public static final int SHOW_FLAG_SHOW = 0;
	// 显示标识_隐藏
	public static final int SHOW_FLAG_HIDDEN = 1;
	// 分页标识_分页
	public static final int LIST_BY_PAGE = 0;
	// 显示标识_不分页
	public static final int LIST_NOT_BY_PAGE = 1;

	@Id
	@Column(name = "id")
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "type")
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name = "parent_id")
	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	@Column(name = "top_pic_url")
	public String getTopPicUrl() {
		return topPicUrl;
	}

	public void setTopPicUrl(String topPicUrl) {
		this.topPicUrl = topPicUrl;
	}

	@Column(name = "show_flag")
	public int getShowFlag() {
		return showFlag;
	}

	public void setShowFlag(int showFlag) {
		this.showFlag = showFlag;
	}

	@Column(name = "LIST_BY_PAGE_FLAG")
	public int getListbyPageFlag() {
		return listbyPageFlag;
	}

	public void setListbyPageFlag(int listbyPageFlag) {
		this.listbyPageFlag = listbyPageFlag;
	}

	@Column(name = "url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
