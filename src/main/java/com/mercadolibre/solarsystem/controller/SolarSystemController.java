package com.mercadolibre.solarsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class SolarSystemController {

    @Autowired
    private com.mercadolibre.solarsystem.services.SolarSystemService service;

    @GetMapping(path="/{date}")
    public com.mercadolibre.solarsystem.dtos.DayDto getDay(@PathVariable("date") int date) {
        return service.predictWeather(date);
    }

    @org.springframework.web.bind.annotation.GetMapping
    public com.mercadolibre.solarsystem.dtos.PredictionDto weatherForecast() {
        return service.weatherForecast();
    }

}
