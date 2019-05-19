package com.mercadolibre.solarsystem.services.impl;

import com.mercadolibre.solarsystem.dtos.DayDto;
import com.mercadolibre.solarsystem.dtos.DetailedDayDto;
import com.mercadolibre.solarsystem.dtos.PredictionDto;
import com.mercadolibre.solarsystem.models.Day;
import com.mercadolibre.solarsystem.services.DayService;
import com.mercadolibre.solarsystem.services.SolarSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolarSystemServiceImpl implements SolarSystemService {

    @Autowired
    private DayService dayService;

    @Override
    public DayDto predictWeather(int day) {
        return new DayDto(dayService.getDay((long) day));
    }

    @Override
    public PredictionDto weatherForecast() {
        int rainyDays = 0;
        int droughtDays = 0;
        int optimalDays = 0;
        List<Day> days = dayService.getAll();
        for (Day day : days) {
            switch (day.getWeatherType()) {
                case "RAINY" : rainyDays++;
                break;
                case "DRY" : droughtDays++;
                break;
                case "IDEAL" : optimalDays++;
                break;
            }
        }
        return new PredictionDto(optimalDays, droughtDays, rainyDays, new DetailedDayDto(days.get(0)));
    }


}
