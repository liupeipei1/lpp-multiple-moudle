package com.example.Dao.second;

import com.example.Response.Userinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMaper {
    List<Userinfo> getUser(@Param(value = "name") String name);
}
