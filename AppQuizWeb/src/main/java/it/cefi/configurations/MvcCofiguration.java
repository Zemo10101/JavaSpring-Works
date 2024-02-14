package it.cefi.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
   Mvc è un alternativa al controller solo nel momento in cui serve legare una route ad una pagina,
   senza implementare azioni legate alla route
 */
@Configuration
public class MvcCofiguration implements WebMvcConfigurer{

	public void addViewControllers(ViewControllerRegistry registry) {
	
		
		//collega la route /login senza il controller, alla pagina login.html
		registry.addViewController("/login").setViewName("login");
		
		//collega la route /403 senza il controller, alla pagina error.html
		registry.addViewController("/403").setViewName("error");
	}
	
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/images/**")
	                .addResourceLocations("classpath:/static/images/");
	 }
	
	
}
