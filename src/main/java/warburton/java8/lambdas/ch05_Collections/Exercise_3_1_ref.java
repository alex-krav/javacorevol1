package warburton.java8.lambdas.ch05_Collections;

import org.junit.jupiter.api.Test;
import warburton.java8.lambdas.ch01_domain.Album;
import warburton.java8.lambdas.ch01_domain.Artist;
import warburton.java8.lambdas.ch01_domain.Track;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise_3_1_ref {
    public static void main(String[] args) {

    }

    public int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (acc, num) -> acc + num);
    }

    public List<String> namesAndOrigins1(List<Artist> artists) {
        return artists
                .stream()
                .map(artist ->
                        artist.getName()
                                + " "
                                + artist.getNationality())
                .collect(Collectors.toList());
    }

    public List<String> namesAndOrigins2(List<Artist> artists) {
        return artists
                .stream()
                .flatMap(artist -> Stream.of(artist.getName(), artist.getNationality()))
                .collect(Collectors.toList());
    }

    public List<Album> atMostThreeTracksAlbums(List<Album> albums) {
        return albums.stream()
                .filter(album -> album.getTrackList().size() <= 3)
                .collect(Collectors.toList());
    }

    @Test
    public void testAddUp() {
        int res = addUp(Stream.of(1,2,3));
        assertEquals(6, res);
    }

    @Test
    public void testNamesAndOrigins1() {
        List<Artist> artists = asList(
                new Artist("The band 1", "England"),
                new Artist("The band 2", "Italy"),
                new Artist("The band 3", "Turkey"));
//        assertEquals("", namesAndOrigins1(artists));
        assertEquals("", namesAndOrigins2(artists));
    }

    @Test
    public void testAtMostThree() {
        List<Track> tracks1 = asList(
                new Track("track 1", 300));
        List<Track> tracks2 = asList(
                new Track("track 1", 300),
                new Track("track 2", 310));
        List<Track> tracks3 = asList(
                new Track("track 1", 300),
                new Track("track 2", 320),
                new Track("track 3", 310));
        List<Track> tracks4 = asList(
                new Track("track 1", 300),
                new Track("track 2", 320),
                new Track("track 3", 310),
                new Track("track 4", 310));

        List<Artist> artists = asList(
                new Artist("The band 1", "England"),
                new Artist("The band 2", "Italy"),
                new Artist("The band 3", "Turkey"));

        Album album1 = new Album("album 1", tracks1, artists);
        Album album2 = new Album("album 2", tracks2, artists);
        Album album3 = new Album("album 3", tracks3, artists);
        Album album4 = new Album("album 4", tracks4, artists);

        List<Album> albums = asList(album1, album2, album3, album4);
        List<Album> atMostThree = atMostThreeTracksAlbums(albums);

        assertEquals(3, atMostThree.size());
        assertEquals(List.of(album1, album2, album3), atMostThree);
    }
}
