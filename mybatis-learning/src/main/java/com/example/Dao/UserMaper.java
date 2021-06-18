package com.example.Dao;

import com.example.Dto.Userinfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMaper {
    List<Userinfo>  getUser(String name);
}
