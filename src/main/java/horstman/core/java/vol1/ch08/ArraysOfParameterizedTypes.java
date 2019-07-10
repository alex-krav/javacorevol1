package horstman.core.java.vol1.ch08;

import horstman.core.java.vol1.ch06.Employee;

public class ArraysOfParameterizedTypes {
    public static void main(String[] args) {
//        Pair<String>[] table1 = new Pair<String>[10];
        Pair<String>[] table2;
        @SuppressWarnings("unchecked")
        var table3 = (Pair<String>[]) new Pair<?>[10];
//        table3[0] = new Pair<Employee>();
        table3[0] = new Pair<String>();

    }
}
