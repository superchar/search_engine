package configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Андрей on 02.10.2016.
 */
@Configuration
@Import({ApplicationConfiguration.class, DatabaseConfiguration.class})
public class RootConfiguration {
}
