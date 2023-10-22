package com.example.colors.controller;
//chose a color
// show all the shades
// select the shades
// add to cart
// place an order
// save the data to db

import com.example.colors.constants.Constants;
import com.example.colors.entity.Orders;
import com.example.colors.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

   @Autowired
   OrderService orderService;

    @PostMapping(Constants.SAVEORDERS)
    public Orders saveOrders(){
       // OrderServiceImpl orderService = new OrderServiceImpl(); you should not create this as it only start while running the code and will give null point exception
        return orderService.SaveOrder();
    }
    @PostMapping(Constants.ORDERSTATUS)
    public List<Orders> searchStudent(@RequestBody Orders orders) {
        return  orderService.SearchOrder(orders);
    }

}
