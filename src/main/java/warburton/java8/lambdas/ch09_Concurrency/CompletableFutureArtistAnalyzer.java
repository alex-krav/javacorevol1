package warburton.java8.lambdas.ch09_Concurrency;

import warburton.java8.lambdas.ch01_domain.Artist;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

public class CompletableFutureArtistAnalyzer implements ArtistAnalyzer {

    private final Function<String, Artist> artistLookupService;

    public CompletableFutureArtistAnalyzer(Function<String, Artist> artistLookupService) {
        this.artistLookupService = artistLookupService;
    }

    @Override
    public void isLargerGroup(String artistName, String otherArtistName, Consumer<Boolean> handler) {
        CompletableFuture<Long> otherArtistMemberCount = CompletableFuture.supplyAsync(() -> getNumberOfMembers(otherArtistName));
        CompletableFuture<Long> artistMemberCount = CompletableFuture.supplyAsync(() -> getNumberOfMembers(artistName));
        artistMemberCount.thenCombine(otherArtistMemberCount, (count, otherCount) -> count > otherCount)
                .thenAccept(handler);

    }

    private long getNumberOfMembers(String artistName) {
        return artistLookupService.apply(artistName)
                .getMembers()
                .count();
    }
}
