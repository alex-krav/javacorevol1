package horstman.core.java.vol1.ch08;

public class UnboundedWildcards {
    public static void main(String[] args) {
        Pair5<String> pair = new Pair5("asdf", null);
        System.out.println(hasNulls(pair));
    }

    public static boolean hasNulls(Pair5<?> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }
}
