package horstman.core.java.vol1.ch08;

import javax.swing.*;
import java.io.Serializable;

/**
 * @author Cay Horstmann
 * @version 1.01 2012-01-26
 */
public class PairTest1 {
    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> mm = ArrayAlg1.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());

//        String middle1 = ArrayAlg.<String>getMiddle("John", "Q.", "Public");
        String middle1 = ArrayAlg1.getMiddle("John", "Q.", "Public");
        System.out.println("middle1=" + middle1);

//        double middle = ArrayAlg.getMiddle(3.14, 1729, 0);
        double middle2 = ArrayAlg1.getMiddle(3.14, 1729.0, 0.0);
        System.out.println("middle2=" + middle2);

//        JButton button = ArrayAlg.getMiddle("Hello", 0, null);
//        String str = ArrayAlg.getMiddle("Hello", 0, null);
        Object m1 = ArrayAlg1.getMiddle("Hello", 0, null);
        Serializable m2 = ArrayAlg1.getMiddle("Hello", 0, null);
        Comparable m3 = ArrayAlg1.getMiddle("Hello", 0, null);


    }
}

class ArrayAlg1 {
    /**
     * Gets the minimum and maximum of an array of strings.
     *
     * @param a an array of strings
     * @return a pair with the min and max values, or null if a is null or empty
     */
    public static Pair<String> minmax(String[] a) {
        if (a == null || a.length == 0) return null;
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min, max);
    }

    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }
}