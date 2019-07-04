package horstman.core.java.vol1.ch04;

/**
 * Java is always pass-by-value.
 * Unfortunately, when we pass the value of an object, we are passing the reference to it.
 * This is confusing to beginners.
 * NOTE: object references are passed by value
 */
public class PassByValue {
    public static void main(String[] args) {
        Person vasya = new Person("Vasya");
        modify(vasya);
        System.out.println(vasya.getName());
    }

    private static void modify(Person person) {
        // modified
        person.setName("modified by setter");

        // not modified
        person = new Person("modified by constructor");
        if (person.getName().equals("modified by constructor"))
            System.out.println("ok");
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
