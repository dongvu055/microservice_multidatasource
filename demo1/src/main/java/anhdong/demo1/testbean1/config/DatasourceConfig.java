package anhdong.demo1.testbean1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:datasource.properties")
public class DatasourceConfig {

    @Autowired
    private Environment environment;

    @Bean
    @Qualifier("datasource1")
    public DataSource getDatasource1() {
        return DataSourceBuilder
                .create()
                .driverClassName(environment.getProperty("spring.datasource1.driverClassName"))
                .url(environment.getProperty("spring.datasource1.url"))
                .username(environment.getProperty("spring.datasource1.username"))
                .password(environment.getProperty("spring.datasource1.password"))
                .build();
    }

    @Bean
    @Qualifier("datasource2")
    public DataSource getDatasource2() {
        return DataSourceBuilder
                .create()
                .driverClassName(environment.getProperty("spring.datasource2.driverClassName"))
                .url(environment.getProperty("spring.datasource2.url"))
                .username(environment.getProperty("spring.datasource2.username"))
                .password(environment.getProperty("spring.datasource2.password"))
                .build();
    }
}
