package warburton.java8.lambdas.ch03_Streams;

import org.junit.jupiter.api.Test;
import warburton.java8.lambdas.ch01_domain.Track;

import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example_3_13_min {
    @Test
    public void testMin() {
        List<Track> tracks = asList(
                new Track("Bakai", 524),
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));
        Track shortestTrack = tracks.stream()
//                .min(Comparator.comparing(Track::getLength))
                .min(Comparator.comparing(track -> track.getLength()))
                .get();
        assertEquals(tracks.get(1), shortestTrack);
    }

    @Test
    public void testFor() {
        List<Track> tracks = asList(
                new Track("Bakai", 524),
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));

        Track shortestTrack = tracks.get(0);
        for (Track track : tracks) {
            if (track.getLength() < shortestTrack.getLength()) {
                shortestTrack = track;
            }
        }

        assertEquals(tracks.get(1), shortestTrack);
    }
}
