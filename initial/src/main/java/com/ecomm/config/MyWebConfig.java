package com.ecomm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ecomm")
public class MyWebConfig implements WebMvcConfigurer{

	
	@Override
	public void configureViewResolvers(final ViewResolverRegistry registry) {
	    registry.jsp("/jsp/", ".jsp");
	}  
}