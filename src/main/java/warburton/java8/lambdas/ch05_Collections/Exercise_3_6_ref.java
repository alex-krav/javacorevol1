package warburton.java8.lambdas.ch05_Collections;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise_3_6_ref {
    public long lowerCaseLetters(String str) {
        return str.chars().filter(c -> c >= 'a' && c <= 'z').count();
    }

    public int countLowercaseLetters(String string) {
        return (int) string.chars()
                .filter(Character::isLowerCase)
                .count();
    }

    public Optional<String> largestNumberOfLowercase(List<String> list) {
        return list.stream()
            .max(Comparator.comparing(this::lowerCaseLetters));
    }

    @Test
    public void testLowerCase() {
        assertEquals(4, lowerCaseLetters("asdf"));
        assertEquals(0, lowerCaseLetters("ASDF"));
        assertEquals(3, lowerCaseLetters("Alex"));
    }

    @Test
    public void testLargestLowercase() {
        assertEquals("asdf", largestNumberOfLowercase(asList("ASDF", "asdf", "Alex")).get());
        assertEquals(Optional.empty(), largestNumberOfLowercase(asList()));
    }
}
