package com.example.common.Executor;

import lombok.Data;

import java.util.List;
import java.util.concurrent.Callable;

/*
刘佩佩
2021/8/30
*/

@Data
public class Student implements Callable {


    int id;
    List<Course> courseList;
    String  name;


    @Override
    public Object call() throws Exception {
        return "Success";
    }
}
