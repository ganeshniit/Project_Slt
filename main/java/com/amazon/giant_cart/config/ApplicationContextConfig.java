package com.amazon.giant_cart.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.amazon.giant_cart.model.Category;
import com.amazon.giant_cart.model.Product;
import com.amazon.giant_cart.model.Supplier;

@Configuration
@ComponentScan("com.amazon.giant_cart")
@EnableTransactionManagement

public class ApplicationContextConfig {
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("sa");
	 
	    return dataSource;
	}
	    private Properties getHibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.show_sql", "true");
	        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	        //properties.put("hibernate.hdm2ddl.auto", "update");
	        return properties;
	    }
	
	    @Autowired
	    @Bean(name = "sessionFactory")
	    public SessionFactory getSessionFactory(DataSource dataSource)
	    {
	     
	        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	        sessionBuilder.addProperties(getHibernateProperties());
	        sessionBuilder.addAnnotatedClasses(Category.class);
	        sessionBuilder.addAnnotatedClasses(Supplier.class);
	        sessionBuilder.addAnnotatedClasses(Product.class);
	        return sessionBuilder.buildSessionFactory();
	    }
	    @Autowired
	    @Bean(name = "transactionManager")
	    public HibernateTransactionManager getTransactionManager(SessionFactory sessionfactory)
	    {
	    	HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionfactory);
	     
	        return transactionManager;
	    }


}

/*jdbc:h2:tcp://localhost/E:/Hibernate*/
