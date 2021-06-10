package com.example.springbootproject.基础.Collections;


/*
   将对象存在map里面，然后从hash里面取数据
   这里必须重写 equals  和 hashCode方法
 */
public class Student {

    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;

    }

    @Override
    public boolean equals(Object obj) {
        Student ss = (Student) obj;
        return this.id == ss.id && this.name == ss.name;
    }

    @Override
    public int hashCode() {
        return id;
    }
}