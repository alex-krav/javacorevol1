package horstman.core.java.vol1.ch09.JdkGenerics;

import java.util.ArrayList;
import java.util.List;

/**
 * L extends T
 * read/get: Object, raw List, List<?>, List<T>, List<? extends T>, List<? extends super-T> - at least T
 * write/set: List<T> - only T
 */
public class TypeExtendsTypeTest_6 {
    public static void main(String[] args) {
        List<Employee> employees1 = new ArrayList<>(); //-1-
        employees1.add(new Manager());

        List<?> employees2; //-2-

        /** class */
        TypeExtendsTypeClass_5<Employee> typeExtendsTypeClass = new TypeExtendsTypeClass_5<>();
        typeExtendsTypeClass.setEmployees(employees1);
        employees2 = typeExtendsTypeClass.getEmployees();
        System.out.println(employees2);

        /** generic method **/
        add(typeExtendsTypeClass, employees1);
        employees2 = get(typeExtendsTypeClass);
        System.out.println(employees2);
    }

    public static <T extends Employee> void add(TypeExtendsTypeClass_5<T> holder, List<T> list) {
        holder.setEmployees(list);
    }

    public static <T extends Employee> List<T> get(TypeExtendsTypeClass_5<T> holder) {
        return holder.getEmployees();
    }
}

class TypeExtendsTypeClass_5<T extends Employee> {
    private List<T> employees = new ArrayList<>();

    public List<T> getEmployees() {
        return employees;
    }

    public void setEmployees(List<T> employees) {
        this.employees = employees;
    }
}