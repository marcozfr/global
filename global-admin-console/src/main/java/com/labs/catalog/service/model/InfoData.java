package com.labs.catalog.service.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InfoData {

    private String id;
    private String name;
    private String details;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    
    @Override
    public String toString() {
        return "InfoData [id=" + id + ", name=" + name + ", details=" + details + "]";
    }
    
}
