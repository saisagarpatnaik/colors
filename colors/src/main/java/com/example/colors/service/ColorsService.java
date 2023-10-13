package com.example.colors.service;

import com.example.colors.entity.Colors;
import org.springframework.stereotype.Service;

public interface ColorsService {
    public Colors SaveColor(Colors colors);

    public Colors getColorId(long id);

}
