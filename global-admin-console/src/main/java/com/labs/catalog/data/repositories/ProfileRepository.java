package com.labs.catalog.data.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.global.model.entities.Profile;

public interface ProfileRepository extends PagingAndSortingRepository<Profile,Long> {

}
