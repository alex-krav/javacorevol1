package warburton.java8.lambdas.ch03_Streams;

import warburton.java8.lambdas.ch01_domain.Artist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Example_3_1 {
    public static void main(String[] args) {
        //1
        List<Artist> allArtists = new ArrayList<>();
        allArtists.add(new Artist("Alex", "ukrainian"));
        long count = 0;
        for (Artist artist : allArtists) {
            if (artist.isFrom("London")) {
                count++;
            }
        }

        //2
        count = 0;
        Iterator<Artist> iterator = allArtists.iterator();
        while (iterator.hasNext()) {
            Artist artist = iterator.next();
            if (artist.isFrom("London")) {
                count++;
            }
        }

        //3
//        count =
                allArtists.stream()
                .filter(artist -> {
                    System.out.println(artist.getName());
                    return artist.isFrom("London");
                });
//                .count();
    }
}
