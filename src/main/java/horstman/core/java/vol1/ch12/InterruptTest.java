package horstman.core.java.vol1.ch12;

public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while(true) {
                /*if (Thread.interrupted()) {
                    System.out.println("Thread.isInterrupted()");
                    return;
                }*/
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException while sleeping");
                    return;
                }
            }
        });

        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        System.out.println("thread.isInterrupted(): " + thread.isInterrupted());
    }
}
