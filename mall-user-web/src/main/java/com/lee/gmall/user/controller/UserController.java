package com.lee.gmall.user.controller;

import com.lee.gmall.bean.UserInfo;
import com.lee.gmall.service.UserService;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@RestController
public class UserController {

    @Reference
    UserService userService;

    @RequestMapping("/userInfoList")
    public ResponseEntity<List<UserInfo>> userInfoList() {
        List<UserInfo> userInfoList = userService.userInfoList();
        return ResponseEntity.ok(userInfoList);
    }

}
