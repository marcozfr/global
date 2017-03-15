package com.labs.catalog.service.beans;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import com.labs.catalog.service.beans.InfoService.InfoMessage;

public class InfoMessageToFile extends InfoMessage{

    private AtomicInteger count;
    
    @PostConstruct
    public void init(){
        count = new AtomicInteger(0);
    }
    
    @Override
    public void getMessage() {
        Integer suffix = count.incrementAndGet();
        String msg = "Hello message # "+suffix+" on thread "  + Thread.currentThread().getId();
        try {
            Files.write(Paths.get("./message"+suffix), msg.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
