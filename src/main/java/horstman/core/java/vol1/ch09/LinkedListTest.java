package horstman.core.java.vol1.ch09;

import java.util.*;

/**
 * This program demonstrates operations on linked lists.
 */
public class LinkedListTest {

    public static void main(String[] args) {
        var a = new LinkedList<String>();
//        a.add("Amy");
//        a.add("Carl");
//        a.add("Erica");
        a.addAll(Arrays.asList("Amy", "Carl", "Erica"));

        var b = new LinkedList<>(Arrays.asList("Bob", "Doug", "Frances", "Gloria"));

        // merge the words from b into a
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println(a);

        // remove every second word from b

        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next(); // skip one element
            if (bIter.hasNext()) {
                bIter.next(); // skip next element
                bIter.remove(); // remove that element
            }
        }

        System.out.println(b);

        // bulk operation: remove all words in b from a

        a.removeAll(b);

        System.out.println(a);
    }
}
