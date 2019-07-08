package horstman.core.java.vol1.ch05;

import java.util.ArrayList;
import java.util.List;

public class ALTest {
    public static void main(String[] args) {
        List list = new ArrayList(100);
        list.add(new Employee("Vasya Pupkin", 25000, 2000, 1, 2));
        list.add(new Manager("John Doe", 30000, 1990, 2, 3));
        list.add("asdf");

        Employee employee = (Employee) list.get(0);
        Manager manager = (Manager) list.get(1);
        String str = (String) list.get(2);

        System.out.println(list);
        System.out.println(employee.getName());
        System.out.println(manager.getName());
        System.out.println(str);
    }
}
