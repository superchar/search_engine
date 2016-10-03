package engine;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Андрей on 02.10.2016.
 */
public class Crawler {

    private static final int DEFAULT_DEPTH = 2;

    private static final int WAITING_TIMEOUT_MILLISECONDS = 5000;

    public void crawl(List<String> urls, int depth) {
        ArrayDeque<String> currentProcessingUrls = new ArrayDeque<>(urls);
        for(int i = 0;i < depth; i++){
            List<String> urlsPresentOnThePages = new ArrayList<>();
            while (!currentProcessingUrls.isEmpty()){
                urlsPresentOnThePages.addAll(processUrl(currentProcessingUrls.pop()));
            }
            currentProcessingUrls.addAll(urlsPresentOnThePages);
        }
    }

    public void crawl(List<String> urls) {
        crawl(urls, DEFAULT_DEPTH);
    }

    private List<String> processUrl(String url) {
        System.out.println(String.format("Indexing - %s", url));
        try {
            URL baseUrl = new URL(url);
            Document document = Jsoup.parse(baseUrl, WAITING_TIMEOUT_MILLISECONDS);
            return document.getElementsByTag("a").stream()
                    .filter(e -> e.hasAttr("href"))
                    .map(e -> combineUrls(e.attr("href"), baseUrl)).collect(Collectors.toList());
        } catch (IOException ex) {
            System.out.println(String.format("Error loading url - %s", url));
            return Collections.emptyList();
        }
    }

    private String combineUrls(String url, URL baseUrl) {
        try {
            return new URL(baseUrl, url).toString();
        } catch (MalformedURLException ex) {
            return "";
        }
    }
}
