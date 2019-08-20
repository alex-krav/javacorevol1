package warburton.java8.lambdas.ch04_Libraries;

import warburton.java8.lambdas.ch01_domain.Artist;

import java.util.List;
import java.util.Optional;

public class Artists {
    private List<Artist> artists;

    public Artists(List<Artist> artists) {
        this.artists = artists;
    }

    public Artist getArtist(int index) {
        if (index < 0 || index >= artists.size()) {
            indexException(index);
        }
        return artists.get(index);
    }

    public Optional<Artist> getArtistOptional(int index) {
        if (index < 0 || index >= artists.size())
            return Optional.empty();
        else
            return Optional.of(artists.get(index));
    }

    private void indexException(int index) {
        throw new IllegalArgumentException(index + " doesn't correspond to an Artist");
    }

    public String getArtistName(int index) {
        try {
            Artist artist = getArtist(index);
            return artist.getName();
        } catch (IllegalArgumentException e) {
            return "unknown";
        }
    }

    public String getArtistNameOptional(int index) {
        Optional<Artist> artist = getArtistOptional(index);
//        return artist.isPresent() ? artist.get().getName() : "unknown";
        return artist.map(a -> a.getName()).orElse("unknown");
    }
}