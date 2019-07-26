package horstman.core.java.vol1.ch09.JdkGenerics;

import java.util.ArrayList;
import java.util.List;

/**
 * RAW
 * read/get: any T
 * write/set: any T
 */
public class RawTest_1 {
    public static void main(String[] args) {
        List<Employee> employees1 = new ArrayList<>(); //-1-
        employees1.add(new Employee());

        List<? extends Employee> employees2; //-2-

        /** class */
        RawClass_1 rawClass = new RawClass_1();
        rawClass.setEmployees(employees1);
        employees2 = rawClass.getEmployees();
        System.out.println(employees2);

        /** generic method **/
        add(rawClass, employees1);
        employees2 = get(rawClass);
        System.out.println(employees2);

        /** Pair **/
        Pair_5<?> pair = new Pair_5<>();
//        pair.setFirst(new Employee());
        Object first = pair.getFirst();
    }

    public static void add(RawClass_1 holder, List list) {
        holder.setEmployees(list);
    }

    public static List get(RawClass_1 holder) {
        return holder.getEmployees();
    }
}

class RawClass_1 {
    private List employees = new ArrayList();

    public List getEmployees() {
        return employees;
    }

    public void setEmployees(List employees) {
        this.employees = employees;
    }
}