package horstman.core.java.vol1.ch03;

public class JavaCharacter {
    public static void main(String[] args) {
        System.out.println(Character.toChars(0x10400));
        System.out.println(Integer.toHexString(Character.toCodePoint('\uD801', '\uDC00')));
        char[] chars = {'\uD801', '\uDC00'};
        System.out.println(Integer.toHexString(Character.codePointAt(chars, 0)));
        System.out.printf("Character %c is invalid.%n", 0x10400);
    }
}
