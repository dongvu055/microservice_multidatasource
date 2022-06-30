package anhdong.demo1.testbean1.datasource;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:datasource.properties")
@EnableJpaRepositories(
        basePackages = "anhdong.demo1.testbean1.repo.repo2",
        entityManagerFactoryRef = "entityManager2",
        transactionManagerRef = "transactionManager2"
)
public class Datasource2 {
    @Autowired
    private Environment environment;

    @Bean("entityManager2")
    public LocalContainerEntityManagerFactoryBean entityManager2() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource2());
        em.setPackagesToScan(
                new String[]{"anhdong.demo1.testbean1.entity.dao2"});

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto",
//                environment.getProperty("hibernate.hbm2ddl.auto"));
//        properties.put("hibernate.dialect",
//                environment.getProperty("hibernate.dialect"));
//        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean("dataSource2")
    public DataSource dataSource2() {

        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName(
                environment.getProperty("spring.datasource2.driverClassName"));
        dataSource.setUrl(environment.getProperty("spring.datasource2.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource2.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource2.password"));

        return dataSource;
    }

    @Bean("transactionManager2")
    public PlatformTransactionManager transactionManager2() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                entityManager2().getObject());
        return transactionManager;
    }
}
