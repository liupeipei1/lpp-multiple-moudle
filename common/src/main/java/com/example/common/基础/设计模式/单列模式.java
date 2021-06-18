package com.example.common.基础.设计模式;

public class 单列模式 {

    private volatile static 单列模式 sigle=null;

    private 单列模式(){}

    public static 单列模式 getInstance(){
        if(sigle==null){
          synchronized (sigle){
              if(sigle==null){
                  sigle=new 单列模式();
              }
          }
        }
        return sigle;
    }

}
