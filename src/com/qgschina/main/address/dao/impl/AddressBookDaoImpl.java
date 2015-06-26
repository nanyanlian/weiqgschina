package com.qgschina.main.address.dao.impl;

import java.util.List;
import java.util.Map;

import net.sf.ehcache.store.chm.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.qgschina.main.address.dao.AddressBookDao;
import com.qgschina.main.address.model.AddressBook;
import com.qgschina.main.base.dao.impl.BaseDaoImpl;

@Repository("/addressBookDao")
@SuppressWarnings("unchecked")
public class AddressBookDaoImpl extends BaseDaoImpl<AddressBook, Integer>
		implements AddressBookDao {
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
	public boolean queryExist(String jobNo, String name) {
		String hql = "from AddressBook where jobNo =:jobNo and name =:name";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("jobNo", jobNo);
		map.put("name", name);
		return queryCount(hql, map) != 0;
	}

	/**
	 * 按照员工名称查询通讯录,需要完全匹配
	 * 
	 * @param name
	 *            员工姓名
	 * */
	public List<AddressBook> queryByName(String name) {
		String hql = "from AddressBook where name =:name";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("name", name);
		return (List<AddressBook>) find(hql, map);
	}

	/**
	 * 按照员工拼音查询通讯录,可以模糊匹配,也支持多音字
	 * 
	 * @param pinyin
	 *            员工姓名拼音
	 * */
	public List<AddressBook> queryByPinYin(String pinyin) {
		String hql = "from AddressBook where pinyinFirst like :pinyinFirst";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("pinyinFirst", "%" + pinyin + "%");
		return (List<AddressBook>) find(hql, map);
	}

}
