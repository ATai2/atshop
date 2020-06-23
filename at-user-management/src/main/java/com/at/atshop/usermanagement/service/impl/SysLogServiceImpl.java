package com.at.atshop.usermanagement.service.impl;

import com.at.atshop.usermanagement.service.ISysLogService;
import com.at.atshop.usermanagement.entity.SysLog;
import com.at.atshop.usermanagement.mapper.SysLogMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统操作日志 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-06-23
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {

}
