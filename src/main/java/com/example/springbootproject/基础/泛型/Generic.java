package com.example.springbootproject.基础.泛型;

public class Generic<a> {
    //此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型

    public a value;

    public  Generic(a value){
        this.value=value;

    }

    public  a getValue(){
        return  value;
    }
}
