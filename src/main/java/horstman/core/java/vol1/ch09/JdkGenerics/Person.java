package horstman.core.java.vol1.ch09.JdkGenerics;

public class Person {
    public String getName() {
        return "Person";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Person)) return false;
        Person other = (Person) obj;
        return other.getName().equals(getName());
    }

    @Override
    public String toString() {
        return getName();
    }
}
