package com.at.atshop.usermanagement.service;

import com.at.atshop.usermanagement.entity.SysUser;
import com.at.atshop.usermanagement.entity.SysUserExample;
import com.at.atshop.usermanagement.mapper.SysUserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;
    public List<SysUser> findPage(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<SysUser> sysUsers = sysUserMapper.selectAll();
        PageInfo<SysUser> pageInfo=new PageInfo<>(sysUsers);
        return pageInfo.getList();
    }

}
