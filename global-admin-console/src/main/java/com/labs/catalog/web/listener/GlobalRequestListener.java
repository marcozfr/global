package com.labs.catalog.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;

import com.labs.catalog.service.beans.NotificationService;
import com.labs.catalog.service.beans.extension.NotificationEvent;

@WebListener
public class GlobalRequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ApplicationContext ctx = (ApplicationContext) sre.getServletContext().getAttribute("springApplicationContext");
        NotificationEvent evt = new NotificationEvent("Request received @ thread " + Thread.currentThread().getId());
        NotificationService notificationService = ctx.getBean(NotificationService.class);
        
        HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
        if(request.getQueryString()!=null){
            evt.setParamString(request.getQueryString());
        };
        
        notificationService.publish(evt);
    }

}
