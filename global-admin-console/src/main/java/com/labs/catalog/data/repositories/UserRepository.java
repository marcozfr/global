package com.labs.catalog.data.repositories;

import org.springframework.data.repository.CrudRepository;

import com.global.model.entities.User;

public interface UserRepository extends CrudRepository<User,Long> {

}
