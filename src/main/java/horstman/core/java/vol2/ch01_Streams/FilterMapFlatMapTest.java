package horstman.core.java.vol2.ch01_Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static horstman.core.java.vol2.ch01_Streams.CreatingStreams.show;

public class FilterMapFlatMapTest {
    public static Stream<String> codePoints(String s) {
        var result = new ArrayList<String>();
        int i = 0;
        while (i < s.length()) {
            int j = s.offsetByCodePoints(i, 1);
            result.add(s.substring(i, j));
            i = j;
        }
        return result.stream();
    }

    public static void main(String[] args) {
        String line = "A stream transformation produces a stream whose elements are derived from those of another stream.";
        List<String> words = List.of(line.split(("\\PL+")));

        Stream<String> longWords = words.stream().filter(w -> w.length() > 12);
        show("longWords", longWords);

        Stream<String> lowercaseWords = words.stream().map(String::toLowerCase);
        show("lowercaseWords", lowercaseWords);

        Stream<String> firstLetters = words.stream().map(s -> s.substring(0, 1));
        show("firstLetters", firstLetters);

        Stream<Stream<String>> codePoints = words.stream().map(w -> codePoints(w));
        Stream<String> flatCodePoints = words.stream().flatMap(w -> codePoints(w));
        show("flatCodePoints", flatCodePoints);
    }
}
