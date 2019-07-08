package horstman.core.java.vol1.ch06;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {
        var comp = new LengthComparator();
        if (comp.compare("Vasya", "Alex") > 0) {
            System.out.println("Vasya is longer then Alex");
        }

        String[] friends = {"Peter", "Paul", "Mary"};
        Arrays.sort(friends, new LengthComparator());
        System.out.println(Arrays.toString(friends));
    }
}

class LengthComparator implements Comparator<String> {

    @Override
    public int compare(String first, String second) {
        return first.length() - second.length();
    }
}