package horstman.core.java.vol1.ch06;

public class ManagerCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        var original = new Manager("John Q. Public", 50000, 1999, 1, 1);
        original.setBonus(100_000);

        Manager copy = original.clone();
        copy.setBonus(150_000);

        System.out.println("original=" + original);
        System.out.println("copy=" + copy);
    }
}
