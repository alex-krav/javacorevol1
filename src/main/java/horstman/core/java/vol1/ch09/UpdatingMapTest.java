package horstman.core.java.vol1.ch09;

import java.util.HashMap;

public class UpdatingMapTest {
    public static void main(String[] args) {
//        int i = getInt() + 1;

        var word = "asdf";
        var counts = new HashMap<String, Integer>();

        counts.put(word, counts.get(word) + 1);

        counts.put(word, counts.getOrDefault(word, 0) + 1);

        counts.putIfAbsent(word, 0);
        counts.put(word, counts.get(word) + 1);

        counts.merge(word, 1, Integer::sum);
    }

    public static Integer getInt() {
        return null;
    }
}
