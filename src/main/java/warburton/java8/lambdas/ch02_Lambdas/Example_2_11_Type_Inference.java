package warburton.java8.lambdas.ch02_Lambdas;

import java.io.UnsupportedEncodingException;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class Example_2_11_Type_Inference {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Predicate<Integer> atLeast5 = x -> x > 5;

        BinaryOperator<Long> addLongs1 = (x, y) -> x + y;
        BinaryOperator<Long> addLongs2= Long::sum;
//        BinaryOperator addLongs3= (x, y) -> x + y; //&#x002B;

        /***********************************************/
        /*Charset utf8 = StandardCharsets.UTF_8;
        Charset def = Charset.defaultCharset();

        String charToPrint = "&#x002B";

        byte[] bytes = charToPrint.getBytes(StandardCharsets.UTF_8);
        String message = new String(bytes , def.name());

        PrintStream printStream = new PrintStream(System.out, true, utf8.name());
        printStream.println(message); // should print your character*/
    }
}
