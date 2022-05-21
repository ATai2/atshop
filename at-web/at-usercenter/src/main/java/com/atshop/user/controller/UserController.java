package com.atshop.user.controller;

import com.at.common.http.HttpResult;
import com.atshop.user.entity.ShopUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/usercenter")
public class UserController {

    @GetMapping("/users")
    public HttpResult<ShopUser> getUserList() {

        return HttpResult.ok(null);
    }


}
