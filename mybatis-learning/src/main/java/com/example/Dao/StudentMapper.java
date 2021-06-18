package com.example.Dao;

import com.example.Dto.Userinfo;
import com.example.Dto.StudentResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface StudentMapper {

    List<StudentResponse> getStudent();

    @Mapper
    interface UserMaper {
        List<Userinfo>  getUser(String name);
    }
}
