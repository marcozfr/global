package com.labs.catalog.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.DispatcherServlet;

public class CatalogApplicationInitializer implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic registration = servletContext.addServlet("spring-root", new DispatcherServlet());
        registration.setLoadOnStartup(1);
        registration.addMapping("/s/*");
        
        servletContext.addListener(new ContextLoaderListener());
        
        servletContext.setInitParameter("contextConfigLocation", "/WEB-INF/root-context.xml");
        
    }

}
