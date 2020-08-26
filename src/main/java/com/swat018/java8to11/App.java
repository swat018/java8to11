package com.swat018.java8to11;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) throws InterruptedException {
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
 /*       List<String> names = new ArrayList<>();
        names.add("keesun");
        names.add("whiteship");
        names.add("tody");
        names.add("foo");*/

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

/*        List<String> collect = names.parallelStream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);*/

        // 9. Stream API
     /*   List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "optional boot", true));
        springClasses.add(new OnlineClass(2, "optional data jpa", true));
        springClasses.add(new OnlineClass(3, "optional mvc", false));
        springClasses.add(new OnlineClass(4, "optional core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);

        System.out.println("optional 으로 시작하는 수업");
        springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("optional"))
                .forEach(oc-> System.out.println(oc.getId()));

        System.out.println("close 되지 않은 수업");
        springClasses.stream()
//                .filter(oc -> !oc.isClosed())
                .filter(Predicate.not(OnlineClass::isClosed))
                .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("수업 이름만 모아서 스트림 만들기");
        springClasses.stream()
                .map(OnlineClass::getTitle)
                .forEach(System.out::println);

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        keesunEvents.stream()
                .flatMap(Collection::stream)
                .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        Stream.iterate(10, i -> i+1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        boolean test = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println(test);

        System.out.println("스프링 수업 중에 제목에 spring이 들어간 제목만 모아서 List로 만들기");
        List<String> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().contains("optional"))
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());
        optional.forEach(System.out::println);*/

        // 10. Optional 소개
/*        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));*/

/*        OnlineClass spring_boot = new OnlineClass(1, "optional boot", true);
        Progress progress = spring_boot.getProgress();
        if (progress != null) {
            System.out.println(progress.getStudyDuration());
        }*/

        // 11. Optional API
/*        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

*//*        boolean present = optional.isPresent();
        System.out.println(present);

        OnlineClass  onlineClass= optional.get();
        System.out.println(onlineClass.getTitle());*//*

*//*        OnlineClass onlineClass = optional.orElseGet(App::createNewClass);
        System.out.println(onlineClass.getTitle());*//*

*//*        OnlineClass onlineClass = optional.orElseThrow(IllegalStateException::new);
        System.out.println(onlineClass.getTitle());*//*

*//*        Optional<OnlineClass> onlineClass = optional
                .filter(OnlineClass::isClosed);
//        System.out.println(onlineClass.isEmpty());
        System.out.println(onlineClass.isPresent());*//*

        Optional<Progress> progress = optional.flatMap(OnlineClass::getProgress);
        Optional<Optional<Progress>> progress1 = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress2 = progress1.orElseThrow();*/

        // 12. Date와 Time API 소개
/*        Date date = new Date();
        long time = date.getTime();
        System.out.println(date);
        System.out.println(time);

        Thread.sleep(1000 * 3);
        Date  after3Seconds = new Date();
        System.out.println(after3Seconds);
        after3Seconds.setTime(time);
        System.out.println(after3Seconds);*/

/*        Calendar jinwooBirthDay = new GregorianCalendar(1984, 4, 18);
        System.out.println(jinwooBirthDay.getTime());
        jinwooBirthDay.add(Calendar.DAY_OF_YEAR, 1);
        System.out.println(jinwooBirthDay.getTime());*/
/*
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);*/

        // 13. Date/Time API
/*        Instant instant = Instant.now();
        System.out.println(instant);                            // 기준시 UTC, GMT
        System.out.println(instant.atZone(ZoneId.of("UTC")));   // 기준시 UTC, GMT

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println(zonedDateTime);*/

/*        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime birthDay = LocalDateTime.of(1984, Month.MAY, 18, 0, 0, 0);
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime);*/

        LocalDate today = LocalDate.now();
        LocalDate thisYearBrithday = LocalDate.of(2020,Month.MAY,18);

        Period period = Period.between(today, thisYearBrithday);
        System.out.println(period.getDays());

        Period until = today.until(thisYearBrithday);
        System.out.println(period.get(ChronoUnit.DAYS));

    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New class", false);
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
