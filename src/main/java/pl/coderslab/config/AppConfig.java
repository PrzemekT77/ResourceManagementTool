package pl.coderslab.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.coderslab")
@EnableTransactionManagement	
public class AppConfig extends WebMvcConfigurerAdapter {
		
		@Bean
		public LocalEntityManagerFactoryBean entityManagerFactory() {
		    LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
		    emfb.setPersistenceUnitName("resourcePersistenceUnit");
		    return emfb; }
		@Bean
		public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		    JpaTransactionManager tm = new JpaTransactionManager(emf);
		    return tm; }
		
		@Bean
		public ViewResolver viewResolver() {
			InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
			viewResolver.setPrefix("/WEB-INF/views/");
			viewResolver.setSuffix(".jsp");
			return viewResolver;
		}
		
	}

