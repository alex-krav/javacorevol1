package horstman.core.java.vol1.ch12;

import java.net.URL;
import java.util.Scanner;

public class ExceptionsTest {
    public static void main(String[] args) throws Exception {
//        System.out.println("returned: " + simpleTry());
        System.out.println("returned: " + tryWithResources());
    }

    private static int simpleTry() {
        try {
            // exception 1
            if (true) throw new Exception();
            // return 1
            return 1;
        } catch (Exception e) {
            // exception 2
//            if (true) throw new RuntimeException();
            return 2;
        } finally {
            // exception 3
//            if (true) throw new RuntimeException();
            // return
//            return 3;
        }
    }

    private static int tryWithResources() throws Exception {
        Scanner savedIn = null;
        try(var in = new Scanner(System.in)) {
            savedIn = in;
            System.out.println("Enter class name (e.g., java.util.Collections): ");
            var name = in.next();
            System.out.println("You entered: " + name);
            // exception 1
            if (true) throw new Exception();
            // return 1
            return 1;
        } catch (Exception e) {
            System.out.println(savedIn);
            // exception 2
            if (true) throw new Exception();
            // return 2
            return 2;
        } finally {
            // exception 3
            if (true) throw new Exception();
            // return
            return 3;
        }
    }
}
