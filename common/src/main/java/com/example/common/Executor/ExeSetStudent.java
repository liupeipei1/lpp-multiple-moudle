package com.example.common.Executor;

import java.util.concurrent.Callable;

/*
刘佩佩
2021/8/30
*/
public class ExeSetStudent implements Callable<String> {
    private  Integer i;
    private  Student student;
    private  String o;
    private  Integer h;
    private Object object;

    public ExeSetStudent(Integer i, Student student, String o, Integer h, Object object) {
        this.i = i;
        this.student = student;
        this.o = o;
        this.h = h;
        this.object = object;
    }

    public ExeSetStudent(Integer i, Student student, String o, Integer h) {
        this.i = i;
        this.student = student;
        this.o = o;
        this.h = h;
    }

    @Override
    public String call() throws Exception {
      /*  System.out.println(student);
        System.out.println("i"+Thread.currentThread().getName());
        System.out.println("o:"+o);
        System.out.println("h:"+h);
        System.out.println("i:"+i);*/
        if(i==1)
        {
            student.setId(h);
        }
        if(i==2)
        {
            student.setName(o);
        }
        /*if(object instanceof  Course){
            student.courseList.add(object);
        }*/
        return "1";
    }
}
