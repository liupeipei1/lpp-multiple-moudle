package com.example.springbootproject.基础.mybatis例子.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMaper {
    List<User>  getUser(String name);
}
