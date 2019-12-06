package com.neroxy.service;

import com.neroxy.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne(Integer id);

    void addOne();

    void updateOne();

    void deleteOne(Integer id);
}
