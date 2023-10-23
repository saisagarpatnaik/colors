package com.example.colors.service;

import com.example.colors.entity.Colors;

public interface ColorsService {
	
	public Colors SaveColor(Colors colors);

	public Colors getColorId(long id);

}
