package horstman.core.java.vol1.ch08;

import java.lang.reflect.Array;
import java.util.function.IntFunction;

public class GenericArray {
    public static void main(String[] args) {
        String[] names2 = minmax2("Tom", "Dick", "Harry");
//        System.out.println(names[0]); // ClassCastException: Comparable -> String

        String[] names3 = minmax3(String[]::new, "Tom", "Dick", "Harry");
//        System.out.println(names3[0]); // ClassCastException: Comparable -> String

        String[] names4 = minmax4("Tom", "Dick", "Harry");
//        System.out.println(names4[0]); // ClassCastException: Comparable -> String
    }


    public static <T extends Comparable> T[] minmax1(T... a) {
//        T[] mm = new T[2];
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable> T[] minmax2(T... a)
    {
        var result = new Comparable[2]; // array of erased type

        return (T[]) result; // compiles with warning
    }

    public static <T extends Comparable> T[] minmax3(IntFunction<T[]> constr, T... a)
    {
        T[] result = constr.apply(2);
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable> T[] minmax4(T... a)
    {
        var result = (T[]) Array.newInstance(a.getClass().getComponentType(), 2);
        return result;
    }
}
