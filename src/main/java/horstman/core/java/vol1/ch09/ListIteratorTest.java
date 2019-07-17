package horstman.core.java.vol1.ch09;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class ListIteratorTest {
    public static void main(String[] args) {
        var list = new LinkedList<>(Collections.singletonList("A"));
        var listIter = list.listIterator();
        System.out.println(listIter.previousIndex());

        listIter.next();
        System.out.println(listIter.nextIndex());
    }
}
