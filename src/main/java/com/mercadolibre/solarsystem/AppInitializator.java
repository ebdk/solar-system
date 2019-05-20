package com.mercadolibre.solarsystem;

import com.mercadolibre.solarsystem.factories.ConditionFactory;
import com.mercadolibre.solarsystem.factories.PlanetFactory;
import com.mercadolibre.solarsystem.models.Planet;
import com.mercadolibre.solarsystem.models.SolarSystem;
import com.mercadolibre.solarsystem.models.conditions.CommonCondition;
import com.mercadolibre.solarsystem.models.conditions.WeatherCondition;
import com.mercadolibre.solarsystem.services.DayService;
import com.mercadolibre.solarsystem.services.impl.PredictionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
class AppInitializator {

    @Autowired
    private DayService dayService;

    @PostConstruct
    private void init() {
        PredictionServiceImpl predictionService = new PredictionServiceImpl(
                new SolarSystem(PlanetFactory.createPlanets()),
                ConditionFactory.createConditions(),
                ConditionFactory.createCommonCondition());

        predictionService.fullfilPrediction(5);
    }

}