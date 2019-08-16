package horstman.core.java.vol2.ch01_Streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static horstman.core.java.vol2.ch01_Streams.CreatingStreams.show;

public class DistinctSortedPeek {
    public static void main(String[] args) {
        Stream<String> uniqueWords = Stream.of("merrily", "merrily", "merrily", "gently").distinct();
        show("uniqueWords", uniqueWords);

        List<String> words = List.of("bb", "a", "dddd", "ccc");
        Stream<String> longestFirst = words.stream().sorted(Comparator.comparing(String::length).reversed());
        show("longestFirst", longestFirst);

        Object[] powers1 = Stream.iterate(1.0, p -> p * 2)
                .peek(e ->
                        System.out.println("Fetching " + e))
                .limit(20).toArray();

        Object[] powers2 = Stream.iterate(1.0, p -> p * 2)
                .peek(e -> {
                        return;})
                .limit(20).toArray();
    }
}
