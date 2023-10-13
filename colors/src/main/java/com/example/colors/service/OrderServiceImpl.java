package com.example.colors.service;

import com.example.colors.dao.ColorsRepository;
import com.example.colors.dao.CustomerRepository;
import com.example.colors.dao.OrdersRepository;
import com.example.colors.entity.Colors;
import com.example.colors.entity.Customer;
import com.example.colors.entity.Orders;
import io.micrometer.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component//@Service
public class OrderServiceImpl implements OrderService {

    @Value("${color.names}") //Bring data from application. properties
    private String names; //set it to a variable calls names

    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ColorsRepository colorsRepository;

    @Autowired
    ColorsRepository shadesRepository;

    @Override
    public Orders SaveOrder(Orders orders) {
        log.info("Hi, Welcome to colors, please chose one the colors: ");
        List<String> l1 = List.of(names.split(","));
        for(int i = 0; i<=l1.size()-1; i++) {
            log.info(l1.get(i).trim());
        }
        List<Colors> searchResult = null;
        Scanner s = new Scanner(System.in);
       log.info("Please chose a color: ");
       String color2 = s.nextLine();
        if(!StringUtils.isEmpty(color2)){
            searchResult = colorsRepository.findByColor(color2);
            log.info("You have chosen: " + searchResult.get(0).getColor());
            log.info("You have chosen RED color with Maroon Shade");

            //orders.setColors(searchResult.get(0));
        }
        else {
            log.info("Please chose a color listed above: ");
            String colorAgain = s.nextLine();
        }
        log.info("Please enter you weight you need: ");
        int quantity = s.nextInt();
        orders.setOrderQuantity(quantity);
        //System.out.println("XXXXXXX" + searchResult.get(0));
        //List<Shades> s1 = shadesRepository.findByColorId(1);
        //log.info("ShadesFindbyColorId: "+ s1);
        Customer customer = new Customer();
        log.info("Please enter you name: ");
        String name = s.nextLine();
        customer.setCustomerName(name);
        log.info("Please enter your current address: ");
        String address = s.nextLine();
        customer.setCustomerAddress(address);
        log.info("Please enter your phone number: ");
        String phone = s.nextLine();
        customer.setCustomerPhoneNumber(phone);
        s.close();
        Customer customer1 = customerRepository.save(customer);
        orders.setCustomer(customer1);
        Orders order = ordersRepository.save(orders);
        return order;
    }
}
