package warburton.java8.lambdas.ch04_Libraries;

import org.junit.jupiter.api.Test;
import warburton.java8.lambdas.ch01_domain.Album;

import java.util.IntSummaryStatistics;

public class Example_4_4 {
    @Test
    public void test1() {

    }

    public static void printTrackLengthStatistics(Album album) {
        IntSummaryStatistics trackLengthStats = album.getTracks()
                .mapToInt(track -> track.getLength())
                .summaryStatistics();

        System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d",
                trackLengthStats.getMax(),
                trackLengthStats.getMin(),
                trackLengthStats.getAverage(),
                trackLengthStats.getSum());
    }
}
