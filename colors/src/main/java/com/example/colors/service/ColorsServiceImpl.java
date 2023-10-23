package com.example.colors.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.colors.dao.ColorsRepository;
import com.example.colors.entity.Colors;

@Component // @Service - Service is parent, component is child
public class ColorsServiceImpl implements ColorsService {

	private static final Logger log = LoggerFactory.getLogger(ColorsServiceImpl.class);

	@Autowired
	private ColorsRepository colorsRepository;

	@Override
	public Colors SaveColor(Colors colors) {
		Colors col = colorsRepository.save(colors);
		log.info("There are many colors" + col.toString());
		return col;
	}

	@Override
	public Colors getColorId(long id) {
		Optional<Colors> colorId = colorsRepository.findById(id);
		log.info("You chose this color: " + colorId.get());
		return colorId.get();
	}
}