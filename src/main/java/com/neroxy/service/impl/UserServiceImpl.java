package com.neroxy.service.impl;

import com.neroxy.mapper.UserMapper;
import com.neroxy.pojo.User;
import com.neroxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public User findOne(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void addOne() {
        User user = new User();
        user.setUser_name("krito");
        user.setName("嘻嘻");
        user.setPassword("123456");
        user.setNote("跟蔡徐坤学打球");
        user.setAge(20);
        user.setCreated(new Date());
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Override
    @Transactional
    public void updateOne() {
        User user = new User();
        user.setId(13);
        user.setUser_name("yasina");
        user.setName("奈斯纳");
        user.setPassword("123456");
        user.setNote("跟蔡徐坤学打球");
        user.setAge(20);
        user.setCreated(new Date());
        int update = userMapper.updateByPrimaryKey(user);
        System.out.println(update);
    }

    @Override
    public void deleteOne(Integer id) {
        int delete = userMapper.deleteByPrimaryKey(id);
        System.out.println(delete);
    }
}
