package horstman.core.java.vol1.ch05.protectedPackage;

public class ChildSamePackage extends Parent {

    public ChildSamePackage(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return getProtectedName() + " " + getDefaultAccessName();
    }
}
