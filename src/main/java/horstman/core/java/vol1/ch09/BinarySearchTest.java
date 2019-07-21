package horstman.core.java.vol1.ch09;

import java.util.*;

public class BinarySearchTest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        int insertIndex = 0;
        int key = 15;
        int index = Collections.binarySearch(numbers, key);
        if (index > 0)
            System.out.printf("Found key %d at index %d", key, index);
        else
            insertIndex = -index -1;
            System.out.printf("Did't find key %d (index %d). Could be inserted at index %d", key, index, insertIndex);
    }
}
