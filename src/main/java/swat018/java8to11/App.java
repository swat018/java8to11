package swat018.java8to11;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {
//        UnaryOperator<String> hi = (s) -> "hi " + s;

//        Greeting greeting = new Greeting();
//
//        UnaryOperator<String> hi = Greeting::hi;
//        UnaryOperator<String> hello= greeting::hello;
//        System.out.println(hello.apply("jinwoo"));
//
//        Supplier<Greeting> newGreeting = Greeting::new;
//        newGreeting.get();
//
//        Function<String, Greeting> jinwooGreeting = Greeting::new;
//        Greeting jinwoo = jinwooGreeting.apply("jinwoo");
//        System.out.println(jinwoo.getName());
//
//
//        String[] names = {"jinwoo", "swat018", "keesun"};
//
//        Arrays.sort(names, (o1, o2) -> 0);
//        Arrays.sort(names, String::compareToIgnoreCase);
//        System.out.println(Arrays.toString(names));

//        FooInterface foo = new DefaultFoo("jinwoo");
//        foo.printName();
//        foo.printNameUpperCase();
//
//
//        FooInterface.printAnything();

        List<String> name = new ArrayList<>();
        name.add("jinwoo");
        name.add("seojin");
        name.add("hyebin");
        name.add("taeyang");
        name.add("hyunji");

//        forEach()
//        name.forEach(s -> {
//            System.out.println(s);
//        });
//        name.forEach(System.out::println);

//        for (String n : name) {
//            System.out.println(n);
//        }

//        spliterator()
//        Spliterator<String> spliterator = name.spliterator();
//        Spliterator<String> spliterator1= spliterator.trySplit();
//        while (spliterator.tryAdvance(System.out::println));
//        System.out.println(" ====================== ");
//        while (spliterator1.tryAdvance(System.out::println));

//        stream()
//        long k = name.stream().map(String::toUpperCase)
//                .filter(s -> s.startsWith("J"))
//                .count();
//        System.out.println(k);

//        removeIf
//        name.removeIf(s -> s.startsWith("j"));
//        name.forEach(System.out::println);

//        name.sort(String::compareToIgnoreCase);
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;;
        name.sort(compareToIgnoreCase.reversed());
        name.forEach(System.out::println);





    }
}
