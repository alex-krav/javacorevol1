package warburton.java8.lambdas.ch02_Lambdas;

import javax.swing.*;
import java.util.function.Predicate;

public class Exercise_2_3 {
    public static void main(String[] args) {
        //1
        Runnable helloWorld = () -> System.out.println("hello world");

        //2
        JButton button = new JButton();
        button.addActionListener(event -> {
            System.out.println(event.getActionCommand());
        });

        //3
        IntPred intPred1 = x -> x > 3;
//        check1(intPred1);
        check2(intPred1);
    }

    static boolean check1(Predicate<Integer> predicate) {
        return false;
    }

    static boolean check2(IntPred predicate) {
        return false;
    }

    interface IntPred {
        boolean test(Integer value);
    }
}
