package com.global.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ApplicationEntity {

    @Id
    private Long applicationId;
    
    private String description;

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
