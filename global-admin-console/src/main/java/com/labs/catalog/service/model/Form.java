package com.labs.catalog.service.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.sun.istack.internal.NotNull;

public class Form {

    @Size(max=25)
    private String firstName;
    
    @NotNull
    @Size(max=25)
    private String lastName;
    
    @NotNull
    @Size(min=4,max=8)
    private String username;
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
}
