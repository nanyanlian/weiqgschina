package com.qgschina.main.module.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qgschina.main.module.dao.ModuleDao;
import com.qgschina.main.module.model.Module;
import com.qgschina.main.module.service.ModuleService;

/**
 * Service - 模块
 * */
@Service("/moduleService")
public class ModuleServiceImpl implements ModuleService {
	@Resource
	private ModuleDao moduleDao;

	/**
	 * 通过id获取到module
	 * 
	 * @param id
	 *            模块编号
	 * */
	public Module disposeQueryModuleById(int parentId) {
		return moduleDao.queryMouleById(parentId);
	}

	/**
	 * 通过父模块获取子模块列表
	 * 
	 * @param parentModule
	 *            父模块
	 * */
	public List<Module> disposeQuerySubModuleListByParentId(Module module) {
		if (module.getListbyPageFlag() != Module.LIST_BY_PAGE)
			return moduleDao.queryModuleListByParentId(module);
		else
			return moduleDao.queryPageModuleListByParentId(module);
	}

	/**
	 * 通过父模块获取子模块数量
	 * 
	 * @param parentModule
	 *            父模块
	 * */
	public long disposeQueryCountByParentId(Module module) {
		return moduleDao.querySubModuleCount(module);
	}
}