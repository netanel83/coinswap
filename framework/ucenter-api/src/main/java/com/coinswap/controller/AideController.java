package com.coinswap.controller;

import com.coinswap.constant.SysAdvertiseLocation;
import com.coinswap.entity.SysAdvertise;
import com.coinswap.service.SysAdvertiseService;
import com.coinswap.util.MessageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ancillary")
public class AideController {
    private static final Logger logger = LoggerFactory.getLogger(AideController.class);
    @Autowired
    private SysAdvertiseService sysAdvertiseService;

    @PostMapping("/system/advertise")
    public MessageResult sysAdvertise(@RequestParam (value = "sysAdvertiseLocation",required = false)
                                      SysAdvertiseLocation sysAdvertiseLocation, @RequestParam (value = "lang",required = false) String lang){
        logger.info("sysAdvertiseLocation: " + sysAdvertiseLocation + "lang:" + lang );
        List<SysAdvertise> list = sysAdvertiseService.findAllNormal(sysAdvertiseLocation,lang);
        MessageResult result = MessageResult.success();
        result.setData(list);
        return result;
    }



}
