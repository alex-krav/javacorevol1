package horstman.core.java.vol1.ch07.cloning;

public class ToBeCloned implements Cloneable {

    private String name;

    public ToBeCloned(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "ToBeCloned{" +
                "name='" + name + '\'' +
                '}';
    }
}
