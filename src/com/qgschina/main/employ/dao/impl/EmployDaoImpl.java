package com.qgschina.main.employ.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qgschina.main.base.dao.impl.BaseDaoImpl;
import com.qgschina.main.employ.dao.EmployDao;
import com.qgschina.main.employ.model.Employ;

/**
 * Dao - 职位信息
 * */
@SuppressWarnings("unchecked")
@Repository("/employDao")
public class EmployDaoImpl extends BaseDaoImpl<Employ, Integer> implements
		EmployDao {
	/**
	 * 查询所有职位
	 * */
	public List<Employ> queryAllEmploy() {
		String hql = "from Employ";
		return (List<Employ>) find(hql);
	}

	/**
	 * 根据职位编号查找职位
	 * 
	 * @param id
	 *            职位编号
	 * */
	public Employ queryEmployById(int id) {
		return get(id);
	}

}
