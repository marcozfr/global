package com.labs.catalog.service.beans;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.labs.catalog.service.beans.extension.NotificationEvent;

@Component
public class NotificationListener implements ApplicationListener<NotificationEvent>{

    protected final Log logger = LogFactory.getLog(getClass());
    
    @Override
    public void onApplicationEvent(NotificationEvent event) {
        logger.info("Received notification: " + event.getMessage());
    }

}
