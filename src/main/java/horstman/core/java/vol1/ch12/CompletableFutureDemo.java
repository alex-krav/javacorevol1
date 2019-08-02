package horstman.core.java.vol1.ch12;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.charset.StandardCharsets.UTF_8;

public class CompletableFutureDemo {

    private static final Pattern IMG_PATTERN = Pattern.compile("[<]\\s*[iI][mM][gG]\\s*[^>]*[sS][rR][cC]\\s*[=]\\s*['\"]([^'\"]*)['\"][^>]*[>]");
    private ExecutorService executor = Executors.newCachedThreadPool();
    private URL urlToProcess;

    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
//        new CompletableFutureDemo().run(new URL("http://horstmann.com/index.html")); //returns: 404
        new CompletableFutureDemo().run(new URL("https://dou.ua"));
    }

    public CompletableFuture<String> readPage(URL url) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                var contents = new String(url.openStream().readAllBytes(), UTF_8);
                System.out.println("Read page from " + url);
                return contents;
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }, executor);
    }

    public List<URL> getImageURLs(String webpage) {
        try {
            var result  = new ArrayList<URL>();
            Matcher matcher = IMG_PATTERN.matcher(webpage);
            while (matcher.find()) {
                var url = new URL(urlToProcess, matcher.group(1));
                result.add(url);
            }
            System.out.println("Found URLs: " + result);
            return result;
        } catch (MalformedURLException e) {
            throw new UncheckedIOException(e);
        }
    }

    public CompletableFuture<List<BufferedImage>> getImages(List<URL> urls) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                var result = new ArrayList<BufferedImage>();
                for (URL url : urls) {
                    result.add(ImageIO.read(url));
                    System.out.println("Loaded " + url);
                }
                return result;
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }, executor);
    }

    public void saveImages(List<BufferedImage> images) {
        System.out.println("Saving " + images.size() + " images");
        try {
            for (int i = 0; i < images.size(); i++) {
                String filename = "C:\\Users\\oakravchuk\\Pictures\\fork_join_test\\dou_http_client\\image" + (i + 1) + ".png";
                ImageIO.write(images.get(i), "PNG", new File(filename));
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        executor.shutdown();
    }

    public void run(URL url) throws URISyntaxException {
        urlToProcess = url;
//        CompletableFuture.completedFuture(url)
//                .thenComposeAsync(this::readPage, executor)
//                .thenApply(this::getImageURLs)
//                .thenCompose(this::getImages)
//                .thenAccept(this::saveImages);

        // or use the experimental HTTP client:
        HttpClient client = HttpClient.newBuilder().executor(executor).build();
        HttpRequest request = HttpRequest.newBuilder(urlToProcess.toURI()).GET().build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body).thenApply(this::getImageURLs)
                .thenCompose(this::getImages).thenAccept(this::saveImages);
    }
}
