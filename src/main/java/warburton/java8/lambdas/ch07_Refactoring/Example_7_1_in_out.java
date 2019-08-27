package warburton.java8.lambdas.ch07_Refactoring;

import java.util.function.Supplier;

public class Example_7_1_in_out {

    private static boolean isDebugEnabled = false;

    public static void log(Supplier<String> msg) {
        if (isDebugEnabled) {
            System.out.println(msg.get());
        } else {
            System.out.println("logging is disabled");
        }
    }

    public static void main(String[] args) {
//        log(() -> "Hello World");
        log(() -> "Hello World " + getUserName("Vasya"));
    }

    public static String getUserName(String name) {
        try {
            System.out.println("About to sleep ...");
            Thread.sleep(10_000);
            return name;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
