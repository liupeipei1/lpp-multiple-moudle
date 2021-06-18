package com.example.Service;

import com.example.Dto.StudentResponse;
import com.example.Dto.ClientDTo;
import org.springframework.stereotype.Service;

@Service
public class DoService {

    public StudentResponse getStudent(ClientDTo clientDTo){
        return  new StudentResponse(clientDTo);
    }


}
