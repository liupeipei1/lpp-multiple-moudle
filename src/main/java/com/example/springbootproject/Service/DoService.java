package com.example.springbootproject.Service;

import com.example.springbootproject.Request.ClientDTo;
import com.example.springbootproject.Request.StudentResponse;
import org.springframework.stereotype.Service;

@Service
public class DoService {


    public StudentResponse  getStudent(ClientDTo clientDTo){
        return  new StudentResponse(clientDTo);
    }
}
