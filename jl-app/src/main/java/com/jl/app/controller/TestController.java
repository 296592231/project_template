package com.jl.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jl
 * @date 2024/6/3 16:43
 */
@RestController
@RequestMapping(value = "/test/")
public class TestController {

    @Autowired
    private TestService testService;

    @ResponseBody
    @RequestMapping(value = "smsCodeLogin.html" , method = RequestMethod.POST)
    public String test () {
        testService.testaaa("123123123");

        return "你好";
    }

}
