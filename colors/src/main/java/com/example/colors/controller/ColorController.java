package com.example.colors.controller;

import com.example.colors.constants.Constants;
import com.example.colors.entity.Colors;
import com.example.colors.service.ColorsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ColorController {

	private static final Logger log = LoggerFactory.getLogger(ColorController.class);
	@Autowired
	private ColorsService colorsService;

	@Value("${color.names}") // Bring data from application. properties
	private String names; // set it to a variable calls names

	@PostMapping(Constants.SAVECOLORS)
	public Colors saveColors(@RequestBody Colors colors) {
		List<String> l1 = List.of(names.split(","));
		for (int i = 0; i <= l1.size() - 1; i++) {
			log.info(l1.get(i).trim());
		}
		return colorsService.SaveColor(colors);
	}

	@GetMapping(Constants.GETCOLORID)
	public Colors getColorId(@PathVariable long id) {
		//PathVariable - you pass one value after POSTMAN URL e.g. /1
		//Postman - http://localhost:8080/getColorId/2
		log.info("Kindly select the colors from the below list");
		// Please print the list of colors here
		return colorsService.getColorId(id);
	}
}