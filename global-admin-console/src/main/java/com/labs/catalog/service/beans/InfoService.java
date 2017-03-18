package com.labs.catalog.service.beans;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.event.EventListener;

import com.labs.catalog.service.beans.extension.NotificationEvent;

public class InfoService implements ApplicationContextAware, MessageSourceAware {
    
    protected final Log logger = LogFactory.getLog(getClass());
    
    private InfoMessage infoMessage;
    
    private ApplicationContext appContext;
    
    private MessageSource msgSource;
    
    InfoService(InfoMessage infoMessage){
        this.infoMessage = infoMessage;
    }
    
    public void showMessage(){
        infoMessage.getMessage();
    }
    
    public void init(){
        logger.info("initializing bean "+this.getClass() + " in appContext "+this.appContext.getApplicationName());
    }
    
    public void end(){
        logger.info("Destroying bean "+this.getClass() + " in appContext "+this.appContext.getApplicationName());
    }
    
    static abstract class InfoMessage{
        public abstract void getMessage();
        
    }

    @Override
    public void setApplicationContext(ApplicationContext arg0) throws BeansException {
        this.appContext = arg0;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.msgSource = messageSource;
    }
    
}
