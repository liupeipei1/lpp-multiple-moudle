package com.example.Dao.second;

import com.example.Response.Userinfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMaper {
    List<Userinfo> getUser(String name);
}
