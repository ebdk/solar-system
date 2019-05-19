package com.mercadolibre.solarsystem;

import com.mercadolibre.solarsystem.services.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
class AppInitializator {

    @Autowired
    private DayService dayService;

    @PostConstruct
    private void init() {
        dayService.mockDays();
    }

}