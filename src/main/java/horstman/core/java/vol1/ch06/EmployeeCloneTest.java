package horstman.core.java.vol1.ch06;

public class EmployeeCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        var original = new Employee("John Q. Public", 50000);
        original.setHireDay(2000, 1,1);

        Employee copy = original.clone();
        copy.raiseSalary(10);
        copy.setHireDay(2002, 2, 2);

        System.out.println("original=" + original);
        System.out.println("copy=" + copy);
    }
}
