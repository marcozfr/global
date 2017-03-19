package com.labs.catalog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:root-context.xml")
@Import(RootWebSecurityConfig.class)
public class RootConfig {
    
}
