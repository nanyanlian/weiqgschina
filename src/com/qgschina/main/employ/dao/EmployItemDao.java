package com.qgschina.main.employ.dao;

import java.util.List;

import com.qgschina.main.base.dao.BaseDao;
import com.qgschina.main.employ.model.EmployItem;

/**
 * Dao - 职位细目
 * */
public interface EmployItemDao extends BaseDao<EmployItem, Integer> {
	/**
	 * 根据职位编号以及细目类别查找所有细目信息
	 * 
	 * @param employId
	 *            职位编号
	 * @param type
	 *            细目类别(1|2)
	 * */
	public List<EmployItem> queryEmpItemByIdWithType(int employId, int type);

}
