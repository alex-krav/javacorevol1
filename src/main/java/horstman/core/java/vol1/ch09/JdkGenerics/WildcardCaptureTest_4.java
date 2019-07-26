package horstman.core.java.vol1.ch09.JdkGenerics;

import java.util.ArrayList;
import java.util.List;

public class WildcardCaptureTest_4 {
    public static void main(String[] args) {
        List<Pair<?>> list1 = new ArrayList<>();
        list1.add(new Pair<>("first", "second"));
        list1.add(new Pair<>("one",2));

        for (Pair<?> pair : list1)
            PairAlg.swapHelper(pair);

        System.out.println(list1);

        List<Pair> list2 = new ArrayList();
        list2.add(new Pair("first", "second"));
        list2.add(new Pair("one",2));

        for (Pair pair : list2)
            PairAlg.swapHelper(pair);

        System.out.println(list2);

        // every ? can hold different T, but it has to be one type
//        PairAlg.cantCaptureListOfAny(list);
    }
}

class Pair<T> {
    private T first;
    private T second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T newValue) {
        first = newValue;
    }

    public void setSecond(T newValue) {
        second = newValue;
    }

    @Override
    public String toString() {
        return "Pair{" + first + ", " + second + '}';
    }
}

class PairAlg {
    public static boolean hasNull(Pair<?> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }

    // example method to demonstrate wildcapture by swapHelper()
    public static void swapAny(Pair<?> p) { // can't use Pair<T>, because Pair may hold different types for T
        swapHelper(p);
    }

    public static void swapRaw(Pair p) { // can't use Pair<T>, because Pair may hold different types for T
        swapHelper(p);
    }

    // todo: use to capture <?> and instantiate ? as var T
    public static <T> void swapHelper(Pair<T> p) {
        T t = p.getFirst(); // can't use: ? t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }

    public static <T> void cantCaptureListOfAny(List<Pair<T>> list) {
        Pair<T> first = list.get(0);
        list.set(0, list.get(1));
        list.set(1, first);
    }
}