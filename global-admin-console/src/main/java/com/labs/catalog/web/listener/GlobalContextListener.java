package com.labs.catalog.web.listener;

import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.labs.catalog.service.beans.Application;
import com.labs.catalog.service.beans.InfoService;
import com.labs.catalog.service.beans.extension.NotificationEvent;

@WebListener
public class GlobalContextListener implements ServletContextListener {

    protected final Log logger = LogFactory.getLog(getClass());
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
        sce.getServletContext().setAttribute("springApplicationContext", ctx);
        ctx.publishEvent(new NotificationEvent("Spring Context started"));
        
        MessageSource msgCtx = (MessageSource)ctx;
        String globalEnabled = msgCtx.getMessage("global", null, Locale.getDefault());
        logger.info("Global enabled :" + globalEnabled);
        logger.info("Spring app context startup date: " +new Date(ctx.getStartupDate()));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext)sce.getServletContext().getAttribute("springApplicationContext");
        ctx.publishEvent(new NotificationEvent("Spring Context destroyed"));
    }

}
