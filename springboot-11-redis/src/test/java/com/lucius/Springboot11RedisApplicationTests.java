package com.lucius;

import com.lucius.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class Springboot11RedisApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    RedisTemplate redisTemplate;

    @Autowired
    RedisUtil redisUtil;

    @Test
    public void test(){
        redisUtil.set("name","lucius");
        System.out.println(redisUtil.get("name"));
    }

}
