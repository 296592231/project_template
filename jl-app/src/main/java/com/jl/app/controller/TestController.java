package com.jl.app.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jl
 * @date 2024/6/3 16:43
 */
@RestController
@RequestMapping(value = "/test/")
public class TestController {

    @ResponseBody
    @RequestMapping(value = "smsCodeLogin.html" , method = RequestMethod.POST)
    public String test () {
        testaaa();
        return "你好";
    }

    @Cacheable(value = "oprInfoByOprCodeCache", key = "#oprCode" , unless="#result == null")
    public List<String> testaaa () {
        List<String> aa = new ArrayList<>();
        aa.add("1");
        aa.add("2");
        aa.add("3");
        return aa;
    }
}
