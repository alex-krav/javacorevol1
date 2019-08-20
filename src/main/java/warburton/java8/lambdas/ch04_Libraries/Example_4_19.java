package warburton.java8.lambdas.ch04_Libraries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example_4_19 {
    @Test
    public void test() {
        Jukebox box = new MusicalCarriage();
        assertEquals("... from side to side", box.rock());
    }
}

interface Jukebox {
    default String rock() {
        return "... all over the world!";
    }
}

interface Carriage {
    default String rock() {
        return "... from side to side";
    }
}

class MusicalCarriage implements Carriage, Jukebox {
    @Override
    public String rock() {
        return Carriage.super.rock();
    }
}