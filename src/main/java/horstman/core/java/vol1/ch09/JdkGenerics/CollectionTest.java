package horstman.core.java.vol1.ch09.JdkGenerics;

import java.util.ArrayList;
import java.util.List;

/**
 * + raw - add/get anything (w/o type) from list
 * + ? - contains(any type here)
 * todo: difference:
 * + T - add/get<T> and subclasses
 * + ? extends T - addAll<T> and subclasses
 */
public class CollectionTest {
    public static void main(String[] args) {
        System.out.println("*** raw ***");
        List rawList = new ArrayList();
        rawList.add(new Employee());
        rawList.add(new Manager());
        rawList.add(new Student());
        System.out.println(rawList);
        Manager manager = (Manager) rawList.get(1);
        System.out.println(manager);

        System.out.println("*** T ***");
        List<Employee> concreteList = new ArrayList<>();
        concreteList.add(new Employee());
        concreteList.add(new Manager());
//        concreteList.add(new Student());
//        concreteList.add(new Person());
        System.out.println(concreteList);
//        Student student = (Student) concreteList.get(1);

        System.out.println("*** ? ***");
        System.out.println(
            concreteList.containsAll(
                    List.of(new Person(), new Employee(), new Student(), new Manager())));
        System.out.println(
            concreteList.containsAll(
                    List.of(new Employee(), new Manager())));

        System.out.println("*** ? extends T ***");
        concreteList.addAll(List.of(new Employee(), new Manager()));
        System.out.println(concreteList);
    }

}
