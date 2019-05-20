package com.mercadolibre.solarsystem.services.impl;

import com.mercadolibre.solarsystem.factories.ConditionFactory;
import com.mercadolibre.solarsystem.factories.PlanetFactory;
import com.mercadolibre.solarsystem.models.SolarSystem;
import com.mercadolibre.solarsystem.services.DayService;
import com.mercadolibre.solarsystem.services.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PredictionServiceConfiguration {

    @Autowired
    private DayService dayService;
    @Bean
    public PredictionService findWeatherService() {
        return new PredictionServiceImpl(
                new SolarSystem(PlanetFactory.createPlanets()),
                ConditionFactory.createConditions(),
                ConditionFactory.createCommonCondition(), dayService);
    }
}
