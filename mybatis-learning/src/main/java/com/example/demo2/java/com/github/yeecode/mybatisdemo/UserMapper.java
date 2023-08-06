package com.example.demo2.java.com.github.yeecode.mybatisdemo;

import com.example.demo2.java.com.github.yeecode.mybatisdemo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> queryUserBySchoolName(User user);
}