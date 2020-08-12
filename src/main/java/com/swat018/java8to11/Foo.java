package com.swat018.java8to11;

import java.util.function.*;

public class Foo {

    public static void main(String[] args) {
//        Function<Integer, Integer> plus10 = (i) -> i + 10;
        UnaryOperator<Integer> plus10 = (i) -> i + 10;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        System.out.println(plus10.apply(1));
        System.out.println(multiply2.apply(1));

        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println(multiply2AndPlus10.apply(2));

        System.out.println(plus10.andThen(multiply2).apply(2));

        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10);

        Predicate<String> startWithJinwoo = (s) -> s.startsWith("jinwoo");
        Predicate<Integer> isEven = (i) -> i%2 == 0;

    }
}
