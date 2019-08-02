package horstman.core.java.vol2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Stream;

public class Interference {
    public static void main(String[] args) {
        // List.of - unmodifiable
        // ArrayList - can't iterator.remove()
        LinkedList<String> wordList = new LinkedList<>(Arrays.asList("a", "b", "c"));
        Stream<String> words = wordList.stream();
        words.forEach(s -> {if (s.length() < 12) wordList.remove(s);});
        //ConcurrentModificationException
    }
}
