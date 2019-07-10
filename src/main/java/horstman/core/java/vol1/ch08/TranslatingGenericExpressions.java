package horstman.core.java.vol1.ch08;

import horstman.core.java.vol1.ch06.Employee;

public class TranslatingGenericExpressions {
    public static void main(String[] args) {
        Pair<Employee> buddies = new Pair<>(
                new Employee("Vasya", 100, 2000, 1, 1),
                new Employee("Misha", 50, 1990, 2, 2)
        );
        Employee buddy = buddies.getFirst();
        System.out.println(buddy);
    }
}
