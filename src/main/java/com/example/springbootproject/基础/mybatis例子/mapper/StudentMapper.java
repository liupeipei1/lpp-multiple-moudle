package com.example.springbootproject.基础.mybatis例子.mapper;

import com.example.springbootproject.Request.StudentResponse;

import java.util.List;

public interface StudentMapper {

    List<StudentResponse> getStudent();
}
