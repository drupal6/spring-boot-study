package com.study.redis;

import com.study.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        stringRedisTemplate.opsForValue().set("test111", "1111");
        Assert.assertEquals(stringRedisTemplate.opsForValue().get("test111"), "1111");
    }

    @Test
    public void testObj() throws InterruptedException {
        User user = new User();
        user.setId(1l);
        user.setUserName("test");
        user.setPassWord("test");
        user.setNickName("test");
        user.setEmail("test@test.test");
        user.setRegTime("2021-06-22 00:00:--");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("com.neox", user);
        operations.set("com.neox", user, 1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        boolean exists = redisTemplate.hasKey("com.neox");
        if(exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
    }
}
