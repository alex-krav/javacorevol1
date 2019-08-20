package warburton.java8.lambdas.ch04_Libraries;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public class Example_4_1 {
    @Test
    public void test1() {
        Logger logger = LoggerFactory.getLogger(Example_4_1.class);
        if (logger.isDebugEnabled()) {
            logger.debug("Look at this: " + expensiveOperation());
        }
    }

    @Test
    public void test2() {
        Logger logger = LoggerFactory.getLogger(Example_4_1.class);
        debug(() -> "Look at this: " + expensiveOperation());
    }

    private String expensiveOperation() {
        try {
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "result";
    }

    private void debug(Supplier<String> message) {
        if (isDebugEnabled()) {
            debug(message.get());
        }
    }

    private void debug(String message) {

    }

    private boolean isDebugEnabled() {
        return true;
    }
}
