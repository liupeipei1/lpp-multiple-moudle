package com.example.springbootproject.基础.设计模式;

import org.junit.Test;

public class CglibMainRun {
    @Test
    public void test(){
        //目标对象
        UserDao target = new UserDao();

        //代理对象
        UserDao proxy = (UserDao)new Cglib代理(target).getProxyInstance();

        //执行代理对象的方法
        proxy.save();
    }
}
