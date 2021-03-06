package com.atshop.security.service.impl;

import com.atshop.security.entity.User;
import com.atshop.security.entity.UserInfo;
import com.atshop.security.repository.UserRepository;
import com.atshop.security.service.UserService;
import com.lambdaworks.crypto.SCryptUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public UserInfo create(UserInfo user) {
        User entity = new User();
        BeanUtils.copyProperties(user, entity);
        entity.setPassword(SCryptUtil.scrypt(user.getPassword(),32768,8,1));
        User bean = userRepository.save(entity);
        user.setId(bean.getId());
        return user;
    }

    @Override
    public UserInfo update(UserInfo user) {
        return null;
    }

    @Override
    public UserInfo delete(Long id) {
        return null;
    }

    @Override
    public List<UserInfo> findAll() {
        Iterable<User> all = userRepository.findAll();
        List<UserInfo> userInfos=new ArrayList<>();
        all.forEach(user -> {
            UserInfo userInfo=new UserInfo();
            BeanUtils.copyProperties(user,userInfo);
            userInfos.add(userInfo);
        });
        return userInfos;
    }

    @Override
    public UserInfo get(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get().buildInfo();
    }

    @Override
    public UserInfo login(UserInfo user) {

        return null;
    }
}
