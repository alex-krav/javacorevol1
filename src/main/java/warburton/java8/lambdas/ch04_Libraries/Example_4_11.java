package warburton.java8.lambdas.ch04_Libraries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example_4_11 {
    @Test
    public void parentDefaultUsed() {
        Parent parent = new ParentImpl();
        parent.welcome();
        assertEquals("Parent: Hi!", parent.getLastMessage());
    }
    @Test
    public void childOverrideDefault() {
        Child child = new ChildImpl();
        child.welcome();
        assertEquals("Child: Hi!", child.getLastMessage());
    }
    @Test
    public void concreteBeatsDefault() {
        Parent parent = new OverridingParent();
        parent.welcome();
        assertEquals("Class Parent: Hi!", parent.getLastMessage());
    }
    @Test
    public void concreteBeatsCloserDefault() {
        Child child = new OverridingChild();
        child.welcome();
        assertEquals("Class Parent: Hi!", child.getLastMessage());
    }
}

interface Parent {
    void message(String body);

    default void welcome() {
        message("Parent: Hi!");
    }

    String getLastMessage();
}

interface Child extends Parent {
    @Override
    default void welcome() {
        message("Child: Hi!");
    }
}

class ParentImpl implements Parent {
    private String lastMsg;

    @Override
    public void message(String body) {
        lastMsg = body;
        System.out.println(body);
    }

    @Override
    public String getLastMessage() {
        return lastMsg;
    }
}

class OverridingParent extends ParentImpl {
    @Override
    public void welcome() {
        message("Class Parent: Hi!");
    }
}

class ChildImpl implements Child {
    private String lastMsg;

    @Override
    public void message(String body) {
        lastMsg = body;
        System.out.println(body);
    }

    @Override
    public String getLastMessage() {
        return lastMsg;
    }
}

class OverridingChild extends OverridingParent implements Child {

}