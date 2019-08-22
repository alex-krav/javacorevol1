package warburton.java8.lambdas.ch05_Collections;

import warburton.java8.lambdas.ch01_domain.Artist;

import java.lang.invoke.StringConcatException;
import java.util.List;

public class Example_5_17_Custom_Collectors {

    public String artistsToString(List<Artist> artists) {
        StringBuilder builder = new StringBuilder("[");
        for (Artist artist : artists) {
            if (builder.length() > 1)
                builder.append(", ");
            String name = artist.getName();
            builder.append(name);
        }
        builder.append("]");
        return builder.toString();
    }

    public String artistsToString1(List<Artist> artists) {
        StringBuilder builder = new StringBuilder("[");
        artists.stream()
            .map(Artist::getName)
            .forEach(
                name -> {
                    if (builder.length() > 1)
                        builder.append(", ");
                    builder.append(name);
                }
            );
        builder.append("]");
        return builder.toString();
    }

    public String artistsToString2(List<Artist> artists) {
        StringBuilder reduced =
            artists.stream()
            .map(Artist::getName)
            .reduce(new StringBuilder(), (builder, name) -> {
                if (builder.length() > 0)
                    builder.append(", ");
                builder.append(name);
                return builder;
            }, (left, right) -> left.append(right)); // StringBuilder::append
        reduced.insert(0, "[");
        reduced.append("]");
        return reduced.toString();
    }

    public String artistsToString3(List<Artist> artists) {
        StringCombiner combined =
            artists.stream()
            .map(Artist::getName)
            .reduce(new StringCombiner(", ", "[", "]"),
                StringCombiner::add,
                StringCombiner::merge);
        return combined.toString();
    }

    public String artistsToString4(List<Artist> artists) {
        return artists.stream()
            .map(Artist::getName)
            .reduce(new StringCombiner(", ", "[", "]"),
                StringCombiner::add,
                StringCombiner::merge)
            .toString();
    }

    public String artistsToString5(List<Artist> artists) {
        return artists.stream()
            .map(Artist::getName)
            .collect(new StringCollector(", ", "[", "]"));
    }
}
