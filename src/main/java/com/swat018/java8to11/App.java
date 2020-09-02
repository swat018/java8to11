package com.swat018.java8to11;

import org.apache.tomcat.util.net.jsse.JSSEUtil;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Chicken("양념")
@Chicken("마늘간장")
public class App {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
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

/*        Instant now = Instant.now();
        Instant plus = now.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now, plus);
        System.out.println(between.getSeconds());*/

        // 14. 자바 Concurrent 프로그래밍 소개
/*        MyThread myThread = new MyThread();
        myThread.start();*//*

        Thread thread = new Thread(() -> {
            *//*try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*//*

*//*            while(true) {
                System.out.println("Thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    System.out.println("exit!");
                   return;
                }
            }*//*

            System.out.println("Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        });
        thread.start();

        System.out.println("Hello: " + Thread.currentThread().getName());
*//*        Thread.sleep(3000L);
        thread.interrupt();*//*
        thread.join();
        System.out.println(thread + " is finished");
        */

        // 15. Executors
/*        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.helloFuture(() -> {
            System.out.println("Thrad " + Thread.currentThread().getName());
        });

//        executorService.shutdownNow();
            executorService.shutdown();*/

/*        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.helloFuture(getRunnable("Hello"));
        executorService.helloFuture(getRunnable("Jinwoo"));
        executorService.helloFuture(getRunnable("The"));
        executorService.helloFuture(getRunnable("Java"));
        executorService.helloFuture(getRunnable("Thread"));

        executorService.shutdown();*/

/*        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(getRunnable("Hello"), 3, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(getRunnable("World"),1, 2, TimeUnit.SECONDS);*/

        // 16. Callable과 Future
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
/*        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "java";
        };

        Callable<String> jinwoo = () -> {
            Thread.sleep(1000L);
            return "jinwoo";
        };

*//*        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone());
        System.out.println("Started!");

//        helloFuture.get();
        helloFuture.cancel(false);

        System.out.println(helloFuture.isDone());

        System.out.println("End!!");*//*

*//*        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, jinwoo));
        for (Future<String> f: futures) {
            System.out.println(f.get());
        }*//*
        String s = executorService.invokeAny(Arrays.asList(hello, java, jinwoo));
        System.out.println(s);

        executorService.shutdown();*/

        // 17. CompletableFuture 1
/*        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("jinwoo");

        System.out.println(future.get());*/
/*        CompletableFuture<String> future = CompletableFuture.completedFuture("jinwoo");
        System.out.println(future.get());*/
/*        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
        });
        future.get();*/
/*        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenApply((s) -> {
            return s.toUpperCase();
        });*/
/*        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenAccept((s) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(s.toUpperCase());
        });*/
/*        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }, executorService).thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        }, executorService);

        future.get();

        executorService.shutdown();*/

        // 18. CompletableFuture 2
    /*    boolean throwFrror = true;

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            if (throwFrror) {
                throw new IllegalArgumentException();
            }

            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).handle((result, ex) -> {
           if (ex != null) {
               System.out.println(ex);
               return "Error!";
           }
           return result;
        });
        *//*.exceptionally(ex -> {
                    System.out.println(ex);
                    return "Error!";
        });*//*

        CompletableFuture<String> future = hello.thenCompose(App::getWorld);
        System.out.println(future.get());

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return "World";
        });

        CompletableFuture<String> future1 = hello.thenCombine(world, (h, w) -> h + " " + w);
        System.out.println(future1.get());

        List<CompletableFuture<String>> futures = Arrays.asList(hello, world);
        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);

        CompletableFuture<List<String>> results = CompletableFuture.allOf(futuresArray)
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));

        results.get().forEach(System.out::println);
        System.out.println();

        CompletableFuture<Void> future3 = CompletableFuture.anyOf(hello, world).thenAccept((s) -> System.out.println(s));
        future3.get();*/

        // 19. 애노테이션의 변화
//        List<@Chicken String> names = Arrays.asList("jinwoo");
/*        Chicken[] chickens = App.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach(c -> {
            System.out.println(c.value());
        });*/
        ChickenContainer chickenContainer = App.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(c-> {
            System.out.println(c.value());
        });

    }

/*    static class FeelsLikeChicken<@Chicken T> {
        public static <@Chicken C> void print(C c) {
            System.out.println(c);
        }
    }*/

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return message + " World";
        });
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread: " + Thread.currentThread().getName());
        }
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
