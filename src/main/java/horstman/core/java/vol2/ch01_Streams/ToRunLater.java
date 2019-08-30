package horstman.core.java.vol2.ch01_Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class ToRunLater {
    public static void main(String[] args) {
        /*Object[] powers = Stream.iterate(1.0, p -> p * 2)
                .limit(20)
                .peek(e -> System.out.println("Fetching " + e))
                .toArray();*/
        Stream stream2 = Stream.iterate(1.0, p -> p * 2)
                .limit(20)
                .peek(e -> System.out.println("Fetching " + e));
        Stream stream3 = Stream.iterate(1.0, p -> p * 2)
                .limit(20)
                .peek(e -> {
                    return;
                });
        Object[] powers2 = Stream.iterate(1.0, p -> p * 2)
                .limit(20)
                .peek(e -> {
                    return;
                })
                .toArray();

        ///////////////////////////////////////////////////////
//        <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
//        - what types allowed here?

        ////////////////////////////////////////////////////////
//        why not use Optional.map instead of Optional.flatMap
//        use Listing 1.3 optional/OptionalTest.java

        // Stream of null values - possible?

        ////////////////////////////////////////////////////////
//        Listing 1.4 collecting/CollectingResults.java

        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, String> languageNames = locales.collect(
                Collectors.toMap(
                        Locale::getDisplayLanguage,
                        loc -> loc.getDisplayLanguage(loc),
                        (existingValue, newValue) -> existingValue));
        System.out.println(languageNames);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryLanguageSets = locales.collect(
                Collectors.toMap(
                        Locale::getDisplayCountry,
                        l -> Collections.singleton(l.getDisplayLanguage()),
                        (a, b) -> { // Union of a and b
                            var union = new HashSet<String>(a);
                            union.addAll(b);
                            return union; }));
        System.out.println(countryLanguageSets);

//        Listing 1.5 collecting/CollectingIntoMaps.java

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryToLanguages = locales.collect(
                groupingBy(Locale::getDisplayCountry,
                        mapping(Locale::getDisplayLanguage,
                                toSet())));
        System.out.println(countryToLanguages);

//        Listing 1.6 collecting/DownstreamCollectors.java



    }
}
