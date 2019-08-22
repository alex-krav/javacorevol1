package warburton.java8.lambdas.ch05_Collections;

import warburton.java8.lambdas.ch01_domain.Album;
import warburton.java8.lambdas.ch01_domain.Artist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example_5_13_Composing {
    public Map<Artist, Integer> getNumberOfAlbumsForEachArtist(List<Album> albums) {
         Map<Artist, List<Album>> albumsByArtist = albums.stream().collect(
                 Collectors.groupingBy(Album::getMainMusician));
         Map<Artist, Integer> numberOfAlbums = new HashMap<>();
         for (Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
             numberOfAlbums.put(entry.getKey(), entry.getValue().size());
         }
         return numberOfAlbums;
    }

    public Map<Artist, Long> getNumberOfAlbumsForEachArtistUsingStream(List<Album> albums) {
        return albums.stream().collect(Collectors.groupingBy(Album::getMainMusician, Collectors.counting()));
    }

    public Map<Artist, List<String>> nameOfAlbumsDumb(Stream<Album> albums) {
        Map<Artist, List<Album>> albumsByArtist = albums.collect(
                Collectors.groupingBy(Album::getMainMusician));
        Map<Artist, List<String>> nameOfAlbums = new HashMap<>();
        for (Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            nameOfAlbums.put(entry.getKey(), entry.getValue().stream().map(Album::getName).collect(Collectors.toList()));
        }
        return nameOfAlbums;
    }

    public Map<Artist, List<String>> nameOfAlbumsUsingStream(Stream<Album> albums) {
        return albums.collect(
                Collectors.groupingBy(
                        Album::getMainMusician,
                        Collectors.mapping(Album::getName, Collectors.toList())));
    }
}
