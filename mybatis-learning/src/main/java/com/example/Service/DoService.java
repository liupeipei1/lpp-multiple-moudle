package com.example.Service;

import com.example.Dao.master.StudentMapper;
import com.example.Response.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DoService {

    @Resource
    private StudentMapper  studentMapper;

    public List<Student> getStudent(String  name){
        return  studentMapper.getStudent(name);
    }

    public void  insertStudent (Student  student){
          studentMapper.insertStudent(student);
    }

    public  void  updateStudent(Student student){
        studentMapper.updateStudent(student);
    }

    public  void deleteStudent(int id){
        studentMapper.deleteStudent(id);
    }
}
