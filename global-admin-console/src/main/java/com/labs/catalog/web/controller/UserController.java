package com.labs.catalog.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.model.entities.User;
import com.labs.catalog.data.repositories.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserRepository userRepository;
    
    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<User>> getUser(
            @RequestParam(name="start",defaultValue="0") Integer start,
            @RequestParam(name="limit",defaultValue="10") Integer limit){
        PageRequest pageRequest = new PageRequest(start, limit);
        Page<User> users = userRepository.findAll(pageRequest);
        return new ResponseEntity<Page<User>>(users, HttpStatus.OK);
    }
    
    @GetMapping(path="/find",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> findUser(
            @RequestParam("username") String username){
        List<User> users = new ArrayList<>();
        if(username != null){
            users = userRepository.findByUsername(username);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
    
    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 =userRepository.save(user);
        return new ResponseEntity<User>(user1,HttpStatus.OK);
    }
    

}
