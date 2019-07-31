package horstman.core.java.vol1.ch12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This program demonstrates the Callable interface and executors.
 */
public class ExecutorDemo {

    /**
     * Counts occurences of a given word in a file.
     */
    public static long occurences(String word, Path path) {
        try (var in = new Scanner(path)) {
            int count = 0;
            while (in.hasNext())
                if (in.next().equals(word)) count++;
            return count;
        } catch (IOException e) {
            return 0;
        }
    }

    /**
     * Returns all descendants of a given directory
     */
    public static Set<Path> descendants(Path rootDir) throws IOException {
        try (Stream<Path> entries = Files.walk(rootDir)) {
            return entries.filter(Files::isRegularFile)
                    .collect(Collectors.toSet());
        }
    }

    /**
     * Yields a task that searches for a word in a file.
     */
    public static Callable<Path> searchForTask(String word, Path path) {
        return () -> {
            try (var in = new Scanner(path)) {
                while (in.hasNext()) {
                    if (in.next().equals(word)) return path;
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Search in " + path + " cancelled.");
                        return null;
                    }
                }
                throw new NoSuchElementException();
            }
        };
    }

    /**
     * Enter base directory (e.g. /opt/jdk-9-src): C:\Users\oakravchuk\projects\jdk-12-src
     * Enter keyword (e.g. volatile): volatile
     * Occurences of volatile: 1276
     * Time elapsed: 50419 ms
     * Search in C:\Users\oakravchuk\projects\jdk-12-src\jdk.internal.vm.compiler\org.graalvm.compiler.lir.jtt\src\org\graalvm\compiler\lir\jtt\StackStoreLoadTest.java cancelled.
     * Search in C:\Users\oakravchuk\projects\jdk-12-src\jdk.hotspot.agent\sun\jvm\hotspot\debugger\win32\coff\DebugVC50SSAlignSym.java cancelled.
     * Search in C:\Users\oakravchuk\projects\jdk-12-src\java.base\java\/util\function\LongPredicate.java cancelled.
     * Search in C:\Users\oakravchuk\projects\jdk-12-src\jdk.scripting.nashorn\jdk\nashorn\internal\ir\FunctionNode.java cancelled.
     * Search in C:\Users\oakravchuk\projects\jdk-12-src\java.xml\com\sun\org\apache\xerces\internal\impl\dtd\XML11NSDTDValidator.java cancelled.
     * volatile occurs in: C:\Users\oakravchuk\projects\jdk-12-src\jdk.jshell\jdk\jshell\execution\JdiEventHandler.java
     * Largest pool size: 5282
     *
     * Occurences of volatile: 1276
     * Time elapsed: 11432 ms
     * Search in C:\Users\oakravchuk\projects\jdk-12-src\java.net.http\jdk\internal\net\http\hpack\DecodingCallback.java cancelled.
     * volatile occurs in: C:\Users\oakravchuk\projects\jdk-12-src\java.base\java\nio\channels\spi\AbstractSelectionKey.java
     */
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        try (var in = new Scanner(System.in)) {
            System.out.print("Enter base directory (e.g. /opt/jdk-9-src): ");
            String start = in.nextLine();
            System.out.print("Enter keyword (e.g. volatile): ");
            String word = in.nextLine();

            Set<Path> files = descendants(Path.of(start));

            var tasks = new ArrayList<Callable<Long>>();
            for (Path file : files ) {
                Callable<Long> task = () -> occurences(word, file);
                tasks.add(task);
            }
//            ExecutorService executor = Executors.newCachedThreadPool();
            ExecutorService executor = Executors.newSingleThreadExecutor();

            Instant startTime = Instant.now();
            List<Future<Long>> results = executor.invokeAll(tasks);
            long total = 0;
            for (Future<Long> result : results)
                total += result.get();
            Instant endTime = Instant.now();
            System.out.println("Occurences of " + word + ": " + total);
            System.out.println("Time elapsed: " + Duration.between(startTime, endTime).toMillis() + " ms");

            var searchTasks = new ArrayList<Callable<Path>>();
            for (Path file : files)
                searchTasks.add(searchForTask(word, file));
            Path found = executor.invokeAny(searchTasks);
            System.out.println(word + " occurs in: " + found);

            if (executor instanceof ThreadPoolExecutor)
                System.out.println("Largest pool size: " + ((ThreadPoolExecutor) executor).getLargestPoolSize());
            executor.shutdown();
        }
    }
}
