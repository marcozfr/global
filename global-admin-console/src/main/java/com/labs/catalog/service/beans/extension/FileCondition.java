package com.labs.catalog.service.beans.extension;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import com.labs.catalog.service.interfaces.WriteToFile;

public class FileCondition implements Condition {

    @Override
    public boolean matches(ConditionContext ctx, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attrs = metadata.getAnnotationAttributes(WriteToFile.class.getName());
        if(attrs!=null){
            for(Entry<String,Object> attr : attrs.entrySet()){
                if(attr.getKey().equals("value") && attr.getValue().equals(true)){
                    return true;
                }
            }
        }
        return false;
    }

}
