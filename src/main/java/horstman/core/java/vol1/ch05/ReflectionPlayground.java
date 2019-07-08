package horstman.core.java.vol1.ch05;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class ReflectionPlayground {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Employee e = new Employee("Name Surname", 50000, 2000, 1, 2);
        Class eCl = e.getClass();
        System.out.println(eCl.getName() + " " + e.getName());
        System.out.println(eCl.getSimpleName() + " " + e.getName());

        var generator = new Random();
        Class gCl = generator.getClass();
        String name = gCl.getName();
        System.out.println(name);

        Class rCl = Class.forName(name);
        System.out.println(rCl.getName());

        Class cl1 = Random.class;
        Class cl2 = int.class;
        Class cl3 = int[].class;
        Class cl4 = Double[].class;
        System.out.println();
        System.out.println(cl1);
        System.out.println(cl2);
        System.out.println(cl3);
        System.out.println(cl4);

        Random random = (Random) cl1.getConstructor().newInstance();
        System.out.println();
        System.out.println(random.nextInt());

    }
}
