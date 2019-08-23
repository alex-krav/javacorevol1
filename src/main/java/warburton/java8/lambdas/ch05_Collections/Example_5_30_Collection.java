package warburton.java8.lambdas.ch05_Collections;

import warburton.java8.lambdas.ch01_domain.Album;
import warburton.java8.lambdas.ch01_domain.Artist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example_5_30_Collection {

    Map<String, Artist> artistCache;

    public String artistsToString6(List<Artist> artists) {
        return null;
        /*return artists.stream()
                .map(Artist::getName)
                .collect(Collectors.reducing(
                        new StringCombiner(", ", "[", "]"),
                        name -> new StringCombiner(", ", "[", "]").add(name),
                        StringCombiner::merge));*/
    }

    public String artistsToString7(List<Artist> artists) {
        return artists.stream()
                .map(Artist::getName)
                .map(name -> new StringCombiner(", ", "[", "]").add(name))
                .reduce(new StringCombiner(", ", "[", "]"), StringCombiner::merge)
                .toString();
    }

    public Artist getArtist(String name) {
        Artist artist = artistCache.get(name);
        if (artist == null) {
            artist = readArtistFromDB(name);
            artistCache.put(name, artist);
        }
        return artist;
    }

    public Artist getArtist1(String name) {
        return artistCache.computeIfAbsent(name, this::readArtistFromDB);
    }

    private Artist readArtistFromDB(String name) {
        return new Artist(name, "ukrainian");
    }

    public void countOfAlbums(Map<Artist,List<Album>> albumsByArtist) {
        Map<Artist, Integer> countOfAlbums = new HashMap<>();
        for (Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            Artist artist = entry.getKey();
            List<Album> albums = entry.getValue();
            countOfAlbums.put(artist, albums.size());
        }
    }

    public void countOfAlbums1(Map<Artist,List<Album>> albumsByArtist) {
        Map<Artist, Integer> countOfAlbums = new HashMap<>();
        albumsByArtist.forEach((artist, albums) -> {
            countOfAlbums.put(artist, albums.size());
        });
    }
}
