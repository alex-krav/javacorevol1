package warburton.java8.lambdas.ch06_Parallelism;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Example_6_3 {
    private static int N = 10_000;
    private Roller roller = new Roller();

    public Map<Integer, Double> parallelDiceRolls(int times) {
        double fraction = 1.0 / times;
        return IntStream.range(0, times)
                .parallel()
                .mapToObj(roller::apply)
                .collect(Collectors.groupingBy(side -> side, Collectors.summingDouble(n -> fraction)));
    }

    @Test
    public void testParallelDiceRolls() {
        parallelDiceRolls(100_000_000);
    }
}

class Roller implements IntFunction<Integer> {

    @Override
    public Integer apply(int value) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int firstThrow = random.nextInt(1, 7);
        int secondThrow = random.nextInt(1, 7);
        return firstThrow + secondThrow;
    }
}