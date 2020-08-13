package com.swat018.java8to11;

public interface Foo {

    void printName();

    default void printNameUpperCase(){
        System.out.println(getName().toUpperCase());
    }

    String getName();

}
