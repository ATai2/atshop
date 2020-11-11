package com.atshop.security.config;

import jdk.internal.vm.compiler.collections.EconomicMap;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handle(Exception ex) {
        Map<String, Object> info = new HashMap<>();
        info.put("msg", ex.getMessage());
        info.put("time", new Date().getTime());
        return info;
    }
}
