package horstman.core.java.vol1.ch07;

import horstman.core.java.vol1.ch07.cloning.ToBeCloned;

public class ToBeClonedTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        ToBeCloned original = new ToBeCloned("Original");

        ToBeCloned copy = (ToBeCloned) original.clone();
        copy.setName("Copy");

        System.out.println(original);
        System.out.println(copy);
    }
}
