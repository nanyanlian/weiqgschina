package com.qgschina.main.address.dao;

import com.qgschina.main.address.model.UserHasAddressBook;
import com.qgschina.main.base.dao.BaseDao;

/**
 * Dao - 微信用户通讯录匹配
 * */
public interface UserHasAddressBookDao extends
		BaseDao<UserHasAddressBook, Integer> {
	/**
	 * 判断微信用户编号为openid的用户是否存在在
	 * 
	 * @param openid
	 *            微信用户编号
	 * 
	 * @return true-存在 , false-不存在
	 * */
	public boolean openIdExists(String openid);

	/**
	 * 根据openid查找微信用户的通讯录匹配信息
	 * 
	 * @param openid
	 *            微信用户编号
	 * */
	public UserHasAddressBook queryByOpenid(String openid);

	/**
	 * 更新工号
	 * 
	 * @param id
	 *            匹配表编号
	 * @param jobNo
	 *            工号
	 * */
	public void updateJobNo(int id, String jobNo);

	/**
	 * 判断工号为jobNo的员工是否存在
	 * 
	 * @param jobNo
	 *            员工工号
	 * @return true-存在 , false-不存在
	 * */
	public boolean queryExist(String jobNo);

}
