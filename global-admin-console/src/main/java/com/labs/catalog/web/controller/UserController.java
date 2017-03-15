package com.labs.catalog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.global.model.entities.User;
import com.labs.catalog.data.repositories.UserRepository;

@RestController("/user")
public class UserController {
    
    @Autowired
    UserRepository userRepository;
    
    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 =userRepository.save(user);
        return new ResponseEntity<User>(user1,HttpStatus.OK);
    }
    

}
