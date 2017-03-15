package com.labs.catalog.service.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.labs.catalog.service.beans.InfoService.InfoMessage;

public class InfoMessageLogger extends InfoMessage {

    public static final Logger logger = LogManager.getLogger(InfoMessageLogger.class);
    
    @Override
    public void getMessage() {
        logger.info("Hi All with logger");
    }
    
}
