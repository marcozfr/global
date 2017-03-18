package com.global.model.entities;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.global.model.types.PrivilegeType;

@Entity
@Table(name="PROFILE_MENU_PRIVILEGE")
@AssociationOverrides({
    @AssociationOverride(name="pk.profile",joinColumns=@JoinColumn(name="profile_fk",referencedColumnName="profileId")),
    @AssociationOverride(name="pk.menu",joinColumns=@JoinColumn(name="menu_fk",referencedColumnName="menuId")),
    @AssociationOverride(name="pk.privilegeType")})
public class ProfileMenuPrivilege {

    @EmbeddedId
    private ProfileMenuPrivilegePk pk = new ProfileMenuPrivilegePk();
    
    @Transient
    public Profile getProfile(){
        return pk.getProfile();
    }
    
    @Transient
    public Menu getMenu(){
        return pk.getMenu();
    }
    
    @Transient
    public PrivilegeType getPrivilegeType(){
        return pk.getPrivilegeType();
    }
    
    public void setProfile(Profile profile){
        pk.setProfile(profile);
    }
    
    public void setMenu(Menu menu){
        pk.setMenu(menu);
    }
    
    public void setPrivilegeType(PrivilegeType privilegeType){
        pk.setPrivilegeType(privilegeType);
    }
    
}
