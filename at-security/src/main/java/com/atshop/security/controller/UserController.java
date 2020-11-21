package com.atshop.security.controller;

import com.atshop.security.entity.User;
import com.atshop.security.entity.UserInfo;
import com.atshop.security.repository.UserRepository;
import com.atshop.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public void login(@Validated UserInfo user, HttpServletRequest request) {
        UserInfo info = userService.login(user);
//        防止cookie哄骗
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        request.getSession(true).setAttribute("user", info);
//SecurityStr

    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request) {
        request.getSession().invalidate();
    }

    @GetMapping
    public List<UserInfo> getUsers() {
        return userService.findAll();
    }

    @PostMapping
    public UserInfo create(@RequestBody @Validated UserInfo user) {
        return userService.create(user);
    }

    @PutMapping
    public UserInfo update(@RequestBody UserInfo user) {
        return user;
    }

    @DeleteMapping("/{id}")
    public UserInfo delete(@PathVariable Long id) {
//        userRepository.
        return null;
    }

    @GetMapping("{id}")
    public UserInfo get(@PathVariable Long id, HttpServletRequest request) {

        User user = (User) request.getAttribute("user");

        if (Objects.isNull(user) || !user.getId().equals(id)) {
            throw new RuntimeException("身份认证信息异常，获取用户信息失败");
        }
        return userService.get(id);
    }
}
