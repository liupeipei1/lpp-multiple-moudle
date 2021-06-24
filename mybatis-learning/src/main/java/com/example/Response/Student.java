package com.example.Response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "查询学生实体",description = "查询学生信息")
public class Student {

    private  int id;
    private  String name;
    private  int age;
    private  String course;


    public Student(ClientDTo clientDTo){
        this.id=clientDTo.getId();
        this.age=clientDTo.getAge();
        this.name=clientDTo.getName();
        this.course="数学";

    }
}
