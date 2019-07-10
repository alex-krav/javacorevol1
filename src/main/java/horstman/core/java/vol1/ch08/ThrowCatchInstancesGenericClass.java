package horstman.core.java.vol1.ch08;

import java.util.logging.Logger;

public class ThrowCatchInstancesGenericClass {
    public static void main(String[] args) {

    }

    public static <T extends Throwable> void doWork1(Class<T> t) {
        /*try
        {
            // do work
        }
        catch (T e)
        {
            Logger.global.info("smth bad happened");
        }*/
    }

    public static <T extends Throwable> void doWork2(Class<T> t) {
        try {
            // do work
        } catch (Throwable realCause) {
//            t.initCause(realCause);
//            throw t;
        }
    }
}

//class Problem<T> extends Exception {}