package com.example.Dao.master;

import com.example.Response.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> getStudent(String name);
}
