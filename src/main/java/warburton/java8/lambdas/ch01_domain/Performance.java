package warburton.java8.lambdas.ch01_domain;


import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

public interface Performance {

    public String getName();

    public Stream<Artist> getMusicians();

    // TODO: test
    public default Stream<Artist> getAllMusicians() {
        return getMusicians().flatMap(artist -> concat(Stream.of(artist), artist.getMembers()));
    }

}