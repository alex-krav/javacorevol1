package warburton.java8.lambdas.ch03_Streams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example_3_8_Map {
    @Test
    public void testForEachLoop() {
        List<String> collected = new ArrayList<>();
        for (String string : Arrays.asList("a", "b", "hello")) {
            String uppercaseString = string.toUpperCase();
            collected.add(uppercaseString);
        }

        assertEquals(Arrays.asList("A", "B", "HELLO"), collected);
    }

    @Test
    public void testStream() {
        List<String> collected = Stream.of("a", "b", "hello")
                .map(string -> string.toUpperCase())
//                .map(String::toUpperCase)
                .collect(Collectors.toList());

        assertEquals(Arrays.asList("A", "B", "HELLO"), collected);
    }
}
