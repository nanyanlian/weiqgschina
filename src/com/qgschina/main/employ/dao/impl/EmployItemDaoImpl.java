package com.qgschina.main.employ.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import net.sf.ehcache.store.chm.ConcurrentHashMap;

import com.qgschina.main.base.dao.impl.BaseDaoImpl;
import com.qgschina.main.employ.dao.EmployItemDao;
import com.qgschina.main.employ.model.EmployItem;

/**
 * Dao - 职位细目
 * */
@SuppressWarnings("unchecked")
@Repository("/employItemDao")
public class EmployItemDaoImpl extends BaseDaoImpl<EmployItem, Integer>
		implements EmployItemDao {
	
	/**
	 * 根据职位编号以及细目类别查找所有细目信息
	 * 
	 * @param employId
	 *            职位编号
	 * @param type
	 *            细目类别(1|2)
	 * */
	public List<EmployItem> queryEmpItemByIdWithType(int employId, int type) {
		String hql = "from EmployItem where employId =:employId and type =:type order by serial desc";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("employId", employId);
		map.put("type", type);
		return (List<EmployItem>) find(hql, map);
	}

}
