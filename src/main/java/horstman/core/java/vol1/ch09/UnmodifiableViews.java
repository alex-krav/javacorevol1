package horstman.core.java.vol1.ch09;

import java.util.Collections;
import java.util.LinkedList;

public class UnmodifiableViews {
    public static void main(String[] args) {
        var staff = new LinkedList<String>();
        var view = Collections.unmodifiableList(staff);
//        view.add("a"); //UnsupportedOperationException
    }
}
