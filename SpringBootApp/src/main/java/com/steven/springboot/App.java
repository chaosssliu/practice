package com.steven.springboot;

import java.util.Arrays;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
    
    @Bean
    public DataSource dataSource() {
    	EmbeddedDatabaseBuilder eDbBuilder = new EmbeddedDatabaseBuilder();
    	EmbeddedDatabase eDb = eDbBuilder
    			.setName("MetaDataDB")
    			.setType(EmbeddedDatabaseType.DERBY)
    			.addScript("./DB/FileMetaData.sql")
    			.ignoreFailedDrops(true)
    			.build();
    	return eDb;
    }
    
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
    	JpaTransactionManager transactionManager = new JpaTransactionManager();
    	transactionManager.setEntityManagerFactory(emf);

    	return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
    	return new PersistenceExceptionTranslationPostProcessor();
    }
    Properties additionalProperties() {
    	Properties properties = new Properties();
    	//  properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
    	properties.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyTenSevenDialect");
    	properties.setProperty("hibernate.show_sql", "true");
    	return properties;
    }
	   
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }
    
}
