package com.example.springbootproject.基础.泛型;

public class GeneratorImpl<A> implements Generator<String> {


    @Override
    public String methos() {
        return "hello";
    }
}
