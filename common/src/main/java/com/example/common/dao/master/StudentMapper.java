package com.example.common.dao.master;

import com.example.common.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    List<Student> getStudent(@Param("name") String name);

    void insertStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(@Param("id") int id);
}
