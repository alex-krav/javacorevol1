package horstman.core.java.vol1.ch09.JdkGenerics;

public class Student extends Person {
    public String getName() {
        return "Student";
    }

    @Override
    public String toString() {
        return getName();
    }
}
