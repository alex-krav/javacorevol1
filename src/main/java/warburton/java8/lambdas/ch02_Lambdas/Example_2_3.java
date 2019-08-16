package warburton.java8.lambdas.ch02_Lambdas;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

public class Example_2_3 {
    public static void main(String[] args) {
        // 1 - no args
        Runnable noArguments = () -> System.out.println("Hello World");

        // 2 - one arg
        ActionListener oneArgument = event -> System.out.println("button clicked");

        // 3 - block
        Runnable multiStatement = () -> {
            System.out.print("Hello");
            System.out.println(" World");
        };

        // 4 - two args
        //not result of adding, but function that adds two numbers
        BinaryOperator<Long> add1 = (x, y) -> x + y;
        BinaryOperator<Long> add2 = Long::sum;

        // 5 - explicit types
        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;


    }
}
