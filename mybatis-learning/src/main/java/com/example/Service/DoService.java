package com.example.Service;

import com.example.Dao.master.StudentMapper;
import com.example.Response.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoService {

    @Autowired
    private StudentMapper  studentMapper;

    public List<Student> getStudent(String  name){
        return  studentMapper.getStudent(name);
    }


}
