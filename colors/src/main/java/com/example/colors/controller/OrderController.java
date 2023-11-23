package com.example.colors.controller;
//chose a color

import java.util.List;

import com.example.colors.entity.Colors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// show all the shades
// select the shades
// add to cart
// place an order
// save the data to db

import com.example.colors.constants.Constants;
import com.example.colors.entity.Orders;
import com.example.colors.service.OrderService;

@RestController
public class OrderController {

	private static final Logger log = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	OrderService orderService;

	@PostMapping(Constants.SAVEORDERS)
	public Orders saveOrders() {
		// OrderServiceImpl orderService = new OrderServiceImpl(); you should not create
		// this as it only start while running the code and will give null point
		// exception
		return orderService.SaveOrder();
	}

	@PostMapping(Constants.ORDERSTATUS)
	public List<Orders> searchStudent(@RequestBody Orders orders) {
		return orderService.SearchOrder(orders);
	}

	@PostMapping(Constants.ORDERSBYDATE)
	public List<Orders> searchOrdersByDate(@RequestParam (value = "order_date") String date,
										   @RequestParam (value = "color_id") String colorId)
	{
		//RequestParam is passed in the URL
		//http://localhost:8080/searchOrdersByDate?order_date=2023-10-21 from Postman (if one needed, u need change in TestRepository and follow the steps
		//http://localhost:8080/searchOrdersByDate?order_date=2023-10-21&color_id=1
		//http://localhost:8080/searchOrdersByDate?order_date=2023-10-21&color_id=1&shade_id=1 (If three parameters needed)
		log.info("This @ Controller");
		return orderService.searchOrdersByDate(date, colorId);
	}

	@PostMapping(Constants.ORDERSBYID)
	public  List<Colors> searchOrdersId (@RequestParam (value = "color_id") String colorId){
		log.info("This @ Controller");
		return orderService.searchOrdersId(colorId);
	}


}
