package com.example.colors.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.colors.entity.Stores;

@Repository
public interface StoresRepository extends JpaRepository<Stores, Long> {

}
