package horstman.core.java.vol1.ch05;

import horstman.core.java.vol1.ch05.protectedPackage.Parent;

public class ChildOtherPackage extends Parent {

    public ChildOtherPackage(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return getProtectedName() + " " /*+ getDefaultAccessName()*/;
    }
}
