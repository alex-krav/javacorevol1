package horstman.core.java.vol1.ch09.JdkGenerics;

import java.util.ArrayList;
import java.util.List;

/**
 * T
 * read/get: Object, raw List, List<?>, List<T>, List<? extends T> - only T
 * write/set: List<T> - only T
 */
public class TypeTest_2 {
    public static void main(String[] args) {
        List<Employee> employees1 = new ArrayList<>(); //-1-
        employees1.add(new Manager());

        List<? extends Employee> employees2; //-2-

        /** class */
        TypeClass_2<Employee> typeClass = new TypeClass_2<>();
        typeClass.setEmployees(employees1);
        employees2 = typeClass.getEmployees();
        System.out.println(employees2);

        /** field **/
        TypeField_2 typeField = new TypeField_2();
        typeField.setEmployees(employees1);
        employees2 = typeField.getEmployees();
        System.out.println(employees2);

        /** generic method **/
        add(typeClass, employees1);
        employees2 = get(typeClass);
        System.out.println(employees2);
    }

    public static <T> void add(TypeClass_2<T> holder, List<T> list) {
        holder.setEmployees(list);
    }

    public static <T> List<T> get(TypeClass_2<T> holder) {
        return holder.getEmployees();
    }
}

class TypeClass_2<T> {
    private List<T> employees = new ArrayList<>();

    public List<T> getEmployees() {
        return employees;
    }

    public void setEmployees(List<T> employees) {
        this.employees = employees;
    }
}

class TypeField_2 {
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}