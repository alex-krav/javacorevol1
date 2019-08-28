package warburton.java8.lambdas.ch09_Concurrency;

import java.util.function.Consumer;

public interface ArtistAnalyzer {

    void isLargerGroup(String artistName,
                       String otherArtistName,
                       Consumer<Boolean> handler);
}
