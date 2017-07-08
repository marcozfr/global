package com.labs.catalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.labs.catalog.service.perf.PerformanceInterceptor;

@Configuration
@ImportResource("classpath:root-context.xml")
@Import(RootWebSecurityConfig.class)
@EnableAspectJAutoProxy
public class RootConfig {
    
    @Bean
    PerformanceInterceptor performanceInterceptor(){
        return new PerformanceInterceptor();
    }
    
}
