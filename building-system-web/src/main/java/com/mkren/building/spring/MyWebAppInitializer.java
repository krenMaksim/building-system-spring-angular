package com.mkren.building.spring;

import javax.servlet.Filter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractDispatcherServletInitializer {

    @Override
    protected WebApplicationContext createRootApplicationContext() {
	return null;
    }

    @Override
    protected WebApplicationContext createServletApplicationContext() {
	XmlWebApplicationContext cxt = new XmlWebApplicationContext();
	cxt.setConfigLocation("classpath:app-config.xml");
	return cxt;
    }

    @Override
    protected String[] getServletMappings() {
	return new String[] { "/" };
    }

    @Override
    protected Filter[] getServletFilters() {
	CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
	characterEncodingFilter.setEncoding("UTF-8");
	characterEncodingFilter.setForceEncoding(true);

	// DelegatingFilterProxy springSecurityFilterChain = new
	// DelegatingFilterProxy();

	return new Filter[] { characterEncodingFilter };
    }
}
