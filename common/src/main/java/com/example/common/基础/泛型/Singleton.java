package com.example.common.基础.泛型;

import java.util.Arrays;
import java.util.List;

public class Singleton<T> {
    //private static T instance = null;
    //无法编译，不能使用 static 修饰泛型 T

  /*  public  T getInstance() {
        if (instance == null)
            instance = new Singleton<T>();

        return instance;
    }*/
  List<Object> objectList;

    List<String> stringList;

   // objectList = stringList; //compilation error incompatible types


    int aa[]={1,2,3};
    List<int[]> bb= Arrays.asList(aa);


}
