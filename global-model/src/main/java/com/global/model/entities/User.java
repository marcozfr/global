package com.global.model.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class User {
    
    @Id @GeneratedValue
    private Long userId;
    
    @ManyToOne(fetch=FetchType.LAZY)
    private UserEntity userEntity;
    
    private String username;
    private String password;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="USER_PROFILE",
            joinColumns=@JoinColumn(name="USER_ID",referencedColumnName="userId"),
            inverseJoinColumns=@JoinColumn(name="PROFILE_ID",referencedColumnName="profileId"))
    private List<Profile> userProfiles;
    
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
