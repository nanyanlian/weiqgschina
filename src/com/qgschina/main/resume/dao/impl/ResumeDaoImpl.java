package com.qgschina.main.resume.dao.impl;

import java.util.List;
import java.util.Map;

import net.sf.ehcache.store.chm.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.qgschina.main.base.dao.impl.BaseDaoImpl;
import com.qgschina.main.resume.dao.ResumeDao;
import com.qgschina.main.resume.model.Resume;
import com.qgschina.main.resume.model.ResumePersonInfo;

/**
 * Dao - 简历
 * */
@SuppressWarnings("unchecked")
@Repository("/resumeDao")
public class ResumeDaoImpl extends BaseDaoImpl<Resume, Integer> implements ResumeDao {

	/**
	 * 获取微信号为openid的用户的所有简历
	 * 
	 * @param openid
	 *            微信号
	 * */
	public List<Resume> listByOpenId(String openid) {
		String hql = "from Resume where openid = :openid";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("openid", openid);
		return (List<Resume>) find(hql, map);
	}


	/**
	 * 根据简历编号删除简历
	 * 
	 * @param resumeId
	 *            简历编号
	 * */
	public void deleteById(int resumeId) {
		String hql = "delete from Resume where id = :id";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("id", resumeId);
		executeUpdate(hql, map);
	}

	/**
	 * 修改简历字段
	 * 
	 * @param personInfo
	 *            简历个人信息
	 * @param map
	 *            修改的键值对
	 * */
	@SuppressWarnings("unused")
	public void changeResumeField(ResumePersonInfo personInfo,Map<String, Object> map) {
		StringBuffer hql = new StringBuffer("update Resume set ");
		int size = map.keySet().size();int index = 1;
		Object value = "";
		for (String key : map.keySet() ) {
			value = map.get(key);
			hql.append(key).append(" = :").append(key).append(" ");
			if( index != size ) {
				hql.append(" , ");
				index++;
			}
		}
		hql.append(" where id = :id");
		executeUpdate(hql.toString(), map,"id",personInfo.getResumeId());
	}

	/**
	 * 修改简历字段
	 * 
	 * @param id
	 *            简历编号
	 * @param map
	 *            修改的键值对
	 * */
	@SuppressWarnings("unused")
	public void changeResumeField(int id, Map<String, Object> map) {
		StringBuffer hql = new StringBuffer("update Resume set ");
		int size = map.keySet().size();int index = 1;
		Object value = "";
		for (String key : map.keySet() ) {
			value = map.get(key);
			hql.append(key).append(" = :").append(key).append(" ");
			if( index != size ) {
				hql.append(" , ");
				index++;
			}
		}
		hql.append(" where id = :id");
		executeUpdate(hql.toString(), map,"id",id);
	}
	


}
