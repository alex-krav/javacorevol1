package horstman.core.java.vol1.ch08;

import java.util.ArrayList;
import java.util.List;

public class InheritanceRules {
    public static void main(String[] args) {
        List<Manager2> managers = new ArrayList<>();
//        List<Employee2> employees = managers;

        Manager2[] managerBuddies = new Manager2[2];
        Employee2[] employeeBuddies = managerBuddies;
//        employeeBuddies[0] = new Employee2();
//        Employee2 employeeBuddy = employeeBuddies[0];
//        System.out.println(employeeBuddy);

        var managerBuds = new Pair<Manager2>(new Manager2(), new Manager2());
        Pair rawBuds = managerBuds;
        rawBuds.setFirst("asdf");
        Pair rawBud = rawBuds;
        System.out.println(rawBud.getFirst());
    }
}

class Employee2 {

}

class Manager2 extends Employee2 {}

