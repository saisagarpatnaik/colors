package com.example.colors.dao;

import com.example.colors.entity.Shades;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShadesRepository extends CrudRepository<Shades, Long> {

}
