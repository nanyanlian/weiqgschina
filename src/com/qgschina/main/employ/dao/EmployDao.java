package com.qgschina.main.employ.dao;

import java.util.List;

import com.qgschina.main.base.dao.BaseDao;
import com.qgschina.main.employ.model.Employ;

/**
 * Dao - 招聘信息
 * */
public interface EmployDao extends BaseDao<Employ, Integer> {
	/**
	 * 查询所有职位
	 * */
	public List<Employ> queryAllEmploy();

	/**
	 * 根据职位编号查找职位
	 * 
	 * @param id
	 *            职位编号
	 * */
	public Employ queryEmployById(int id);

}
