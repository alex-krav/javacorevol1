package warburton.java8.lambdas.ch06_Parallelism;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise_6_11_multiply {

    @Test
    public void testMultiplySequential() {
        List<Integer> ints = List.of(1, 2, 3);
        assertEquals(30, multiplyThrough(ints));
        assertEquals(30, multiplyThroughParallel(ints));
    }

    public static int multiplyThrough(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.stream()
                .reduce(5, (acc, x) -> x * acc);
    }

    public static int multiplyThroughParallel(List<Integer> linkedListOfNumbers) {
        return 5 * linkedListOfNumbers.parallelStream()
                .reduce(1, (acc, x) -> x * acc);
    }
}
