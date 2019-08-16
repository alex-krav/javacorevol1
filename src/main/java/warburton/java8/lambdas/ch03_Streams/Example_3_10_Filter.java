package warburton.java8.lambdas.ch03_Streams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example_3_10_Filter {
    @Test
    public void testFor() {
        List<String> numbers = new ArrayList<>();
        for(String value : asList("a", "1abc", "abc1")) {
            if (isDigit(value.charAt(0))) {
                numbers.add(value);
            }
        }

        assertEquals(asList("1abc"), numbers);
    }

    @Test
    public void testStream() {
        List<String> numbers = Stream.of("a", "1abc", "abc1")
                .filter(value -> isDigit(value.charAt(0)))
                .collect(Collectors.toList());

        assertEquals(asList("1abc"), numbers);
    }
}
