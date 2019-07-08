package horstman.core.java.vol1.ch05.protectedPackage;

public class Parent {
    private String name;

    public Parent(String name) {
        this.name = name;
    }

    protected String getProtectedName() {
        return name;
    }

    String getDefaultAccessName() {
        return name;
    }
}
