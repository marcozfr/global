package com.labs.catalog.data.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.global.model.entities.User;

public interface UserRepository extends PagingAndSortingRepository<User,Long> {
    List<User> findByUsername(String username);
}
