package horstman.core.java.vol1.ch09.JdkGenerics;

public class Employee extends Person {
    public String getName() {
        return "Employee";
    }

    @Override
    public String toString() {
        return getName();
    }
}
