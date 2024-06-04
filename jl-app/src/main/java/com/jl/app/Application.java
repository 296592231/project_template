package com.jl.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * springboot启动类
 * Created by kz on 2022/1/4.
 */
@EnableCaching
@SpringBootApplication(scanBasePackages = "com.jl")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
