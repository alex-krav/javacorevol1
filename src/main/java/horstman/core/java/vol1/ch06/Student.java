package horstman.core.java.vol1.ch06;

public class Student implements Person, Named, Talkable {

    public static void main(String[] args) {
        Student s = new Student();
        s.say();
    }

    @Override
    public String twoDefaultMethods() {
        return null;
    }

    @Override
    public String oneDefaultMethod() {
        return null;
    }

    @Override
    public String twoNonDefaultMethods() {
        return null;
    }
}

interface Person {
    default String twoDefaultMethods() {
        return "";
    }

    default String oneDefaultMethod() {
        return "";
    }

    String twoNonDefaultMethods();
}

interface Named {
    default String twoDefaultMethods() {
        return "";
    }

    String oneDefaultMethod();

    String twoNonDefaultMethods();
}

interface Talkable {
    default String say() {
        return "blah blah blah";
    }
}

