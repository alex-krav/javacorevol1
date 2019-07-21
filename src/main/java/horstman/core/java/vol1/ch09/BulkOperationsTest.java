package horstman.core.java.vol1.ch09;

import java.util.*;

public class BulkOperationsTest {
    public static void main(String[] args) {
        Map<String,String> staffMap = new HashMap<>();
        staffMap.put("a", "A");
        staffMap.put("b", "B");
        staffMap.put("c", "C");
        staffMap.put("d", "D");
        staffMap.put("e", "E");
        Set<String> termindatedIDs = Set.of("a","b");
        staffMap.keySet().removeAll(termindatedIDs);
        System.out.println(staffMap);

        List<String> staff = new ArrayList<>(List.of("a", "b", "c", "d", "e"));
        staff.subList(0,2).clear();
        System.out.println(staff);
    }
}
