package horstman.core.java.vol1.ch09;

import java.util.HashMap;

public class GetOrDefaultTest {
    public static void main(String[] args) {
        var strings = new HashMap<String,String>();
        strings.put("a", "A");
        strings.put("b", "B");
        strings.put("c", "C");
        strings.put("null", null);

        System.out.println(strings.getOrDefault("a", "AAA"));
        System.out.println(strings.getOrDefault("null", "NULL"));
        System.out.println(strings.getOrDefault("d", "doesn't exist"));
    }
}
