package com.jl.app.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jl
 * @date 2024/6/3 16:43
 */
@Service
public class TestService {


    @Cacheable(value = "sysMenuListByBusinessSystemCache", key = "#businessSystem" , unless="#result?.size() == 0")
    public List<String> testaaa (String businessSystem) {
        List<String> aa = new ArrayList<>();
        aa.add("1");
        aa.add("2");
        aa.add("3");
        return aa;
    }
}
