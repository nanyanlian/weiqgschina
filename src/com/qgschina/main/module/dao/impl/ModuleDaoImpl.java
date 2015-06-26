package com.qgschina.main.module.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.qgschina.main.base.dao.impl.BaseDaoImpl;
import com.qgschina.main.module.dao.ModuleDao;
import com.qgschina.main.module.model.Module;

/**
 * Dao - 模块
 * */
@SuppressWarnings("unchecked")
@Repository("/moduleDao")
public class ModuleDaoImpl extends BaseDaoImpl<Module, Integer> implements
		ModuleDao {
	/**
	 * 根据编号查询模块
	 * 
	 * @param id
	 *            模块编号
	 * */
	public Module queryMouleById(int id) {
		return get(id);
	}

	/**
	 * 根据父模块编号查询子模块列表(不分页)
	 * 
	 * @param parentModule
	 *            父模块
	 * */
	public List<Module> queryModuleListByParentId(Module parentModule) {
		String hql = "from Module where parentId =:parentId and showFlag =:showFlag order by id desc";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("parentId", parentModule.getId());
		map.put("showFlag", parentModule.getShowFlag());
		return (List<Module>) find(hql, map);
	}

	/**
	 * 根据父模块编号查询子模块列表(分页)
	 * 
	 * @param parentModule
	 *            父模块
	 * */
	public List<Module> queryPageModuleListByParentId(Module parentModule) {
		String hql = "from Module where parentId =:parentId and showFlag =:showFlag order by id desc";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("parentId", parentModule.getId());
		map.put("showFlag", parentModule.getShowFlag());
		if (parentModule.getPage() == 0) {
			parentModule.setDefaultPageData();
		}
		return findPage(hql, parentModule.getPage(), parentModule.getRows(),
				map);
	}

	/**
	 * 查询子模块数量
	 * 
	 * @param parentModule
	 *            父模块
	 */
	public long querySubModuleCount(Module parentModule) {
		String hql = "from Module where parentId =:parentId";
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("parentId", parentModule.getId());
		return queryCount(hql, map);
	}
}