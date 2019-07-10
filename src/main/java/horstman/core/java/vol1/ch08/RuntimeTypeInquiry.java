package horstman.core.java.vol1.ch08;

import horstman.core.java.vol1.ch06.Employee;

public class RuntimeTypeInquiry {

    public static void main(String[] args) {
        Pair<String> a = new Pair<>();
//        if (a instanceof Pair<String>) {}
//        if (a instanceof Pair<T>) {}

        Pair<String> p = (Pair<String>) a;

        Pair<String> stringPair = new Pair<>();
        Pair<Employee> employeePair = new Pair<>();
        if (stringPair.getClass() == employeePair.getClass()) {
            System.out.println("Pair<String> == Pair<Employee>");
        }
    }
}
