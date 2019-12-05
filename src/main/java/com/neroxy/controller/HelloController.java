package com.neroxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class HelloController {
    @Autowired
    private DataSource dataSource;

    @Value("${baidu.url}")
    private String baiduUrl;
    @Value("${google.url}")
    private String googleUrl;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
