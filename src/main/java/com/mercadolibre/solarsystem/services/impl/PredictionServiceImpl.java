package com.mercadolibre.solarsystem.services.impl;

import com.mercadolibre.solarsystem.models.Day;
import com.mercadolibre.solarsystem.models.SolarSystem;
import com.mercadolibre.solarsystem.models.conditions.CommonCondition;
import com.mercadolibre.solarsystem.models.conditions.WeatherCondition;
import com.mercadolibre.solarsystem.services.DayService;
import com.mercadolibre.solarsystem.services.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PredictionServiceImpl implements PredictionService {

    @Autowired
    private DayService dayService;

    private SolarSystem solarSystem;

    private List<WeatherCondition> weatherConditions;

    private CommonCondition defaultCondition;

    public PredictionServiceImpl(SolarSystem solarSystem, List<WeatherCondition> weatherConditions, CommonCondition defaultCondition, DayService dayService) {
        this.solarSystem = solarSystem;
        this.weatherConditions = weatherConditions;
        this.defaultCondition = defaultCondition;
        this.dayService = dayService;
    }

    @Override
    public void fullfilPrediction(int days) {
        for(int date = 1; date <= days; date++) {
            dayService.saveDay(predictDay(date));
            solarSystem.movePlanetsGivenDays(date);
        }
    }

    private Day predictDay(int date) {
        return new Day(date, weatherConditions.stream().filter(
                condition -> condition.isOfCondition(solarSystem)
        ).findFirst().orElse(defaultCondition).getWeather(solarSystem));
    }
}
