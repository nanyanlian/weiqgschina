package com.qgschina.main.employ.service;

import java.util.List;

import com.qgschina.main.employ.model.Employ;
import com.qgschina.main.employ.model.EmployItem;

/**
 * Service - 招聘信息
 * */
public interface EmployService {
	/**
	 * 查询所有职位
	 * */
	public List<Employ> disposeQueryAllEmploy();

	/**
	 * 查询某个职位下的细目
	 * 
	 * @param employId
	 *            职位编号
	 * @param type
	 *            职位细目类别
	 * */
	public List<EmployItem> disposeQueryAllEmployItemByEmployIdWithType(
			int employId, int type);

	/**
	 * 查询职位编号查找职位
	 * 
	 * @param 职位编号
	 * */
	public Employ disposeEmployById(int employId);

}
