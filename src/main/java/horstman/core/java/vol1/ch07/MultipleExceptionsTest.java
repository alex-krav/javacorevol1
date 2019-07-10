package horstman.core.java.vol1.ch07;

import java.io.EOFException;
import java.io.IOException;

public class MultipleExceptionsTest {
    public static void main(String[] args) {
        /*try {
            method1();
            method1();
        }*/
        /*catch (IOException e) {
            e = new EOFException();
            throw e;
        }*/
        /*catch (IOException | ArrayStoreException e) {
            e = new EOFException();
        }*/
    }

    public static void method1() throws IOException {

    }

    public static void method2() throws ArrayStoreException {

    }
}
