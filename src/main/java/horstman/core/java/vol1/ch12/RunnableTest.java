package horstman.core.java.vol1.ch12;

/**
 * Runnable.run() - just normal object & method
 * Thread.run() - runs code in same thread as calling thread
 * Thread.start() - creates new thread, and runs code there
 */
public class RunnableTest {
    public static void main(String[] args) {
//        Runnable run = () -> {
//            System.out.println("run running...");
//        };
//        run.run();

//        RunnableClass runClass = new RunnableClass();
//        runClass.run();

        System.out.println(Thread.currentThread() + " in main");

//        Thread threadA = new ChildThread();
//        threadA.run();

        Thread threadB = new Thread(() -> {
            System.out.println(Thread.currentThread() + " is new thread");
        });
        threadB.start();
    }
}

class RunnableClass implements Runnable {

    @Override
    public void run() {
        System.out.println("RunnableClass running...");
    }
}

class ChildThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread() + " running");
    }
}
