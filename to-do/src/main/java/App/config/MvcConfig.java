package App.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/newseller").setViewName("newseller");
        registry.addViewController("/seller").setViewName("newseller");
        registry.addViewController("/saveseller").setViewName("newseller");
        registry.addViewController("/updateseller").setViewName("newseller");
        registry.addViewController("/deleteseller").setViewName("newseller");
        registry.addViewController("/loginHome").setViewName("LoginHome");
        registry.addViewController("/updateorder").setViewName("updateorder");
        
    }
    
    @Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
    
    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
 	   DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
 	   driverManagerDataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 	   driverManagerDataSource.setUrl("jdbc:sqlserver://localhost;databaseName=medikart");
 	   driverManagerDataSource.setUsername("sa");
 	   driverManagerDataSource.setPassword("success12!#");
 	   return driverManagerDataSource;
    }
    

}