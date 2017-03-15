package com.labs.catalog.service.beans.extension;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {

    public static final Logger logger = LogManager.getLogger(InstantiationTracingBeanPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("Initializing bean named {} of class {}",beanName,bean.getClass());
        return bean;
    }
    
}
