package com.app;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.app")
@EnableTransactionManagement
@EnableJpaRepositories
public class AppConfig {

//    @PersistenceUnit
//    EntityManagerFactory entityManagerFactory;
    @Bean
    DataSource dataSource(){
        var dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/demo");
        dataSource.setUsername("root");
        dataSource.setPassword("Shree@123");
        return dataSource;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
        var emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan("com.app");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setEntityManagerFactoryInterface(EntityManagerFactory.class);
        return emf;
    }

    @Bean
    PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        var manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(emf);
        return manager;
    }
}
