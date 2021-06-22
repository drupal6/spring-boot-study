package com.study.mapper;

import com.study.entity.UserEntity;
import com.study.enums.UserSexEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user_entity")
    @Results({
            @Result(property = "userName", column = "user_name"),
            @Result(property = "passWord", column = "pass_word"),
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")

    })
    List<UserEntity>getAll();

    @Select("SELECT * FROM user_entity WHERE id = #{id}")
    @Results({
            @Result(property = "userName", column = "user_name"),
            @Result(property = "passWord", column = "pass_word"),
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    UserEntity getOne(Long id);

    @Insert("INSERT INTO user_entity(user_name, pass_word, user_sex, nick_name) VALUES(#{userName}, #{passWord}, #{userSex}, #{nickName})")
    void insert(UserEntity userEntity);

    @Update("UPDATE user_entity SET user_name=#{userName},nick_name=#{nickName} WHERE id=#{id}")
    void update(UserEntity userEntity);

    @Delete("DELETE FROM user_entity WHERE id=#{id}")
    void delete(Long id);
}
