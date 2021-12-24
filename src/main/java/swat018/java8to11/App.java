package swat018.java8to11;

import java.time.Duration;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

//        List<String> name = new ArrayList<>();
//        name.add("jinwoo");
//        name.add("seojin");
//        name.add("hyebin");
//        name.add("taeyang");
//        name.add("hyunji");

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
//        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;;
//        name.sort(compareToIgnoreCase.reversed());
//        name.forEach(System.out::println);

//        List<String> names = new ArrayList<>();
//        names.add("jinwoo");
//        names.add("seojin");
//        names.add("hyebin");
//        names.add("taeyang");
//        names.add("hyunji");
//
//        Stream<String> stringStream = names.stream().map(String::toUpperCase);
//
//        List<String> collect = names.stream().map((s) -> {
//            System.out.println(s);
//            return s.toUpperCase();
//        }).collect(Collectors.toList());
//        collect.forEach(System.out::println);
//
//        System.out.println("==============");
//
//        names.forEach(System.out::println);
//
//        List<String> collect1 = names.parallelStream().map((s) -> {
//            System.out.println(s + " " + Thread.currentThread().getName());
//            return s.toUpperCase();
//        }).collect(Collectors.toList());
//        collect1.forEach(System.out::println);

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

//        System.out.println("spring 으로 시작하는 수업");
//        springClasses.stream()
//                .filter( oc -> oc.getTitle().startsWith("spring"))
//                .forEach(oc -> System.out.println(oc.getId()));
//
//        System.out.println("close 되지 않은 수업");
//        springClasses.stream()
//                .filter(Predicate.not(OnlineClass::isClosed))
//                .forEach(oc -> System.out.println(oc.getId()));
//
//        System.out.println("수업 이름만 모아서 스트림 만들기");
//        springClasses.stream()
//                .map(OnlineClass::getTitle)
//                .forEach(System.out::println);
//
//        List<OnlineClass> javaClasses = new ArrayList<>();
//        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
//        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
//        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));
//
//        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
//        keesunEvents.add(springClasses);
//        keesunEvents.add(javaClasses);
//
//        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
//        keesunEvents.stream().flatMap(Collection::stream)
//                .forEach(oc -> System.out.println(oc.getId()));
//
//        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
//        Stream.iterate(10, i -> i + 1)
//                .skip(10)
//                .limit(10)
//                .forEach(System.out::println);
//
//        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
//        boolean test = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test"));
//        System.out.println(test);
//
//        System.out.println("스프링 수업 중에 제목에 spring이 들어간 제목만 모아서 List로 만들기");
//        List<String> spring = springClasses.stream()
//                .map(OnlineClass::getTitle)
//                .filter(t -> t.contains("spring"))
//                .collect(Collectors.toList());
//        spring.forEach(System.out::println);

//        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
//        Optional<Progress> progress = spring_boot.getProgress();
//        progress.ifPresent(p -> System.out.println(p.getStudyDuration()));

//        OptionalInt(10);

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

//        boolean present = optional.isPresent();
//        System.out.println(!present);

//        OnlineClass onlineClass = optional.get();
//        System.out.println(onlineClass.getTitle());

//        optional.ifPresent(oc -> System.out.println(oc.getTitle()));
//        OnlineClass onlineClass = optional.orElse(createNewClass());
//        System.out.println(onlineClass.getTitle());

//        OnlineClass onlineClass = optional.orElseGet(App::createNewClass);
//        System.out.println(onlineClass.getTitle());

//        OnlineClass onlineClass = optional.orElseThrow(IllegalStateException::new);
//        System.out.println(onlineClass.getTitle());
//
//        Optional<OnlineClass> onlineClass = optional.filter(oc -> !oc.isClosed());
//        System.out.println(onlineClass.isPresent());

        Optional<Integer> integer = optional.map(OnlineClass::getId);
        System.out.println(integer.isPresent());

        Optional<Progress> progress = optional.flatMap((OnlineClass::getProgress));

        Optional<Optional<Progress>> progress1 = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress2 = progress1.orElse(Optional.empty());

    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New class", false);
    }
}
