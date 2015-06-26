package com.qgschina.main.module.service;

import java.util.List;

import com.qgschina.main.module.model.Module;

/**
 * Service - 模块
 * */
public interface ModuleService {
	/**
	 * 通过id获取到module
	 * 
	 * @param id
	 *            模块编号
	 * */
	public Module disposeQueryModuleById(int id);

	/**
	 * 通过父模块获取子模块列表
	 * 
	 * @param parentModule
	 *            父模块
	 * */
	public List<Module> disposeQuerySubModuleListByParentId(Module parentModule);

	/**
	 * 通过父模块获取子模块数量
	 * 
	 * @param parentModule
	 *            父模块
	 * */
	public long disposeQueryCountByParentId(Module parentModule);
}
