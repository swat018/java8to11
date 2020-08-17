package com.swat018.java8to11;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        // 3. 자바에서 제공하는 함수형 인터페이스
/*//        Function<Integer, Integer> plus10 = (i) -> i + 10;
        UnaryOperator<Integer> plus10 = (i) -> i + 10;
        UnaryOperator<Integer> multiply2 = (i) -> i * 2;

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

        BinaryOperator<Integer> sum = (a,b) -> a + b;

        // 4. 람다 표현식
        Foo foo = new Foo();
        foo.run();*/

        // 5. 메소드 레퍼런스
/*        Greeting greeting = new Greeting();
        UnaryOperator<String> hi = Greeting::hi;
        UnaryOperator<String> hello = greeting::hello;

        System.out.println(hello.apply("jinwoo"));

        Function<String, Greeting> jinwooGreeting
                = Greeting::new;
        Greeting jinwoo = jinwooGreeting.apply("jinwoo");
        System.out.println(jinwoo.getName());

        Supplier<Greeting> newGreeting = Greeting::new;

        String[] names = {"keesun", "whiteshop", "toby"};
*//*        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });*//*
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));*/

        // 6. 인터페이스 기본 메소드와 스태틱 메소드
/*        Foo foo = new DefaultFoo("jinwoo");
        foo.printName();
        foo.printNameUpperCase();

        Foo.printAnything();*/

        // 7. 자바 8 API의 기본 메소드와 스태틱 메소드
        List<String> names = new ArrayList<>();
        names.add("keesun");
        names.add("whiteship");
        names.add("tody");
        names.add("foo");

//        name.forEach(System.out::println);

/*        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("================");
        while (spliterator1.tryAdvance(System.out::println));*/

/*        long k = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("K"))
                .count();
        System.out.println(k);*/

//        name.removeIf(s -> s.startsWith("k"));

/*
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
*/
//        names.forEach(System.out::println);

        // 8. Stream 소개
/*        List<String> collect = names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println("==================");
        names.forEach(System.out::println);*/

        List<String> collect = names.parallelStream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

/*    private void run() {
        int baseNumber = 10;

        // 로컬 클래스
        class LocalClass {
            void pringBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber);
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber);
            }
        };

        // 람다
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };

        printInt.accept(10);
    }*/
}
