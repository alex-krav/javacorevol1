package horstman.core.java.vol1.ch05;

public class EmployeeManagerArray {
    public static void main(String[] args) {
        // runtime ArrayStoreException
//        Manager[] managers = new Manager[10];
//        Employee[] staff = managers; // OK
//        staff[0] = new Employee("Harry Hacker", 100000, 1989, 5, 12);

        // compile error
//        Employee[] staff = new Employee[10];
//        Manager[] managers = staff;
    }
}
