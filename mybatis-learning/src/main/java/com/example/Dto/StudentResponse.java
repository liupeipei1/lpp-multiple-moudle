package com.example.Dto;

import com.example.Dto.ClientDTo;
import lombok.Data;

@Data
public class StudentResponse {

    private  int id;
    private  String name;
    private  int age;
    private  String course;


    public  StudentResponse(ClientDTo clientDTo){
        this.id=clientDTo.getId();
        this.age=clientDTo.getAge();
        this.name=clientDTo.getName();
        this.course="数学";

    }
}
