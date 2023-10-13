package com.example.colors.dao;

import com.example.colors.entity.Colors;
import com.example.colors.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    
}
