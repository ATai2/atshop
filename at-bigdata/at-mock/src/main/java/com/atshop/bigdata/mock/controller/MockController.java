package com.atshop.bigdata.mock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("mock")
public class MockController {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @RequestMapping("webInfoservice")
    @ResponseBody
    public String webInfoservice(@RequestParam String jsonString) {
        System.out.println("hello world "+jsonString);
        kafkaTemplate.send("testTopic", jsonString);
        return "jsonString";
    }

}
