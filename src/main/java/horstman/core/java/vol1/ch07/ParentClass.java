package horstman.core.java.vol1.ch07;

import java.io.IOException;

public class ParentClass {
    public void method1() throws IOException {}
    public void method2() throws Exception {}
    public void method3() throws Exception {}
    public void method4() {}
}

class ChildClass extends ParentClass {

    /*@Override
    public void method1() throws Exception {

    }*/

    @Override
    public void method2() throws IOException {}

    @Override
    public void method3() {}

    /*@Override
    public void method4() throws Exception {}*/
}
