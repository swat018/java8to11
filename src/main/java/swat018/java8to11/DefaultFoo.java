package swat018.java8to11;

public class DefaultFoo implements FooInterface{

    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

//    @Override
//    public void printNameUpperCase() {
//        System.out.println(this.name.toUpperCase());
//    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
