package com.example.springbootproject.基础.single;

public class HungruySingleton {

    private static HungruySingleton ll=new HungruySingleton();

    private HungruySingleton(){}

    public static HungruySingleton getInstance(){return  ll;}
}

