package com.example.colors.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.colors.dao.ColorsRepository;
import com.example.colors.dao.ShadesRepository;
import com.example.colors.entity.Colors;
import com.example.colors.entity.Shades;

@Component // @Service
public class ShadesServiceImpl implements ShadesService {

	private static final Logger log = LoggerFactory.getLogger(ShadesServiceImpl.class);

	@Autowired
	private ShadesRepository shadesRepository;

	@Autowired
	private ColorsRepository colorsRepository;

	@Override
	public Shades saveShades(Shades shades) {
		long l = shades.getColors().getColorId(); // fetching the color id from the input
		log.info("This is to get color id " + l); // This print the id
		Optional<Colors> colors = colorsRepository.findById(l); // finding the l id
		Shades s1 = shadesRepository.save(shades); // This will save the data in repo
		if (colors.isPresent()) {
			s1.setColors(colors.get()); // This will set the colors data from findById using get()
		}
		log.info("After saving the shades" + s1.toString());
		return s1;
	}
}
