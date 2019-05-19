package com.mercadolibre.solarsystem.services;

import com.mercadolibre.solarsystem.dtos.DayDto;
import com.mercadolibre.solarsystem.dtos.PredictionDto;

public interface SolarSystemService {

    DayDto predictWeather(int day);

    PredictionDto weatherForecast();

}
