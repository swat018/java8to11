package swat018.java8to11;

import java.util.function.*;

public class Foo {

    public static void main(String[] args) {
//        Plus10 plus10 = new Plus10();
//        System.out.println(plus10.apply(1));

//        Function<Integer, Integer> plus10 = (i) -> i + 10;
//        Function<Integer, Integer> multiply2 = (i) -> i * 2;
//        System.out.println(plus10.apply(1));
//        System.out.println(multiply2.apply(1));
//
//        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
//        System.out.println(multiply2AndPlus10.apply(2));
//        System.out.println(plus10.andThen(multiply2).apply(2));
//
//        Consumer<Integer> printT = (i) -> System.out.println(i);
//        printT.accept(10);
//
//        Supplier<Integer> get10 = () -> 10;
//        System.out.println(get10.get());
//
//        Predicate<String> startsWithJinwoo = (s) -> s.startsWith("jinwoo");
//        Predicate<Integer> isEven = (i) -> 1%2 ==0;

//        UnaryOperator<Integer> plus12 = (i) -> i + 12;
//        UnaryOperator<Integer> multiply4 = (i) -> i * 4;
//        System.out.println(plus12.andThen(multiply4).apply(2));

        Supplier<Integer> get10 =  () -> 10;

        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(1,2));

        BinaryOperator<Integer> sum1 = (a, b) -> a + b;
        System.out.println(sum1.apply(2, 4));

        Foo foo = new Foo();
        foo.run();

    }

    private void run() {
        int baseNumber = 10;

        // 로컬 클래스
        class localClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber); //   11
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
    }
}
