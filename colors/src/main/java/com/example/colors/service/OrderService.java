package com.example.colors.service;

import com.example.colors.entity.Orders;

import java.util.List;

public interface OrderService {
    public Orders SaveOrder();

    public List<Orders> SearchOrder(Orders orders);

}
