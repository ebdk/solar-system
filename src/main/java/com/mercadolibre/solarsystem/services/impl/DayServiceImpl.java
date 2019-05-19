package com.mercadolibre.solarsystem.services.impl;

import com.mercadolibre.solarsystem.dtos.DetailedDayDto;
import com.mercadolibre.solarsystem.dtos.MessageResponse;
import com.mercadolibre.solarsystem.entity.DayEntity;
import com.mercadolibre.solarsystem.models.Day;
import com.mercadolibre.solarsystem.repositories.DayDAO;
import com.mercadolibre.solarsystem.services.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DayServiceImpl implements DayService {

    @Autowired
    private DayDAO dayRepository;


    @Override
    public MessageResponse sayHello() {
        return new MessageResponse("Prueba");
    }

    @Override
    public MessageResponse saveDay(DetailedDayDto day) {
        dayRepository.save(new DayEntity(day));
        return new MessageResponse("Agregado" + day.getDate() + " correctamente.");
    }

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
    public com.mercadolibre.solarsystem.dtos.MessageResponse mockDays() {
        Day day1 = new Day(1, "RAINY", 300);
        Day day2 = new Day(2, "DRY", 0);
        Day day3 = new Day(3, "DRY", 0);
        Day day4 = new Day(4, "IDEAL", 30);
        Day day5 = new Day(5, "IDEAL", 30);
        Day day6 = new Day(6, "COMMON", 300);
        Day day7 = new Day(7, "COMMON", 300);

        dayRepository.save(new DayEntity(day1));
        dayRepository.save(new DayEntity(day2));
        dayRepository.save(new DayEntity(day3));
        dayRepository.save(new DayEntity(day4));
        dayRepository.save(new DayEntity(day5));
        dayRepository.save(new DayEntity(day6));
        dayRepository.save(new DayEntity(day7));


        return new MessageResponse("Agregado days al 7.");
    }
}
