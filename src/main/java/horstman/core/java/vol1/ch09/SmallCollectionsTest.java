package horstman.core.java.vol1.ch09;

import java.util.*;

import static java.util.Map.entry;

public class SmallCollectionsTest {
    public static void main(String[] args) {
        var names = List.of("Peter", "Paul", "Mary");
        var numbers = Set.of(2,3,5);
        var scores = Map.of("Peter", 2, "Paul", 3, "Mary", 5);

//        scores.put("Alex", 7);

        var scores2 = Map.ofEntries(
                entry("Peter", 2),
                entry("Paul", 3),
                entry("Mary", 5)
        );

        var names2 = new ArrayList<>(List.of("Peter", "Paul", "Mary"));

        var settings = Collections.nCopies(100, "DEFAULT");

        // mutable, not resizable
        var mutable = Arrays.asList("a", "b", "c");
        mutable.set(0, "A");
//        mutable.add("d"); //UnsupportedOperationException
        System.out.println(mutable);

        // unmutable, not resizable
        var resizable = List.of("a", "b", "c");
//        resizable.set(0, "A"); //UnsupportedOperationException
//        resizable.add("d"); //UnsupportedOperationException
        System.out.println(resizable);

        Map.Entry<String,String> pair1 = Map.entry("a", "b");
        var pair2 = Map.entry("a", "b");
        System.out.println("key="+pair2.getKey()+", val="+pair2.getValue());
    }
}
