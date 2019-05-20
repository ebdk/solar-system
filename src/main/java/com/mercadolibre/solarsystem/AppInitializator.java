package com.mercadolibre.solarsystem;

import com.mercadolibre.solarsystem.services.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
class AppInitializator {

    @Autowired
    private PredictionService predictionService;

    @PostConstruct
    private void init() {
        predictionService.fullfilPrediction(3600);
    }

}