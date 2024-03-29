package com.example.common.基础.设计模式;

import org.junit.jupiter.api.Test;

public class CglibMainRunTest {
    @Test
    public void test() {
        //目标对象
        UserDao target = new UserDao();

        //代理对象
        UserDao proxy = (UserDao) new Cglib代理(target).getProxyInstance();

        //执行代理对象的方法
        proxy.save();
    }
}
