package com.example.common.基础.设计模式;

public class 动态代理Run {
    public static void main(String[] args) {
        // 目标对象:代理实现接口的类  UserDao
        IUserDao target = new UserDao();
        System.out.println(target.getClass());//输出结果：class com.example.demo.设计模式.UserDao
        //IUserDao proxy = (IUserDao) new 动态代理(target).getProxyInstance();  // 给目标对象，创建代理对象   等价下面两行代码
        动态代理 aa = new 动态代理(target);
        IUserDao proxy1 = (IUserDao) aa.getProxyInstance();
        System.out.println(proxy1.getClass()); //输出结果:class com.sun.proxy.$Proxy0  内存中动态生成的代理对象
        proxy1.save(); // 执行方法 【代理对象】


        System.out.printf("================2==================================");
        //测试代理2
        IUserDao userDao=new UserDao();
        IUserDao proxy=new 动态代理方法2(userDao).createProxy();
        proxy.insert();
        proxy.delete();
        proxy.update();
        proxy.query(1);

        System.out.printf("================3==================================");

        IUserDao userDao1=new UserDao();
        IUserDao proxy2= (IUserDao) new Cglib代理(userDao1).getProxyInstance();
        System.out.println(proxy2.getClass()); //输出结果:class com.sun.proxy.$Proxy0  内存中动态生成的代理对象

        proxy2.insert();  //调用方法前，会先调用Cglib代理 里面的 intercept
        proxy2.delete();
        proxy2.update();
        proxy2.query(2);

    }
}
