package com.mkren.building;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@EnableWebSecurity
public class Application extends SpringBootServletInitializer implements WebApplicationInitializer {

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

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	return configureApplication(builder);
    }

    public static void main(String[] args) {
	configureApplication(new SpringApplicationBuilder()).run(args);
    }

    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
	return builder.sources(Application.class)
	              .bannerMode(Banner.Mode.OFF);
    }
}
