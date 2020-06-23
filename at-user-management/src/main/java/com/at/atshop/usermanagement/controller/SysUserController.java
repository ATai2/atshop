package com.at.atshop.usermanagement.controller;


import com.at.atshop.usermanagement.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户管理 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-06-23
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

    @GetMapping("/findPage")
    public Object findPage() {
        return sysUserService.findPage(1, 2);
    }


}
