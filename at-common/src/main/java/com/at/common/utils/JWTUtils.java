package com.at.common.utils;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.Map;

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

    public static String encode(String key, Map<String, Object> param, String salt) {
        if (salt != null) {
            key += salt;
        }
        JwtBuilder jwtBuilder = Jwts.builder().signWith(SignatureAlgorithm.HS256, key);
        jwtBuilder = jwtBuilder.setClaims(param);
        String token = jwtBuilder.compact();
        return token;

    }


    public static Map<String, Object> decode(String token, String key, String salt) {
        Claims claims = null;
        if (salt != null) {
            key += salt;
        }
        try {
            claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        } catch (JwtException e) {
            return null;
        }
        return claims;
    }
}
