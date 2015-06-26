package com.qgschina.main.address.dao.impl;

import java.util.List;
import java.util.Map;

import net.sf.ehcache.store.chm.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.qgschina.main.address.dao.UserHasAddressBookDao;
import com.qgschina.main.address.model.UserHasAddressBook;
import com.qgschina.main.base.dao.impl.BaseDaoImpl;

/**
 * Dao - 微信用户通讯录匹配
 * */
@SuppressWarnings("unchecked")
@Repository("/userHasAddressBookDao")
public class UserHasAddressBookDaoImpl extends
		BaseDaoImpl<UserHasAddressBook, Integer> implements
		UserHasAddressBookDao {
	/**
	 * 判断微信用户编号为openid的用户是否存在在
	 * 
	 * @param openid
	 *            微信用户编号
	 * 
	 * @return true-存在 , false-不存在
	 * */
	public boolean openIdExists(String openid) {
		String hql = "from UserHasAddressBook where openid =:openid";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("openid", openid);
		return queryCount(hql, map) != 0;
	}

	/**
	 * 根据openid查找微信用户的通讯录匹配信息
	 * 
	 * @param openid
	 *            微信用户编号
	 * */
	public UserHasAddressBook queryByOpenid(String openid) {
		String hql = "from UserHasAddressBook where openid =:openid";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("openid", openid);
		List<?> list = find(hql, map);
		if (list.size() != 0)
			return (UserHasAddressBook) list.get(0);
		return null;
	}

	/**
	 * 更新工号
	 * 
	 * @param id
	 *            匹配表编号
	 * @param jobNo
	 *            工号
	 * */
	public void updateJobNo(int id, String jobNo) {
		String hql = "update UserHasAddressBook set jobNo=:jobNo where id=:id";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("jobNo", jobNo);
		map.put("id", id);
		executeUpdate(hql, map);
	}

	/**
	 * 判断工号为jobNo的员工是否存在
	 * 
	 * @param jobNo
	 *            员工工号
	 * @return true-存在 , false-不存在
	 * */
	public boolean queryExist(String jobNo) {
		String hql = "from UserHasAddressBook where jobNo =:jobNo";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("jobNo", jobNo);
		return queryCount(hql, map) != 0;
	}

}
