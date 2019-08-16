package warburton.java8.lambdas.ch03_Streams;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example_3_12_flatMap {
    @Test
    public void testFlatMap() {
        List<Stream> streams = Stream.of(asList(1, 2), asList(3, 4))
                .map(numbers -> numbers.stream())
                .collect(toList());
        List<Integer> integers = Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(toList());

        assertEquals(asList(1, 2, 3, 4), integers);
    }
}
