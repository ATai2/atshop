package com.atshop.user.controller;

import com.at.common.http.HttpResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/usercenter")
public class UserController {

    @GetMapping("/users")
    public HttpResult<ShopUser> getUserList() {

        return HttpResult.ok(null);
    }


}
