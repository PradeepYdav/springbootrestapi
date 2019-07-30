package com.pradeep.rest.webservices.restfulwebservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}
	
	@Bean
	public LocaleResolver loaLocaleResolver() {
		SessionLocaleResolver sessionLocaleResolver= new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.US);
		return sessionLocaleResolver;
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource bundleMessageSource= new ResourceBundleMessageSource();
		bundleMessageSource.setBasename("messages");
		return bundleMessageSource;
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry
	        .addResourceHandler("swagger-ui.html")
	        .addResourceLocations("classpath:/META-INF/resources/");
	    registry
	        .addResourceHandler("/webjars/**")
	        .addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}
