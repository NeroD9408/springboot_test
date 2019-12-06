package com.neroxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test1() {
        //存取String数据类型
        redisTemplate.boundValueOps("name").set("zhangsan");
        System.out.println(redisTemplate.boundValueOps("name").get());
        //存取Hash类型的数据
        redisTemplate.boundHashOps("h_key").put("name", "lisi");
        redisTemplate.boundHashOps("h_key").put("age", 20);
        Set h_key = redisTemplate.boundHashOps("h_key").keys();
        List h_key_values = redisTemplate.boundHashOps("h_key").values();
        System.out.println("键集合：" + h_key);
        System.out.println("值集合：" + h_key_values);
        //存取List集合类型数据
        redisTemplate.boundListOps("h_list").leftPush("c");
        redisTemplate.boundListOps("h_list").leftPush("b");
        redisTemplate.boundListOps("h_list").leftPush("a");
        List h_list = redisTemplate.boundListOps("h_list").range(0, -1);
        System.out.println(h_list);
        //存取set集合类型数据
        redisTemplate.boundSetOps("h_set").add("a", "b", "c", "d");
        Set h_set = redisTemplate.boundSetOps("h_set").members();
        System.out.println(h_set);
        //存取zset集合类型数据
        redisTemplate.boundZSetOps("h_zset").add("a", 30);
        redisTemplate.boundZSetOps("h_zset").add("b", 20);
        redisTemplate.boundZSetOps("h_zset").add("c", 10);
        Set h_zset = redisTemplate.boundZSetOps("h_zset").range(0, -1);
        System.out.println(h_zset);


    }
}
