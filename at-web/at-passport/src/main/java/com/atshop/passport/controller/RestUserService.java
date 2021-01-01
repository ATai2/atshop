package com.atshop.passport.controller;

import com.at.common.bean.UmsMember;
import com.at.common.bean.UmsMemberReceiveAddress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "at-user")
public interface RestUserService {
    @GetMapping("getAllUser")
//    @Override
    List<UmsMember> getAllUser();

    @GetMapping("getReceiveAddressByMemberId")
    //    @Override
    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(@RequestParam String memberId);
    //
    @PostMapping("login")
//    @Override
    UmsMember login(@RequestBody UmsMember umsMember);
    //
//    @Override
    @GetMapping("addUserToken")
    void addUserToken(@RequestParam String token, @RequestParam String memberId);
}