package com.qgschina.main.module.dao;

import java.util.List;

import com.qgschina.main.base.dao.BaseDao;
import com.qgschina.main.module.model.Module;

/**
 * Dao - 模块
 * */
public interface ModuleDao extends BaseDao<Module, Integer> {
	/**
	 * 根据编号查询模块
	 * 
	 * @param id
	 *            模块编号
	 * */
	public Module queryMouleById(int id);

	/**
	 * 根据父模块编号查询子模块列表(不分页)
	 * 
	 * @param parentModule
	 *            父模块
	 * */
	public List<Module> queryModuleListByParentId(Module parentModule);

	/**
	 * 根据父模块编号查询子模块列表(分页)
	 * 
	 * @param parentModule
	 *            父模块
	 */
	public List<Module> queryPageModuleListByParentId(Module parentModule);

	/**
	 * 查询子模块数量
	 * 
	 * @param parentModule
	 *            父模块
	 */
	public long querySubModuleCount(Module parentModule);

}
