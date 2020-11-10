package com.atshop.security.controller;

import com.atshop.security.entity.User;
import com.atshop.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserRepository userRepository;


    @PostMapping
    public User create(@RequestBody User user) {
        return new User();
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return user;
    }

}
