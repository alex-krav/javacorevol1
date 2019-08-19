package warburton.java8.lambdas.ch03_Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class MapUsingReduce {
    public static <I,O> Stream<O> map(Stream<I> stream, Function<I,O> function) {
//        stream.reduce(stream, e -> function.apply(e))
        return null;
    }

    public static <I, O> List<O> map1(Stream<I> stream, Function<I, O> mapper) {
        return stream.reduce(
                // identity
                new ArrayList<O>(),
                // accumulator, BiFunction
                (acc, x) -> {
                    List<O> newAcc = new ArrayList<>(acc);
                    newAcc.add(mapper.apply(x));
                    return newAcc;
                },
                // combiner, BiOperator
                (List<O> left, List<O> right) -> {
                    List<O> newLeft = new ArrayList<>(left);
                    newLeft.addAll(right);
                    return newLeft;
                });
    }
}
