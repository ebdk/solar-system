package com.mercadolibre.solarsystem.services.impl;

import com.mercadolibre.solarsystem.dtos.DayDto;
import com.mercadolibre.solarsystem.dtos.DetailedDayDto;
import com.mercadolibre.solarsystem.dtos.PredictionDto;
import com.mercadolibre.solarsystem.models.Day;
import com.mercadolibre.solarsystem.models.SolarSystem;
import com.mercadolibre.solarsystem.services.DayService;
import com.mercadolibre.solarsystem.services.SolarSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mercadolibre.solarsystem.models.Weather.Type.RAINY;

@Service
public class SolarSystemServiceImpl implements SolarSystemService {

    @Autowired
    private DayService dayService;

    @Autowired
    private SolarSystem solarSystem;

    @Override
    public DayDto predictWeather(int day) {
        return new DayDto(dayService.getDay((long) day));
    }

    @Override
    public PredictionDto weatherForecast() {
        List<Day> days = dayService.getAll();
        Day mostRainyDay = new Day(0, RAINY, 0);
        for(Day day : days) {
            mostRainyDay = (day.getPrecipitation() > mostRainyDay.getPrecipitation()) ? day : mostRainyDay;
        }
        return new PredictionDto(countWeatherTypeOccurrences(days, com.mercadolibre.solarsystem.models.Weather.Type.IDEAL),
                countWeatherTypeOccurrences(days, com.mercadolibre.solarsystem.models.Weather.Type.DRY),
                countWeatherTypeOccurrences(days, com.mercadolibre.solarsystem.models.Weather.Type.RAINY),
                new DetailedDayDto(mostRainyDay));
    }

    private int countWeatherTypeOccurrences(List<Day> days, com.mercadolibre.solarsystem.models.Weather.Type type) {
        return Math.toIntExact(days.stream().filter(day -> day.getWeather().equals(type)).count());
    }

}
