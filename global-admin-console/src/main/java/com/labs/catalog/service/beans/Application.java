package com.labs.catalog.service.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

import com.labs.catalog.service.beans.InfoService.InfoMessage;
import com.labs.catalog.service.beans.extension.FileCondition;
import com.labs.catalog.service.beans.extension.NotificationEvent;
import com.labs.catalog.service.interfaces.WriteToFile;

@Configuration
@ComponentScan
@ImportResource("global.xml")
public class Application {
    
    public static final Logger logger = LogManager.getLogger(Application.class);
    
    @Bean
    @Conditional(FileCondition.class)
    @WriteToFile(true)
    @Primary
    public InfoMessage fileMessage(){
        return new InfoMessageToFile();
    }
    
    @EventListener
    @Async
    @Order(2)
    public void notifyMessageEvent(NotificationEvent evt){
        logger.info("Application Notification Received :" +evt.getMessage());
    }
    
    @EventListener(condition="#evt.paramString != null")
    public void notifyRequestEvent(NotificationEvent evt){
        logger.info("Application Notification Received with params:" +evt.getMessage() + ". Params: "+evt.getParamString());
    }

}
