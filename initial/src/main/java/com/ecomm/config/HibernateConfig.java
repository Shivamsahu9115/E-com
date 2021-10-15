package com.ecomm.config;

import java.util.Properties;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;



@Configuration
@EnableTransactionManagement
public class HibernateConfig {

    @Autowired
    private Environment env;
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.ecomm.entity");
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    public HikariDataSource dataSource() {
    	HikariDataSource dataSource = new HikariDataSource();
    	dataSource.setJdbcUrl(env.getProperty("app.datasource.master.jdbcUrl"));
    	dataSource.setUsername(env.getProperty("app.datasource.master.username"));
    	dataSource.setPassword(env.getProperty("app.datasource.master.password"));
    	dataSource.setDriverClassName(env.getProperty("app.datasource.master.driverClassName"));
    	dataSource.setMaximumPoolSize(Integer.parseInt(env.getProperty("app.datasource.master.maxPoolSize")));
    	dataSource.setIdleTimeout(Integer.parseInt(env.getProperty("app.datasource.master.idleTimeout")));

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
          = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
          "hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        hibernateProperties.setProperty(
          "hibernate.dialect", env.getProperty("spring.jpa.database-platform"));
        
       

        return hibernateProperties;
    }
}
