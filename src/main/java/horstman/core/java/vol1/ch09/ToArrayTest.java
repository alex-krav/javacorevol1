package horstman.core.java.vol1.ch09;

import java.util.ArrayList;
import java.util.List;

public class ToArrayTest {
    public static void main(String[] args) {
        List<String> staff = new ArrayList<>(List.of("a", "b", "c", "d", "e"));
//        String[] staffArray = (String[]) staff.toArray();
//        if (staffArray[0] instanceof String) System.out.println(staffArray[0]);

        String[] strings1 = staff.toArray(new String[0]);
        if (strings1[0] instanceof String) System.out.println(strings1[0]);

        String[] strings2 = staff.toArray(new String[staff.size()]);
        if (strings2[0] instanceof String) System.out.println(strings2[0]);
    }
}
