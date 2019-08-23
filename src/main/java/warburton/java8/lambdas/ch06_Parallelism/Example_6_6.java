package warburton.java8.lambdas.ch06_Parallelism;

import java.util.List;

public class Example_6_6 {

    public int addIntegers(List<Integer> values) {
        return values.parallelStream()
                .mapToInt(i -> i)
                .sum();
    }
}
