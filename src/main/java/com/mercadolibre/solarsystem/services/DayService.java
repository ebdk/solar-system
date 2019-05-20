package com.mercadolibre.solarsystem.services;

import com.mercadolibre.solarsystem.dtos.MessageDto;
import com.mercadolibre.solarsystem.models.Day;

import java.util.List;

public interface DayService {

    Day getDay(Long date);

    void saveDay(com.mercadolibre.solarsystem.models.Day day);

    List<Day> getAll();

    MessageDto mockDays();
}
