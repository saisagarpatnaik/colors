package com.example.colors.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.colors.entity.Colors;

@Repository
public interface ColorsRepository extends JpaRepository<Colors, Long> {

	public List<Colors> findByColor(String s1);

}
