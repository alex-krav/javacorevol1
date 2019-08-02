package horstman.core.java.vol1.ch12;

public class ImmutableClassTest {
}

/**
 * final class
 * final fields
 *
 * parameterized constructor
 * getter methods for all fields
 * no setters
 */
final class ImmutableClass {
    private final int num = 0;

    public final int getNum() {
        return num;
    }
}
