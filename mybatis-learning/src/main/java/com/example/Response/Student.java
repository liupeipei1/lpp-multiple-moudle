package com.example.Response;

import lombok.Data;

@Data
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
