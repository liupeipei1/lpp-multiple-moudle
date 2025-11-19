package com.example.common.Executor;

import lombok.Data;

import java.util.List;

/*
刘佩佩
2021/8/30
*/


public class SmallStudent {

    int id;
    List<Course> courseList;
    String  name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
