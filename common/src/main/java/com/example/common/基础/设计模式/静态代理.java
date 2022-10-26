package com.example.common.基础.设计模式;

/*
静态代理在使用时,需要定义接口或者父类,被代理对象与代理对象一起实现相同的接口或者是继承相同父类.
模拟保存动作,定义一个保存动作的接口:IUserDao.java,然后目标对象实现这个接口的方法UserDao.java,此时如果使用静态代理方式,就需要在代理对象(UserDaoProxy.java)中也实现IUserDao接口.调用的时候通过调用代理对象的方法来调用目标对象.
需要注意的是,代理对象与目标对象要实现相同的接口,然后通过调用相同的方法来调用目标对象的方法

静态代理总结:
1.可以做到在不修改目标对象的功能前提下,对目标功能扩展
2.缺点:
因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护.
 */
public class 静态代理 implements com.example.common.基础.设计模式.IUserDao {

    private com.example.common.基础.设计模式.IUserDao IUserDao;


    //代理对象:UserDaoProxy.java
    public 静态代理(com.example.common.基础.设计模式.IUserDao IUserDao) {
        this.IUserDao = IUserDao;
    }

    @Override
    public void save() {
        System.out.println("开始事务...");
        IUserDao.save();//执行目标对象的方法
        System.out.println("提交事务...");

    }

    @Override
    public void insert() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public void query(int a) {

    }
}
