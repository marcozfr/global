package com.global.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class Auditable implements Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    
    private String creationUser;
    private String lastModifiedUser;
    
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public String getCreationUser() {
        return creationUser;
    }
    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }
    public String getLastModifiedUser() {
        return lastModifiedUser;
    }
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }
    
    
    
}
