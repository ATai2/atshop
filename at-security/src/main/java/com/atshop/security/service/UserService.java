package com.atshop.security.service;

import com.atshop.security.entity.UserInfo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {
    public UserInfo create( UserInfo user) ;

    public UserInfo update( UserInfo user) ;

    public UserInfo delete( Long id) ;

    List<UserInfo> findAll();
}
