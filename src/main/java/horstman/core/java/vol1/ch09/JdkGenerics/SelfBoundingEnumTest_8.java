package horstman.core.java.vol1.ch09.JdkGenerics;

/**
 * self-bounded
 */
public class SelfBoundingEnumTest_8 {
    public static void main(String[] args) {

    }
}

/**
 * compiler gurantess that T is of the same type as class,
 * so that you can add special functionality in methods for that type
 */
class SelfBounded_8<T extends SelfBounded_8<T>> implements Comparable<T> {
    T element; // holds all fields and methods of class
    int specialParam;

    public SelfBounded_8(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public int getSpecialParam() {
        return specialParam;
    }

    public void setSpecialParam(int specialParam) {
        this.specialParam = specialParam;
    }

    @Override
    public int compareTo(T other) {
        return element.specialParam - other.specialParam;
    }
}

class NotSelfBounded_8<T> implements Comparable<T> {
    T element; // hold methods of Object
    int specialParam;

    public NotSelfBounded_8(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public int getSpecialParam() {
        return specialParam;
    }

    public void setSpecialParam(int specialParam) {
        this.specialParam = specialParam;
    }

    @Override
    public int compareTo(T other) {
//        return element.specialParam - other.specialParam;
        return 0;
    }
}



