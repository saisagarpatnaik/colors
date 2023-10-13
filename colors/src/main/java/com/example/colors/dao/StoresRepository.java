package com.example.colors.dao;

import com.example.colors.entity.Stores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoresRepository extends CrudRepository<Stores, Long> {

}
