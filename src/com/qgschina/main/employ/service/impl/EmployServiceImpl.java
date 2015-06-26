package com.qgschina.main.employ.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qgschina.main.employ.dao.EmployDao;
import com.qgschina.main.employ.dao.EmployItemDao;
import com.qgschina.main.employ.model.Employ;
import com.qgschina.main.employ.model.EmployItem;
import com.qgschina.main.employ.service.EmployService;

/**
 * Service - 招聘信息
 * */
@Service("/employService")
public class EmployServiceImpl implements EmployService {
	@Resource
	private EmployDao employDao;
	@Resource
	private EmployItemDao employItemDao;
	
	/**
	 * 查询所有职位
	 * */
	public List<Employ> disposeQueryAllEmploy() {
		List<Employ> employList = employDao.queryAllEmploy();
		int employId = 0;
		for(int i = 0 ; i < employList.size() ; i++ ) {
			employId = employList.get(i).getId();
			employList.get(i).setJobDesc(disposeQueryAllEmployItemByEmployIdWithType(
					employId, EmployItem.EMPLOY_ITEM_TYPE_JOB_DESC));
			employList.get(i).setJobRequest(disposeQueryAllEmployItemByEmployIdWithType(
					employId, EmployItem.EMPLOY_ITEM_TYPE_JOB_REQ));
			employList.get(i).setJobDescNum(employList.get(i).getJobDesc().size());
			employList.get(i).setJobRequestNum(employList.get(i).getJobRequest().size());
		}
		return employList;
	}

	/**
	 * 查询某个职位下的细目
	 * 
	 * @param employId
	 *            职位编号
	 * @param type
	 *            职位细目类别
	 * */
	public List<EmployItem> disposeQueryAllEmployItemByEmployIdWithType(
			int employId, int type) {
		return employItemDao.queryEmpItemByIdWithType(employId,type);
	}

	/**
	 * 查询职位编号查找职位
	 * 
	 * @param 职位编号
	 * */
	public Employ disposeEmployById(int employId) {
		Employ employ = employDao.queryEmployById(employId);
		employ.setJobDesc(disposeQueryAllEmployItemByEmployIdWithType(
				employId, EmployItem.EMPLOY_ITEM_TYPE_JOB_DESC));
		employ.setJobRequest(disposeQueryAllEmployItemByEmployIdWithType(
				employId, EmployItem.EMPLOY_ITEM_TYPE_JOB_REQ));
		employ.setJobDescNum(employ.getJobDesc().size());
		employ.setJobRequestNum(employ.getJobRequest().size());
		return employ;
	}

}
