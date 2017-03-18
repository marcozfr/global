package com.labs.catalog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.model.entities.Menu;
import com.global.model.entities.Profile;
import com.labs.catalog.data.repositories.MenuRepository;
import com.labs.catalog.data.repositories.ProfileRepository;

@RestController
@RequestMapping(path="/admin",consumes=MediaType.APPLICATION_JSON_VALUE)
public class AdminController {

    @Autowired
    ProfileRepository profileRepository;
    
    @Autowired
    MenuRepository menuRepository;
    
    @PostMapping(path="/profile")
    public Profile addProfile(@RequestBody Profile profile){
        return profileRepository.save(profile);
    }
    
    @PostMapping(path="/menu")
    public Menu addMenu(@RequestBody Menu menu){
        return menuRepository.save(menu);
    }
    
}
