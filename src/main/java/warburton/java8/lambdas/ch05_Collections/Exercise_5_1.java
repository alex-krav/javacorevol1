package warburton.java8.lambdas.ch05_Collections;

import org.junit.jupiter.api.Test;
import warburton.java8.lambdas.ch01_domain.Artist;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise_5_1 {
    @Test
    public void testLongestName() {
        List<Artist> names = asList(new Artist("John Lennon"), new Artist("Paul McCartney"), new Artist("George Harrison"), new Artist("Ringo Starr"), new Artist("Stuart Sutcliffe"), new Artist("Pete Best"));

        Artist longest1 = byReduce(names);
        Artist longest2 = byCollecting(names);

        assertEquals("Stuart Sutcliffe", longest1.getName());
        assertEquals("Stuart Sutcliffe", longest2.getName());
    }

    private static Comparator<Artist> byNameLength = Comparator.comparing(artist -> artist.getName().length());

    public static Artist byReduce(List<Artist> artists) {
        return artists.stream()
                .reduce((acc, artist) -> {
                    return (byNameLength.compare(acc, artist) >= 0) ? acc : artist;
                })
                .orElseThrow(RuntimeException::new);
    }

    public static Artist byCollecting(List<Artist> artists) {
        return artists.stream()
                .collect(Collectors.maxBy(byNameLength))
                .orElseThrow(RuntimeException::new);
    }

    @Test
    public void testNumberOfAppearance() {
        Stream<String> names = Stream.of("John", "Paul", "George", "John", "Paul", "John");
        Map<String, Long> frequency = countWords(names);

        assertEquals(Map.of("John", 3L, "Paul", 2L, "George", 1L), frequency);
    }

    public static Map<String, Long> countWords(Stream<String> names) {
        return names.collect(Collectors.groupingBy(name -> name, Collectors.counting()));
    }

    @Test
    public void testGroupingBy() {
        // see GroupingBy.class
    }

    @Test
    public void testFibonacci() {
        // only computeIfAbsent on Map
        Fibonacci fib = new Fibonacci();

        assertEquals(0, fib.fibonacci(0));
        assertEquals(1, fib.fibonacci(1));
        assertEquals(1, fib.fibonacci(2));
        assertEquals(2, fib.fibonacci(3));
        assertEquals(3, fib.fibonacci(4));
        assertEquals(5, fib.fibonacci(5));
        assertEquals(8, fib.fibonacci(6));
    }
}
