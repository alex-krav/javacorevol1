package warburton.java8.lambdas.ch04_Libraries;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class Example_4_5 {
    public static void main(String[] args) {
        overloadedMethod("abc");

        overloadedMethod((x,y) -> x + y);

        overloadedMethod((IntPredicate) x -> true);
    }

    private static void overloadedMethod(Object o) {
        System.out.println("Object");
    }

    private static void overloadedMethod(String s) {
        System.out.println("String");
    }

    private static void overloadedMethod(BinaryOperator<Integer> lambda) {
        System.out.println("BinaryOperator");
    }

    private static void overloadedMethod(IntegerBiFunction lambda) {
        System.out.println("IntegerBinaryOperator");
    }

    private static void overloadedMethod(Predicate<Integer> predicate) {
        System.out.println("Predicate");
    }

    private static void overloadedMethod(IntPredicate predicate) {
        System.out.println("IntPredicate");
    }
}

interface  IntegerBiFunction extends BinaryOperator<Integer> {

}

@FunctionalInterface
interface IntPredicate {
    boolean abstractMethod(int value);
//    boolean anotherAbstractMethod(int value);
}