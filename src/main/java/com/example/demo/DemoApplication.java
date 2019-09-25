package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }
    @RequestMapping(value = "hello")
    public String Hello(){
        return "曹冰你个傻逼！！！哈哈哈哈哈哈哈哈";
    }

    @RequestMapping(value = "img")
    public String img(){
        return "index";
    }
}

