package com.qgschina.main.base.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.qgschina.main.base.dao.BaseDao;

public class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {
	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> entityClass;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseDaoImpl() {
		this.entityClass = null;
		Class clazz = getClass();
		Type type = clazz.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) type).getActualTypeArguments();
			this.entityClass = (Class<T>) p[0];
		}
	}
	
	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public PK save(T entity) {
		return (PK) getSession().save(entity);
	}

	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	@Override
	public void update(T entity) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void merge(T entity) {
		getSession().merge(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
	}

	@Override
	public void delete(PK id) {
		getSession().delete(this.get(id));
	}

	@Override
	public boolean exists(PK id) {
		return get(id) != null;
	}

	@Override
	public boolean exist(String hql, Map<String, Object> map) {
		return queryCount(hql, map) != 0;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T get(PK id) {
		return (T) getSession().get(this.entityClass, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public T load(PK id) {
		return (T) getSession().load(this.entityClass, id);
	}

	/**
	 * 获取PO总数(默认为entityClass)
	 * */
	public int countAll() {
		Criteria criteria = createCriteria();
		return countAll(criteria);
	}

	/**
	 * 根据Criteria查询条件，获取PO总数
	 * */
	public int countAll(Criteria criteria) {
		return Integer.valueOf(criteria.setProjection(Projections.rowCount())
				.uniqueResult().toString());
	}

	/**
	 * 删除所有
	 * */
	public void deleteAll(Collection<?> entities) {
		if (entities == null)
			return;
		for (Object entity : entities) {
			getSession().delete(entity);
		}
	}

	/**
	 * 获取全部对象
	 */
	@SuppressWarnings("unchecked")
	public List<T> list() {
		return createCriteria().list();
	}

	/**
	 * 获取对象列表根据Criteria
	 */
	@SuppressWarnings("unchecked")
	public List<T> list(Criteria criteria) {
		return criteria.list();
	}

	/**
	 * 离线查询
	 */
	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> List<T> list(DetachedCriteria criteria) {
		return (List<T>) list(criteria.getExecutableCriteria(getSession()));
	}

	/**
	 * 获取全部对象，支持排序
	 * 
	 * @param orderBy
	 * 
	 * @param isAsc
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> list(String orderBy, boolean isAsc) {
		Criteria criteria = createCriteria();
		if (isAsc) {
			criteria.addOrder(Order.asc(orderBy));
		} else {
			criteria.addOrder(Order.desc(orderBy));
		}
		return criteria.list();
	}

	/**
	 * 按属性查找对象列表，匹配方式为相等
	 * 
	 * @param propertyName
	 * 
	 * @param value
	 * 
	 * @return
	 */
	public List<T> list(String propertyName, Object value) {
		Criterion criterion = Restrictions
				.like(propertyName, "%" + value + "%");
		return list(criterion);
	}

	/**
	 * 根据查询条件获取数据列表
	 */
	@SuppressWarnings("unchecked")
	public List<T> list(Criterion criterion) {
		Criteria criteria = createCriteria();
		criteria.add(criterion);
		return criteria.list();
	}

	/**
	 * 按Criteria查询对象列表
	 * 
	 * @param criterions数量可变的Criterion
	 * @param criterions
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> list(Criterion... criterions) {
		return createCriteria(criterions).list();
	}

	/**
	 * 按属性查找唯一对象，匹配方式为相等
	 * 
	 * @param propertyName
	 * 
	 * @param value
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T uniqueResult(String propertyName, Object value) {
		Criterion criterion = Restrictions.eq(propertyName, value);
		return (T) createCriteria(criterion).uniqueResult();
	}

	/**
	 * 按Criteria查询唯一对象
	 * 
	 * @param criterions数量可变的Criterion
	 * 
	 * @param criterions
	 * 
	 * @return
	 */
	public T uniqueResult(Criterion... criterions) {
		Criteria criteria = createCriteria(criterions);
		return uniqueResult(criteria);
	}

	/**
	 * 按Criteria查询唯一对象
	 * 
	 * @param criterions
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T uniqueResult(Criteria criteria) {
		return (T) criteria.uniqueResult();
	}

	/**
	 * 为Criteria添加distinct transformer
	 * 
	 * @param criteria
	 * @return
	 */
	public Criteria distinct(Criteria criteria) {
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return criteria;
	}

	/**
	 * 强制清空session
	 */
	public void flush() {
		getSession().flush();
	}

	/**
	 * 清空session
	 */
	public void clear() {
		getSession().clear();
	}

	/**
	 * 创建Criteria实例
	 */
	public Criteria createCriteria() {
		return getSession().createCriteria(entityClass);
	}

	/**
	 * 根据Criterion条件创建Criteria
	 * 
	 * @param criterions数量可变的Criterion
	 */
	public Criteria createCriteria(Criterion... criterions) {
		Criteria criteria = createCriteria();
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}

	/**
	 * 分页查询Criteria
	 * 
	 * @param
	 * @return
	 */
	public List<T> findPage(Criteria criteria, int pageNo, int pageSize) {
		// 设置起始结果数
		criteria.setFirstResult((pageNo - 1) * pageSize);
		// 返回的最大结果集
		criteria.setMaxResults(pageSize);
		return list(criteria);
	}

	/**
	 * 分页查询
	 * */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List findPage(String hql, int pageNo, int pageSize) {
		Query query = getSession().createQuery(hql);
		return findPage(query, pageNo, pageSize);
	}

	/**
	 * 分页查询
	 * */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List findPage(String hql, int pageNo, int pageSize,
			Map<String, Object> map) {
		Query query = getSession().createQuery(hql);
		for (String key : map.keySet()) {
			query.setParameter(key, map.get(key));
		}
		return findPage(query, pageNo, pageSize);
	}

	public Long queryCount(String hql, Map<String, Object> map) {
		String prefix = "select count(*) as count ";
		Query query = getSession().createQuery(prefix + hql);
		for (String key : map.keySet()) {
			query.setParameter(key, map.get(key));
		}
		return (Long) query.list().get(0);
	}

	/**
	 * 分页查询
	 * */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List findPage(Query query, int pageNo, int pageSize) {
		query.setFirstResult((pageNo - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List convertToDataList(List list, String[] ary) {
		List res = new ArrayList();
		Map<Object, Object> rowData = null;
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			rowData = new HashMap<Object, Object>();
			for (int j = 0; j < ary.length; j++) {
				rowData.put(ary[j], obj[j]);
			}
			res.add(rowData);
		}
		return res;
	}

	public List<?> find(String hql, Map<String, Object> map) {
		Query query = getSession().createQuery(hql);
		for (String key : map.keySet()) {
			query.setParameter(key, map.get(key));
		}
		return query.list();
	}

	public List<?> find(String hql) {
		Query query = getSession().createQuery(hql);
		return query.list();
	}

	public int executeUpdate(String hql, Map<String, Object> map) {
		Query query = getSession().createQuery(hql);
		for (String key : map.keySet()) {
			query.setParameter(key, map.get(key));
		}
		getSession().beginTransaction();
		int countNum = query.executeUpdate();
		getSession().getTransaction().commit();
		return countNum;
	}

	public Long queryCount(String hql) {
		String prefix = "select count(*) as count ";
		Query query = getSession().createQuery(prefix + hql);
		return (Long) query.list().get(0);
	}

	public int executeUpdate(String hql) {
		Query query = getSession().createQuery(hql);
		getSession().beginTransaction();
		int countNum = query.executeUpdate();
		getSession().getTransaction().commit();
		return countNum;
	}

	public int executeUpdate(String hql, Map<String, Object> map,
			String idField, Serializable id) {
		Query query = getSession().createQuery(hql);
		for (String key : map.keySet()) {
			query.setParameter(key, map.get(key));
		}
		query.setParameter(idField, id);
		getSession().beginTransaction();
		int countNum = query.executeUpdate();
		getSession().getTransaction().commit();
		return countNum;
	}

}
