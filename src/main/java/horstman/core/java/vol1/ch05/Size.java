package horstman.core.java.vol1.ch05;

import java.util.Arrays;

public enum Size {
    SMALL("S"),
    MEDIUM("M"),
    LARGE("L"),
    EXTRA_LARGE("XL");

    private String abbreviation;

    Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}

class SizeEnumTest {
    public static void main(String[] args) {
        Size size = Size.SMALL;

        System.out.println("Enum? " + (size instanceof Enum));

        System.out.println("toString: " + size);
        System.out.println("name: " + size.name());
        System.out.println("ordinal: " + size.ordinal());

        System.out.println("Enum.valueOf: " + Enum.valueOf(Size.class, "SMALL"));
        System.out.println("Size.valueOf: " + Size.valueOf("MEDIUM"));
        System.out.println("values: " + Arrays.toString(Size.values()));
        System.out.println("compare: " + (size.compareTo(Size.EXTRA_LARGE)));
    }
}
