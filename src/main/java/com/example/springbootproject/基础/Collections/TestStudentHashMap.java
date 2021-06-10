package com.example.springbootproject.基础.Collections;

import java.util.HashMap;

/*
 将对象存在map里面，然后从hash里面取数据
   这里必须重写 equals  和 hashCode方法,否则就会取不到
 */
public class TestStudentHashMap {

    public static void main(String[] args) {
        HashMap<Student,Course>  hashMap=new HashMap<>();
       Student ss=new Student(1,"我我我哦",18);
       Student ss2=new Student(1,"我我我哦",15);
       Student ss3=new Student(1,"我我我哦",17);
       Student ss4=new Student(1,"我我我哦",19);

        Course  cc=new Course("数学,英语","");
        Course  cc1=new Course("英语","");
        Course  cc2=new Course("体育,英语","");

        hashMap.put(ss,cc);
        hashMap.put(ss2,cc1);
        hashMap.put(ss3,cc2);
        hashMap.put(ss4,cc);

   //获取小六的选课
       Course course= hashMap.get(new Student(1,"我我我哦",15));
       System.out.printf("输出："+course.courseName);







    }
}
