package com.at.atshop.usermanagement.service;

import java.util.List;

import com.at.atshop.usermanagement.entity.SysDept;
import com.at.common.service.CurdService;

/**
 * 机构管理
 * @author Louis
 * @date Jan 13, 2019
 */
public interface SysDeptService extends CurdService<SysDept> {

	/**
	 * 查询机构树
	 * @param userId 
	 * @return
	 */
	List<SysDept> findTree();
}
