package horstman.core.java.vol1.ch09.JdkGenerics;

import java.util.ArrayList;
import java.util.List;

public class GenericsOutline {
    public static void main(String[] args) {
        System.out.println("*** ? ***");
        CollectionOfAnyType colAny = new CollectionOfAnyType();
        colAny.setElements(List.of("a", "b", "c"));
        List<Double> anyElements1 = (List<Double>) colAny.getElements();
        List anyElements2 = colAny.getElements();
        System.out.println(anyElements1);
        System.out.println(anyElements2);

        System.out.println("*** raw ***");
        RawCollection colRaw = new RawCollection();
        colRaw.setElements(List.of("a", "b", "c"));
        List rawElements = colRaw.getElements();
        System.out.println(rawElements);

        System.out.println("*** T ***");
        CollectionOfSpecific colSpec = new CollectionOfSpecific();
        colSpec.setEmployees(List.of(new Employee(), new Manager()));
        List<Employee> employees1 = colSpec.getEmployees();
//        List<Person> employees2 = colSpec.getEmployees();
        Manager manager = (Manager) colSpec.getEmployees().get(1);
        System.out.println(employees1);
        System.out.println(manager);

        System.out.println("*** ? extends T ***");
        CollectionAnyExtends colAnyExt = new CollectionAnyExtends();
        var employees10 = new ArrayList<Manager>();
        employees10.add(new Manager());
        employees10.add(new Manager());
//        colAnyExt.setEmployees(List.of(new Employee(), new Manager()));
        colAnyExt.setEmployees(employees10);
        List<? extends Employee> employees3 = colAnyExt.getEmployees();
        List<Employee> employees4 = (List<Employee>) colAnyExt.getEmployees();
        List<Manager> employees5 = (List<Manager>) colAnyExt.getEmployees();
        Manager manager1 = (Manager) colAnyExt.getEmployees().get(1);
        System.out.println(employees3);
        System.out.println(employees4);
        System.out.println(employees5);
        System.out.println(manager1);

        System.out.println("*** L extends T *** (generic class)");
        CollectionTypeExtends1 colTypeExt1 = new CollectionTypeExtends1();
        colTypeExt1.setEmployees(List.of("asdf"));
        List<String> persons1 = colTypeExt1.getEmployees();
        System.out.println(persons1);

        System.out.println("*** L extends T *** (generic method)");
        CollectionTypeExtends2 colTypeExt2 = new CollectionTypeExtends2();
        colTypeExt2.setEmployees(List.of(new Manager()));
        List<Manager> persons2 = colTypeExt2.getEmployees();
        System.out.println(persons2);

        System.out.println("*** ? super T ***");
        CollectionAnySuper colAnySuper = new CollectionAnySuper();
        colAnySuper.setEmployees(List.of(new Manager()));
        List<Employee> employees6 = (List<Employee>) colAnySuper.getEmployees();
        System.out.println(employees6);

    }
}

class RawCollection {
    public List getElements() {
        return elements;
    }

    public void setElements(List elements) {
        this.elements = elements;
    }

    private List elements = new ArrayList<>();
}

/** ? */
class CollectionOfAnyType {
    private List<?> elements = new ArrayList<>();

    public List<?> getElements() {
        return elements;
    }

    public void setElements(List<?> elements) {
        this.elements = elements;
    }

    // syntax error
    /*public ? get(int index) {
        return elements(index);
    }

    public void set(? object) {

    }*/
}

class CollectionOfSpecific {
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

class CollectionAnyExtends {
    private List<? extends Employee> employees = new ArrayList<>();

    public List<? extends Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<? extends Employee> employees) {
        this.employees = employees;
    }
}

class CollectionTypeExtends1<T extends Employee> {
    private List<T> employees = new ArrayList<>();

    public List<T> getEmployees() {
        return employees;
    }

    public void setEmployees(List<T> employees) {
        this.employees = employees;
    }
}

class CollectionTypeExtends2 {
    private List employees = new ArrayList();

    public <T extends Employee> void setEmployees(List<T> employees) {
        this.employees = employees;
    }

    public <T extends Employee> List<T> getEmployees() {
        return employees;
    }
}

class CollectionAnySuper {
    private List<? super Employee> employees = new ArrayList<>();

    public List<? super Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<? super Employee> employees) {
        this.employees = employees;
    }
}

/** impossible <T super Employee>
class CollectionTypeSuper {
    private List employees = new ArrayList();

    public <T super Employee> void setEmployees(List<T> employees) {
        this.employees = employees;
    }

    public <T super Employee> List<T> getEmployees() {
        return employees;
    }
}*/
