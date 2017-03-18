package com.global.model.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import com.global.model.types.PrivilegeType;

@Embeddable
public class ProfileMenuPrivilegePk implements Serializable {

    @ManyToOne
    private Profile profile;
    
    @ManyToOne
    private Menu menu;
    
    @Enumerated(EnumType.ORDINAL)
    private PrivilegeType privilegeType;
    
    public Profile getProfile() {
        return profile;
    }
    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    public Menu getMenu() {
        return menu;
    }
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    public PrivilegeType getPrivilegeType() {
        return privilegeType;
    }
    public void setPrivilegeType(PrivilegeType privilegeType) {
        this.privilegeType = privilegeType;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((menu == null) ? 0 : menu.hashCode());
        result = prime * result + ((privilegeType == null) ? 0 : privilegeType.hashCode());
        result = prime * result + ((profile == null) ? 0 : profile.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProfileMenuPrivilegePk other = (ProfileMenuPrivilegePk) obj;
        if (menu == null) {
            if (other.menu != null)
                return false;
        } else if (!menu.equals(other.menu))
            return false;
        if (privilegeType != other.privilegeType)
            return false;
        if (profile == null) {
            if (other.profile != null)
                return false;
        } else if (!profile.equals(other.profile))
            return false;
        return true;
    }
    
}
