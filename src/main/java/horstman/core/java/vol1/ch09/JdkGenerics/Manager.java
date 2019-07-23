package horstman.core.java.vol1.ch09.JdkGenerics;

public class Manager extends Employee {
    @Override
    public String getName() {
        return "Manager";
    }

    @Override
    public String toString() {
        return getName();
    }
}
