package horstman.core.java.vol1.ch05.protectedPackage;

/**
 * Access:
 * - public - any class in any package
 * - protected - child class or any class in the same package
 * - default - any class in the same package
 * - private - that class only
 */
public class NonChild {
    public static void main(String[] args) {
        Parent parent = new Parent("Vasya");
        System.out.println("protected: " + parent.getProtectedName());
        System.out.println("default: " + parent.getDefaultAccessName());
    }
}
