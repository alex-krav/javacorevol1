package horstman.core.java.vol1.ch08;

public class WildcardCapture {
    public static void main(String[] args) {
        var ceo = new Manager3("Gus Greedy", 800000, 2003, 12, 15);
        var cfo = new Manager3("Sid Sneaky", 600000, 2003, 12, 15);
        var buddies = new Pair5<>(ceo, cfo);
        printBuddies(buddies);

        ceo.setBonus(1000000);
        cfo.setBonus(500000);
        Manager3[] managers = {ceo, cfo};

        var result = new Pair5<Employee3>();
        minmaxBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName() + ", second: " + result.getSecond().getName());
        maxminBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName() + ", second: " + result.getSecond().getName());
    }

    public static void printBuddies(Pair5<? extends Employee3> p) {
        Employee3 first = p.getFirst();
        Employee3 second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }

    public static void minmaxBonus(Manager3[] a, Pair5<? super Manager3> result) {
        if (a.length == 0) return;
        Manager3 min = a[0];
        Manager3 max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.getBonus() > a[i].getBonus()) min = a[i];
            if (max.getBonus() < a[i].getBonus()) max = a[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxminBonus(Manager3[] a, Pair5<? super Manager3> result) {
        minmaxBonus(a, result);
        PairAlg.swapHelper(result); // OK--swapHelper captures wildcard type
    }
    // can't write public static <T super manager> . . .
}

class PairAlg {
    public static boolean hasNulls(Pair5<?> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(Pair5<?> p) {
        swapHelper(p);
    }

    public static <T> void swapHelper(Pair5<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}
