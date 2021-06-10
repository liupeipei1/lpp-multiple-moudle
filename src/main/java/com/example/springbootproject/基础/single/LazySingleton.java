package com.example.springbootproject.基础.single;

public class LazySingleton {

    private LazySingleton(){}

    private volatile static LazySingleton instance ;

    //懒汉式，线程安全  这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
    public   static LazySingleton getInstance(){
        if (instance == null){
            synchronized(LazySingleton.class){
                instance=new LazySingleton();
            }
        }
        return  instance;
 }

}
