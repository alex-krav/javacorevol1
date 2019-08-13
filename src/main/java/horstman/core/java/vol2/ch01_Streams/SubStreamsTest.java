package horstman.core.java.vol2.ch01_Streams;

import java.util.List;
import java.util.stream.Stream;

import static horstman.core.java.vol2.ch01_Streams.CreatingStreams.show;
import static horstman.core.java.vol2.ch01_Streams.FilterMapFlatMapTest.codePoints;

public class SubStreamsTest {
    public static void main(String[] args) {
        Stream<Double> randoms = Stream.generate(Math::random).limit(100);
        show("randoms", randoms);

        String line = "A stream transformation produces a stream whose elements are derived from those of another stream.";
        Stream<String> words = Stream.of(line.split(("\\PL+"))).skip(1);
        show("words", words);

        Stream<String> codePoints = codePoints(line);
        show("codePoints", codePoints);

        Stream<String> initialDigits = codePoints(line).takeWhile(
                s -> "0123456789".contains(s));
        show("initialDigits", initialDigits);

        Stream<String> s_t_r_e_a_m = codePoints(line).takeWhile(
                s -> "A stream".contains(s));
        show("s_t_r_e_a_m", s_t_r_e_a_m);

        Stream<String> withoutInitialWhitespace = codePoints(line).dropWhile(s -> s.trim().length() == 0);
        show("withoutInitialWhitespace", withoutInitialWhitespace);

        Stream<String> woAandSpace = codePoints(line).dropWhile(s -> "A ".contains(s));
        show("woAandSpace", woAandSpace);

        Stream<String> combined = Stream.concat(codePoints("Hello"), codePoints("World"));
        show("combined", combined);
    }
}
