package warburton.java8.lambdas.ch07_Refactoring;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example_7_8_unitTest {

    public static List<String> allToUpperCase(List<String> words) {
        return words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    @Test
    public void multipleWordsToUpperCase() {
        List<String> input = asList("a", "b", "hello");
        List<String> result = Example_7_8_unitTest.allToUpperCase(input);
        assertEquals(asList("A", "B", "HELLO"), result);
    }

    public static List<String> elementFirstToUpperCaseLambdas(List<String> words) {
        return words.stream()
                .map(value -> {
                    char firstChar = Character.toUpperCase(value.charAt(0));
                    return firstChar + value.substring(1);
                })
                .collect(Collectors.toList());
    }

    @Test
    public void twoLetterStringConvertedToUppercaseLambdas() {
        List<String> input = asList("ab");
        List<String> result = Example_7_8_unitTest.elementFirstToUpperCaseLambdas(input);
        assertEquals(asList("Ab"), result);
    }

    public static List<String> elementFirstToUppercase(List<String> words) {
        return words.stream()
                .map(Example_7_8_unitTest::firstToUpperCase)
                .collect(Collectors.toList());
    }

    public static String firstToUpperCase(String value) {
        char firstChar = Character.toUpperCase(value.charAt(0));
        return firstChar + value.substring(1);
    }

    @Test
    public void twoLetterStringConvertedToUppercase() {
        String input = "ab";
        String result = Example_7_8_unitTest.firstToUpperCase(input);
        assertEquals("Ab", result);
    }
}
