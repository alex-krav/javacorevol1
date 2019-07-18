package horstman.core.java.vol1.ch09;

import java.util.ArrayList;
import java.util.Arrays;

public class SubrangesTest {
    public static void main(String[] args) {
        var staff = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g"));
        var group = staff.subList(3,5);
        group.clear();
        System.out.println(staff);
    }
}
