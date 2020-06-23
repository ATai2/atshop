package com.at.atshop.usermanagement.service;

import java.util.List;

import com.at.atshop.usermanagement.entity.SysDict;
import com.at.common.service.CurdService;

/**
 * 字典管理
 * @author Louis
 * @date Jan 13, 2019
 */
public interface SysDictService extends CurdService<SysDict> {

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysDict> findByLable(String lable);
}
