package warburton.java8.lambdas.ch06_Parallelism;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Example_6_7_parallel_array_operations {

    public static void main(String[] args) {
        double[] imperative = imperativeInitialize(10);
        System.out.println(Arrays.toString(imperative));

        double[] parallel = parallelInitialize(10);
        System.out.println(Arrays.toString(parallel));

        System.out.println();
        int sum = IntStream.of(0,1,2,3,4,5,6,7,8,9).sum();
        System.out.println(sum);
        System.out.println(Arrays.toString(parallelPrefix(parallelInitialize(10))));
        System.out.println();

        for (int i = 1; i <= 10; i++) {
            double[] average = simpleMovingAverage(parallelInitialize(10), i);
            System.out.println(Arrays.toString(average));
        }
    }

    public static double[] imperativeInitialize(int size) {
        double[] values = new double[size];
        for (int i = 0; i < values.length; i++) {
            values[i] = i;
        }
        return values;
    }

    public static double[] parallelInitialize(int size) {
        double[] values = new double[size];
        Arrays.parallelSetAll(values, i -> i);
        return values;
    }

    public static double[] parallelPrefix(double[] values) {
        Arrays.parallelPrefix(values, Double::sum);
        return values;
    }

    public static double [] simpleMovingAverage(double[] values, int n) {
        double[] sums = Arrays.copyOf(values, values.length);
        Arrays.parallelPrefix(sums, Double::sum);
        int start = n - 1;
        return IntStream.range(start, sums.length)
                .mapToDouble(i -> {
                    double prefix = i == start ? 0 : sums[i - n];
                    return (sums[i] - prefix) / n;
                })
                .toArray();
    }
}
