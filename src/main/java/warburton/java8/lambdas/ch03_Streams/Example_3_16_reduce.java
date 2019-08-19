package warburton.java8.lambdas.ch03_Streams;

import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example_3_16_reduce {
    @Test
    public void testReduce() {
        int count = Stream.of(1, 2, 3)
                .reduce(0, (acc, element) -> acc + element);

        assertEquals(6, count);
    }

    @Test
    public void testApply() {
        BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
        int count = accumulator.apply(
                accumulator.apply(
                        accumulator.apply(0, 1),
                2),
        3);

        assertEquals(6, count);
    }

    @Test
    public void testImperative() {
        int acc = 0;
        for (Integer element : asList(1,2,3)) {
            acc += element;
        }

        assertEquals(6, acc);
    }
}

