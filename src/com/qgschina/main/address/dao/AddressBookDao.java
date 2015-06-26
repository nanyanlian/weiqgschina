package com.qgschina.main.address.dao;

import java.util.List;

import com.qgschina.main.address.model.AddressBook;
import com.qgschina.main.base.dao.BaseDao;

/**
 * Dao - 通讯录
 * */
public interface AddressBookDao extends BaseDao<AddressBook, Integer> {
	/**
	 * 判断工号为jobNo,姓名为name的员工是否存在
	 * 
	 * @param jobNo
	 *            员工工号
	 * @param name
	 *            员工姓名
	 * 
	 * @return true-存在 , false-不存在
	 * */
	public boolean queryExist(String jobNo, String name);
	/**
	 * 按照员工名称查询通讯录,需要完全匹配
	 * 
	 * @param name 员工姓名
	 * */
	public List<AddressBook> queryByName(String name);
	/**
	 * 按照员工拼音查询通讯录,可以模糊匹配,也支持多音字
	 * 
	 * @param pinyin 员工姓名拼音
	 * */
	public List<AddressBook> queryByPinYin(String pinyin);
}
