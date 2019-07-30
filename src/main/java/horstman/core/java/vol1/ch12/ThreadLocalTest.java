package horstman.core.java.vol1.ch12;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalTest{
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
    private final ThreadLocal<SimpleDateFormat> dateFormatTL = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S"));

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            ThreadLocalTest tlt = new ThreadLocalTest();
            while(true) {
//                System.out.println(Thread.currentThread().getName() + " " + tlt.dateFormat.format(new Date()));
                System.out.println(Thread.currentThread().getName() + " " + tlt.dateFormatTL.get().format(new Date()));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ignored) {}
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            ThreadLocalTest tlt = new ThreadLocalTest();
            while(true) {
                /*System.out.println(Thread.currentThread().getName() + " " + tlt.dateFormat.format(new Date()));*/
                System.out.println(Thread.currentThread().getName() + " " + tlt.dateFormatTL.get().format(new Date()));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ignored) {}
            }
        });
        thread2.start();
    }
}
