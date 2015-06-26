package com.qgschina.main.base.model;

/**
 * 分页辅助类
 * */
public class PageData {
	//页数:第N页 - 默认为1
	protected int page;
	//行数:一页N行 - 默认为5
	protected int rows;
	//默认页数
	public static final int PAGE_DEFAULT = 1;
	//每页默认行数
	public static final int ROWS_DEFAULT = 5;
	
	public PageData() {}
	public PageData(int page, int rows) {
		this.page = page;
		this.rows = rows;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public void setDefaultPageData() {
		this.page = PAGE_DEFAULT;
		this.rows = ROWS_DEFAULT;
	}
}

