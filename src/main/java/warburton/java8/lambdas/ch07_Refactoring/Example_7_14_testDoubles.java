package warburton.java8.lambdas.ch07_Refactoring;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Example_7_14_testDoubles {
    @Test
    public void testUsingMockito() {
        List<String> otherList = List.of("a","b","c");
        List<String> list = mock(List.class);
        when(list.size()).thenAnswer(inv -> otherList.size());
        assertEquals(3, list.size());
    }
}
