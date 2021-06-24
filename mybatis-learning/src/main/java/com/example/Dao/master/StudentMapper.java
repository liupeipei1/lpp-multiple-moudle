package com.example.Dao.master;

import com.example.Response.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentMapper {
    List<Student> getStudent(@Param("name") String name);
}
