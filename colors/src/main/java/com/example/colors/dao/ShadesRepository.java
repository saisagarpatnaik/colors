package com.example.colors.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.colors.entity.Colors;
import com.example.colors.entity.Shades;

@Repository
public interface ShadesRepository extends JpaRepository<Shades, Long> { // using JpaRepository instead of CrudRepository

	List<Shades> findByColors(Colors colors);
}
