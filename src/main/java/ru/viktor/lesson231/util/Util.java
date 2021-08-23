package ru.viktor.lesson231.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan("ru.viktor.lesson231")
public class Util {

    Environment environment;

    @Autowired
    public Util(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource dataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(environment.getRequiredProperty("db.url"));
        ds.setUsername(environment.getRequiredProperty("db.username"));
        ds.setPassword(environment.getRequiredProperty("db.password"));
        ds.setDriverClassName(environment.getRequiredProperty("db.driver"));

        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean (){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(environment.getRequiredProperty("db.entity.package"));
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
        em.setJpaVendorAdapter(adapter);Map<String, Object> properties = new Hashtable<>();
        em.setJpaProperties(getHibernateProperties());
        return em;
    }


    public Properties getHibernateProperties(){
        try {
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("hibernate.properties");
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new IllegalArgumentException("not found hibernate properties", e);
        }
    }
}
