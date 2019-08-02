package horstman.core.java.vol2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CountLongWords {
    public static void main(String[] args) throws IOException {
        /*var contents = new String(
            Files.readAllBytes(
                    Paths.get("C:\\Users\\oakravchuk\\projects\\javacorevol1\\src\\main\\java\\horstman\\core\\java\\vol1\\ch09\\alice.txt")), StandardCharsets.UTF_8);*/
        var contents = Files.readString(
                Paths.get("C:\\Users\\oakravchuk\\projects\\javacorevol1\\src\\main\\java\\horstman\\core\\java\\vol1\\ch09\\alice.txt"));
        List<String> words = List.of(contents.split(("\\PL+")));

        long start = System.nanoTime();
        long count = 0;
        for (String w : words) {
            if (w.length() > 12) count++;
        }
        long end = System.nanoTime();
        System.out.println(count + "("+(end-start)+" ns)");

        start = System.nanoTime();
        count = words.stream().filter(w -> w.length() > 12).count();
        end = System.nanoTime();
        System.out.println(count + "("+(end-start)+" ns)");

        start = System.nanoTime();
        count = words.parallelStream().filter(w -> w.length() > 12).count();
        end = System.nanoTime();
        System.out.println(count + "("+(end-start)+" ns)");
    }
}
