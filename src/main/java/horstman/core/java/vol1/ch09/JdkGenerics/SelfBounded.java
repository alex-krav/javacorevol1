package horstman.core.java.vol1.ch09.JdkGenerics;

class SelfBounded<T extends SelfBounded<T>> {
    T element;
    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }
    T get() { return element; }

    public static void main(String[] args) {
        A a = new A();
        A a1 = a.set(new A()).get();

        C c = new C();
        C c1 = (C) c.set(new C());
    }
}

class A extends SelfBounded<A> {}
class B extends SelfBounded<A> {} // Also OK

class C extends SelfBounded<C> {
    C setAndGet(C arg) { set(arg); return get(); }
}

class D {}
// Can't do this:
// class E extends SelfBounded<D> {}
// Compile error: Type parameter D is not within its bound

