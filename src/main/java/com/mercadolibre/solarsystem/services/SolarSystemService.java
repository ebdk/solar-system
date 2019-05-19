package com.mercadolibre.solarsystem.services;

public interface SolarSystemService {

    com.mercadolibre.solarsystem.dtos.DayDto predictWeather(int day);

    com.mercadolibre.solarsystem.dtos.PredictionDto weatherForecast();

}
