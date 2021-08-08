package swat018.java8to11;

public class Foo {

    public static void main(String[] args) {
//        // 익명 내부 클래스 anonymous inner class
//        RunSomething runSomething = () -> System.out.println("Hello");
//        runSomething.doIt();


//        RunSomething runSomething = (number) -> {
//            return number + 10;
//        };
//
//        System.out.println(runSomething.doIt(1));
//        System.out.println(runSomething.doIt(1));
//        System.out.println(runSomething.doIt(1));
//
//        System.out.println(runSomething.doIt(2));
//        System.out.println(runSomething.doIt(2));
//        System.out.println(runSomething.doIt(2));
//    }


        int baseNumber = 10;
        RunSomething runSomething = number -> number + baseNumber;
    }
}
