package horstman.core.java.vol1.ch09.JdkGenerics;

import java.util.*;

/**
 * + ? extends T
 * - L extends T
 * - ? super Employee
 * - PECS
 *
 * - T extends List<T>
 *
 * - other found in Collections
 */
public class CollectionsTest {
    public static void main(String[] args) {
        /** Collections.binarySearch */
        int index = Collections.binarySearch(List.of(new Small()), new Medium(), new MediumComparator());
        System.out.println(index);

        /** MapEntryTest */
        Set<List<Small>> set = new HashSet<>();
        set.add(List.of(new Small()));
        MapEntryTest<Medium> entries = new MapEntryTest<>();
        entries.setEntries(set);

    }
}

class Large {
    private int size = 10;

    public int getSize() {
        return size;
    }
}
class Medium extends Large {
    private int size = 5;
}
class Small extends Medium {
    private int size = 1;
}

class LargeComparator implements Comparator<Large> {

    @Override
    public int compare(Large obj1, Large obj2) {
        return obj1.getSize() - obj2.getSize();
    }
}

class MediumComparator implements Comparator<Medium> {

    @Override
    public int compare(Medium obj1, Medium obj2) {
        return obj1.getSize() - obj2.getSize();
    }
}

class SmallComparator implements Comparator<Small> {

    @Override
    public int compare(Small obj1, Small obj2) {
        return obj1.getSize() - obj2.getSize();
    }
}

class MapEntryTest<K> {
    private Set<? extends List<? extends K>> entries = new HashSet<>();

    public Set<? extends List<? extends K>> getEntries() {
        return entries;
    }

    public void setEntries(Set<? extends List<? extends K>> entries) {
        this.entries = entries;
    }
}