package com.example.colors.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.colors.constants.Constants;
import com.example.colors.entity.Shades;
import com.example.colors.service.ShadesService;

@RestController
public class ShadeController {

	private static final Logger log = LoggerFactory.getLogger(ShadeController.class);
	@Autowired
	private ShadesService shadesService;

	@PostMapping(Constants.SAVESHADES)
	public Shades saveShades(@RequestBody Shades shade) {
		log.info("This is controller shades" + shade.toString());
		return shadesService.saveShades(shade);
	}

}
