package com.example.colors.dao;

import com.example.colors.entity.Shades;
import com.example.colors.entity.Colors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShadesRepository extends JpaRepository<Shades, Long> { // using JpaRepository instead of CrudRepository

    List<Shades> findByColors(Colors colors);
}
