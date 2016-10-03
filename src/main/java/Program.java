import configuration.DatabaseConfiguration;
import configuration.RootConfiguration;
import data_access.dao.UrlDao;
import data_access.entities.Url;
import engine.Crawler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Андрей on 02.10.2016.
 */
public class Program {

    public static void main(String ... args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfiguration.class);
        UrlDao urlDao = applicationContext.getBean(UrlDao.class);
        Url url = new Url();
        url.setUrl("http://google.com");
        urlDao.insert(url);
    }
}
