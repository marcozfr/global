package com.labs.catalog.web;

import javax.servlet.ServletContext;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class GlobalSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    
    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
        System.out.println("Initializing Spring Security FilterChain");
    }

}
