package horstman.core.java.vol1.ch09.JdkGenerics;

import java.util.ArrayList;
import java.util.List;

/**
 * ? super T
 * read/get: Object, raw List, List<?> - any T
 * write/set: List<T>, List<super-T> - at least T
 */
public class AnySuperTypeTest_7 {
    public static void main(String[] args) {
        List<Person> employees1 = new ArrayList<>(); //-1-
        employees1.add(new Manager());

        List<?> employees2; //-2-

        /** field **/
        AnySuperTypeField_7 anySuperTypeField = new AnySuperTypeField_7();
        anySuperTypeField.setEmployees(employees1);
        employees2 = anySuperTypeField.getEmployees();
        System.out.println(employees2);

        /** generic method **/
        add(anySuperTypeField, employees1);
        employees2 = get(anySuperTypeField);
        System.out.println(employees2);

        /** Pair **/
        Pair_5<? super Employee> pair = new Pair_5<>();
        pair.setFirst(new Manager());
        Object first = pair.getFirst();
    }

    public static void add(AnySuperTypeField_7 holder, List<? super Employee> list) {
        holder.setEmployees(list);
    }

    public static List<? super Employee> get(AnySuperTypeField_7 holder) {
        return holder.getEmployees();
    }
}

class AnySuperTypeField_7 {
    private List<? super Employee> employees = new ArrayList<>();

    public List<? super Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<? super Employee> employees) {
        this.employees = employees;
    }
}