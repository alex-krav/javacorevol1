package warburton.java8.lambdas.ch06_Parallelism;

import java.util.stream.IntStream;

public class Exercise_6_10_sum {

    public static int sequentialSumOfSquares(IntStream range) {
        return range.map(x -> x * x)
                .sum();
    }

    public static int parallelSumOfSquares(IntStream range) {
        return range.parallel()
                .map(x -> x * x)
                .sum();
    }
}
