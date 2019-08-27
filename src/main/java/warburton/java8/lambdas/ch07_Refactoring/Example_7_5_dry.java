package warburton.java8.lambdas.ch07_Refactoring;

import warburton.java8.lambdas.ch01_domain.Album;
import warburton.java8.lambdas.ch01_domain.Track;

import java.util.List;
import java.util.function.ToLongFunction;

public class Example_7_5_dry {

    public long countRunningTime1(List<Album> albums) {
        long count = 0;
        for (Album album : albums) {
            for (Track track : album.getTrackList()) {
                count += track.getLength();
            }
        }
        return count;
    }

    public long countMusicians1(List<Album> albums) {
        long count = 0;
        for (Album album : albums) {
            count += album.getMusicianList().size();
        }
        return count;
    }

    public long countTracks1(List<Album> albums) {
        long count = 0;
        for (Album album : albums) {
            count += album.getTrackList().size();
        }
        return count;
    }

    //////////////////////////////////////////////////////

    public long countRunningTime2(List<Album> albums) {
        return albums.stream()
                .mapToLong(album -> album.getTracks()
                                        .mapToLong(Track::getLength)
                                        .sum())
                .sum();
    }

    public long countMusicians2(List<Album> albums) {
        return albums.stream()
                .mapToLong(album -> album.getMusicians().count())
                .sum();
    }

    public long countTracks2(List<Album> albums) {
        return albums.stream()
                .mapToLong(album -> album.getTracks().count())
                .sum();
    }

    ///////////////////////////////////////////////////////////////

    public long countFeature(List<Album> albums, ToLongFunction<Album> mapper) {
        return albums.stream()
                .mapToLong(mapper)
                .sum();
    }

    public long countTracks3(List<Album> albums) {
        return countFeature(albums, album -> album.getTracks().count());
    }

    public long countRunningTime3(List<Album> albums) {
        return countFeature(albums, album -> album.getTracks()
                                                .mapToLong(Track::getLength)
                                                .sum());
    }

    public long countMusicians3(List<Album> albums) {
        return countFeature(albums, album -> album.getMusicians().count());
    }

    public ToLongFunction<Album> countTracksFunction() {
        return album -> album.getTracks().count();
    }

    public long countTracks4(List<Album> albums) {
//        return countFeature(albums, countTracksFunction());
        return countFeature(albums, AlbumToTrackLength::count);
    }


}

class AlbumToTrackLength {
    public static long count(Album album) {
        return album.getTracks().count();
    }
}
