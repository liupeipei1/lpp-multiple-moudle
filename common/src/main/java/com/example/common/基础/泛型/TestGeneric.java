package com.example.common.基础.泛型;

public class TestGeneric {


    public static void main(String[] args) {
        Generic<String> gg = new Generic<>("那么");
        System.out.printf("输出结果：" + gg.getValue());
    }

}
