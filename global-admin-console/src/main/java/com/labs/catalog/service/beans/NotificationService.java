package com.labs.catalog.service.beans;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import com.labs.catalog.service.beans.extension.NotificationEvent;

@Component
public class NotificationService implements ApplicationEventPublisherAware{

    private ApplicationEventPublisher applicationEventPublisher;
    
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
    
    public void publish(String message){
        applicationEventPublisher.publishEvent(new NotificationEvent(message));
    }
    
    public void publish(NotificationEvent evt){
        applicationEventPublisher.publishEvent(evt);
    }
    
}
