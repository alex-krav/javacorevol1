package horstman.core.java.vol1.ch09.JdkGenerics;

public class NotSelfBounded<T> {
    T element;
    NotSelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }
    T get() { return element; }

    public static void main(String[] args) {
        A2 a = new A2();
        A2 a1 = a.set(new A2()).get(); // cannot set NotSelfBounded<A2> to A2

        E2 e = new E2();
//        E2 e1 = e.set(new E2()); // D2 expected

    }
}

class A2 extends NotSelfBounded<A2> {}
class B2 extends NotSelfBounded<A2> {}

class C2 extends NotSelfBounded<C2> {
    C2 setAndGet(C2 arg) { set(arg); return get(); }
}

class D2 {}
// Now this is OK:
class E2 extends NotSelfBounded<D2> {}