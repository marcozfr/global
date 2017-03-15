package com.labs.catalog.service.beans.extension;

import org.springframework.context.ApplicationEvent;

public class NotificationEvent extends ApplicationEvent {

    private String message;
    private String paramString;
    
    public NotificationEvent(Object source) {
        super(source);
        setMessage((String)source);
    }

    public String getParamString() {
        return paramString;
    }

    public void setParamString(String paramString) {
        this.paramString = paramString;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
