package horstman.core.java.vol1.ch05;

/**
 * + primitive can be cast to Object (autoboxing, int -> Integer -> Object)
 *
 * + Object[] or Object can't be cast to Employee[] or Employee
 * + Employee[] can be cast to Object[] or Object
 * + primitive[] can't be cast to Object[]
 */
public class ObjectCastTest {
    public static void main(String[] args) {
        System.out.println("--------- Employee[] to Object[] --------");
        // to Object[] - Employee[], int[], Comparable[]
        Employee[] employees = new Employee[10];
        int[] ints = new int[10]; // todo: can't cast primitive[] to Object[]
        Integer[] integers = new Integer[10];

        Object[] empObj = employees;
        System.out.println(empObj[0]);

//        Object[] intObj = (Object[]) ints;
//        System.out.println(intObj[0]);

        Object[] integerObj = integers;
        System.out.println(integerObj[0]);

        System.out.println("-------- Employee[] to Object ---------");
        // to Object - Employee[], int[], Comparable[]
        Object empO = employees;
        System.out.println(((Employee[])empO)[0]);

        Object intO = ints;
        System.out.println(((int[])intO)[0]);

        Object integerO = integers;
        System.out.println(((Integer[])integerO)[0]);

        System.out.println("-------- Object[] to Employee[] ---------");
        Object[] objects = new Object[10];
//        Employee[] e2 = (Employee[]) objects;
//        System.out.println(e2[0].getName());
        System.out.println(objects);

        System.out.println("--------- Object to Employee --------");
        Object obj = new Object();
//        Employee e3 = (Employee) obj;
        System.out.println(obj);

        System.out.println("--------- primitive to Object--------");
        int four = 4;
        Object omg = four;
        System.out.println(omg);
    }
}
