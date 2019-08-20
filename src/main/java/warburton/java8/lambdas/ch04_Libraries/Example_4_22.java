package warburton.java8.lambdas.ch04_Libraries;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class Example_4_22 {
    @Test
    public void test1() {
        Optional<String> a = Optional.of("a");
        assertEquals("a", a.get());
        assertTrue(a.isPresent());
    }

    @Test
    public void test2() {
        Optional emptyOptional = Optional.empty();
        Optional alsoEmpty = Optional.ofNullable(null);
        assertFalse(emptyOptional.isPresent());
        assertFalse(alsoEmpty.isPresent());
    }

    @Test
    public void test3() {
        Optional emptyOptional = Optional.empty();
        assertEquals("b", emptyOptional.orElse("b"));
        assertEquals("c", emptyOptional.orElseGet(() -> "c"));
    }
}
