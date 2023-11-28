package com.example.colors.service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.example.colors.dao.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.colors.entity.Colors;
import com.example.colors.entity.Customer;
import com.example.colors.entity.Orders;
import com.example.colors.entity.Shades;

import io.micrometer.common.util.StringUtils;

@Component // @Service
public class OrderServiceImpl implements OrderService {

	@Value("${color.names}") // Bring data from application. properties
	private String names; // set it to a variable calls names

	private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
	@Autowired
	OrdersRepository ordersRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	ColorsRepository colorsRepository;
	@Autowired
	ShadesRepository shadesRepository;
	@Autowired
	TestRepository testRepository;
	@Autowired
	TestRepository1 testRepository1;

	@Override
	public Orders SaveOrder() {
		Orders orders = new Orders();
		log.info(names);
		log.info("Hi, Welcome to colors, please chose one of the colors: ");
		try {
			List<String> l1 = List.of(names.split(","));
			for (int i = 0; i <= l1.size() - 1; i++) {
				log.info(l1.get(i).trim());
			}
		} catch (NullPointerException nl) {
			log.info("Values are empty");
		}
		List<Colors> searchResult = null;
		boolean anyMatch = false;
		Scanner s = new Scanner(System.in);
		log.info("Please chose a color: ");
		String color2 = s.nextLine();
		log.info("Before Entering first: " + color2);
		if (!StringUtils.isEmpty(color2)) {
			do {
			searchResult = colorsRepository.findByColor(color2);
			log.info("This is the search result: " + searchResult);
			if (!searchResult.isEmpty() && searchResult.get(0).getColor().equalsIgnoreCase(color2)){
				anyMatch = true;
			}
			else {
				log.info("Please chose a color: ");
				color2 = s.nextLine();
				}
			} while(!anyMatch); //This loop will run until anymatch becomes true. //Do while run until while condition becomes true

			log.info("You have chosen: " + searchResult.get(0).getColor());
			log.info("And the color id selected is: " + searchResult.get(0).getColorId());
			// The below lines are not required at all #Ravi review, we are fetching same
			// data twice...
			// Optional<Colors> colors1 =
			// colorsRepository.findById((long)searchResult.get(0).getColorId());
			// Colors colors2 = colors1.get();
			// orders.setColors(colors2);
			orders.setColors(searchResult.get(0));
			// List<Shades> shades = shadesRepository.findByColors(colors2);
			List<Shades> shades = shadesRepository.findByColors(searchResult.get(0));
			log.info("Below are list of shades available");
			for (Shades shade : shades) {
				log.info("Shade ID: " + shade.getShadeId() + " : " + shade.getShadeName());
			}
			log.info("Please chose a shadeId: ");
			int shadeId = s.nextInt();
			// This Optional line checks the value that is entered in shadeId in the list of
			// shades and if it finds
			Optional<Shades> sh = shades.stream().filter(sr -> sr.getShadeId() == shadeId).findFirst();
			if (sh.isPresent()) { // if the value is present
				Shades sh1 = sh.get();
				log.info("You have selected the shade::" + sh1.getShadeName());
				orders.setShades(sh1);
			} else {
				log.info("This id is not in the list: ");
			}
		} else {
			log.info("Please chose a color listed above: ");
			String colorAgain = s.next();
		}
		log.info("Please enter you weight you need: ");
		int quantity = s.nextInt();
		orders.setOrderQuantity(quantity);
		Customer customer = new Customer();
		Scanner s1 = new Scanner(System.in);
		log.info("Please enter you name: ");
		String name = s1.nextLine();
		customer.setCustomerName(name);
		log.info("Please enter your current address: ");
		String address = s1.nextLine();
		customer.setCustomerAddress(address);
		log.info("Please enter your phone number: ");
		String phone = s1.nextLine();
		customer.setCustomerPhoneNumber(phone);
		log.info("Final customer object" + customer);
		Customer customer1 = customerRepository.save(customer);
		orders.setCustomer(customer1);
		return ordersRepository.save(orders);
	}

	@Override
	public List<Orders> SearchOrder(Orders orders) {

		return null;
	}

	@Override
	public List<Orders> searchOrdersByDate(String date, String colorId) {
		log.info("This @ Service IMPL");
		List<Orders> l1 = testRepository.SearchOrderByDate(date, colorId);
		log.info(l1.toString());
		return l1;
	}

	@Override
	public List<Colors> searchOrdersId(String colorId) {
		log.info("This @ Service IMPL");
		List<Colors> c1 = testRepository1.searchOrdersId(colorId);
		log.info("This after testRepository Service IMPL");
		return c1;
	}
}
