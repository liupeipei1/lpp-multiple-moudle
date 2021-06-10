package com.example.springbootproject.基础.泛型;

public class GeneratorSon<T> extends  GeneratorImpl<T>{
    void aa(){
        super.methos();
    }

  //泛型方法
    public static < E > void printArray( E[] inputArray )
    {
        for ( E element : inputArray ){
            System.out.printf( "%s ", element );
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = { "Hello", "World" };
        printArray( intArray  );
        printArray( stringArray  );
    }

}
