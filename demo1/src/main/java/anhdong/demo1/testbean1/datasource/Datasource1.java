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
        basePackages = "anhdong.demo1.testbean1.repo.repo1",
        entityManagerFactoryRef = "entityManager1",
        transactionManagerRef = "transactionManager1")
public class Datasource1 {
    @Autowired
    private Environment environment;

    @Bean("entityManager1")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManager1() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource1());
        em.setPackagesToScan(new String[]{"anhdong.demo1.testbean1.entity.dao1"});

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
//        properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
//        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean("dataSource1")
    @Primary
    public DataSource dataSource1() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("spring.datasource1.driverClassName"));
        dataSource.setUrl(environment.getProperty("spring.datasource1.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource1.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource1.password"));

        return dataSource;
    }

    @Bean("transactionManager1")
    @Primary
    public PlatformTransactionManager transactionManager1() {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManager1().getObject());
        return transactionManager;
    }
}
