package horstman.core.java.vol1.ch07;

import java.util.Random;
import java.util.logging.Logger;

public class LoggingProxyTest {
    public static void main(String[] args) {
        var generator = new Random() {
            @Override
            public double nextDouble() {
                double result = super.nextDouble();
                Thread.dumpStack();
                Logger.getGlobal().info("nextDouble: " + result);
                return result;
            }
        };
        /*for (int i = 0; i < 5; i++) {
            System.out.println(generator.nextDouble());
        }*/
        System.out.println(generator.nextDouble());
    }
}
