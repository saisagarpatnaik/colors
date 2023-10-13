package com.example.colors.dao;

import com.example.colors.entity.Colors;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ColorsRepository extends CrudRepository<Colors, Long> {

   public List<Colors> findByColor(String s1);

}
