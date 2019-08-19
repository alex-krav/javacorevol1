package warburton.java8.lambdas.ch03_Streams;

import warburton.java8.lambdas.ch01_domain.Album;
import warburton.java8.lambdas.ch01_domain.Track;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Example_3_19_Legacy {

    public Set<String> findLongTracks(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        for (Album album : albums) {
            for (Track track : album.getTrackList()) {
                if (track.getLength() > 60) {
                    String name = track.getName();
                    trackNames.add(name);
                }
            }
        }
        return trackNames;
    }

    public Set<String> findLongTracks1(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
            .forEach(album -> {
                album.getTracks()
                    .forEach(track -> {
                        if (track.getLength() > 60) {
                            String name = track.getName();
                            trackNames.add(name);
                        }
                    });
            });
        return trackNames;
    }

    public Set<String> findLongTracks2(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
            .forEach(album -> {
                album.getTracks()
                    .filter(track -> track.getLength() > 60)
                    .map(track -> track.getName())
                    .forEach(name -> trackNames.add(name));
            });
        return trackNames;
    }

    public Set<String> findLongTracks3(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
            .flatMap(album -> album.getTracks())
            .filter(track -> track.getLength() > 60)
            .map(track -> track.getName())
            .forEach(name -> trackNames.add(name));

        return trackNames;
    }

    public Set<String> findLongTracks4(List<Album> albums) {
        return albums.stream()
                .flatMap(album -> album.getTracks())
                .filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .collect(Collectors.toSet());
    }
}
