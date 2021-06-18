package com.example.common.基础.设计模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class 动态代理方法2 implements InvocationHandler {

    private IUserDao iUserDao;  //接口类

    public 动态代理方法2(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }


    public IUserDao createProxy() {
        IUserDao IUserDao = (com.example.common.基础.设计模式.IUserDao) Proxy.newProxyInstance(iUserDao.getClass().getClassLoader(), iUserDao.getClass().getInterfaces(), this);
        return IUserDao;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("update".equals(method.getName())) {
            System.out.println("权限校验");
            return method.invoke(iUserDao, args);
        }
        return method.invoke(iUserDao, args);

    }
}
