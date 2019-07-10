package horstman.core.java.vol1.ch08;

import horstman.core.java.vol1.ch06.Employee;

import java.util.ArrayList;
import java.util.Collection;

public class VarargsWarnings {
//    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Collection<Pair<String>> table1 = new ArrayList<>();
        Pair<String> pair1 = new Pair<>();
        Pair<String> pair2 = new Pair<>();
        addAll(table1, pair1, pair2);

        Pair<String>[] table2 = array(pair1, pair2);
        Object[] objarray = table2;
        objarray[0] = new Pair<Employee>();
        @SuppressWarnings("unchecked")
        Pair<Employee> employee = (Pair<Employee>) objarray[0];
    }

    @SafeVarargs
    public static <T> void addAll(Collection<T> coll, T... ts) {
        for (T t : ts) coll.add(t);
    }

    @SafeVarargs static <E> E[] array(E... array) { return array; }
}
