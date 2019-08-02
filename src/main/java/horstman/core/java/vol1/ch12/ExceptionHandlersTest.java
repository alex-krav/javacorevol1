package horstman.core.java.vol1.ch12;

public class ExceptionHandlersTest {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> System.out.println("Caught by Thread"));

        Runnable r = () -> {
            System.out.println("Working...");
            throw new RuntimeException();
        };
        Thread thread = new Thread(r);
        thread.setUncaughtExceptionHandler((t, e) -> System.out.println("Caught by thread object"));
        thread.start();

    }
}