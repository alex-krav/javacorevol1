package horstman.core.java.vol1.ch09.JdkGenerics;

import java.util.ArrayList;
import java.util.List;

/**
 * ? extends T
 * read/get: Object, raw List, List<?>, List<? extends T>, List<? extends super-T> - at least T
 * write/set: List<T>, List<sub-T> - T and sub
 */
public class AnyExtendsTypeTest_5 {
    public static void main(String[] args) {
        List<Manager> employees1 = new ArrayList<>(); //-1-
        employees1.add(new Manager());

        List<?> employees2; //-2-

        /** field **/
        AnyExtendsField_5 anyExtendsField = new AnyExtendsField_5();
        anyExtendsField.setEmployees(employees1);
        employees2 = anyExtendsField.getEmployees();
        System.out.println(employees2);

        /** generic method **/
        add(anyExtendsField, employees1);
        employees2 = get(anyExtendsField);
        System.out.println(employees2);

        /** Pair **/

    }

    public static void add(AnyExtendsField_5 holder, List<? extends Employee> list) {
        holder.setEmployees(list);
    }

    public static List<? extends Employee> get(AnyExtendsField_5 holder) {
        return holder.getEmployees();
    }
}

class AnyExtendsField_5 {
    private List<? extends Employee> employees = new ArrayList<>();

    public List<? extends Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<? extends Employee> employees) {
        this.employees = employees;
    }
}

class Pair_5<T> {
    T first;
    T second;

    public Pair_5() {}

    public Pair_5(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public static void main(String[] args) {
        Pair_5<? extends Employee> pair = new Pair_5<>();
//        pair.setFirst(new Person());
        Person first = pair.getFirst();
    }
}