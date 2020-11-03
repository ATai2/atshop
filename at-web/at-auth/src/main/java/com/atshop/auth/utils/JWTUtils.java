package com.atshop.auth.utils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTUtils {

    public String getToken() {
        long now = System.currentTimeMillis();
        long exp = now + 1000 * 30;//30秒过期
        JwtBuilder jwtBuilder = Jwts.builder().setId("888")
                .setSubject("小白")
                .setIssuedAt(new Date())//签发时间
                .setExpiration(new Date(exp))//过期时间
                .signWith(SignatureAlgorithm.HS256, "hahaha");
        String token = jwtBuilder.compact();
        System.out.println(token);
        return null;
    }
}
