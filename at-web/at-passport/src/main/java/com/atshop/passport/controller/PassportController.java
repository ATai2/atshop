package com.atshop.passport.controller;

import com.alibaba.fastjson.JSON;
import com.at.common.bean.UmsMember;
import com.at.common.utils.JWTUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PassportController {

    @Autowired
    RestUserService userService;

    @GetMapping("verify")
    @ResponseBody
    public String verify(String token, String currentIp, HttpServletRequest request) {
        // 通过jwt校验token真假
        Map<String, String> map = new HashMap<>();
        Map<String, Object> decode = JWTUtils.decode(token, "2019gmall0105", currentIp);
        if (decode != null) {
            map.put("status", "success");
            map.put("memberId", (String) decode.get("memberId"));
            map.put("nickname", (String) decode.get("nickname"));
        } else {
            map.put("status", "fail");
        }
        return JSON.toJSONString(map);
    }


    @PostMapping("login")
    @ResponseBody
    public String login(@RequestBody UmsMember umsMember, HttpServletRequest request) {
        String token = "";
        // 调用用户服务验证用户名和密码
        UmsMember umsMemberLogin = userService.login(umsMember);
        if (umsMemberLogin != null) {
            // 登录成功
            // 用jwt制作token
            String memberId = umsMemberLogin.getId();
            String nickname = umsMemberLogin.getNickname();
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("memberId", memberId);
            userMap.put("nickname", nickname);

            String ip = request.getHeader("x-forwarded-for");// 通过nginx转发的客户端ip
            if (StringUtils.isBlank(ip)) {
                ip = request.getRemoteAddr();// 从request中获取ip
                if (StringUtils.isBlank(ip)) {
                    ip = "127.0.0.1";
                }
            }
            // 按照设计的算法对参数进行加密后，生成token
            token = JWTUtils.encode("2019gmall0105", userMap, ip);
            // 将token存入redis一份
            userService.addUserToken(token, memberId);
        } else {
            // 登录失败
            token = "fail";
        }
        return token;
    }

    @GetMapping("index")
    public String index(String ReturnUrl, ModelMap map) {
        map.put("ReturnUrl", ReturnUrl);
        return "index";
    }
}
