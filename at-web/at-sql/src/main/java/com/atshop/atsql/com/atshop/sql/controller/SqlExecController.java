package com.atshop.atsql.com.atshop.sql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SqlExecController {

    @GetMapping("hello")
    public String hello(){
        return "ok";
    }

}
