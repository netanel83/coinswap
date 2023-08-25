package com.coinswap.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {
    private static final Logger Logger = LoggerFactory.getLogger(RegisterController.class);
    @GetMapping("/test")
    public String test(){
        Logger.info("test logger");
        return "test";
    }
}
