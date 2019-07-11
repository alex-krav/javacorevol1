package horstman.core.java.vol1.ch08;

public class ClashesAfterErasure {
    public static void main(String[] args) {

    }
}

class Pair4<T> {
    private T first;
    private T second;

    public Pair4(T first, T second) {
        this.first = first;
        this.second = second;
    }

    /*public boolean equals(T value) {
        return first.equals(value) && second.equals(value);
    }*/
}

class Employee implements Comparable<Employee> {
    @Override
    public int compareTo(Employee o) {
        return 0;
    }
}

/*class Manager extends Employee implements Comparable<Manager> {

}*/

class Employee1 implements Comparable {
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

class Manager1 extends Employee1 implements Comparable {

}