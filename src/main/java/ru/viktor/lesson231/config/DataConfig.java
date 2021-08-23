package ru.viktor.lesson231.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;


@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan("ru.viktor.lesson231")
public class DataConfig {
    Environment environment;

    public DataConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(environment.getRequiredProperty("db.url"));
        ds.setUsername(environment.getRequiredProperty("db.username"));
        ds.setPassword(environment.getRequiredProperty("db.password"));
        ds.setDriverClassName(environment.getRequiredProperty("db.driver"));

        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(environment.getRequiredProperty("db.entity.package"));
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
        em.setJpaVendorAdapter(adapter);
        Map<String, Object> properties = new Hashtable<>();
        em.setJpaProperties(getHibernateProperties());
        return em;
    }


    public Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        return properties;
    }
}
