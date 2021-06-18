package com.example.common.基础.设计模式;

public class UserDao  implements IUserDao {


    @Override
    public void save() {
            System.out.println("----已经保存数据!(目标类的实现)----");
    }

    @Override
    public void insert() {
        System.out.println("----已经insert数据!(目标类的实现)----");

    }

    @Override
    public void delete() {
        System.out.println("----已经delete数据!(目标类的实现)----");

    }

    @Override
    public void update() {
        System.out.println("----已经update数据!(目标类的实现)----");

    }

    @Override
    public void query(int a) {
        System.out.println("----已经query数据!(目标类的实现)----"+a);

    }

}
