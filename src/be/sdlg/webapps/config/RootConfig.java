package be.sdlg.webapps.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//import org.springframework.transaction.annotatioen.EnableTransactionManagement;


@Configuration
@ComponentScan({ "be.sdlg.webapps.controllers", "be.sdlg.webapps.dao", "be.sdlg.webapps.services" })
//@org.springframework.transaction.annotation.EnableTransactionManagement
@Import({ SecurityConfig.class })
public class RootConfig {
	@Bean // par defaut le bean porte le nom de la fonction (ici dataSource).
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/stt_db");
        dataSource.setUsername("root");
        dataSource.setPassword("secret");
        return dataSource;
    }
	
	   @Bean
	    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	        jdbcTemplate.setResultsMapCaseInsensitive(true);
	        return jdbcTemplate;
	    }

/*	@Bean
	public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan(new String[] { "be.sdlg.webapps.model" }); // endroit ou sont stockes les repository
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect"); // SQL flavor
	        properties.put("hibernate.show_sql", "true");
	        properties.put("hibernate.format_sql", "true");
	        properties.put("hibernate.hbm2ddl.auto", "create"); // Cree automatiquement la base de donnees
	        sessionFactory.setHibernateProperties(properties);
	        return sessionFactory;
	}*/
/*	@Bean 
	public HibernateTransactionManager transactionManager() {
	       HibernateTransactionManager txManager = new HibernateTransactionManager(
	    		   (SessionFactory) sessionFactory().getObject()); // Un bean est un composant, pas un objet, or ici c'est l'objet que l'on veut recuperer
	       return txManager;
	}*/

}
