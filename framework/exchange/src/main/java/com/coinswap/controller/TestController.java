package com.coinswap.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchange")
public class TestController {

    private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(TestController.class);
    @GetMapping("/test")
    public String test(){
        Logger.info("test logger");
        return "test";
    }
}
