package horstman.core.java.vol1.ch09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The program demonstrates the random shuffle and sort algorithms.
 */
public class ShuffleTest {
    public static void main(String[] args) {
        var numbers = new ArrayList<Integer>();
        for (int i = 1; i <= 49; i++)
            numbers.add(i);
        Collections.shuffle(numbers);

        List<Integer> winningCombination = numbers.subList(0, 6);
        Collections.sort(winningCombination);
        System.out.println(winningCombination);
    }
}