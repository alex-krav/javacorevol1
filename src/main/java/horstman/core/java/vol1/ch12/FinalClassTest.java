package horstman.core.java.vol1.ch12;

public class FinalClassTest {
}

final class FinalClass {
   private final int num;

    public FinalClass(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}

/*class ChildOfFinalClass extends FinalClass {

    public ChildClass(int num) {
        super(num);
    }
}*/

class FinalMethods {
    private int num;

    public FinalMethods(int num) {
        this.num = num;
    }

    public final int getNum() {
        return num;
    }
}

class ChildOfFinalMethods extends FinalMethods {

    public ChildOfFinalMethods(int num) {
        super(num);
    }

    /*@Override
    public int getNum() {
        return 0;
    }*/
}