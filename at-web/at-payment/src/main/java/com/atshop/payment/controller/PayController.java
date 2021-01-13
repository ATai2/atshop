package com.atshop.payment.controller;

import com.at.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {

    @PostMapping("/pay")
    public Result pay(){



        return Result.withSuccess(null);
    }

}
