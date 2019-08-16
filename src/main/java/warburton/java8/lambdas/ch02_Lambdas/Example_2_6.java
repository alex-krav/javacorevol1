package warburton.java8.lambdas.ch02_Lambdas;

public class Example_2_6 {
    public static void main(String[] args) {
        /*final*/ String name = "Vasya";
//        name = "Alex";
        Runnable runnable = () -> System.out.println("hi " + name);
    }
}
