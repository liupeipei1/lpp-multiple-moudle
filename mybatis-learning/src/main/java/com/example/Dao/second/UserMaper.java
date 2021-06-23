package com.example.Dao.second;

import com.example.Response.Userinfo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMaper {
    List<Userinfo> getUser(String name);
}
