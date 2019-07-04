package horstman.core.java.vol1.ch03;

public class Unicode {
    public static void main(String[] args) {
        // look inside c:/users
        // /u000A is a newline
    }

    /*
    https://stackoverflow.com/questions/27331819
    https://stackoverflow.com/questions/23979676
    https://en.wikipedia.org/wiki/Character_encoding#Terminology
    https://docs.oracle.com/javase/tutorial/i18n/text/terminology.html
    https://www.youtube.com/watch?v=tA3RXB2a8xI
    https://www.javaspecialists.eu/archive/Issue209.html
    https://www.javaspecialists.eu/archive/Issue211.html

    WRITING
    - text - collection of characters
    - character - individual unit of text composed of one or more graphemes
    - grapheme -

    UNICODE
    - font - collection of glyphs
    - glyph - image used to represent graphemes (a) or parts (a + .. = ä)
    - grapheme - sequence of one or more code points that are displayed as single graphical unit, that a reader recognizes as a single element of the writing system. eg, a, ä. ä may be one (legacy) or two code points. some code points are never part of any grapheme (&zwnj;)
    - code point - number that identifies a symbol. Standards for assigning numbers to symbols:
        ASCII - one byte per number
        Unicode - UTF-8 (8 bits), UTF-16, UTF-32

    - code unit - unit of storage representing a full code point or part. eg, snowman glyph (☃) is a single code point, but 3 UTF-8 code units (8 bits) or 1 UTF-16 code unit (16 bits).

    JAVA


     */
}
