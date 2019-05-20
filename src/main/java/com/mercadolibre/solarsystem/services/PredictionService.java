package com.mercadolibre.solarsystem.services;

import com.mercadolibre.solarsystem.dtos.MessageDto;

public interface PredictionService {

    MessageDto fullfilPrediction(int days);

}
