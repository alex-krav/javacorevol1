package horstman.core.java.vol1.ch12;

public class SynchronizedInstanceMethodsTest {
    public static void main(String[] args) throws InterruptedException {
        SyncMethods sm = new SyncMethods();
        Thread thread1 = new Thread(() -> {
            while(true) {
                System.out.println(sm.getA());
//                System.out.println(SyncStaticMethods.getStaticA());
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException ignored) {}
            }
        });
        Thread thread2 = new Thread(() -> {
            while(true) {
                System.out.println(sm.getA());
//                System.out.println(SyncStaticMethods.getStaticA());
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException ignored) {}
            }
        });
        thread1.start();
        thread2.start();
        Thread.sleep(3000);
        thread1.interrupt(); //won't work
        thread2.interrupt();
    }
}

class SyncMethods {
    private int a = 1;
    private int b = 2;

    public synchronized int getA() {
        return a;
    }

    public synchronized int getB() {
        return b;
    }
}


class SyncStaticMethods {
    private static int a = 1;
    private static int b = 2;

    public static synchronized int getStaticA() {
        return a;
    }

    public static synchronized int getStaticB() {
        return b;
    }
}

