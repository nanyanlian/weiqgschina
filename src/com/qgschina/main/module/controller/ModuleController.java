package com.qgschina.main.module.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qgschina.main.message.model.Message;
import com.qgschina.main.message.service.MessageService;
import com.qgschina.main.module.model.Module;
import com.qgschina.main.module.service.ModuleService;

/**
 * Controller - 模块
 * */
@RequestMapping("/module")
@Controller
public class ModuleController {
	@Resource
	private ModuleService moduleService;
	@Resource
	private MessageService messageService;

	/**
	 * 在主页上使用,转住页面用
	 * 
	 * @param moduleId
	 *            模块编号
	 * */
	@RequestMapping("/turnToPage.do")
	public ModelAndView turnToPage(int moduleId) {
		ModelAndView mav = new ModelAndView();
		Module module = moduleService.disposeQueryModuleById(moduleId);
		mav.addObject("module", module);
		if (module.getType() == Module.TYPE_LIST_PAGE) {
			mav.addObject("moduleList",
					moduleService.disposeQuerySubModuleListByParentId(module));
			if (module.getListbyPageFlag() == Module.LIST_BY_PAGE) {
				long count = moduleService.disposeQueryCountByParentId(module);
				if (count <= module.getRows() * module.getPage())
					mav.addObject("hasMore", "noMore");
				else
					mav.addObject("hasMore", "hasMore");
			}
			mav.setViewName("common/listPage");
		} else {
			Message message = messageService
					.disposeQueryMessageByModuleId(module);
			mav.addObject("message", message);
			mav.setViewName("common/infoPage");
		}
		return mav;
	}

	/**
	 * 查看更多,目录页中使用
	 * 
	 * @param parentId
	 *            父模块编号
	 * @param module
	 *            模块信息(带分页信息)
	 * */
	@RequestMapping("/listMoreModule.do")
	@ResponseBody
	public Map<String, Object> listMoreModule(int parentId, Module module) {
		List<Module> moduleList = moduleService
				.disposeQuerySubModuleListByParentId(module);
		String hasMore = "hasMore";
		long count = moduleService.disposeQueryCountByParentId(module);
		if (count <= module.getRows() * module.getPage())
			hasMore = "noMore";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("moduleList", moduleList);
		map.put("hasMore", hasMore);
		return map;
	}
}
