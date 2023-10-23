package com.example.colors.service;

import java.util.List;

import com.example.colors.entity.Orders;

public interface OrderService {
	
	public Orders SaveOrder();

	public List<Orders> SearchOrder(Orders orders);

}
