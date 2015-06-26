package com.qgschina.main.base.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Dao - 基础
 * 
 * @param T
 *            - 实体类类型
 * @param PK
 *            - 主键类型
 * */
public interface BaseDao<T, PK extends Serializable> {
	/** 获取Hibernate的Session */
	public Session getSession();

	/** 保存实体对象,并返回主键 */
	public PK save(T entity);

	/** 删除实体对象 */
	public void delete(T entity);

	/** 更新实体对象 */
	public void update(T entity);

	/** 合并实体对象 */
	public void merge(T entity);

	/** 保存或更新实体对象 */
	public void saveOrUpdate(T entity);

	/** 根据主键删除实体对象 */
	public void delete(PK id);

	/** 判断主键为ID的对象是否存在 */
	public boolean exists(PK id);

	/**
	 * 传入带参数hql字符串和参数键值对,判断是否存在对象
	 * 
	 * @param hql
	 *            - select * from user where user.username = :username and
	 *            password = :password
	 * @param map
	 *            - Map<String> map map.put("username","admin")
	 *            map.put("password" , "123")
	 * */
	public boolean exist(String hql, Map<String, Object> map);

	/** get 主键为ID的对象 */
	public T get(PK id);

	/** load 主键为id的对象 */
	public T load(PK id);

	/** 查询该类对象总数 */
	public int countAll();

	/** 查询所有该类对象 */
	public List<T> list();

	/** flush hibernate缓冲区 */
	public void flush();

	/** clear hibernate缓冲 */
	public void clear();

	/**
	 * 根据不带参数的hql语句进行分页查询
	 * */
	public List<T> findPage(String hql, int pageNo, int pageSize);

	/**
	 * 根据带参数的hql语句进行分页查询
	 * */
	public List<T> findPage(String hql, int pageNo, int pageSize,
			Map<String, Object> map);

	/**
	 * 根据Hibernate Query分页查询
	 * */
	public List<T> findPage(Query query, int pageNo, int pageSize);

	/**
	 * 根据带参数的hql语句查询数量
	 * */
	public Long queryCount(String hql, Map<String, Object> map);

	/**
	 * 根据不带参数的hql语句查询数量
	 * */
	public Long queryCount(String hql);

	/**
	 * 根据带参数的hql语句查询所有
	 * */
	public List<?> find(String hql, Map<String, Object> map);

	/**
	 * 根据不带参数的hql语句查询所有
	 * */
	public List<?> find(String hql);

	/**
	 * 根据带参数的hql语句执行更新操作
	 * */
	public int executeUpdate(String hql, Map<String, Object> map);

	/**
	 * 根据不带参数的hql语句执行更新操作
	 * */
	public int executeUpdate(String hql);

	/**
	 * 根据带参数的hql语句执行更新操作,并指定主键的属性名以及主键的值
	 * */
	public int executeUpdate(String hql, Map<String, Object> map,
			String idField, Serializable id);

	public List<?> convertToDataList(List<?> list, String[] ary);
}
