package com.mkren.building.spring;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {
	XmlWebApplicationContext appContext = new XmlWebApplicationContext();
	appContext.setConfigLocation("classpath:app-config.xml");

	ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet(appContext));
	registration.setLoadOnStartup(1);
	registration.addMapping("/");

	CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
	characterEncodingFilter.setEncoding("UTF-8");
	characterEncodingFilter.setForceEncoding(true);

	container.addFilter("encodingFilter", characterEncodingFilter)
	         .addMappingForUrlPatterns(null, false, "/*");

	DelegatingFilterProxy springSecurityFilterChain = new DelegatingFilterProxy();

	container.addFilter("springSecurityFilterChain", springSecurityFilterChain)
	         .addMappingForUrlPatterns(null, false, "/*");
    }

}
