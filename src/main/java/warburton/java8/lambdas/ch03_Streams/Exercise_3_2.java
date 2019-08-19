package warburton.java8.lambdas.ch03_Streams;

import org.junit.jupiter.api.Test;
import warburton.java8.lambdas.ch01_domain.Artist;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise_3_2 {

    public int totalMembers(List<Artist> artists) {
        int totalMembers = 0;
        for (Artist artist : artists) {
            Stream<Artist> members = artist.getMembers();
            totalMembers += members.count();
        }
        return totalMembers;
    }

    public long totalMembers1(List<Artist> artists) {
        return artists.stream()
                .flatMap(artist -> artist.getMembers())
                .count();
    }

    public int totalMembers2(List<Artist> artists) {
        return artists.stream()
                .map(artist -> artist.getMembers().count())
                .reduce(0L, (acc, x) -> acc +x)
                .intValue();
    }

    @Test
    public void testTotalMembers() {
        Artist artist1 = new Artist("Vasya", "Ukraine");
        Artist artist2 = new Artist("Kolya", "Ukraine");
        Artist artist3 = new Artist("Vanya", "Ukraine");
        Artist band = new Artist("The Band", asList(artist1, artist2, artist3), "Ukraine");
        int total = totalMembers(asList(band));
        long total1 = totalMembers1(asList(band));
        int total2 = totalMembers2(asList(band));

        assertEquals(3, total);
        assertEquals(3, total1);
        assertEquals(3, total2);
    }
}
