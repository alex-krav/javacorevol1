package horstman.core.java.vol1.ch09;

import horstman.core.java.vol1.ch08.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CheckedViewsTest {
    public static void main(String[] args) {
        var strings = new ArrayList<String>();
        ArrayList rawList = strings; // warning only, not an error, for compatibility with legacy code
        rawList.add(new Date()); // now strings contains a Date object!
//        var date = strings.get(0); // ClassCastException
//        System.out.println(date);

        List<String> safeStrings = Collections.checkedList(strings, String.class);
        List rawList2 = safeStrings;
//        rawList2.add(new Date()); //ClassCastException
        rawList2.add(null);

//        List<String> safeStrings2 = Collections.checkedList(strings, Pair<String>.class);
    }
}
