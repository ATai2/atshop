package com.at.atshop.sqltrans.controller;

import com.at.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("sql")
public class SqlController {

    @GetMapping("/templates")
    public Result getTemplates() {

        return Result.withSuccess(null);
    }




}
