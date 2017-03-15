package com.labs.catalog.service.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.labs.catalog.service.beans.extension.NotificationEvent;

@Component
public class NotificationListener implements ApplicationListener<NotificationEvent>{

    public static final Logger logger = LogManager.getLogger(InfoService.class);
    
    @Override
    public void onApplicationEvent(NotificationEvent event) {
        logger.info("Received notification: {}",event.getMessage());
    }

}
