package com.atshop.passport.controller;

import com.at.common.bean.UmsMember;
import com.at.common.bean.UmsMemberReceiveAddress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "at-user")
public interface RestUserService {
    @GetMapping("getAllUser")
//    @Override
    List<UmsMember> getAllUser();

    //    @Override
    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);
    //
//    @Override
    UmsMember login(UmsMember umsMember);
    //
//    @Override
    void addUserToken(String token, String memberId);
}