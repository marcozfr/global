package com.labs.catalog.service.beans;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.labs.catalog.service.beans.InfoService.InfoMessage;

public class InfoMessageLogger extends InfoMessage {

    protected final Log logger = LogFactory.getLog(getClass());
    
    @Override
    public void getMessage() {
        logger.info("Hi All with logger");
    }
    
}
