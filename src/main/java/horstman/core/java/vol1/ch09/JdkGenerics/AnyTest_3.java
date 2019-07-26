package horstman.core.java.vol1.ch09.JdkGenerics;

import java.util.ArrayList;
import java.util.List;

/**
 * ?
 * read/get: Object, raw List, List<?> - any T
 * write/set: any List<T> - any T
 */
public class AnyTest_3 {
    public static void main(String[] args) {
        List<Manager> employees1 = new ArrayList<>(); //-1-
        employees1.add(new Manager());

        List<?> employees2; //-2-

        /** field **/
        AnyField_3 anyField = new AnyField_3();
        anyField.setEmployees(employees1);
        employees2 = anyField.getEmployees();
        System.out.println(employees2);

        /** generic method **/
        add(anyField, employees1);
        employees2 = get(anyField);
        System.out.println(employees2);
    }

    public static void add(AnyField_3 holder, List<?> list) {
        holder.setEmployees(list);
    }

    public static List<?> get(AnyField_3 holder) {
        return holder.getEmployees();
    }
}

class AnyField_3 {
    private List<?> employees = new ArrayList<>();

    public List<?> getEmployees() {
        return employees;
    }

    public void setEmployees(List<?> employees) {
        this.employees = employees;
    }
}