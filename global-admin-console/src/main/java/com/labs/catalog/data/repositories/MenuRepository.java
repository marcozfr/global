package com.labs.catalog.data.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.global.model.entities.Menu;

public interface MenuRepository extends PagingAndSortingRepository<Menu,Long> {

}
