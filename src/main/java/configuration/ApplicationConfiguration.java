package configuration;

import data_access.dao.UrlDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Андрей on 02.10.2016.
 */
@Configuration
public class ApplicationConfiguration {

    @Bean
    public UrlDao urlDao(){
        return new UrlDao();
    }
}
