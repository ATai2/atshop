package com.atshop.oauth.entity;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Oauth2OauthApprovalsEntityTest extends TestCase {

    @Test
    public void test(){
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
        System.out.println(new BCryptPasswordEncoder().encode("654321"));
    }

}