package com.mercadolibre.solarsystem.services.impl;

import com.google.common.collect.ImmutableMap;
import com.mercadolibre.solarsystem.dtos.MessageDto;
import com.mercadolibre.solarsystem.entity.DayEntity;
import com.mercadolibre.solarsystem.models.Day;
import com.mercadolibre.solarsystem.models.Weather.TypeOfWeather;
import com.mercadolibre.solarsystem.repositories.DayDao;
import com.mercadolibre.solarsystem.services.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DayServiceImpl implements DayService {

    @Autowired
    private DayDao dayRepository;

    @Override
    public Day getDay(Long date) {
        return new Day(dayRepository.findById(date).get());
    }

    @Override
    public List<Day> getAll() {
        List<DayEntity> entities = dayRepository.findAll();
        List<Day> days = new ArrayList<>();
        for(DayEntity entity : entities) {
            days.add(new Day(entity));
        }
        return days;
    }

    @Override
    public MessageDto mockDays() {
        ImmutableMap<Integer, TypeOfWeather> map = ImmutableMap.of(0, TypeOfWeather.COMMON,
                1, TypeOfWeather.IDEAL,
                2, TypeOfWeather.RAINY,
                3, TypeOfWeather.DRY);
        for(int i = 1; i <= 3650; i++) {
            int numberForPrecipitacion = (int)(Math.random() * ((1825) + 1));
            int numberForChoosenEnum = (int)(Math.random() * ((3) + 1));
            Day day = new Day(i, map.get(numberForChoosenEnum), numberForPrecipitacion);
            dayRepository.save(new DayEntity(day));
        }

        return new MessageDto("Added 3650 mocked days.");
    }

}
