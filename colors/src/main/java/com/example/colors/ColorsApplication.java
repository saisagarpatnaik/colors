package com.example.colors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ColorsApplication {

	private static final Logger log = LoggerFactory.getLogger(ColorsApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(ColorsApplication.class, args);

		log.info("This Project is working");

	}
}
