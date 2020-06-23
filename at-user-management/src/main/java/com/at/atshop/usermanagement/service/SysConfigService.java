package com.at.atshop.usermanagement.service;

import java.util.List;

import com.at.atshop.usermanagement.entity.SysConfig;
import com.at.common.service.CurdService;

/**
 * 系统配置管理
 * @author Louis
 * @date Jan 13, 2019
 */
public interface SysConfigService extends CurdService<SysConfig> {

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysConfig> findByLable(String lable);
}
