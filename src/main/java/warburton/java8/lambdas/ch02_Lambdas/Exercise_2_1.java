package warburton.java8.lambdas.ch02_Lambdas;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;

public class Exercise_2_1 {
    public static void main(String[] args) {
        ThreadLocal<DateFormatter> threadSafeDateFormatter1 = ThreadLocal.withInitial(DateFormatter::new);
        ThreadLocal<DateFormatter> threadSafeDateFormatter2 = ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));
    }
}
