package warburton.java8.lambdas.ch09_Concurrency;

import warburton.java8.lambdas.ch01_domain.Artist;

import java.util.function.Consumer;
import java.util.function.Function;

public class CallbackArtistAnalyzer implements ArtistAnalyzer {

    private final Function<String, Artist> artistLookupService;

    public CallbackArtistAnalyzer(Function<String, Artist> artistLookupService) {
        this.artistLookupService = artistLookupService;
    }

    @Override
    public void isLargerGroup(String artistName, String otherArtistName, Consumer<Boolean> handler) {
        boolean isLarger = getNumberOfMembers(artistName) > getNumberOfMembers(otherArtistName);
        handler.accept(isLarger);
    }

    private long getNumberOfMembers(String artistName) {
        return artistLookupService.apply(artistName)
                .getMembers()
                .count();
    }
}
