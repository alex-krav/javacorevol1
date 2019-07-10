package horstman.core.java.vol1.ch08;

import java.util.function.Supplier;

public class InstantiateTypeVariables {
    public static void main(String[] args) {
        Pair3<String> p2 = Pair3.makePair(String::new);
        @SuppressWarnings("unchecked")

        Pair2<String> p1 = new Pair2();

        Pair3<String> p3 = Pair3.makePair(String.class);
    }
}

class Pair2<T> {
    private T first;
    private T second;

    public Pair2() {
//        first = new T();
//        second = new T();

//        first = T.class.getConstructor().newInstance();
    }
}

class Pair3<T> {
    private T first;
    private T second;

    public Pair3(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public static <T> Pair3<T> makePair(Supplier<T> constr) {
        return new Pair3<>(constr.get(), constr.get());
    }

    public static <T> Pair3<T> makePair(Class<T> cl) {
        try {
            return new Pair3<>(cl.getConstructor().newInstance(),
                    cl.getConstructor().newInstance());
        } catch (Exception e) {
            return null;
        }
    }
}