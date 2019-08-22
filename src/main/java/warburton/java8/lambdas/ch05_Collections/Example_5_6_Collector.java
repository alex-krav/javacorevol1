package warburton.java8.lambdas.ch05_Collections;

import org.junit.jupiter.api.Test;
import warburton.java8.lambdas.ch01_domain.Album;
import warburton.java8.lambdas.ch01_domain.Artist;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example_5_6_Collector {
    @Test
    public void testMaxBy() {

    }

    public Optional<Artist> biggestGroup(Stream<Artist> artists) {
        Function<Artist,Long> getCount = artist -> artist.getMembers().count();
        return artists.collect(Collectors.maxBy(Comparator.comparing(getCount)));
    }

    public double averageNumberOfTracks(List<Album> albums) {
        return albums.stream().collect(Collectors.averagingInt(album -> album.getTrackList().size()));
    }

    public Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artists) {
        return artists.collect(Collectors.partitioningBy(Artist::isSolo));
    }

    public Map<Artist, List<Album>> albumsByArtist(Stream<Album> albums) {
        return albums.collect(Collectors.groupingBy(Album::getMainMusician));
    }

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

    public String artistsToStringUsingStream(List<Artist> artists) {
        return artists.stream().map(Artist::getName).collect(Collectors.joining(", ", "[", "]"));
    }
}
