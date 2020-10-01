package com.atshop.atsql.com.atshop.sql.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SqlExecController {

    @GetMapping("hello")
    public String hello(){
        log.info("info");
        log.error("error");
        log.debug("debug");
        return "ok";
    }
    @GetMapping("sql")
    public String sql(){



        return "ok";
    }

}
