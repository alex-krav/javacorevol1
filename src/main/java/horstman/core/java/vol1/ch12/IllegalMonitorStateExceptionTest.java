package horstman.core.java.vol1.ch12;

public class IllegalMonitorStateExceptionTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread1 running...");
        });
//        thread1.start();
//        thread1.wait();
        thread1.notifyAll();
    }
}
