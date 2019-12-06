package com.neroxy.controller;

import com.neroxy.pojo.User;
import com.neroxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private DataSource dataSource;

    @Value("${baidu.url}")
    private String baiduUrl;
    @Value("${google.url}")
    private String googleUrl;

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        System.out.println(dataSource);
        return "Hello World";
    }

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/findOne/{id}")
    public User findOne(@PathVariable Integer id) {
        return userService.findOne(id);
    }

    @GetMapping("/addOne")
    public void addOne() {
        userService.addOne();
    }

    @GetMapping("/updateOne")
    public void updateOne() {
        userService.updateOne();
    }

    @GetMapping("/deleteOne/{id}")
    public void deleteOne(@PathVariable Integer id) {
        userService.deleteOne(id);
    }
}
