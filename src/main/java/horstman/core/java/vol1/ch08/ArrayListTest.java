package horstman.core.java.vol1.ch08;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        var list2 = new ArrayList<>();
        Object o = list2.get(0);
        var list3 = new ArrayList<String>();
        String s = list3.get(0);
        ArrayList<String> list4 = new ArrayList<>(){
            @Override
            public String get(int index) {
                return super.get(index);
            }
        };
    }
}
