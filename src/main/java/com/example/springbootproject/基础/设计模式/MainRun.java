package com.example.springbootproject.基础.设计模式;

public class MainRun {
    //目标对象:UserDao.java

    public static void main(String[] args) {
        //目标对象
        UserDao target = new UserDao();  //被代理对象
        //代理对象,把目标对象传给代理对象,建立代理关系
        静态代理 proxy = new 静态代理(target);  //代理对象:静态代理
        proxy.save();//执行的是代理的方法

        //2、动态代理
        IUserDao target1 = new UserDao(); // 目标对象

        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
        System.out.println(target1.getClass());


    }
}
