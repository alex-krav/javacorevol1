package warburton.java8.lambdas.ch04_Libraries;

import org.junit.jupiter.api.Test;
import warburton.java8.lambdas.ch01_domain.Album;
import warburton.java8.lambdas.ch01_domain.Artist;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise_4_1 {
    @Test
    public void testPerformanceGetMusicians() {
        List<Artist> artists = asList(new Artist("Vasya", "England"), new Artist("Kolya", "Ireland"));
        Artist band = new Artist("The Band", artists, "UK");
        Album album = new Album("The Album", new ArrayList<>(), List.of(band));

        assertEquals(3, album.getAllMusicians().count());
    }

    @Test
    public void testArtists() {
        Artist vasya = new Artist("Vasya", "England");
        Artist kolya = new Artist("Kolya", "Ireland");
        Artists artists = new Artists(asList(vasya, kolya));
        assertTrue(artists.getArtistOptional(2).isEmpty());
        assertEquals(kolya, artists.getArtistOptional(1).get());
    }

    @Test
    public void testArtistName() {
        Artist vasya = new Artist("Vasya", "England");
        Artist kolya = new Artist("Kolya", "Ireland");
        Artists artists = new Artists(asList(vasya, kolya));
        assertEquals("unknown", artists.getArtistNameOptional(2));
        assertEquals("Kolya", artists.getArtistNameOptional(1));
    }
}

interface OverrideHashcodeEquals {
    /*default boolean equals(Object obj) {
        return true;
    }

    default int hashCode() {

    }*/
}