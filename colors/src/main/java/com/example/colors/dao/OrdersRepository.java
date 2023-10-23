package com.example.colors.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.colors.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
