package horstman.core.java.vol1.ch03;

import java.util.Arrays;

public class JavaArrays {
    public static void main(String[] args) {
        // 0,1,2,3,4 ... 141,142,143    index
        // 1,2,3,4,5 ... 142,143,144    number

        int[] a1;
        a1 = new int[100];
        var a2 = new int[10];
        int[] a3 = {2,3,4,5,6,};
        System.out.printf("a1: %d\n", a1.length);
        System.out.printf("a2: %d\n", a2.length);
        System.out.printf("a3: %d\n", a3.length);

        int[] b1 = {0,1,2};
        int[] b2 = {3,4,5};
        b1 = b2;
        int[] b3 = Arrays.copyOf(b2, 2 * b2.length);
        b2[0] = 100;
        System.out.println("b1: " + Arrays.toString(b1));
        System.out.println("b2: " + Arrays.toString(b2));
        System.out.println("b3: " + Arrays.toString(b3));

        for(int element : b2) {
            System.out.print(element + " ");
        }

    }
}
