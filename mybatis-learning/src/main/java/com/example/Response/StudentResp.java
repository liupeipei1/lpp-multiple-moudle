package com.example.Response;

import com.example.Entity.Student;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/*
刘佩佩
2021/6/24
*/
@Data
@ApiModel(value = "学生出参Resp", description = "student输出响应")
public class StudentResp {
    List<com.example.Entity.Student> Student;

    public void setStudent(List<Student> student) {
        this.Student = student;
    }
}
