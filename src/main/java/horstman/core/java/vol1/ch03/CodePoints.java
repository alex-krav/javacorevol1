package horstman.core.java.vol1.ch03;

import java.util.Arrays;

public class CodePoints {
    public static void main(String[] args) {
        String s1 = "Hello";
        int cuCount1 = s1.length();
        System.out.println("Hello - code units: " + cuCount1);

        String s2 = String.valueOf(Character.toChars(0x10400));
        int cuCount2 = s2.length();
        System.out.println("\uD801\uDC00 - code units: " + cuCount2);

        int cpCount1 = s1.codePointCount(0, s1.length());
        System.out.println("Hello - code points: " + cpCount1);

        int cpCount2 = s2.codePointCount(0, s2.length());
        System.out.println("\uD801\uDC00 - code points: " + cpCount2);

        int index = s1.offsetByCodePoints(0, 1);
        int cp = s1.codePointAt(index);
        String s = String.valueOf(Character.toChars(cp));
        System.out.println(String.format("\nString: %s, cp: %d", s, cp));

        System.out.println(String.format("String: %s, [0] supplementary: %b, surrogate: %b", s2,
                Character.isSupplementaryCodePoint(s2.codePointAt(0)),
                Character.isSurrogate(s2.charAt(0))));

        System.out.println(String.format("String: %s, [1] supplementary: %b, surrogate: %b", s2,
                Character.isSupplementaryCodePoint(s2.codePointAt(1)),
                Character.isSurrogate(s2.charAt(1))));

        int[] codePoints = s2.codePoints().toArray();
        String str = new String(codePoints, 0, codePoints.length);
        System.out.println(str + ": " + Arrays.toString(codePoints));
    }
}
