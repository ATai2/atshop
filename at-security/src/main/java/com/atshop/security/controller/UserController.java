package com.atshop.security.controller;

import com.atshop.security.entity.User;
import com.atshop.security.entity.UserInfo;
import com.atshop.security.repository.UserRepository;
import com.atshop.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping
    public List<UserInfo> getUsers() {
        return userService.findAll();
    }
    @PostMapping
    public UserInfo create(@RequestBody UserInfo user) {
        return userService.create(user);
    }

    @PutMapping
    public UserInfo update(@RequestBody UserInfo user) {
        return user;
    }

    @DeleteMapping
    public UserInfo delete(@RequestBody Long id) {
//        userRepository.
        return null;
    }

}
