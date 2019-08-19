package warburton.java8.lambdas.ch03_Streams;

import org.junit.jupiter.api.Test;
import warburton.java8.lambdas.ch01_domain.Album;
import warburton.java8.lambdas.ch01_domain.Artist;
import warburton.java8.lambdas.ch01_domain.Track;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuttingOperationsTogether {
    @Test
    public void testGetNationalities() {
        List<Track> tracks = asList(
                new Track("track 1", 300),
                new Track("track 2", 320),
                new Track("track 3", 310));
        List<Artist> artists = asList(
                new Artist("The band 1", "England"),
                new Artist("The band 2", "Italy"),
                new Artist("The band 3", "Turkey"));
        Album album = new Album("album 1", tracks, artists);

        Set<String> origins = album.getMusicians()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(artist -> artist.getNationality())
                .collect(Collectors.toSet());

        assertEquals(Set.of("England", "Italy", "Turkey"), origins);
    }
}
