package warburton.java8.lambdas.ch05_Collections;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Example_5_1 {
    @Test
    public void testListOrder() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        List<Integer> samerOder = numbers.stream().collect(Collectors.toList());
        assertEquals(numbers, samerOder);
    }

    @Test
    public void testHashSetOrder() {
        Set<Integer> numbers = new HashSet<>(asList(4, 3, 2, 1));
        List<Integer> samerOder = numbers.stream().collect(Collectors.toList());
        assertEquals(asList(4, 3, 2, 1), samerOder);
    }

    @Test
    public void testSorted() {
        Set<Integer> numbers = new HashSet<>(asList(4, 3, 2, 1));
        List<Integer> samerOder = numbers.stream().sorted().collect(Collectors.toList());
        assertEquals(asList(1, 2, 3, 4), samerOder);
    }

    @Test
    public void testHasItem() {
        List<Integer> numbers = asList(1,2,3,4);
        List<Integer> stillOrdered = numbers.stream().map(x -> x + 1).collect(Collectors.toList());
        assertEquals(asList(2,3,4,5), stillOrdered);

        Set<Integer> unordered = new HashSet<>(numbers);
        List<Integer> stillUnordered = unordered.stream().unordered().map(x -> x +1).collect(Collectors.toList());
        assertEquals(asList(2,3,4,5), stillUnordered);
        assertTrue(stillUnordered.contains(2));
    }
}
