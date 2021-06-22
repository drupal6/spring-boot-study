package com.study.mapper;

import com.study.entity.UserEntity;
import com.study.enums.UserSexEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        UserEntity user = new UserEntity();
        user.setUserName("aaaa");
        user.setPassWord("aaaa");
        user.setUserSex(UserSexEnum.MAN);
        user.setNickName("aaaa");
        userMapper.insert(user);
    }

    @Test
    public void testQuery() {
        UserEntity user = userMapper.getOne(1l);
        System.out.println(user.getUserName());
    }

    @Test
    public void testUpdate() {
        UserEntity user = userMapper.getOne(1l);
        user.setNickName("bbbb");
        userMapper.update(user);
    }
}
